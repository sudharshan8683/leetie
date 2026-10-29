// ──────────────────────────────────────────────────
// Problem  : 318. Maximum Product of Word Lengths
// Difficulty: Medium
// Tags     : Array, String, Bit Manipulation
// Link     : https://leetcode.com/problems/maximum-product-of-word-lengths/
// Runtime  : 9 ms (beats 99%)
// Memory   : 48276000 (beats 95%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lens = new int[n];
        
        for (int i = 0; i < n; i++) {
            lens[i] = words[i].length();
            int mask = 0;
            for (int j = 0; j < lens[i]; j++) {
                mask |= (1 << (words[i].charAt(j) - 'a'));
            }
            masks[i] = mask;
        }
        
        int maxProd = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, lens[i] * lens[j]);
                }
            }
        }
        
        return maxProd;
    }
}