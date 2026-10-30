// ──────────────────────────────────────────────────
// Problem  : 438. Find All Anagrams in a String
// Difficulty: Medium
// Tags     : Hash Table, String, Sliding Window
// Link     : https://leetcode.com/problems/find-all-anagrams-in-a-string/
// Runtime  : 11 ms (beats 65%)
// Memory   : 46004000 (beats 98%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int[] a = new int[26];
        int[] b = new int[26];

        if (s.length() < p.length()) return ans;

        for (int i = 0; i < p.length(); i++) {
            a[s.charAt(i) - 'a']++;
            b[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(a, b)) ans.add(0);

        for (int i = p.length(); i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            a[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(a, b)) {
                ans.add(i - p.length() + 1);
            }
        }

        return ans;
    }
}