// ──────────────────────────────────────────────────
// Problem  : 416. Partition Equal Subset Sum
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Knapsack Problem, 0-1 Knapsack
// Link     : https://leetcode.com/problems/partition-equal-subset-sum/
// Runtime  : 32 ms (beats 71%)
// Memory   : 43344000 (beats 95%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int n : nums) sum += n;

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int n : nums) {
            for (int j = target; j >= n; j--) {
                dp[j] = dp[j] || dp[j - n];
            }
        }

        return dp[target];
    }
}
