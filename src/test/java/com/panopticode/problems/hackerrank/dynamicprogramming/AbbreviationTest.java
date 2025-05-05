package com.panopticode.problems.hackerrank.dynamicprogramming;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import static org.testng.Assert.assertEquals;

public class AbbreviationTest {

    @DataProvider
    public static Object[][] simple() {
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
                { "JHMY", "JHMYY", false },
        };
    }

    @DataProvider
    public Iterator<Object[]> longStrings()
            throws IOException {
        var args = new ArrayList<Object[]>();

        try (var is = getClass().getClassLoader().getResourceAsStream("abbreviation_long_strings.txt")) {
            assert is != null;
            var bufferedReader = new BufferedReader(new InputStreamReader(is));
            var line1 = bufferedReader.readLine();

            while (line1 != null) {
                // line1 is a
                var line2 = bufferedReader.readLine();   // b
                var line3 = bufferedReader.readLine();   // expected result

                var entry = new Object[]{
                        line1, line2, line3
                };
                args.add(entry);

                line1 = bufferedReader.readLine();
            }
        }

        return args.iterator();
    }

    @BeforeClass
    public void setUp() {
        Abbreviation.setDebug(false);
    }

    @Test(dataProvider = "simple")
    public void testSimple(final String a,
                     final String b,
                     boolean expected) {
        var result = Abbreviation.abbreviation(a, b);

        assertEquals(result, expected ? "YES" : "NO");
    }

    @Test(dataProvider = "longStrings")
    public void testLongStrings(final String a,
                     final String b,
                     final String expected) {
        var result = Abbreviation.abbreviation(a, b);

        assertEquals(result, expected);
    }

}