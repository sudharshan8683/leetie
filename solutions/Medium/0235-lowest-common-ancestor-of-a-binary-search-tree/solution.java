// ──────────────────────────────────────────────────
// Problem  : 235. Lowest Common Ancestor of a Binary Search Tree
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Binary Search Tree, Binary Tree, Binary Lifting, Lowest Common Ancestor
// Link     : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// Runtime  : 6 ms (beats 98%)
// Memory   : 47480000 (beats 74%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            // If both p and q are greater than curr, LCA lies in the right subtree
            if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } 
            // If both p and q are smaller than curr, LCA lies in the left subtree
            else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } 
            // We found the split point, which is the LCA
            else {
                return curr;
            }
        }
        
        return null;
    }
}