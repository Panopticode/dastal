package com.panopticode.problems.leetcode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RansomNoteTest {

    private RansomNote ransomNoteSolver;

    @BeforeMethod
    public void setUp() {
        ransomNoteSolver = new RansomNote();
    }

    @Test
    public void testEmptyRansomNote() {
        // Even an empty ransom note can always be constructed
        assertTrue(ransomNoteSolver.canConstruct("", ""));
        assertTrue(ransomNoteSolver.canConstruct("", "anything"));
    }

    @Test
    public void testEmptyMagazine() {
        // Non-empty ransom note cannot be constructed from an empty magazine
        assertFalse(ransomNoteSolver.canConstruct("a", ""));
        assertFalse(ransomNoteSolver.canConstruct("hello", ""));
    }

    @Test
    public void testExactMatch() {
        // Magazine has exactly the same letters as the ransom note
        assertTrue(ransomNoteSolver.canConstruct("abc", "abc"));
        assertTrue(ransomNoteSolver.canConstruct("zz", "zz"));
    }

    @Test
    public void testNotEnoughCharacters() {
        // Magazine is shorter than ransom note
        assertFalse(ransomNoteSolver.canConstruct("abcd", "abc"));
        // Magazine missing a needed character
        assertFalse(ransomNoteSolver.canConstruct("aa", "ab"));
    }

    @Test
    public void testExtraCharacters() {
        // Magazine has extra letters that are not needed
        assertTrue(ransomNoteSolver.canConstruct("aaa", "aaabbb"));
        assertTrue(ransomNoteSolver.canConstruct("read", "editoraready"));
    }

    @Test
    public void testComplexCase() {
        String note = "leetcode";
        String magazine = "lleetcodeo";
        // counts: l(2), e(4), t(1), c(1), o(1), d(1)
        assertTrue(ransomNoteSolver.canConstruct(note, magazine));

        String missingMagazine = "leetcode";
        // one 'e' short
        assertFalse(ransomNoteSolver.canConstruct("eeeee", missingMagazine));
    }

    @Test
    public void testAllSameCharacter() {
        // Large counts of same character
        String note = "a".repeat(1000);
        String magazine = "a".repeat(1000);
        assertTrue(ransomNoteSolver.canConstruct(note, magazine));

        String tooShortMagazine = "a".repeat(999);
        assertFalse(ransomNoteSolver.canConstruct(note, tooShortMagazine));
    }
}