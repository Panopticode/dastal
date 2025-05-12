package com.panopticode.problems.hackerrank.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * Alice is a kindergarten teacher. She wants to give some candies to the children in her class.
 * All the children sit in a line and each of them has a rating score according to his or her
 * performance in the class.  Alice wants to give at least 1 candy to each child. If two children
 * sit next to each other, then the one with the higher rating must get more candies.
 * Alice wants to minimize the total number of candies she must buy.
 *
 * <h3> Example
 * <p>
 * arr = [4, 6, 4, 5, 6, 2]
 * <p>
 * She gives the students candy in the following minimal amounts: [1, 2, 1, 2, 3, 1].
 * She must buy a minimum of 10 candies.
 */
public class Candies {

    /*
     * Complete the 'candies' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static long candies(int n, List<Integer> arr) {
        // Do a naive first pass left-to-right and then another pass right-to-left to adjust the values
        var candies = new int[arr.size()];
        candies[0] = 1;

        // fist pass
        for (int i = 1; i < arr.size(); ++i) {
            if (arr.get(i) > arr.get(i - 1)) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        // second pass
        for (int i = arr.size() - 2; i >= 0; --i) {
            switch (Integer.compare(arr.get(i), arr.get(i + 1))) {
                case 1:
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                    break;
                case 0:
                    break;
                case -1:
                    if (candies[i + 1] > 1) {
                        candies[i] = Math.min(candies[i], candies[i + 1] - 1);
                    } else {
                        candies[i] = 1;
                    }
                    break;
            }
        }

        return Arrays.stream(candies).asLongStream().sum();
    }
}
