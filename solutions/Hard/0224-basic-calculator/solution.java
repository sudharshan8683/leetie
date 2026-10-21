// ──────────────────────────────────────────────────
// Problem  : 224. Basic Calculator
// Difficulty: Hard
// Tags     : Math, String, Stack, Recursion
// Link     : https://leetcode.com/problems/basic-calculator/
// Runtime  : 12 ms (beats 36%)
// Memory   : 46208000 (beats 81%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int calculate(String s) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int result = 0, number = 0, sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        return result + sign * number;
    }
}