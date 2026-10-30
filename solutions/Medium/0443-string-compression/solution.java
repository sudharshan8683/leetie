// ──────────────────────────────────────────────────
// Problem  : 443. String Compression
// Difficulty: Medium
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/string-compression/
// Runtime  : 1 ms (beats 100%)
// Memory   : 44964000 (beats 88%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int compress(char[] chars) {
        int i = 0, j = 0;

        while (i < chars.length) {
            char c = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == c) {
                i++;
                count++;
            }

            chars[j++] = c;

            if (count > 1) {
                for (char ch : String.valueOf(count).toCharArray())
                    chars[j++] = ch;
            }
        }
        return j;
    }
}