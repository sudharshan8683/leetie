// ──────────────────────────────────────────────────
// Problem  : 467. Unique Substrings in Wraparound String
// Difficulty: Medium
// Tags     : String, Dynamic Programming
// Link     : https://leetcode.com/problems/unique-substrings-in-wraparound-string/
// Runtime  : 10 ms (beats 39%)
// Memory   : 43920000 (beats 99%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] dp = new int[26];
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 &&
                (s.charAt(i) - s.charAt(i - 1) + 26) % 26 == 1)
                len++;
            else
                len = 1;

            int index = s.charAt(i) - 'a';
            dp[index] = Math.max(dp[index], len);
        }

        int ans = 0;

        for (int n : dp)
            ans += n;

        return ans;
    }
}