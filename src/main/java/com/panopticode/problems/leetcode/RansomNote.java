package com.panopticode.problems.leetcode;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        var records = new int[26];

        var note = ransomNote.toCharArray();
        var mgz  = magazine.toCharArray();

        for (var c : mgz) {
            ++records[c - 97];
        }

        for (var c : note) {
            if (--records[c - 97] < 0) {
                return false;
            }
        }

        return true;
    }
}
