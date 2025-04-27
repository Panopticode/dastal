package com.panopticode.algorithms.stringmatching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NaiveMatcher extends AbstractStringMatcher {
    @Override
    public List<Integer> _match(final String text,
                                final String pattern) {
        var m = pattern.length();
        var shifts = new ArrayList<Integer>();

        for (var s = 0; s <= text.length() - pattern.length(); ++s) {
            if (pattern.equals(text.substring(s, s + m))) {
                shifts.add(s);
            }
        }

        return Collections.unmodifiableList(shifts);
    }
}
