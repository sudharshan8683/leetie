// ──────────────────────────────────────────────────
// Problem  : 447. Number of Boomerangs
// Difficulty: Medium
// Tags     : Array, Hash Table, Math
// Link     : https://leetcode.com/problems/number-of-boomerangs/
// Runtime  : 111 ms (beats 71%)
// Memory   : 46560000 (beats 76%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;

        for (int[] p : points) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int[] q : points) {
                int dx = p[0] - q[0];
                int dy = p[1] - q[1];

                int d = dx * dx + dy * dy;

                int count = map.getOrDefault(d, 0);
                ans += count * 2;

                map.put(d, count + 1);
            }
        }
        return ans;
    }
}