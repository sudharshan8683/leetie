// ──────────────────────────────────────────────────
// Problem  : 397. Integer Replacement
// Difficulty: Medium
// Tags     : Dynamic Programming, Greedy, Bit Manipulation, Memoization
// Link     : https://leetcode.com/problems/integer-replacement/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41516000 (beats 92%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int integerReplacement(int n) {
        long x = n;
        int count = 0;

        while (x != 1) {
            if (x % 2 == 0) {
                x /= 2;
            } else if (x == 3 || x % 4 == 1) {
                x--;
            } else {
                x++;
            }

            count++;
        }

        return count;
    }
}
