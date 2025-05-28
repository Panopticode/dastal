package com.panopticode.problems.leetcode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsNoOrder;
import static org.testng.Assert.assertNull;

public class TwoSumTest {

    private TwoSum solver;

    @BeforeMethod
    public void setUp() {
        solver = new TwoSum();
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        int target = 0;
        assertNull(solver.twoSumNaive(nums, target));
        assertNull(solver.twoSum(nums, target));
        assertNull(solver.twoSumQuick(nums, target));
    }

    @Test
    public void testNoSolution() {
        int[] nums = {1, 2, 3, 4};
        int target = 8;
        assertNull(solver.twoSumNaive(nums, target));
        assertNull(solver.twoSum(nums, target));
        assertNull(solver.twoSumQuick(nums, target));
    }

    @Test
    public void testBasicSolution() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        assertEquals(solver.twoSumNaive(nums, target), new int[]{0, 1});
        assertEqualsNoOrder(toList(solver.twoSum(nums, target)), List.of(0, 1));
        assertEqualsNoOrder(toList(solver.twoSumQuick(nums, target)), List.of(0, 1));
    }

    @Test
    public void testTwoDuplicateNumbers() {
        int[] nums = {3, 3};
        int target = 6;
        assertEquals(solver.twoSumNaive(nums, target), new int[]{0, 1});
        assertEqualsNoOrder(toList(solver.twoSum(nums, target)), List.of(0, 1));
        assertEqualsNoOrder(toList(solver.twoSumQuick(nums, target)), List.of(0, 1));
    }

    @Test
    public void testDuplicateNumbers() {
        int[] nums = {-1, 3, 5, 3, -4};
        int target = 6;
        assertEquals(solver.twoSumNaive(nums, target), new int[]{1, 3});
        assertEqualsNoOrder(toList(solver.twoSum(nums, target)), List.of(1, 3));
        assertEqualsNoOrder(toList(solver.twoSumQuick(nums, target)), List.of(1, 3));
    }

    @Test
    public void testNegativeNumbers() {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;
        assertEquals(solver.twoSumNaive(nums, target), new int[]{2, 4});
        assertEqualsNoOrder(toList(solver.twoSum(nums, target)), List.of(2, 4));
        assertEqualsNoOrder(toList(solver.twoSumQuick(nums, target)), List.of(2, 4));
    }

    @Test
    public void testMixedNumbers() {
        int[] nums = {1, -2, -3, 4, -5, 6};
        int target = 4;
        assertEquals(solver.twoSumNaive(nums, target), new int[]{1, 5});
        assertEqualsNoOrder(toList(solver.twoSum(nums, target)), List.of(1, 5));
        assertEqualsNoOrder(toList(solver.twoSumQuick(nums, target)), List.of(1, 5));
    }

    // the following cases are edge cases that we can rule out, because the problem states that we
    // can assume the solution is unique.
//    @Test
//    public void testSameNumbers() {
//        int[] nums = {1, 5, 1, 5, 1, 5};
//        int target = 10;
//        assertEquals(solver.twoSumNaive(nums, target), new int[]{1, 3});
//        assertEquals(solver.twoSum(nums, target), new int[]{1, 5});
//    }
//
//    @Test
//    public void testAllSameNumbers() {
//        int[] nums = {5, 5, 5, 5, 5, 5};
//        int target = 10;
//        assertEquals(solver.twoSumNaive(nums, target), new int[]{0, 1});
//        assertEquals(solver.twoSum(nums, target), new int[]{0, 1});
//    }

    private static List<Integer> toList(int[] array) {
        return Arrays.stream(array).boxed().toList();
    }
}