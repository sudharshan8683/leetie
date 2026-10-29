// ──────────────────────────────────────────────────
// Problem  : 394. Decode String
// Difficulty: Medium
// Tags     : String, Stack, Recursion
// Link     : https://leetcode.com/problems/decode-string/
// Runtime  : 1 ms (beats 83%)
// Memory   : 42304000 (beats 90%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public String decodeString(String s) {
        java.util.Stack<Integer> nums = new java.util.Stack<>();
        java.util.Stack<StringBuilder> strs = new java.util.Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                nums.push(num);
                strs.push(curr);
                curr = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                StringBuilder temp = strs.pop();
                int k = nums.pop();

                while (k-- > 0) temp.append(curr);
                curr = temp;
            } else {
                curr.append(c);
            }
        }

        return curr.toString();
    }
}
