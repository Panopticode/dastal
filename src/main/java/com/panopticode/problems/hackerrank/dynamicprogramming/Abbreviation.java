package com.panopticode.problems.hackerrank.dynamicprogramming;

import com.panopticode.utils.Printer;

import static java.lang.Character.isUpperCase;
import static java.lang.Character.toUpperCase;

/**
 * You can perform the following operations on the string, a:
 *
 * <ol>
 *     <li> Capitalize zero or more of a's lowercase letters.
 *     <li> Delete all of the remaining lowercase letters in a.
 * </ol>
 *
 * Given two strings, a and b, determine if it's possible to make a equal to b as described. If so, print YES on a new line.
 * Otherwise, print NO. For example, given a='AbcDE' and b='ABDE', in a we can convert b and delete c to match b.
 * If a='AbcDE' and b='AFDE', matching is not possible because letters may only be capitalized or discarded, not changed.
 *
 * <h3> Constraints
 *
 * <ol>
 *     <li> String a consists only of uppercase and lowercase English letters, ascii[A-Za-z].
 *     <li> String b consists only of uppercase English letters, ascii[A-Z].
 * </ol>
 */
public class Abbreviation {
    private static boolean debug =  false;
    /*
     * Complete the 'abbreviation' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static String abbreviation(String a, String b) {
        // a couple optimisations
        if (a.length() < b.length()) {
            if (debug) {
                System.out.println("Optimisation: cannot generate b from a since b is longer than a");
            }
            return "NO";
        }
        if (a.length() == b.length()) {
            if (debug) {
                System.out.println("Optimisation: b can be generated from a only if they have the same characters (case insensitive) " +
                        "since they have the same length");
            }
            return a.equalsIgnoreCase(b) ? "YES" : "NO";
        }

        var boolMatrix = new boolean[a.length() + 1][b.length() + 1];
        var lowerCase = true;
        boolMatrix[0][0] = true;
        for (int i = 1; i <= a.length(); ++i) {
            if (isUpperCase(a.charAt(i - 1))) {
                lowerCase = false;
            }
            if (lowerCase) {
                boolMatrix[i][0] = true;
            }
        }
        for (int j = 1; j <= b.length(); ++j) {
            for (int i = 1; i <= a.length(); ++i) {
                if (!boolMatrix[i - 1][j] || isUpperCase(a.charAt(i - 1))) {
                    boolMatrix[i][j] = (boolMatrix[i - 1][j - 1] && toUpperCase(a.charAt(i - 1)) == b.charAt(j - 1));
                } else {
                    boolMatrix[i][j] = true;
                }
            }
        }

        if (debug) {
            Printer.printTable(boolMatrix, false, ("*" + b).split(""), ("*" + a).split(""));
        }

        return boolMatrix[a.length()][b.length()] ? "YES" : "NO";
    }

    public static void setDebug(final boolean debug) {
        Abbreviation.debug = debug;
    }
}
