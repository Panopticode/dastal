package com.panopticode.problems.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        var r = matrix.length;

        var col1 = new int[r];

        for (int i = 0; i < r; i++) {
            col1[i] = matrix[i][0];
        }

        var ir = Arrays.binarySearch(col1, target);

        if (ir >= 0) {
            return true;
        }

        ir = -ir-2;

        if (ir < 0) {
            return false;
        }

        var ic = Arrays.binarySearch(matrix[ir], target);

        return ic >= 0;
    }
}
