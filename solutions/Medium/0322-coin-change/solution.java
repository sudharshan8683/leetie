// ──────────────────────────────────────────────────
// Problem  : 322. Coin Change
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Breadth-First Search, Knapsack Problem, Complete Knapsack
// Link     : https://leetcode.com/problems/coin-change/
// Runtime  : 18 ms (beats 43%)
// Memory   : 46024000 (beats 84%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        java.util.Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
