// ──────────────────────────────────────────────────
// Problem  : 229. Majority Element II
// Difficulty: Medium
// Tags     : Array, Hash Table, Sorting, Counting, Boyer–Moore Majority Vote Algorithm
// Link     : https://leetcode.com/problems/majority-element-ii/
// Runtime  : 2033 ms (beats 5%)
// Memory   : 51520000 (beats 86%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean added = false;

            for (int j = 0; j < i; j++) {
                if (nums[j] == nums[i]) {
                    added = true;
                    break;
                }
            }
            if (added) continue;

            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > n / 3) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }
}