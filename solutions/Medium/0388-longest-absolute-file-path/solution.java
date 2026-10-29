// ──────────────────────────────────────────────────
// Problem  : 388. Longest Absolute File Path
// Difficulty: Medium
// Tags     : String, Stack, Depth-First Search
// Link     : https://leetcode.com/problems/longest-absolute-file-path/
// Runtime  : 1 ms (beats 58%)
// Memory   : 42180000 (beats 93%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int[] lengths = new int[lines.length + 1];
        int max = 0;

        for (String line : lines) {
            int level = line.lastIndexOf("\t") + 1;
            int len = line.length() - level;

            if (line.contains(".")) {
                max = Math.max(max, lengths[level] + len);
            } else {
                lengths[level + 1] = lengths[level] + len + 1;
            }
        }

        return max;
    }
}
