// ──────────────────────────────────────────────────
// Problem  : 368. Largest Divisible Subset
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming, Sorting
// Link     : https://leetcode.com/problems/largest-divisible-subset/
// Runtime  : 17 ms (beats 64%)
// Memory   : 44324000 (beats 99%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int max = 1;
        int index = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (index != -1) {
            ans.add(nums[index]);
            index = prev[index];
        }

        return ans;
    }
}
