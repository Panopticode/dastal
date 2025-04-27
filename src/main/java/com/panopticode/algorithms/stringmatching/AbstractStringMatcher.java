package com.panopticode.algorithms.stringmatching;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

abstract class AbstractStringMatcher implements StringMatcher {

    @Override
    public List<Integer> match(final String text,
                               final String pattern) {
        validate(text, "text");
        validate(pattern, "pattern");

        if (text.equals(pattern)) {
            return List.of(0);
        }
        else if (text.length() <= pattern.length()) {
            return Collections.emptyList();
        }
        else if (pattern.isEmpty()) {
            return IntStream.rangeClosed(0, text.length())
                    .boxed()
                    .toList();
        }

        return _match(text, pattern);
    }

    private void validate(final String text,
                          final String paramName) {
        if (text == null) {
            throw new IllegalArgumentException("%s cannot be null".formatted(paramName));
        }
    }

    protected abstract List<Integer> _match(String text, String pattern);
}
