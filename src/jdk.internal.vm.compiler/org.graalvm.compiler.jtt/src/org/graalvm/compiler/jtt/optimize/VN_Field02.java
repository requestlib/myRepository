/*
 * Copyright (c) 2009, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 * Tests constant folding of integer operations.
 */
public class VN_Field02 extends JTTTest {

    private static class TestClass {
        int field = 9;
    }

    private static boolean cond = true;
    static final TestClass object = new TestClass();

    public static int test(int arg) {
        if (arg == 0) {
            return test1();
        }
        if (arg == 1) {
            return test2();
        }
        if (arg == 2) {
            return test3();
        }
        return 0;
    }

    private static int test1() {
        TestClass a = object;
        int c = a.field;
        if (cond) {
            return c + a.field;
        }
        return 0;
    }

    private static int test2() {
        TestClass a = object;
        if (cond) {
            TestClass b = object;
            return a.field + b.field;
        }
        return 0;
    }

    @SuppressWarnings("all")
    private static int test3() {
        TestClass a = null;
        if (cond) {
            TestClass b = null;
            return a.field + b.field;
        }
        return 0;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2);
    }

}
