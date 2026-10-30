// ──────────────────────────────────────────────────
// Problem  : 462. Minimum Moves to Equal Array Elements II
// Difficulty: Medium
// Tags     : Array, Math, Sorting
// Link     : https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
// Runtime  : 11 ms (beats 32%)
// Memory   : 46572000 (beats 93%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;
        int median = nums[nums.length / 2];

        for (int n : nums)
            ans += Math.abs(n - median);

        return ans;
    }
}