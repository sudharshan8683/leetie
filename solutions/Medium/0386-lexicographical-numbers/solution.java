// ──────────────────────────────────────────────────
// Problem  : 386. Lexicographical Numbers
// Difficulty: Medium
// Tags     : Depth-First Search, Trie
// Link     : https://leetcode.com/problems/lexicographical-numbers/
// Runtime  : 25 ms (beats 7%)
// Memory   : 50036000 (beats 56%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        list.sort((a, b) -> String.valueOf(a).compareTo(String.valueOf(b)));

        return list;
    }
}
