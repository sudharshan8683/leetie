// ──────────────────────────────────────────────────
// Problem  : 453. Minimum Moves to Equal Array Elements
// Difficulty: Medium
// Tags     : Array, Math
// Link     : https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
// Runtime  : 3 ms (beats 27%)
// Memory   : 46924000 (beats 78%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        long sum = 0;

        for (int n : nums) {
            min = Math.min(min, n);
            sum += n;
        }

        return (int)(sum - (long)min * nums.length);
    }
}