// ──────────────────────────────────────────────────
// Problem  : 231. Power of Two
// Difficulty: Easy
// Tags     : Math, Bit Manipulation, Recursion
// Link     : https://leetcode.com/problems/power-of-two/
// Runtime  : 2 ms (beats 6%)
// Memory   : 41700000 (beats 100%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}