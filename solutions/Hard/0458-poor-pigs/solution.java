// ──────────────────────────────────────────────────
// Problem  : 458. Poor Pigs
// Difficulty: Hard
// Tags     : Math, Dynamic Programming, Combinatorics
// Link     : https://leetcode.com/problems/poor-pigs/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41520000 (beats 91%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int poorPigs(int buckets, int minutesToDie,
                        int minutesToTest) {
        int states = minutesToTest / minutesToDie + 1;
        int pigs = 0;
        long total = 1;

        while (total < buckets) {
            total *= states;
            pigs++;
        }
        return pigs;
    }
}