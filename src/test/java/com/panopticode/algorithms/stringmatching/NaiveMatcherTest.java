package com.panopticode.algorithms.stringmatching;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class NaiveMatcherTest extends AbstractMatcherTest {
    @BeforeMethod
    @Override
    void setUp() {
        this.matcher = new NaiveMatcher();
    }

    @Test
    public void testMatch_happyPath() {
        var result = matcher.match("acaabc", "aab");

        assertEquals(result, List.of(2));
    }

    @Test
    public void testMatch_firstAndLast() {
        var result = matcher.match("abbababaaabb", "abb");

        assertEquals(result, List.of(0, 9));
    }
}