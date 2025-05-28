package com.panopticode.problems.leetcode;

import java.util.HashMap;

public class TwoSum {
    // O(n^2)
    public int[] twoSumNaive(int[] nums, int target) {

        for (var i = 0; i < nums.length - 1; ++i) {
            for (var j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    // O(n) space complexity
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();

        // O(n)
        for (var i = 0; i < nums.length; ++i) {
            var diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{i, map.get(diff)};
            }
            else {
                map.put(nums[i], i);
            }
        }

        return null;
    }

    // O(1) space complexity
    public int[] twoSumQuick(int[] nums, int target) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j-i] + nums[j] == target) {
                    return new int[] {j-i, j};
                }
            }
        }
        return null;
    }
}
