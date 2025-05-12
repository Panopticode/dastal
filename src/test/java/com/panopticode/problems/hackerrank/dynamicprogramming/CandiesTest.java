package com.panopticode.problems.hackerrank.dynamicprogramming;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CandiesTest {


    @Test(dataProvider = "candiesData")
    public void testCandies(List<Integer> ratings, long expected) {
        var ans = Candies.candies(ratings.size(), ratings);

        assertEquals(ans, expected);
    }

    @DataProvider
    public Object[][] candiesData() {
        return new Object[][]{
                {List.of(4, 6, 4, 5, 6, 2), 10L},
                {List.of(2, 4, 2, 6, 1, 7, 8, 9, 2, 1), 19L},
                {List.of(2, 4, 3, 5, 2, 6, 4, 5), 12L},
                {List.of(2, 4, 2, 5, 7, 9, 10, 9, 8, 7, 6, 1), 34L},
                {List.of(9, 7, 6, 4, 3, 2, 5, 4, 9, 6, 1, 2), 32L},
                {List.of(4, 6, 4, 5, 6, 2), 10L},
                {List.of(2, 4, 2, 6, 1, 7, 7, 7, 2, 1), 16L}
        };
    }
    
    

}