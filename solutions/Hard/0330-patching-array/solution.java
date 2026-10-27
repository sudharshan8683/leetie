// ──────────────────────────────────────────────────
// Problem  : 330. Patching Array
// Difficulty: Hard
// Tags     : Array, Greedy
// Link     : https://leetcode.com/problems/patching-array/
// Runtime  : 0 ms (beats 100%)
// Memory   : 44748000 (beats 93%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int i = 0;
        int patches = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                patches++;
            }
        }

        return patches;
    }
}
