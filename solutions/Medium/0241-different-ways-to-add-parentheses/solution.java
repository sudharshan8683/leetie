// ──────────────────────────────────────────────────
// Problem  : 241. Different Ways to Add Parentheses
// Difficulty: Medium
// Tags     : Math, String, Dynamic Programming, Recursion, Memoization, Bracket Sequences
// Link     : https://leetcode.com/problems/different-ways-to-add-parentheses/
// Runtime  : 3 ms (beats 58%)
// Memory   : 43888000 (beats 71%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);
                for (int l : leftResults) {
                    for (int r : rightResults) {
                        if (c == '+') res.add(l + r);
                        else if (c == '-') res.add(l - r);
                        else if (c == '*') res.add(l * r);
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }
        return res;
    }
}