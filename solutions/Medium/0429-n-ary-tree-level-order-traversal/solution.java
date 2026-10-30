// ──────────────────────────────────────────────────
// Problem  : 429. N-ary Tree Level Order Traversal
// Difficulty: Medium
// Tags     : Tree, Breadth-First Search
// Link     : https://leetcode.com/problems/n-ary-tree-level-order-traversal/
// Runtime  : 4 ms (beats 34%)
// Memory   : 46036000 (beats 95%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                list.add(curr.val);

                for (Node child : curr.children) {
                    q.add(child);
                }
            }

            ans.add(list);
        }

        return ans;
    }
}