// ──────────────────────────────────────────────────
// Problem  : 455. Assign Cookies
// Difficulty: Easy
// Tags     : Array, Two Pointers, Greedy, Sorting, Quicksort
// Link     : https://leetcode.com/problems/assign-cookies/
// Runtime  : 16 ms (beats 12%)
// Memory   : 50980000 (beats 89%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i])
                i++;

            j++;
        }
        return i;
    }
}