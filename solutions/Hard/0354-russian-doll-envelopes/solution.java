// ──────────────────────────────────────────────────
// Problem  : 354. Russian Doll Envelopes
// Difficulty: Hard
// Tags     : Array, Binary Search, Dynamic Programming, Sorting, Longest Increasing Subsequence
// Link     : https://leetcode.com/problems/russian-doll-envelopes/
// Runtime  : 39 ms (beats 86%)
// Memory   : 98908000 (beats 90%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int[] dp = new int[envelopes.length];
        int len = 0;

        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int left = 0, right = len;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (dp[mid] < height) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            dp[left] = height;

            if (left == len) {
                len++;
            }
        }

        return len;
    }
}
