// ──────────────────────────────────────────────────
// Problem  : 456. 132 Pattern
// Difficulty: Medium
// Tags     : Array, Binary Search, Stack, Monotonic Stack, Ordered Set
// Link     : https://leetcode.com/problems/132-pattern/
// Runtime  : 39 ms (beats 39%)
// Memory   : 98240000 (beats 61%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) return true;

            while (!stack.isEmpty() && stack.peek() < nums[i])
                third = stack.pop();

            stack.push(nums[i]);
        }
        return false;
    }
}