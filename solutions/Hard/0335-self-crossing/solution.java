// ──────────────────────────────────────────────────
// Problem  : 335. Self Crossing
// Difficulty: Hard
// Tags     : Array, Math, Geometry
// Link     : https://leetcode.com/problems/self-crossing/
// Runtime  : 7 ms (beats 50%)
// Memory   : 58740000 (beats 95%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;

        for (int i = 3; i < n; i++) {
            if (distance[i] >= distance[i - 2]
                    && distance[i - 1] <= distance[i - 3]) {
                return true;
            }

            if (i >= 4
                    && distance[i - 1] == distance[i - 3]
                    && distance[i] + distance[i - 4] >= distance[i - 2]) {
                return true;
            }

            if (i >= 5
                    && distance[i - 2] >= distance[i - 4]
                    && distance[i] + distance[i - 4] >= distance[i - 2]
                    && distance[i - 1] <= distance[i - 3]
                    && distance[i - 1] + distance[i - 5] >= distance[i - 3]) {
                return true;
            }
        }

        return false;
    }
}
