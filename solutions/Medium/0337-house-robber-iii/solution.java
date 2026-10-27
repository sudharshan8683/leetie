// ──────────────────────────────────────────────────
// Problem  : 337. House Robber III
// Difficulty: Medium
// Tags     : Dynamic Programming, Tree, Depth-First Search, Binary Tree, DP on Trees
// Link     : https://leetcode.com/problems/house-robber-iii/
// Runtime  : 1 ms (beats 49%)
// Memory   : 46208000 (beats 83%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int rob(TreeNode root) {
        int[] ans = solve(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] solve(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        int rob = root.val + left[1] + right[1];
        int skip = Math.max(left[0], left[1])
                 + Math.max(right[0], right[1]);

        return new int[]{rob, skip};
    }
}
