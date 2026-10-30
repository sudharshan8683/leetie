// ──────────────────────────────────────────────────
// Problem  : 427. Construct Quad Tree
// Difficulty: Medium
// Tags     : Array, Divide and Conquer, Tree, Matrix
// Link     : https://leetcode.com/problems/construct-quad-tree/
// Runtime  : 1 ms (beats 55%)
// Memory   : 45980000 (beats 94%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    public Node build(int[][] grid, int r, int c, int size) {
        int val = grid[r][c];
        boolean same = true;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (grid[i][j] != val) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same)
            return new Node(val == 1, true);

        int half = size / 2;

        Node tl = build(grid, r, c, half);
        Node tr = build(grid, r, c + half, half);
        Node bl = build(grid, r + half, c, half);
        Node br = build(grid, r + half, c + half, half);

        return new Node(true, false, tl, tr, bl, br);
    }
}