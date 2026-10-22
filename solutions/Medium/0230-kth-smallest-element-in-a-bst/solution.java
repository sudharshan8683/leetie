// ──────────────────────────────────────────────────
// Problem  : 230. Kth Smallest Element in a BST
// Difficulty: Medium
// Tags     : Tree, Depth-First Search, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// Runtime  : 0 ms (beats 100%)
// Memory   : 45832000 (beats 100%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    int count = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }
    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);

        count++;
        if (count == k) {
            ans = root.val;
            return;
        }
        inorder(root.right, k);
    }
}