// ──────────────────────────────────────────────────
// Problem  : 389. Find the Difference
// Difficulty: Easy
// Tags     : Hash Table, String, Bit Manipulation, Sorting
// Link     : https://leetcode.com/problems/find-the-difference/
// Runtime  : 1 ms (beats 100%)
// Memory   : 42784000 (beats 85%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public char findTheDifference(String s, String t) {
        int sum = 0;

        for (char c : t.toCharArray()) {
            sum += c;
        }

        for (char c : s.toCharArray()) {
            sum -= c;
        }

        return (char) sum;
    }
}
