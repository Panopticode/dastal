package com.panopticode.algorithms.dynamicprogramming;

public class LongestCommonSubsequence {

    public static String compute(final char[] s1, final char[] s2) {
        var table = new int[s1.length + 1][s2.length  + 1];
        var ans = new StringBuilder();

        for (int i = 1; i <= s1.length; ++i) {
            for (int j = 1; j <= s2.length ; ++j) {
                if (s1[i - 1] == s2[j - 1]) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                }
                else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        backtrackLcs(table, s1, s2, s1.length, s2.length, ans);

        return ans.toString();
    }

    private static void backtrackLcs(final int[][] table,
                              final char[] s1,
                              final char[] s2,
                              final int i,
                              final int j,
                              final StringBuilder collector) {
        if (i == 0 || j == 0) {
            return;
        }

        if (s1[i - 1] == s2[j - 1]) {
            backtrackLcs(table, s1, s2, i - 1, j - 1, collector);
            collector.append(s1[i - 1]);
        }
        else if (table[i - 1][j] >= table[i][j - 1]) {
            backtrackLcs(table, s1, s2, i - 1, j, collector);
        }
        else {
            backtrackLcs(table, s1, s2, i, j - 1, collector);
        }
    }
}
