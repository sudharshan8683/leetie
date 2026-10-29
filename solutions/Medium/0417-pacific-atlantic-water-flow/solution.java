// ──────────────────────────────────────────────────
// Problem  : 417. Pacific Atlantic Water Flow
// Difficulty: Medium
// Tags     : Array, Depth-First Search, Breadth-First Search, Matrix
// Link     : https://leetcode.com/problems/pacific-atlantic-water-flow/
// Runtime  : 5 ms (beats 61%)
// Memory   : 47028000 (beats 86%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public java.util.List<java.util.List<Integer>> pacificAtlantic(int[][] h) {
        int m = h.length, n = h[0].length;
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(h, p, i, 0);
            dfs(h, a, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(h, p, 0, j);
            dfs(h, a, m - 1, j);
        }

        java.util.List<java.util.List<Integer>> ans = new java.util.ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] && a[i][j]) {
                    ans.add(java.util.Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    void dfs(int[][] h, boolean[][] seen, int r, int c) {
        if (seen[r][c]) return;
        seen[r][c] = true;

        int[] d = {0, 1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + d[i], nc = c + d[i + 1];

            if (nr >= 0 && nr < h.length && nc >= 0 && nc < h[0].length
                && !seen[nr][nc] && h[nr][nc] >= h[r][c]) {
                dfs(h, seen, nr, nc);
            }
        }
    }
}
