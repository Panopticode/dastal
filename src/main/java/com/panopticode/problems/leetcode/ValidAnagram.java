package com.panopticode.problems.leetcode;

import java.util.HashMap;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 *
 * Output: false
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var check = new HashMap<Character, Integer>();

        for (Character c : s.toCharArray()) {
            check.put(c, check.getOrDefault(c, 0) + 1);
        }

        for (Character c : t.toCharArray()) {
            var count = check.get(c);

            if (count == null || count == 0) {
                return false;
            }

            check.put(c, count - 1);
        }

        return true;
    }
}
