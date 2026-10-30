// ──────────────────────────────────────────────────
// Problem  : 450. Delete Node in a BST
// Difficulty: Medium
// Tags     : Tree, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/delete-node-in-a-bst/
// Runtime  : 0 ms (beats 100%)
// Memory   : 47264000 (beats 74%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode temp = root.right;

            while (temp.left != null)
                temp = temp.left;

            root.val = temp.val;
            root.right = deleteNode(root.right, temp.val);
        }
        return root;
    }
}