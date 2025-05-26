package com.panopticode.problems.leetcode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LongestCommonPrefixTest {

    private LongestCommonPrefix solver;

    @BeforeMethod
    public void setUp() {
        solver = new LongestCommonPrefix();
    }

    @Test
    public void testEmptyArray() {
        assertEquals(solver.longestCommonPrefix(new String[]{}), "");
        assertEquals(solver.longestCommonPrefixWithSorting(new String[]{}), "");
    }

    @Test
    public void testSingleString() {
        assertEquals(solver.longestCommonPrefix(new String[]{"hello"}), "hello");
        assertEquals(solver.longestCommonPrefixWithSorting(new String[]{"hello"}), "hello");
    }

    @Test
    public void testCommonPrefix() {
        assertEquals(solver.longestCommonPrefix(new String[]{"flower", "flow", "flight"}), "fl");
        assertEquals(solver.longestCommonPrefix(new String[]{"interstellar", "interrupt", "integer"}), "inte");
        assertEquals(solver.longestCommonPrefix(new String[]{"hel", "hello", "hell"}), "hel");
        assertEquals(solver.longestCommonPrefix(new String[]{"hell", "hel", "hell"}), "hel");
        assertEquals(solver.longestCommonPrefixWithSorting(new String[]{"flower", "flow", "flight"}), "fl");
        assertEquals(solver.longestCommonPrefixWithSorting(new String[]{"interstellar", "interrupt", "integer"}), "inte");
        assertEquals(solver.longestCommonPrefixWithSorting(new String[]{"hel", "hello", "hell"}), "hel");
        assertEquals(solver.longestCommonPrefixWithSorting(new String[]{"hell", "hel", "hell"}), "hel");
    }

    @Test
    public void testNoCommonPrefix() {
        assertEquals(solver.longestCommonPrefix(new String[]{"dog", "racecar", "car"}), "");
        assertEquals(solver.longestCommonPrefix(new String[]{"cat", "dog", "rat"}), "");
        assertEquals(solver.longestCommonPrefixWithSorting(new String[]{"dog", "racecar", "car"}), "");
        assertEquals(solver.longestCommonPrefixWithSorting(new String[]{"cat", "dog", "rat"}), "");
    }

    @Test
    public void testEmptyStrings() {
        assertEquals(solver.longestCommonPrefix(new String[]{"", ""}), "");
        assertEquals(solver.longestCommonPrefix(new String[]{"", "a"}), "");
        assertEquals(solver.longestCommonPrefixWithSorting(new String[]{"", ""}), "");
        assertEquals(solver.longestCommonPrefixWithSorting(new String[]{"", "a"}), "");
    }
}