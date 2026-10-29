// ──────────────────────────────────────────────────
// Problem  : 396. Rotate Function
// Difficulty: Medium
// Tags     : Array, Math, Dynamic Programming
// Link     : https://leetcode.com/problems/rotate-function/
// Runtime  : 4 ms (beats 98%)
// Memory   : 90864000 (beats 86%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int maxRotateFunction(int[] nums) {
        long sum = 0, f = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }

        long max = f;

        for (int i = n - 1; i > 0; i--) {
            f = f + sum - (long) n * nums[i];
            max = Math.max(max, f);
        }

        return (int) max;
    }
}
