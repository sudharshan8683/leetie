// ──────────────────────────────────────────────────
// Problem  : 461. Hamming Distance
// Difficulty: Easy
// Tags     : Bit Manipulation
// Link     : https://leetcode.com/problems/hamming-distance/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42184000 (beats 48%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}