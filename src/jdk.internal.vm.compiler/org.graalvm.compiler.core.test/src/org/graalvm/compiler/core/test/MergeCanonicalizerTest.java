/*
 * Copyright (c) 2011, 2019, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.test;

import org.graalvm.compiler.debug.DebugContext;
import org.graalvm.compiler.nodes.ReturnNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.phases.OptimisticOptimizations;
import org.junit.Test;

public class MergeCanonicalizerTest extends GraalCompilerTest {

    /**
     * These tests assume all code paths are reachable so disable profile based dead code removal.
     */
    @Override
    protected OptimisticOptimizations getOptimisticOptimizations() {
        return OptimisticOptimizations.ALL.remove(OptimisticOptimizations.Optimization.RemoveNeverExecutedCode);
    }

    public static int staticField;

    private int field;

    @Test
    public void testSplitReturn() {
        test("testSplitReturnSnippet", 2);
        testReturnCount("testSplitReturnSnippet", 2);
    }

    public int testSplitReturnSnippet(int b) {
        int v;
        if (b < 0) {
            staticField = 1;
            v = 10;
        } else {
            staticField = 2;
            v = 20;
        }
        int i = field;
        i = field + i;
        return v;
    }

    private void testReturnCount(String snippet, int returnCount) {
        StructuredGraph graph = parseEager(snippet, AllowAssumptions.YES);
        createCanonicalizerPhase().apply(graph, getProviders());
        createCanonicalizerPhase().apply(graph, getProviders());
        graph.getDebug().dump(DebugContext.BASIC_LEVEL, graph, "Graph");
        assertDeepEquals(returnCount, graph.getNodes(ReturnNode.TYPE).count());
    }
}
