package com.panopticode.algorithms.stringmatching;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class RabinKarpMatcherTest extends AbstractMatcherTest {
    @BeforeMethod
    @Override
    void setUp() {
        this.matcher = new RabinKarpMatcher(RabinKarpMatcher.Alphabet.ALPHA);
    }

    @Test
    public void testMatch_happyPathDigit() {
        var matcher = new RabinKarpMatcher(RabinKarpMatcher.Alphabet.DIGIT);

        var result = matcher.match("2359023141526739921", "31415");

        assertEquals(result, List.of(6));
    }

    @Test
    public void testMatch_happyPathAlpha() {
        var result = matcher.match("abbababaaabb", "abb");

        assertEquals(result, List.of(0, 9));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMatch_invalidAlphaThrows() {
        matcher.match("16857498", "74");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMatch_invalidDigitThrows() {
        var matcher = new RabinKarpMatcher(RabinKarpMatcher.Alphabet.DIGIT);

        matcher.match("abdkjasfdbyaeb", "jas");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTextWithInvalidCharacters() {
        matcher.match("abc def", "abc");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testPatternWithInvalidCharacters() {
        matcher.match("abcdef", "ab c");
    }
}