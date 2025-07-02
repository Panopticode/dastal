package com.panopticode.problems.leetcode;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

public class KthLargestElementTest {
    private KthLargestElement _test;

    @DataProvider
    public static Object[][] dataProvider() {
        return new Object[][] {
                { new int[]{3,2,1,5,6,4}, 2, 5 },
                { new int[]{3,2,3,1,2,4,5,5,6}, 4, 4 }
        };
    }

    @BeforeClass
    public void setUp() {
        _test = new KthLargestElement();
    }

    @Test(dataProvider = "dataProvider")
    public void test(final int[] nums,
                     final int k,
                     final int expected) {
        assertEquals(_test.findKthLargest(nums, k), expected);
    }

    @Test(dataProvider = "dataProvider")
    public void testQuickSelectLomuto(final int[] nums,
                     final int k,
                     final int expected) {
        assertEquals(_test.findKthLargestQuickSelectLomuto(nums, k), expected);
    }

    @Test(dataProvider = "dataProvider")
    public void testQuickSelectHoare(final int[] nums,
                                      final int k,
                                      final int expected) {
        assertEquals(_test.findKthLargestQuickSelectHoare(nums, k), expected);
    }

    @Test
    public void lomuto1() {
        var arr = new int[]{1, 7, 9, 3, 6, 2, 5, 4};

        var ans = KthLargestElement.lomuto(arr, 0, arr.length - 1);

        assertEquals(ans, 4);
        assertThat(arr).containsExactly(7, 9, 6, 5, 4, 2, 3, 1);
    }

    @Test
    public void lomuto2() {
        var arr = new int[]{100, 7, 109, 100, 101, 100, 5, 101};

        var ans = KthLargestElement.lomuto(arr, 0, arr.length - 1);

        assertEquals(ans, 2);
        assertThat(arr).containsExactly(109, 101, 101, 100, 7, 100, 5, 100);
    }

    @Test
    public void hoare1() {
        var arr = new int[]{3, 7, 9, 1, 6, 2, 5, 4};

        var ans = KthLargestElement.hoare(arr, 0, arr.length - 1);

        assertEquals(ans, 4);
        assertThat(arr).containsExactly(4, 7, 9, 5, 6, 2, 1, 3);
    }

    @Test
    public void hoare2() {
        var arr = new int[]{100, 7, 109, 100, 101, 100, 5, 101};

        var ans = KthLargestElement.hoare(arr, 0, arr.length - 1);

        assertEquals(ans, 3);
        assertThat(arr).containsExactly(101, 100, 109, 101, 100, 7, 5, 100);
    }
}