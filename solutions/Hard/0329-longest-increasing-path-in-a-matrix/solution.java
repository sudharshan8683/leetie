// ──────────────────────────────────────────────────
// Problem  : 329. Longest Increasing Path in a Matrix
// Difficulty: Hard
// Tags     : Array, Dynamic Programming, Depth-First Search, Breadth-First Search, Graph Theory, Topological Sort, Memoization, Matrix, Directed Acyclic Graph
// Link     : https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
// Runtime  : 10 ms (beats 30%)
// Memory   : 46712000 (beats 88%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, dp, i, j));
            }
        }

        return max;
    }

    public int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        dp[i][j] = 1;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && x < m && y >= 0 && y < n
                    && matrix[x][y] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j],
                        1 + dfs(matrix, dp, x, y));
            }
        }

        return dp[i][j];
    }
}
