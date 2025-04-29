package com.panopticode.problems.hackerrank.stringmanipulation;

/**
 * A student is taking a cryptography class and has found anagrams to be very useful. Two strings are anagrams of each
 * other if the first string's letters can be rearranged to form the second string. In other words, both strings must
 * contain the same exact letters in the same exact frequency. For example, <code>bacdc</code> and <code>dcbac</code>
 * are anagrams, but <code>bacdc</code> and <code>dcbad</code> are not.
 * <p>
 * The student decides on an encryption scheme that involves two large strings. The encryption is dependent on the
 * minimum number of character deletions required to make the two strings anagrams. Determine this number.
 * <p>
 * Given two strings, a and b, that may or may not be of the same length, determine the minimum number of character
 * deletions required to make a and b anagrams. Any characters can be deleted from either of the strings.
 * <p>
 * The strings a and b consist of lowercase English alphabetic letters, ascii[a-z].
 */
public class MakingAnagrams {
    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
        // Write your code here
        var records = new int[26];

        a.chars().forEach(c -> ++records[Character.getNumericValue(c) - 10]);
        b.chars().forEach(c -> --records[Character.getNumericValue(c) - 10]);

        var count = 0;

        for (var i : records) {
            if (i != 0) {
                count += Math.abs(i);
            }
        }

        return count;
    }
}
