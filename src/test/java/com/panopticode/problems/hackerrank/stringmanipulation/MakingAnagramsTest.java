package com.panopticode.problems.hackerrank.stringmanipulation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MakingAnagramsTest {

    @DataProvider(name = "test")
    public static Object[][] strings() {
        return new Object[][] {
                { "cde", "abc", 4 },
                { "showman", "woman", 2 },
                { "fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke", 30 },
        };
    }

    @Test(dataProvider = "test")
    public void test(final String a,
                     final String b,
                     int expected) {
        var result = MakingAnagrams.makeAnagram(a, b);

        assertEquals(result, expected);
    }
}