// ──────────────────────────────────────────────────
// Problem  : 371. Sum of Two Integers
// Difficulty: Medium
// Tags     : Math, Bit Manipulation
// Link     : https://leetcode.com/problems/sum-of-two-integers/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41680000 (beats 87%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }
}
