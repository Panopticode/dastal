package com.panopticode.problems.leetcode;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TopKFrequentElementsTest {
    private TopKFrequentElements _test;

    @DataProvider
    public static Object[][] dataProvider() {
        return new Object[][]{
                { new int[]{1, 1, 1, 2, 2, 3}, 2, List.of(1, 2) },
                { new int[]{5,3,1,1,1,3,73,1}, 2, List.of(1, 3) }
        };
    }

    @BeforeClass
    public void setUp() {
        _test = new TopKFrequentElements();
    }

    @Test
    public void testTopKFrequentNaive() {
        var ans = Arrays.stream(_test.topKFrequentNaive(new int[]{1, 1, 1, 2, 2, 3}, 2)).boxed().toList();

        assertThat(ans).hasSameElementsAs(List.of(1, 2));
    }

    @Test(dataProvider = "dataProvider")
    public void testTopKFrequent(final int[] nums,
                                 final int k,
                                 final List<Integer> expected) {
        var ans = Arrays.stream(_test.topKFrequent(nums, k)).boxed().toList();

        assertThat(ans).hasSameElementsAs(expected);
    }

    @Test(dataProvider = "dataProvider")
    public void testTopKFrequentQuick(final int[] nums,
                                 final int k,
                                 final List<Integer> expected) {
        var ans = Arrays.stream(_test.topKFrequentQuick(nums, k)).boxed().toList();

        assertThat(ans).hasSameElementsAs(expected);
    }
}