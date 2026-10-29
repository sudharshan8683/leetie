// ──────────────────────────────────────────────────
// Problem  : 326. Power of Three
// Difficulty: Easy
// Tags     : Math, Recursion
// Link     : https://leetcode.com/problems/power-of-three/
// Runtime  : 25 ms (beats 7%)
// Memory   : 45516000 (beats 89%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}