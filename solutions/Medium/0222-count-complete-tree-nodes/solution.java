// ──────────────────────────────────────────────────
// Problem  : 222. Count Complete Tree Nodes
// Difficulty: Medium
// Tags     : Binary Search, Bit Manipulation, Tree, Binary Tree
// Link     : https://leetcode.com/problems/count-complete-tree-nodes/
// Runtime  : 0 ms (beats 100%)
// Memory   : 48908000 (beats 94%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left = leftHeight(root);
        int right = rightHeight(root);

        if (left == right) {
            return (1 << left) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public int leftHeight(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.left;
        }
        return h;
    }
    public int rightHeight(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.right;
        }
        return h;
    }
}