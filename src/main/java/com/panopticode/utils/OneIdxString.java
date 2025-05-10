package com.panopticode.utils;

public final class OneIdxString {
    private final String s;
    public final int length;

    public OneIdxString(final String s) {
        this.s = s;
        this.length = s.length();
    }

    public char at(int i) {
        if (i < 1 || i > s.length()) {
            throw new IndexOutOfBoundsException(i);
        }

        return s.charAt(i - 1);
    }
}
