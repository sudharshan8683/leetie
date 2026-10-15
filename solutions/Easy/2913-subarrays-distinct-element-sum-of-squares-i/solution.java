// ──────────────────────────────────────────────────
// Problem  : 2913. Subarrays Distinct Element Sum of Squares I
// Difficulty: Easy
// Tags     : Array, Hash Table, Binary Indexed Tree, Segment Tree
// Link     : https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/
// Runtime  : 10 ms (beats 27%)
// Memory   : 46724000 (beats 69%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int totalSum = 0;

        // Outer loop determines the starting point of the subarray
        for (int i = 0; i < n; i++) {
            Set<Integer> distinctElements = new HashSet<>();
            
            // Inner loop expands the subarray to the right
            for (int j = i; j < n; j++) {
                distinctElements.add(nums.get(j));
                
                int distinctCount = distinctElements.size();
                totalSum += distinctCount * distinctCount;
            }
        }

        return totalSum;
    }
}