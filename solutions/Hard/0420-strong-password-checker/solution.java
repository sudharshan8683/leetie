// ──────────────────────────────────────────────────
// Problem  : 420. Strong Password Checker
// Difficulty: Hard
// Tags     : String, Greedy, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/strong-password-checker/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41968000 (beats 96%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        boolean lower = false, upper = false, digit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) lower = true;
            if (Character.isUpperCase(c)) upper = true;
            if (Character.isDigit(c)) digit = true;
        }

        int missing = (lower ? 0 : 1) + (upper ? 0 : 1) + (digit ? 0 : 1);
        int replace = 0, one = 0, two = 0;

        for (int i = 0; i < n;) {
            int j = i;

            while (j < n && password.charAt(j) == password.charAt(i)) j++;

            int len = j - i;

            if (len >= 3) {
                replace += len / 3;
                if (len % 3 == 0) one++;
                else if (len % 3 == 1) two++;
            }

            i = j;
        }

        if (n < 6) return Math.max(missing, 6 - n);

        if (n <= 20) return Math.max(missing, replace);

        int delete = n - 20;
        replace -= Math.min(delete, one);
        replace -= Math.min(Math.max(delete - one, 0), two * 2) / 2;
        replace -= Math.max(delete - one - two * 2, 0) / 3;

        return delete + Math.max(missing, replace);
    }
}
