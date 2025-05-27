package com.panopticode.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        final Map<Character, Integer> ledge = new HashMap<>();
        var longest = 0;
        int left = 0, right;
        ledge.put(s.charAt(left), left);

        for (right = 1; right < s.length() && left < s.length(); ++right) {
            var index = ledge.get(s.charAt(right));
            if (index != null && index >= left) { // found duplicate
                longest = Math.max(longest, right - left);
//                System.out.printf("candidate substring '%s'\n", s.substring(left, right));
                left = index + 1;
            }
            ledge.put(s.charAt(right), right);
        }

        longest = Math.max(longest, right - left);

        return longest;
    }

}
