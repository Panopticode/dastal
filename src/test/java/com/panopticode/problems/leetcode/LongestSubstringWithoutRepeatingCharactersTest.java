package com.panopticode.problems.leetcode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LongestSubstringWithoutRepeatingCharactersTest {

    private LongestSubstringWithoutRepeatingCharacters solution;

    @BeforeMethod
    public void setUp() {
        solution = new LongestSubstringWithoutRepeatingCharacters();
    }

    @Test
    public void testEmptyString() {
        assertEquals(solution.lengthOfLongestSubstring(""), 0);
    }

    @Test
    public void testSingleCharacter() {
        assertEquals(solution.lengthOfLongestSubstring("a"), 1);
    }

    @Test
    public void testNoRepeatingCharacters() {
        assertEquals(solution.lengthOfLongestSubstring("abcde"), 5);
    }

    @Test
    public void testWithRepeatingCharacters() {
        assertEquals(solution.lengthOfLongestSubstring("abcabcbb"), 3);
        assertEquals(solution.lengthOfLongestSubstring("bbbbb"), 1);
        assertEquals(solution.lengthOfLongestSubstring("pwwkew"), 3);
        assertEquals(solution.lengthOfLongestSubstring("aaaaabcd"), 4);
        assertEquals(solution.lengthOfLongestSubstring("abcdddddddd"), 4);
    }
}