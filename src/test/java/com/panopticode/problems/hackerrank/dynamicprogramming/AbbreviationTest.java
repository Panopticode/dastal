package com.panopticode.problems.hackerrank.dynamicprogramming;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AbbreviationTest {

    @DataProvider(name = "test")
    public static Object[][] strings() {
        return new Object[][] {
                { "Pi", "P", true },
                { "AfPZN", "APZNC", false },
                { "LDJAN", "LJJM", false },
                { "UMKFW", "UMKFW", true },
                { "KXzQ", "K", false },
                { "LIT", "LIT", true },
                { "QYCH", "QYCH", true },
                { "DFIQG", "DFIQG", true },
                { "sYOCa", "YOCN", false },
                { "JHMWY", "HUVPW", false },
        };
    }

    @Test(dataProvider = "test")
    public void test(final String a,
                     final String b,
                     boolean expected) {
        var result = Abbreviation.abbreviation(a, b);

        assertEquals(result, expected ? "YES" : "NO");
    }

}