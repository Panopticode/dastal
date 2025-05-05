package com.panopticode.algorithms.dynamicprogramming;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LongestCommonSubsequenceTest {

    @Test
    public void testCompute() {
        var s1 = "ABCBDAB".toCharArray();
        var s2 = "BDCABA".toCharArray();

        var res = LongestCommonSubsequence.compute(s1, s2);

        assertEquals(res, "BCBA");
    }
}