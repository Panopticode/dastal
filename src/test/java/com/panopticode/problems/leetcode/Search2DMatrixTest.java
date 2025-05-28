package com.panopticode.problems.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;


public class Search2DMatrixTest {
    private Search2DMatrix solution;

    @Test
    public void testSearchMatrix() {
        solution = new Search2DMatrix();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        assertTrue(solution.searchMatrix(matrix, 1));
        assertTrue(solution.searchMatrix(matrix, 3));
        assertTrue(solution.searchMatrix(matrix, 60));
        assertFalse(solution.searchMatrix(matrix, -25));
        assertFalse(solution.searchMatrix(matrix, 0));
        assertFalse(solution.searchMatrix(matrix, 13));
        assertFalse(solution.searchMatrix(matrix, 61));
    }

    @Test
    public void testEmptyMatrix() {
        solution = new Search2DMatrix();
        int[][] matrix = {};
        assertFalse(solution.searchMatrix(matrix, 0));
    }

    @Test
    public void testSingleElementMatrix() {
        solution = new Search2DMatrix();
        int[][] matrix = {{1}};
        assertTrue(solution.searchMatrix(matrix, 1));
        assertFalse(solution.searchMatrix(matrix, 0));
    }

    @Test
    public void testMatrixWithNegativeNumbers() {
        solution = new Search2DMatrix();
        int[][] matrix = {
                {-10, -8, -6},
                {-5, -3, -1},
                {2, 4, 6}
        };
        assertTrue(solution.searchMatrix(matrix, -10));
        assertTrue(solution.searchMatrix(matrix, -3));
        assertTrue(solution.searchMatrix(matrix, 6));
        assertFalse(solution.searchMatrix(matrix, -9));
        assertFalse(solution.searchMatrix(matrix, 1));
        assertFalse(solution.searchMatrix(matrix, 7));
    }
}