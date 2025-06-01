package com.panopticode.problems.leetcode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

public class WordBreakTest {

    private WordBreak wordBreak;

    @BeforeMethod
    public void setUp() {
        wordBreak = new WordBreak();
    }

    @Test
    public void testSingleWord() {
        assertTrue(wordBreak.wordBreak("leet", List.of("leet")));
        assertFalse(wordBreak.wordBreak("leetx", List.of("leet")));
    }

    @Test
    public void testMultipleWords() {
        assertTrue(wordBreak.wordBreak("leetcode", List.of("leet", "code")));
        assertTrue(wordBreak.wordBreak("applepenapple", List.of("apple", "pen")));
    }

    @Test
    public void testOverlappingWords() {
        assertFalse(wordBreak.wordBreak("catsandog", List.of("cats","dog","sand","and","cat")));
        assertTrue(wordBreak.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat", "an")));
    }

    @Test
    public void testRepeatedWords() {
        assertTrue(wordBreak.wordBreak("gogogo", List.of("go")));
        assertTrue(wordBreak.wordBreak("aaaaaaa", List.of("a", "aa", "aaa")));
    }
}