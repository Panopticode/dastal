package com.panopticode.problems.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 */
public class TopKFrequentElements {

    // O(n + n log n) /in O(n(1 + log n)) /in O(n log n)
    public int[] topKFrequentNaive(int[] nums, int k) {
        var countMap = new HashMap<Integer, Integer>();
        var ans = new int[k];

        // O(n)
        for (final int num : nums) {
            var value = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, value);
        }

        // eg input = [1,1,1,2,2,3], countMap = {(1, 3), (2, 2), (3, 1)}

        // O(n log n)
        List<Map.Entry<Integer, Integer>> sorted = countMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparingInt(Map.Entry::getValue)))
                .toList();

        for (var i = 0; i < k; ++i) {
            ans[i] = sorted.get(i).getKey();
        }

        return ans;
    }

    // O(n log k)
    public int[] topKFrequent(int[] nums, int k) {
        var countMap = new HashMap<Integer, Integer>();
        var topK = new PriorityQueue<Map.Entry<Integer, Integer>>(k, Comparator.comparingInt(Map.Entry::getValue));
        var ans = new int[k];

        // O(n)
        for (final int num : nums) {
            var value = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, value);
        }

        // eg input = [1,1,1,2,2,3], countMap = {(1, 3), (2, 2), (3, 1)}

        // O(n)
        for (var entry: countMap.entrySet()) {
            // O(log k)
            topK.add(entry);

            // O(1)
            if (topK.size() > k) {
                topK.poll();
            }
        }

        for (var i = 0; i < k; ++i) {
            ans[i] = Objects.requireNonNull(topK.poll()).getKey();
        }

        return ans;
    }

    // uses bucket sort
    // O(n + R) where R is the range (ie max - min among values)
    // NB: this is only quick for small R!
    public int[] topKFrequentQuick(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // O(n) - find min and max
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        int[] freq = new int[max - min + 1];
        int max_freq = 0;

        // build array of frequencies (normalised over min)
        for (int num : nums) {
            int dif = num - min;
            int f = ++freq[dif];
            if (f > max_freq) {
                max_freq = f;
            }
        }

        // create buckets, where buckets[i] contains numbers with frequency i+1
        ArrayList<Integer>[] buckets = new ArrayList[max_freq];
        for (int i = 0; i < freq.length; i++) {
            int n = freq[i] -1;
            if (n == -1) {
                continue;
            }
            if (buckets[n] == null) {
                buckets[n] = new ArrayList<>();
            }
            buckets[n].add(i + min);
        }

        // find the k buckets starting from the highest frequency
        int[] res = new int[k];
        int t = 0;
        for (int i = max_freq - 1; i >= 0; i--) {
            if (buckets[i] == null) continue;
            for (int j = 0; j < buckets[i].size(); j++) {
                res[t++] = buckets[i].get(j);
                if (t == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
