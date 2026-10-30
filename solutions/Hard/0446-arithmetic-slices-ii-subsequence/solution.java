// ──────────────────────────────────────────────────
// Problem  : 446. Arithmetic Slices II - Subsequence
// Difficulty: Hard
// Tags     : Array, Dynamic Programming
// Link     : https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
// Runtime  : 174 ms (beats 47%)
// Memory   : 109172000 (beats 66%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Long, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++)
            dp[i] = new HashMap<>();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long)nums[i] - nums[j];

                int count = dp[j].getOrDefault(diff, 0);

                ans += count;

                dp[i].put(diff,
                    dp[i].getOrDefault(diff, 0) + count + 1);
            }
        }
        return ans;
    }
}