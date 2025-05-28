package com.panopticode.problems.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MinimumFallingPathSumTest {

    @DataProvider(name = "test")
    public static Object[][] testData() {
        return new Object[][]{
                {new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}, 13},
                {new int[][]{{2, 1, 3, 4}, {7, 6, 5, 4}, {8, 9, 1, 5}, {6, 3, 4, 2}}, 9},
                {new int[][]{{-19, 57}, {-40, -5}}, -59},
                {new int[][]{{-48}}, -48}
        };
    }

    @Test(dataProvider = "test")
    public void test(int[][] matrix, int expected) {
        var solution = new MinimumFallingPathSum();
        assertEquals(solution.minFallingPathSum(matrix), expected);
        assertEquals(solution.minFallingPathSumInPlace(matrix), expected);
    }
}