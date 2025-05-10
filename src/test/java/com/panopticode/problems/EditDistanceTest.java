package com.panopticode.problems;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EditDistanceTest {

    @BeforeClass
    public void setUp() {
        EditDistance.setDebug(false);
    }

    @Test
    public void testEditDistance_happyPath() {
        var result =  EditDistance.editDistance("algorithm", "altruistic");

        assertEquals(result, 23);
    }

    @Test
    public void testEditDistance_identicalStrings() {
        var string = "algorithm";
        var result =  EditDistance.editDistance(string, string);

        assertEquals(result, 2 * string.length());
    }

    @Test
    public void testEditDistance_emptyStrings() {
        var result =  EditDistance.editDistance("", "");

        assertEquals(result, 0);
    }

    @Test
    public void testEditDistance_oneEmpty() {
        var string = "algorithm";
        var result =  EditDistance.editDistance(string, "");

        assertEquals(result, 2 * string.length());
    }

    @Test
    public void testEditDistance_differentStringsSameLength() {
        var string = "abcdefghi";
        var result =  EditDistance.editDistance(string, "lmnopqrst");

        assertEquals(result, 3 * string.length());
    }

    @Test
    public void testEditDistance_differentStringsDifferentLength() {
        var string1 = "01234567";
        var string2 = "abcdefghilmnopqrstuvwx";
        var result =  EditDistance.editDistance(string1, string2);

        assertEquals(result, 3 * string1.length() + 2 * (string2.length() - string1.length()));
    }
}