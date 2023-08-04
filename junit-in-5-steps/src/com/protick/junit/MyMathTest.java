package com.protick.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    private final MyMath myMath = new MyMath();

    @Test
    void calculateSum_threeMemberArray() {
        assertEquals(6,myMath.calculateSum(new int[]{1,2,3}));
    }

    @Test
    void calculateSum_EmptyArray() {
        assertEquals(0,myMath.calculateSum(new int[]{}));
    }

    @Test
    void testAssert() {
        assertArrayEquals(new int[]{1,2},new int[]{1,2,3});
    }

}