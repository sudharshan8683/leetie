// ──────────────────────────────────────────────────
// Problem  : 324. Wiggle Sort II
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Greedy, Sorting, Quickselect
// Link     : https://leetcode.com/problems/wiggle-sort-ii/
// Runtime  : 8 ms (beats 96%)
// Memory   : 48464000 (beats 89%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);

        int n = nums.length;
        int mid = (n + 1) / 2;
        int j = mid - 1;
        int k = n - 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = arr[j--];
            } else {
                nums[i] = arr[k--];
            }
        }
    }
}
