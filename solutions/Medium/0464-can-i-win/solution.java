// ──────────────────────────────────────────────────
// Problem  : 464. Can I Win
// Difficulty: Medium
// Tags     : Math, Dynamic Programming, Bit Manipulation, Memoization, Game Theory, Bitmask
// Link     : https://leetcode.com/problems/can-i-win/
// Runtime  : 64 ms (beats 83%)
// Memory   : 45212000 (beats 98%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;

        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;

        if (sum < desiredTotal) return false;

        Boolean[] dp = new Boolean[1 << maxChoosableInteger];

        return dfs(maxChoosableInteger, desiredTotal, 0, dp);
    }

    public boolean dfs(int max, int target, int used, Boolean[] dp) {
        if (dp[used] != null) return dp[used];

        for (int i = 1; i <= max; i++) {
            int bit = 1 << (i - 1);

            if ((used & bit) == 0) {
                if (i >= target ||
                    !dfs(max, target - i, used | bit, dp))
                    return dp[used] = true;
            }
        }
        return dp[used] = false;
    }
}