// ──────────────────────────────────────────────────
// Problem  : 227. Basic Calculator II
// Difficulty: Medium
// Tags     : Math, String, Stack
// Link     : https://leetcode.com/problems/basic-calculator-ii/
// Runtime  : 14 ms (beats 83%)
// Memory   : 45824000 (beats 99%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int calculate(String s) {
        int result = 0, num = 0, last = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    result += last;
                    last = num;
                } else if (sign == '-') {
                    result += last;
                    last = -num;
                } else if (sign == '*') {
                    last *= num;
                } else if (sign == '/') {
                    last /= num;
                }

                sign = c;
                num = 0;
            }
        }

        return result + last;
    }
}