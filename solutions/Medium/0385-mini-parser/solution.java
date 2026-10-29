// ──────────────────────────────────────────────────
// Problem  : 385. Mini Parser
// Difficulty: Medium
// Tags     : String, Stack, Depth-First Search
// Link     : https://leetcode.com/problems/mini-parser/
// Runtime  : 8 ms (beats 41%)
// Memory   : 47320000 (beats 79%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        NestedInteger root = new NestedInteger();
        java.util.Stack<NestedInteger> stack = new java.util.Stack<>();
        int num = 0, sign = 1;
        boolean reading = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                NestedInteger curr = new NestedInteger();
                if (!stack.isEmpty()) {
                    stack.peek().add(curr);
                }
                stack.push(curr);
            } else if (c == '-' ) {
                sign = -1;
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                reading = true;
            } else if (c == ',' || c == ']') {
                if (reading) {
                    stack.peek().add(new NestedInteger(num * sign));
                    num = 0;
                    sign = 1;
                    reading = false;
                }

                if (c == ']') {
                    NestedInteger last = stack.pop();
                    if (stack.isEmpty()) {
                        return last;
                    }
                }
            }
        }

        return new NestedInteger();
    }
}
