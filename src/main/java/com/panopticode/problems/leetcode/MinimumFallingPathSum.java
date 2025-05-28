package com.panopticode.problems.leetcode;

import java.util.Arrays;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        var r = matrix.length;
        var c = matrix[0].length;
        var dyn = new int[r][c];

        System.arraycopy(matrix[0], 0, dyn[0], 0, c);

        for (var i = 1; i < r; ++i) {
            for (var j = 0; j < c; ++j) {
                var min = Integer.MAX_VALUE;

                if (j > 0) {
                    min = Math.min(dyn[i - 1][j - 1], min);
                }
                min = Math.min(dyn[i - 1][j], min);
                if (j < dyn[0].length - 1) {
                    min = Math.min(dyn[i - 1][j + 1], min);
                }

                dyn[i][j] = matrix[i][j] + min;
            }
        }

        return Arrays.stream(dyn[r - 1]).min().orElseThrow();
    }

    public int minFallingPathSumInPlace(int[][] matrix) {
        var r = matrix.length;
        var c = matrix[0].length;
        int min;

        for (var i = 1; i < r; ++i) {
            for (var j = 0; j < c; ++j) {
                min = matrix[i - 1][j];

                if (j > 0) {
                    min = Math.min(matrix[i - 1][j - 1], min);
                }
                if (j < matrix[0].length - 1) {
                    min = Math.min(matrix[i - 1][j + 1], min);
                }

                matrix[i][j] = matrix[i][j] + min;
            }
        }

        return Arrays.stream(matrix[r - 1]).min().orElseThrow();
    }
}
