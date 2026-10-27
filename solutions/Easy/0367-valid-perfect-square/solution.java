// ──────────────────────────────────────────────────
// Problem  : 367. Valid Perfect Square
// Difficulty: Easy
// Tags     : Math, Binary Search
// Link     : https://leetcode.com/problems/valid-perfect-square/
// Runtime  : 1 ms (beats 19%)
// Memory   : 41672000 (beats 89%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false;
        }

        long i = 1;

        while (i * i < num) {
            i++;
        }

        return i * i == num;
    }
}
