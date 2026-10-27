// ──────────────────────────────────────────────────
// Problem  : 357. Count Numbers with Unique Digits
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Backtracking
// Link     : https://leetcode.com/problems/count-numbers-with-unique-digits/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41364000 (beats 96%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int count = 10;
        int unique = 9;
        int available = 9;

        for (int i = 2; i <= n && i <= 10; i++) {
            unique *= available;
            count += unique;
            available--;
        }

        return count;
    }
}
