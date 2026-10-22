// ──────────────────────────────────────────────────
// Problem  : 228. Summary Ranges
// Difficulty: Easy
// Tags     : Array
// Link     : https://leetcode.com/problems/summary-ranges/
// Runtime  : 3 ms (beats 78%)
// Memory   : 42172000 (beats 100%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < nums.length) {
            int start = nums[i];

            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            if (start == nums[i]) {
                ans.add(String.valueOf(start));
            } else {
                ans.add(start + "->" + nums[i]);
            }

            i++;
        }

        return ans;
    }
}