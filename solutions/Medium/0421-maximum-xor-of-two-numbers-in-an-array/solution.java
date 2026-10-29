// ──────────────────────────────────────────────────
// Problem  : 421. Maximum XOR of Two Numbers in an Array
// Difficulty: Medium
// Tags     : Array, Hash Table, Bit Manipulation, Trie
// Link     : https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
// Runtime  : 650 ms (beats 63%)
// Memory   : 241492000 (beats 26%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;

        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            java.util.Set<Integer> set = new java.util.HashSet<>();

            for (int n : nums) set.add(n & mask);

            int candidate = max | (1 << i);

            for (int prefix : set) {
                if (set.contains(candidate ^ prefix)) {
                    max = candidate;
                    break;
                }
            }
        }

        return max;
    }
}
