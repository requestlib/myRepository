################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../rt-thread/libcpu/risc-v/nuclei/cpuport.c 

S_UPPER_SRCS += \
../rt-thread/libcpu/risc-v/nuclei/context_gcc.S \
../rt-thread/libcpu/risc-v/nuclei/interrupt_gcc.S 

OBJS += \
./rt-thread/libcpu/risc-v/nuclei/context_gcc.o \
./rt-thread/libcpu/risc-v/nuclei/cpuport.o \
./rt-thread/libcpu/risc-v/nuclei/interrupt_gcc.o 

S_UPPER_DEPS += \
./rt-thread/libcpu/risc-v/nuclei/context_gcc.d \
./rt-thread/libcpu/risc-v/nuclei/interrupt_gcc.d 

C_DEPS += \
./rt-thread/libcpu/risc-v/nuclei/cpuport.d 


# Each subdirectory must supply rules for building sources it contributes
rt-thread/libcpu/risc-v/nuclei/%.o: ../rt-thread/libcpu/risc-v/nuclei/%.S
	@echo 'Building file: $<'
	@echo 'Invoking: GNU RISC-V Cross Assembler'
	riscv-nuclei-elf-gcc -march=rv32imac -mabi=ilp32 -mcmodel=medany -mno-save-restore -fno-code-hoisting -fno-tree-vectorize -finline-functions -falign-functions=4 -falign-jumps=4 -falign-loops=4 -finline-limit=200 -fno-if-conversion -fno-if-conversion2 -fipa-pta -fselective-scheduling -fno-tree-loop-distribute-patterns -funroll-loops -funroll-all-loops -fno-delete-null-pointer-checks -fno-rename-registers -mbranch-cost=1 --param fsm-scale-path-stmts=5 --param max-average-unrolled-insns=200 --param max-grow-copy-bb-insns=16 --param max-jump-thread-duplication-stmts=8 --param hot-bb-frequency-fraction=4 --param unroll-jam-min-percent=0 -Ofast -ffunction-sections -fdata-sections -fno-common --specs=nano.specs --specs=nosys.specs -u _printf_float  -g -x assembler-with-cpp -D__IDE_RV_CORE=n205 -DDOWNLOAD_MODE=DOWNLOAD_MODE_FLASHXIP -DDOWNLOAD_MODE_STRING=\"FLASHXIP\" -I"D:\design\workplace\rvstar\nuclei_sdk\NMSIS\Core\Include" -I"D:\design\workplace\rvstar\libraries\gd32vf103\HAL_Drivers" -I"D:\design\workplace\rvstar\board" -I"D:\design\workplace\rvstar\rt-thread\include" -I"D:\design\workplace\rvstar\rt-thread\include\libc" -I"D:\design\workplace\rvstar\rt-thread\components\drivers\include" -I"D:\design\workplace\rvstar\rt-thread\components\finsh" -I"D:\design\workplace\rvstar\rt-thread\libcpu\risc-v\nuclei" -I"D:\design\workplace\rvstar\nuclei_sdk\SoC\gd32vf103\Common\Include" -I"D:\design\workplace\rvstar\nuclei_sdk\SoC\gd32vf103\Board\gd32vf103v_rvstar\Include" -I"D:\design\workplace\rvstar\application" -x assembler-with-cpp -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -c -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

rt-thread/libcpu/risc-v/nuclei/%.o: ../rt-thread/libcpu/risc-v/nuclei/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GNU RISC-V Cross C Compiler'
	riscv-nuclei-elf-gcc -march=rv32imac -mabi=ilp32 -mcmodel=medany -mno-save-restore -fno-code-hoisting -fno-tree-vectorize -finline-functions -falign-functions=4 -falign-jumps=4 -falign-loops=4 -finline-limit=200 -fno-if-conversion -fno-if-conversion2 -fipa-pta -fselective-scheduling -fno-tree-loop-distribute-patterns -funroll-loops -funroll-all-loops -fno-delete-null-pointer-checks -fno-rename-registers -mbranch-cost=1 --param fsm-scale-path-stmts=5 --param max-average-unrolled-insns=200 --param max-grow-copy-bb-insns=16 --param max-jump-thread-duplication-stmts=8 --param hot-bb-frequency-fraction=4 --param unroll-jam-min-percent=0 -Ofast -ffunction-sections -fdata-sections -fno-common --specs=nano.specs --specs=nosys.specs -u _printf_float  -g -D__IDE_RV_CORE=n205 -DDOWNLOAD_MODE=DOWNLOAD_MODE_FLASHXIP -DDOWNLOAD_MODE_STRING=\"FLASHXIP\" -DFLAGS_STR=\""-Ofast -fno-code-hoisting -fno-tree-vectorize -fno-common -finline-functions -falign-functions=4 -falign-jumps=4 -falign-loops=4 -finline-limit=200 -fno-if-conversion -fno-if-conversion2 -fipa-pta -fselective-scheduling -fno-tree-loop-distribute-patterns -funroll-loops -funroll-all-loops -fno-delete-null-pointer-checks -fno-rename-registers -mbranch-cost=1 --param fsm-scale-path-stmts=5 --param max-average-unrolled-insns=200 --param max-grow-copy-bb-insns=16 --param max-jump-thread-duplication-stmts=8 --param hot-bb-frequency-fraction=4 --param unroll-jam-min-percent=0"\" -DITERATIONS=800 -DPERFORMANCE_RUN=1 -I"D:\design\workplace\rvstar\nuclei_sdk\NMSIS\Core\Include" -I"D:\design\workplace\rvstar\libraries\gd32vf103\HAL_Drivers" -I"D:\design\workplace\rvstar\board" -I"D:\design\workplace\rvstar\rt-thread\include" -I"D:\design\workplace\rvstar\rt-thread\include\libc" -I"D:\design\workplace\rvstar\rt-thread\components\drivers\include" -I"D:\design\workplace\rvstar\rt-thread\components\finsh" -I"D:\design\workplace\rvstar\rt-thread\libcpu\risc-v\nuclei" -I"D:\design\workplace\rvstar\nuclei_sdk\SoC\gd32vf103\Common\Include" -I"D:\design\workplace\rvstar\nuclei_sdk\SoC\gd32vf103\Board\gd32vf103v_rvstar\Include" -I"D:\design\workplace\rvstar\application" -std=gnu11 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -c -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


