package com.panopticode.problems.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortByBitsTest {

    @Test
    public void testSortByBits() {
        var arr = new int[] {0,1,2,3,4,5,6,7,8};
        var sol = new SortByBits();

        assertEquals(sol.sortByBits(arr), new int[]{0,1,2,4,8,3,5,6,7});
    }

    @Test
    public void testSortByBits_sameBits() {
        var arr = new int[] {1024,512,256,128,64,32,16,8,4,2,1};
        var sol = new SortByBits();

        assertEquals(sol.sortByBits(arr), new int[]{1,2,4,8,16,32,64,128,256,512,1024});
    }
}