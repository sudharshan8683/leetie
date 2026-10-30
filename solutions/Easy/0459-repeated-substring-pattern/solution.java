// ──────────────────────────────────────────────────
// Problem  : 459. Repeated Substring Pattern
// Difficulty: Easy
// Tags     : String, String Matching, Z Algorithm, Knuth–Morris–Pratt Algorithm
// Link     : https://leetcode.com/problems/repeated-substring-pattern/
// Runtime  : 79 ms (beats 13%)
// Memory   : 46368000 (beats 86%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}