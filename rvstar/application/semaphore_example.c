#include<rtthread.h>
#include "gd32vf103v_rvstar.h"

static rt_sem_t dynamic_sem = RT_NULL;
#define THREAD_PRIORITY 25
#define THREAD_TIMESLICE 5

ALIGN(RT_ALIGN_SIZE)
static char thread1_stack[1024];
static struct rt_thread thread1;
static void rt_thread1_entry(void *parameter){

    static rt_uint8_t count = 0;
    while(1){
        if(count <= 100){
            count++;
        }
        else
            return;
        /* count 每计数10次，就释放一次信号量*/
        if(0 == (count % 10)){
            rt_kprintf("t1 release a dynamic semaphore.\n");
            rt_sem_release(dynamic_sem);
        }
    }
}

ALIGN(RT_ALIGN_SIZE)
static char thread2_stack[1024];
static struct rt_thread thread2;
static void rt_thread2_entry(void *parameter){

    static rt_err_t result;
    static rt_uint8_t number = 0;
    while(1){
        /* 永久等待信号量，获取到信号量，则执行number自加操作*/
        result = rt_sem_take(dynamic_sem, RT_WAITING_FOREVER);
        if (result != RT_EOK){
            rt_kprintf("t2 take a dynamic semaphore failed.\n");
            return;
        }
        else{
            number++;
            rt_kprintf("t2 take a dynamic semaphore number = %d\n", number);
        }
    }
}

int signal_example()
{
	/*创建信号量 初始值0*/
    dynamic_sem = rt_sem_create("dsem", 0, RT_IPC_FLAG_FIFO);
    if(dynamic_sem == RT_NULL){
        rt_kprintf("create dynamic semaphore failed. \n");
        return -1;
    }
    else{
        rt_kprintf("create done. dynamic semaphore value = 0.\n");
    }
    rt_thread_init(&thread1, "thread1", rt_thread1_entry, RT_NULL, &thread1_stack[0], sizeof(thread1_stack), THREAD_PRIORITY, THREAD_TIMESLICE);
    rt_thread_startup(&thread1);

    rt_thread_init(&thread2, "thread2", rt_thread2_entry, RT_NULL, &thread2_stack[0], sizeof(thread2_stack), THREAD_PRIORITY-1, THREAD_TIMESLICE);
    rt_thread_startup(&thread2);

    return 0;
}
