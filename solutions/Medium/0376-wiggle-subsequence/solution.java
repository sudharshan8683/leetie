// ──────────────────────────────────────────────────
// Problem  : 376. Wiggle Subsequence
// Difficulty: Medium
// Tags     : Array, Dynamic Programming, Greedy
// Link     : https://leetcode.com/problems/wiggle-subsequence/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42316000 (beats 94%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        
        int count = 1;
        int prevDiff = 0;
        
        for (int i = 1; i < nums.length; i++) {
            int currDiff = nums[i] - nums[i - 1];
            
            // If we found a positive change after a non-positive one, 
            // or a negative change after a non-negative one:
            if ((currDiff > 0 && prevDiff <= 0) || (currDiff < 0 && prevDiff >= 0)) {
                count++;
                prevDiff = currDiff;
            }
        }
        
        return count;
    }
}