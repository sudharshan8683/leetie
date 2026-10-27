// ──────────────────────────────────────────────────
// Problem  : 343. Integer Break
// Difficulty: Medium
// Tags     : Math, Dynamic Programming
// Link     : https://leetcode.com/problems/integer-break/
// Runtime  : 2 ms (beats 22%)
// Memory   : 41564000 (beats 93%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i],
                        Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }
}
