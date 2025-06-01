package com.panopticode.problems.leetcode;

import java.util.ArrayDeque;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        var list = new ArrayDeque<String>();
        list.add(s);

        while (!list.isEmpty()) {
            var word = list.pop();

            for (String string : wordDict) {
                if (word.startsWith(string)) {
                    if (word.equals(string)) {
                        return true;
                    }
                    else {
                        var tail = word.substring(string.length());
                        if (!list.contains(tail)) {
                            list.add(tail);
                        }
                    }
                }
            }
        }

        return false;
    }
}
