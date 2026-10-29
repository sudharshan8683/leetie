// ──────────────────────────────────────────────────
// Problem  : 413. Arithmetic Slices
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Sliding Window
// Link     : https://leetcode.com/problems/arithmetic-slices/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42868000 (beats 82%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int curr = 0, total = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr++;
                total += curr;
            } else {
                curr = 0;
            }
        }

        return total;
    }
}
