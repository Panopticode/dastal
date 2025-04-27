package com.panopticode.algorithms.stringmatching;

import java.util.List;

public interface StringMatcher {

    /**
     *
     * @param text text to match the pattern against
     * @param pattern pattern to match
     * @return a list of shifts, empty if none found
     */
    List<Integer> match(String text, String pattern);
}
