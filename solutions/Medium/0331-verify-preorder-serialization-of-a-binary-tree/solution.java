// ──────────────────────────────────────────────────
// Problem  : 331. Verify Preorder Serialization of a Binary Tree
// Difficulty: Medium
// Tags     : String, Stack, Tree, Binary Tree
// Link     : https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
// Runtime  : 5 ms (beats 37%)
// Memory   : 44504000 (beats 82%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int slots = 1;

        for (String node : nodes) {
            slots--;

            if (slots < 0) {
                return false;
            }

            if (!node.equals("#")) {
                slots += 2;
            }
        }

        return slots == 0;
    }
}
