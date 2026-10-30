// ──────────────────────────────────────────────────
// Problem  : 440. K-th Smallest in Lexicographical Order
// Difficulty: Hard
// Tags     : Trie
// Link     : https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/
// Runtime  : 1 ms (beats 9%)
// Memory   : 41652000 (beats 89%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while (k > 0) {
            long steps = 0;
            long first = curr;
            long last = curr + 1;

            while (first <= n) {
                steps += Math.min((long)n + 1, last) - first;
                first *= 10;
                last *= 10;
            }

            if (steps <= k) {
                curr++;
                k -= steps;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }
}