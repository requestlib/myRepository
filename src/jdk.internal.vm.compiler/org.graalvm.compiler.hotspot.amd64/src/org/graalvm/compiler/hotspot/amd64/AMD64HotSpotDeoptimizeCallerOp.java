/*
 * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


package org.graalvm.compiler.hotspot.amd64;

import static org.graalvm.compiler.hotspot.HotSpotHostBackend.DEOPT_BLOB_UNCOMMON_TRAP;

import org.graalvm.compiler.asm.amd64.AMD64MacroAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.amd64.AMD64Call;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

/**
 * Removes the current frame and tail calls the uncommon trap routine.
 */
@Opcode("DEOPT_CALLER")
final class AMD64HotSpotDeoptimizeCallerOp extends AMD64HotSpotEpilogueBlockEndOp {

    public static final LIRInstructionClass<AMD64HotSpotDeoptimizeCallerOp> TYPE = LIRInstructionClass.create(AMD64HotSpotDeoptimizeCallerOp.class);

    protected AMD64HotSpotDeoptimizeCallerOp() {
        super(TYPE);
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AMD64MacroAssembler masm) {
        leaveFrameAndRestoreRbp(crb, masm);
        AMD64Call.directJmp(crb, masm, crb.foreignCalls.lookupForeignCall(DEOPT_BLOB_UNCOMMON_TRAP));
    }
}
