package com.panopticode.problems.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class SortByBits {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted(new BitComparator()).mapToInt(Integer::intValue).toArray();
    }

    /**
     * Comparator using Brian Kerninghan's Algorithm.
     * It's based on the fact that for any integer x with n bits set to 1, n-1 bits will be in common with x-1.
     */
    static class BitComparator implements Comparator<Integer> {
        private int countBits(int n) {
            var count = 0;

            while (n > 0) {
                n &= (n-1);
                ++count;
            }

            return count;
        }

        @Override
        public int compare(final Integer a, final Integer b) {
            var bitCompA = countBits(a);
            var bitCompB = countBits(b);

            if (bitCompA == bitCompB) {
                return a - b;
            }
            else {
                return bitCompA - bitCompB;
            }
        }
    }
}
