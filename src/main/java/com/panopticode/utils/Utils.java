package com.panopticode.utils;

public final class Utils {
    private Utils() {
        throw new UnsupportedOperationException("Cannot instantiate utility class");
    }

    public static int min(final int ... ints) {
        if (ints.length == 0) {
            throw new IllegalArgumentException("Invoked Utils::min with no arguments");
        }

        var min = Integer.MAX_VALUE;

        for (int i : ints) {
            min = Math.min(min, i);
        }

        return min;
    }
}
