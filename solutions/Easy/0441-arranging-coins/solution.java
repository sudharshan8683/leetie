// ──────────────────────────────────────────────────
// Problem  : 441. Arranging Coins
// Difficulty: Easy
// Tags     : Math, Binary Search
// Link     : https://leetcode.com/problems/arranging-coins/
// Runtime  : 2 ms (beats 52%)
// Memory   : 41900000 (beats 99%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int arrangeCoins(int n) {
        long left = 0, right = n;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long sum = mid * (mid + 1) / 2;

            if (sum == n) return (int)mid;
            if (sum < n) left = mid + 1;
            else right = mid - 1;
        }
        return (int)right;
    }
}