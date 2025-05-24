package com.panopticode.problems.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ClimbingStairsTest {

    @Test
    public void testClimbStairs() {
        var sol = new ClimbingStairs();

        assertEquals(sol.climbStairs(2), 2);
        assertEquals(sol.climbStairs(3), 3);
        assertEquals(sol.climbStairs(5), 8);
    }
}