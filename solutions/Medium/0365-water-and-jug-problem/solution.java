// ──────────────────────────────────────────────────
// Problem  : 365. Water and Jug Problem
// Difficulty: Medium
// Tags     : Math, Depth-First Search, Breadth-First Search, Bézout's Lemma, Euclidean Algorithm, Greatest Common Divisor, Extended Euclidean Algorithm
// Link     : https://leetcode.com/problems/water-and-jug-problem/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41680000 (beats 88%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) {
            return false;
        }

        if (target == 0) {
            return true;
        }

        return target % gcd(x, y) == 0;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
