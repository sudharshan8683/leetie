// ──────────────────────────────────────────────────
// Problem  : 390. Elimination Game
// Difficulty: Medium
// Tags     : Math, Recursion
// Link     : https://leetcode.com/problems/elimination-game/
// Runtime  : 5 ms (beats 7%)
// Memory   : 43012000 (beats 83%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        int remaining = n;
        boolean left = true;

        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head += step;
            }

            remaining /= 2;
            step *= 2;
            left = !left;
        }

        return head;
    }
}
