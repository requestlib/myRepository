#include<rtthread.h>
#define THREAD_PRIORITY 25
#define THREAD_STACK_SIZE 512
#define THREAD_TIMESLICE 5
static rt_thread_t tid1 = RT_NULL;

/* 线程1 入口函数*/
static void thread1_entry(void *parameter)
{
    int i;
    char* ptr = RT_NULL; /*内存块指针*/
    for(i = 0; ;i++){
        /*每次分配 1<<i 大小字节数的内存空间*/
        ptr = rt_malloc(1<<i);
        /*如果分配陈工*/
        if(ptr != RT_NULL){
            rt_kprintf("get memory :%d byte\n", (1<<i));
            rt_free(ptr);
            rt_kprintf("free memory :%d byte\n", (1<<i));
            ptr = RT_NULL;
        }
        else{
        	list_mem();
            rt_kprintf("try to get %d byte memory faild!\n", (1<<i));
            return;
        }
    }
}

int main()
{
	rt_kprintf("hello main\n");
	list_mem();
    /*创建线程1 名称是thread1 入口是 thread1_entry*/
    tid1 = rt_thread_create("thread1", thread1_entry, RT_NULL, THREAD_STACK_SIZE, THREAD_PRIORITY, THREAD_TIMESLICE);

    /*如果获得线程控制块, 启动这个线程*/
    if(tid1 != RT_NULL)
        rt_thread_startup(tid1);

    return 0;
}
