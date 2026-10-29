// ──────────────────────────────────────────────────
// Problem  : 424. Longest Repeating Character Replacement
// Difficulty: Medium
// Tags     : Hash Table, String, Sliding Window
// Link     : https://leetcode.com/problems/longest-repeating-character-replacement/
// Runtime  : 7 ms (beats 90%)
// Memory   : 46096000 (beats 71%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxCount = 0, ans = 0;

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            count[idx]++;
            maxCount = Math.max(maxCount, count[idx]);

            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
