// ──────────────────────────────────────────────────
// Problem  : 449. Serialize and Deserialize BST
// Difficulty: Medium
// Tags     : String, Tree, Depth-First Search, Breadth-First Search, Design, Binary Search Tree, Binary Tree
// Link     : https://leetcode.com/problems/serialize-and-deserialize-bst/
// Runtime  : 4 ms (beats 96%)
// Memory   : 46028000 (beats 97%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        preorder(root, sb);

        return sb.toString();
    }

    public void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) return;

        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] arr = data.split(",");
        int[] index = {0};

        return build(arr, index, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public TreeNode build(String[] arr, int[] index, long min, long max) {
        if (index[0] >= arr.length) return null;

        int val = Integer.parseInt(arr[index[0]]);

        if (val <= min || val >= max) return null;

        index[0]++;

        TreeNode root = new TreeNode(val);

        root.left = build(arr, index, min, val);
        root.right = build(arr, index, val, max);

        return root;
    }
}