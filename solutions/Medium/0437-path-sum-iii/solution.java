// ──────────────────────────────────────────────────
// Problem  : 437. Path Sum III
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Binary Tree
// Link     : https://leetcode.com/problems/path-sum-iii/
// Runtime  : 20 ms (beats 14%)
// Memory   : 44220000 (beats 99%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        return count(root, targetSum) 
             + pathSum(root.left, targetSum)
             + pathSum(root.right, targetSum);
    }

    public int count(TreeNode root, long target) {
        if (root == null) return 0;

        int ans = 0;

        if (root.val == target) ans++;

        ans += count(root.left, target - root.val);
        ans += count(root.right, target - root.val);

        return ans;
    }
}