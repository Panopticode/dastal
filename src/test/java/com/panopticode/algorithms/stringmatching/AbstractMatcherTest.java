package com.panopticode.algorithms.stringmatching;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractMatcherTest {
    protected StringMatcher matcher;

    @BeforeMethod
    abstract void setUp();

    @Test
    public void testSingleOccurrence() {
        List<Integer> result = matcher.match("helloworld", "world");
        Assert.assertEquals(result, Collections.singletonList(5));
    }

    @Test
    public void testMultipleOccurrences() {
        List<Integer> result = matcher.match("abababab", "ab");
        Assert.assertEquals(result, Arrays.asList(0, 2, 4, 6));
    }

    @Test
    public void testNoOccurrence() {
        List<Integer> result = matcher.match("abcdef", "gh");
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testEmptyText() {
        List<Integer> result = matcher.match("", "pattern");
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testEmptyPattern() {
        List<Integer> result = matcher.match("text", "");
        // Assuming empty pattern matches at every position
        Assert.assertEquals(result, Arrays.asList(0, 1, 2, 3, 4));
    }

    @Test
    public void testBothEmpty() {
        List<Integer> result = matcher.match("", "");
        Assert.assertEquals(result, Collections.singletonList(0));
    }

    @Test
    public void testPatternLongerThanText() {
        List<Integer> result = matcher.match("abc", "abcdef");
        Assert.assertTrue(result.isEmpty());
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullText() {
        matcher.match(null, "abc");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullPattern() {
        matcher.match("abcdef", null);
    }
}
