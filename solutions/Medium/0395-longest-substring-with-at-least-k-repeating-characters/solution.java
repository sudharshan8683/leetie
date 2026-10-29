// ──────────────────────────────────────────────────
// Problem  : 395. Longest Substring with At Least K Repeating Characters
// Difficulty: Medium
// Tags     : Hash Table, String, Divide and Conquer, Sliding Window
// Link     : https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
// Runtime  : 0 ms (beats 100%)
// Memory   : 42008000 (beats 99%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int longestSubstring(String s, int k) {
        return solve(s, 0, s.length(), k);
    }

    int solve(String s, int start, int end, int k) {
        if (end - start < k) return 0;

        int[] count = new int[26];

        for (int i = start; i < end; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = start; i < end; i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                int j = i + 1;

                while (j < end && count[s.charAt(j) - 'a'] < k) j++;

                return Math.max(
                    solve(s, start, i, k),
                    solve(s, j, end, k)
                );
            }
        }

        return end - start;
    }
}
