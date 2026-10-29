// ──────────────────────────────────────────────────
// Problem  : 398. Random Pick Index
// Difficulty: Medium
// Tags     : Hash Table, Math, Reservoir Sampling, Randomized
// Link     : https://leetcode.com/problems/random-pick-index/
// Runtime  : 1580 ms (beats 5%)
// Memory   : 60216000 (beats 95%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    int[] nums;
    java.util.Random rand = new java.util.Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int result = -1, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;

                if (rand.nextInt(count) == 0) {
                    result = i;
                }
            }
        }

        return result;
    }
}
