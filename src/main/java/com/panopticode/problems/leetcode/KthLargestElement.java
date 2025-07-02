package com.panopticode.problems.leetcode;

import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 *
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class KthLargestElement {
    private static final Random RND = new Random();

    public int findKthLargest(int[] nums, int k) {
        var heap = new PriorityQueue<Integer>();

        // O(n)
        for (final int num : nums) {
            heap.add(num);

            // O(log k)
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return Optional.ofNullable(heap.poll()).orElse(-1);
    }

    public int findKthLargestQuickSelectLomuto(int[] nums, int k) {
        var l = 0;
        var r = nums.length - 1;

        int pvt;

        while (true) {
            if (l == r) {
                return nums[l];
            }

            randomisePivot(nums, l, r, r);
            pvt = lomuto(nums, l, r);

            if (pvt == k - 1) {
                return nums[pvt];
            }
            else if (pvt <= k - 1) {
                l = pvt + 1;
            }
            else {
                r = pvt - 1;
            }
        }
    }

    public int findKthLargestQuickSelectHoare(final int[] nums,
                                              final int k) {
        var l = 0;
        var r = nums.length - 1;

        int pvt;

        while (true) {
            if (l == r) {
                return nums[l];
            }

            randomisePivot(nums, l, r, l);
            pvt = hoare(nums, l, r);

            if (pvt >= k - 1) {
                r = pvt;
            }
            else {
                l = pvt + 1;
            }
        }
    }

    public static int lomuto(final int[] nums,
                             final int l,
                             final int r) {
        var pvt = nums[r];
        var i = l - 1;

        for (var j = l; j < r; ++j) {
            if (nums[j] >= pvt) {
                i += 1;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, r);

        return i + 1;
    }

    public static int hoare(final int[] nums,
                            final int l,
                            final int r) {
        var pivot = nums[l];
        var i = l - 1;
        var j = r + 1;

        while (true) {
            // Find the leftmost element greater
            // than or equal to pivot
            do {
                i += 1;
            } while (nums[i] > pivot);

            // Find the rightmost element smaller
            // than or equal to pivot
            do {
                j -= 1;
            } while (nums[j] < pivot);

            // If two pointers met.
            if (i >= j)
                return j;

            swap(nums, i, j);
        }
    }

    private static void randomisePivot(final int[] arr,
                                       final int l,
                                       final int r,
                                       final int index) {
        var rndIdx = RND.nextInt(r - l) + l;
        swap(arr, rndIdx, index);
    }

    private static void swap(final int[] a,
                             final int i,
                             final int j) {
        var tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }
}
