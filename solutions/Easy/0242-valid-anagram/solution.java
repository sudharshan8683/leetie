// ──────────────────────────────────────────────────
// Problem  : 242. Valid Anagram
// Difficulty: Easy
// Tags     : Hash Table, String, Sorting
// Link     : https://leetcode.com/problems/valid-anagram/
// Runtime  : 7 ms (beats 34%)
// Memory   : 43752000 (beats 97%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        
        return true;
    }
}