package com.panopticode.problems.leetcode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LongestPalindromicSubstringTest {
    private LongestPalindromicSubstring solver;

    @BeforeMethod
    public void setUp() {
        solver = new LongestPalindromicSubstring();
    }

    @Test
    public void testEmptyString() {
        assertEquals(solver.longestPalindrome(""), "");
    }

    @Test
    public void testSingleCharacter() {
        assertEquals(solver.longestPalindrome("a"), "a");
    }

    @Test
    public void testAllSameCharacters() {
        assertEquals(solver.longestPalindrome("aaaa"), "aaaa");
    }

    @Test
    public void testSimplePalindromes() {
        assertEquals(solver.longestPalindrome("babad"), "bab");
        assertEquals(solver.longestPalindrome("cbbd"), "bb");
    }

    @Test
    public void testComplexCases() {
        String longText = """
                civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendure\
                WeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplace\
                forthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothis\
                ButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivingand\
                deadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittle\
                notlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobe\
                dedicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforusto\
                beherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotionto\
                thatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnot\
                havediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythe\
                peopleforthepeoplebythepeoplebythepeoplebythepeoplebythepeoplebythepeopleforthepeopleshallnotperish\
                fromtheearth""";
        assertEquals(solver.longestPalindrome(longText), "ranynar");
        assertEquals(solver.longestPalindrome("aacabdkacaa"), "aca");
    }

    @Test
    public void testIsPalindromeOutsideIn() {
        var palEven = "abcddcba";
        var palOdd = "abcba";
        var notPal = "abcdefegba";
        var partPal = "mnabrbasd";

        assertTrue(solver.isPalindromeOutsideIn(palEven, 0, palEven.length() - 1));
        assertTrue(solver.isPalindromeOutsideIn(palOdd, 0, palOdd.length() - 1));
        assertFalse(solver.isPalindromeOutsideIn(notPal, 0, notPal.length() - 1));
        assertTrue(solver.isPalindromeOutsideIn(partPal, 2, 6));
    }

    @Test
    public void testIsPalindromeInsideOut() {
        var palEven = "abcddcba";
        var palOdd = "abcba";
        var notPal = "abcdefegba";

        var d1 = solver.isPalindromeInsideOut(palEven, 3);
        assertEquals(d1.start(), 0);
        assertEquals(d1.end(), 7);
        var d2 = solver.isPalindromeInsideOut(palOdd, 2);
        assertEquals(d2.start(), 0);
        assertEquals(d2.end(), 4);
        var d3 = solver.isPalindromeInsideOut(notPal, 5);
        assertEquals(d3.start(), 4);
        assertEquals(d3.end(), 6);
    }
}