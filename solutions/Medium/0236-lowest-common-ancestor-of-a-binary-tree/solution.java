// ──────────────────────────────────────────────────
// Problem  : 236. Lowest Common Ancestor of a Binary Tree
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Binary Tree, Binary Lifting, Lowest Common Ancestor
// Link     : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Runtime  : 18 ms (beats 30%)
// Memory   : 70196000 (beats 14%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or matches either p or q
        if (root == null || root == p || root == q) {
            return root;
        }

        // Look for p and q in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right return non-null, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null child (or null if both are null)
        return left != null ? left : right;
    }
}