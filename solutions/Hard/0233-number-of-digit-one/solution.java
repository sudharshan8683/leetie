// ──────────────────────────────────────────────────
// Problem  : 233. Number of Digit One
// Difficulty: Hard
// Tags     : Math, Dynamic Programming, Recursion
// Link     : https://leetcode.com/problems/number-of-digit-one/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41504000 (beats 92%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countDigitOne(int n) {
        long count = 0;

        for (long m = 1; m <= n; m *= 10) {
            long a = n / m;
            long b = n % m;

            count += (a + 8) / 10 * m;

            if (a % 10 == 1) {
                count += b + 1;
            }
        }

        return (int) count;
    }
}