// ──────────────────────────────────────────────────
// Problem  : 393. UTF-8 Validation
// Difficulty: Medium
// Tags     : Array, Bit Manipulation
// Link     : https://leetcode.com/problems/utf-8-validation/
// Runtime  : 2 ms (beats 38%)
// Memory   : 46152000 (beats 79%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public boolean validUtf8(int[] data) {
        int count = 0;

        for (int num : data) {
            num &= 255;

            if (count == 0) {
                if ((num >> 7) == 0) continue;
                else if ((num >> 5) == 6) count = 1;
                else if ((num >> 4) == 14) count = 2;
                else if ((num >> 3) == 30) count = 3;
                else return false;
            } else {
                if ((num >> 6) != 2) return false;
                count--;
            }
        }

        return count == 0;
    }
}
