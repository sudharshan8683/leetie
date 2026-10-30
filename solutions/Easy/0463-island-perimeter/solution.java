// ──────────────────────────────────────────────────
// Problem  : 463. Island Perimeter
// Difficulty: Easy
// Tags     : Array, Depth-First Search, Breadth-First Search, Matrix
// Link     : https://leetcode.com/problems/island-perimeter/
// Runtime  : 9 ms (beats 28%)
// Memory   : 46400000 (beats 99%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans += 4;

                    if (i > 0 && grid[i - 1][j] == 1) ans--;
                    if (j > 0 && grid[i][j - 1] == 1) ans--;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) ans--;
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) ans--;
                }
            }
        }
        return ans;
    }
}