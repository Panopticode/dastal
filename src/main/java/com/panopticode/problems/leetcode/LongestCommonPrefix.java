package com.panopticode.problems.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 2) {
            return strs.length == 0 ? "" : strs[0];
        }

        var sb = new StringBuilder();
        var str1 = strs[0];

        for (var i = 0; i < str1.length(); ++i) {
            var c = str1.charAt(i);

            for (var j = 1; j < strs.length; ++j) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }

    public String longestCommonPrefixWithSorting(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int index = 0;
        while (index < first.length() && index < last.length()) {
            if (first.charAt(index) == last.charAt(index)) {
                index++;
            }
            else {
                break;
            }

        }
        return first.substring(0, index);
    }
}
