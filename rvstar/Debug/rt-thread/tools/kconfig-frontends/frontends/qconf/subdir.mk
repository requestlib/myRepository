################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CC_SRCS += \
../rt-thread/tools/kconfig-frontends/frontends/qconf/qconf.cc 

CC_DEPS += \
./rt-thread/tools/kconfig-frontends/frontends/qconf/qconf.d 

OBJS += \
./rt-thread/tools/kconfig-frontends/frontends/qconf/qconf.o 


# Each subdirectory must supply rules for building sources it contributes
rt-thread/tools/kconfig-frontends/frontends/qconf/%.o: ../rt-thread/tools/kconfig-frontends/frontends/qconf/%.cc
	@echo 'Building file: $<'
	@echo 'Invoking: GNU RISC-V Cross C++ Compiler'
	riscv-nuclei-elf-g++ -march=rv32imac -mabi=ilp32 -mcmodel=medany -mno-save-restore -fno-code-hoisting -fno-tree-vectorize -finline-functions -falign-functions=4 -falign-jumps=4 -falign-loops=4 -finline-limit=200 -fno-if-conversion -fno-if-conversion2 -fipa-pta -fselective-scheduling -fno-tree-loop-distribute-patterns -funroll-loops -funroll-all-loops -fno-delete-null-pointer-checks -fno-rename-registers -mbranch-cost=1 --param fsm-scale-path-stmts=5 --param max-average-unrolled-insns=200 --param max-grow-copy-bb-insns=16 --param max-jump-thread-duplication-stmts=8 --param hot-bb-frequency-fraction=4 --param unroll-jam-min-percent=0 -Ofast -ffunction-sections -fdata-sections -fno-common --specs=nano.specs --specs=nosys.specs -u _printf_float  -g -D__IDE_RV_CORE=n205 -DDOWNLOAD_MODE=DOWNLOAD_MODE_FLASHXIP -DDOWNLOAD_MODE_STRING=\"FLASHXIP\" -I"D:\design\workplace\rvstar\nuclei_sdk\NMSIS\Core\Include" -I"D:\design\workplace\rvstar\nuclei_sdk\SoC\gd32vf103\Common\Include" -I"D:\design\workplace\rvstar\nuclei_sdk\SoC\gd32vf103\Board\gd32vf103v_rvstar\Include" -I"D:\design\workplace\rvstar\application" -std=gnu++11 -fabi-version=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -c -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


