package com.panopticode.problems.leetcode;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        var steps = new int[n + 1];
        steps[1] = 1;
        steps[2] = 2;

        for (var i = 3; i <= n; ++i) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }

        return steps[n];
    }
}
