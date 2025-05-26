package com.panopticode.problems.leetcode;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        String longestPalindrome = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            var delim  = isPalindromeInsideOut(s, i);

            if (delim != null) {
                var cand = s.substring(delim.start(), delim.end() + 1);
                if (cand.length() > longestPalindrome.length()) {
                    longestPalindrome = cand;
                }
            }
        }

        return longestPalindrome;
    }

    public boolean isPalindromeOutsideIn(String s, int from, int to) {
        for (int i = from, j = to; j - i >= 0; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Expands around the centres (from, to). Returns null if there's no valid palindrome
     * or if the initial characters don't match.
     */
    public Delimiter isPalindromeInsideOut(String s, int mid) {
        if (mid < 0 || mid >= s.length()) {
            return null;
        }
        int l = mid, r = mid;
        // 1) Expand to the right if it's the same character
        while (r + 1 < s.length() && s.charAt(r) == s.charAt(r + 1)) {
            ++r;
        }

        // 2) Expand outwards while still a palindrome
        while (l - 1 >= 0 && r + 1 < s.length() && s.charAt(l - 1) == s.charAt(r + 1)) {
            l--;
            r++;
        }
        return new Delimiter(l, r);
    }

    public record Delimiter(int start, int end) {}
}