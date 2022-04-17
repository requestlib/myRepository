################################################################################
# Automatically-generated file. Do not edit!
################################################################################

-include ../makefile.init

RM := rm -rf

# All of the sources participating in the build are defined here
-include sources.mk
-include test/subdir.mk
-include rt-thread/src/subdir.mk
-include rt-thread/libcpu/risc-v/nuclei/subdir.mk
-include rt-thread/components/finsh/subdir.mk
-include rt-thread/components/drivers/serial/subdir.mk
-include rt-thread/components/drivers/misc/subdir.mk
-include nuclei_sdk/SoC/gd32vf103/Common/Source/Stubs/newlib/subdir.mk
-include nuclei_sdk/SoC/gd32vf103/Common/Source/GCC/subdir.mk
-include nuclei_sdk/SoC/gd32vf103/Common/Source/Drivers/subdir.mk
-include nuclei_sdk/SoC/gd32vf103/Common/Source/subdir.mk
-include nuclei_sdk/SoC/gd32vf103/Board/gd32vf103v_rvstar/Source/subdir.mk
-include libraries/gd32vf103/HAL_Drivers/subdir.mk
-include board/subdir.mk
-include application/subdir.mk
-include subdir.mk
-include objects.mk

ifneq ($(MAKECMDGOALS),clean)
ifneq ($(strip $(CC_DEPS)),)
-include $(CC_DEPS)
endif
ifneq ($(strip $(C++_DEPS)),)
-include $(C++_DEPS)
endif
ifneq ($(strip $(C_UPPER_DEPS)),)
-include $(C_UPPER_DEPS)
endif
ifneq ($(strip $(CXX_DEPS)),)
-include $(CXX_DEPS)
endif
ifneq ($(strip $(ASM_DEPS)),)
-include $(ASM_DEPS)
endif
ifneq ($(strip $(S_UPPER_DEPS)),)
-include $(S_UPPER_DEPS)
endif
ifneq ($(strip $(C_DEPS)),)
-include $(C_DEPS)
endif
ifneq ($(strip $(CPP_DEPS)),)
-include $(CPP_DEPS)
endif
endif

-include ../makefile.defs

# Add inputs and outputs from these tool invocations to the build variables 
SECONDARY_FLASH += \
rvstar.hex \

SECONDARY_LIST += \
rvstar.lst \

SECONDARY_SIZE += \
rvstar.siz \


# All Target
all: rvstar.elf secondary-outputs

# Tool invocations
rvstar.elf: $(OBJS) $(USER_OBJS)
	@echo 'Building target: $@'
	@echo 'Invoking: GNU RISC-V Cross C++ Linker'
	riscv-nuclei-elf-g++ -march=rv32imac -mabi=ilp32 -mcmodel=medany -mno-save-restore -fno-code-hoisting -fno-tree-vectorize -finline-functions -falign-functions=4 -falign-jumps=4 -falign-loops=4 -finline-limit=200 -fno-if-conversion -fno-if-conversion2 -fipa-pta -fselective-scheduling -fno-tree-loop-distribute-patterns -funroll-loops -funroll-all-loops -fno-delete-null-pointer-checks -fno-rename-registers -mbranch-cost=1 --param fsm-scale-path-stmts=5 --param max-average-unrolled-insns=200 --param max-grow-copy-bb-insns=16 --param max-jump-thread-duplication-stmts=8 --param hot-bb-frequency-fraction=4 --param unroll-jam-min-percent=0 -Ofast -ffunction-sections -fdata-sections -fno-common --specs=nano.specs --specs=nosys.specs -u _printf_float  -g -T "D:\design\workplace\rvstar\nuclei_sdk\SoC\gd32vf103\Board\gd32vf103v_rvstar\Source\GCC\gcc_gd32vf103_flashxip.ld" -nostartfiles -Xlinker --gc-sections -Wl,-Map,"rvstar.map" -Wl,--check-sections -u _isatty -u _write -u _sbrk -u _read -u _close -u _fstat -u _lseek -o "rvstar.elf" $(OBJS) $(USER_OBJS) $(LIBS)
	@echo 'Finished building target: $@'
	@echo ' '

rvstar.hex: rvstar.elf
	@echo 'Invoking: GNU RISC-V Cross Create Flash Image'
	riscv-nuclei-elf-objcopy -O ihex "rvstar.elf"  "rvstar.hex"
	@echo 'Finished building: $@'
	@echo ' '

rvstar.lst: rvstar.elf
	@echo 'Invoking: GNU RISC-V Cross Create Listing'
	riscv-nuclei-elf-objdump --source --all-headers --demangle --line-numbers --wide "rvstar.elf" > "rvstar.lst"
	@echo 'Finished building: $@'
	@echo ' '

rvstar.siz: rvstar.elf
	@echo 'Invoking: GNU RISC-V Cross Print Size'
	riscv-nuclei-elf-size --format=berkeley "rvstar.elf"
	@echo 'Finished building: $@'
	@echo ' '

# Other Targets
clean:
	-$(RM) $(CC_DEPS)$(C++_DEPS)$(OBJS)$(C_UPPER_DEPS)$(CXX_DEPS)$(SECONDARY_FLASH)$(SECONDARY_LIST)$(SECONDARY_SIZE)$(ASM_DEPS)$(S_UPPER_DEPS)$(C_DEPS)$(CPP_DEPS) rvstar.elf
	-@echo ' '

secondary-outputs: $(SECONDARY_FLASH) $(SECONDARY_LIST) $(SECONDARY_SIZE)

.PHONY: all clean dependents

-include ../makefile.targets
