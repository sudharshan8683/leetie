// ──────────────────────────────────────────────────
// Problem  : 372. Super Pow
// Difficulty: Medium
// Tags     : Math, Divide and Conquer, Euler's Totient Function, Euler's Theorem
// Link     : https://leetcode.com/problems/super-pow/
// Runtime  : 4 ms (beats 74%)
// Memory   : 45644000 (beats 96%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int superPow(int a, int[] b) {
        return pow(a, b, b.length - 1);
    }

    public int pow(int a, int[] b, int index) {
        if (index < 0) {
            return 1;
        }

        int part1 = pow(a, b, index - 1);
        int part2 = myPow(part1, 10);
        int part3 = myPow(a, b[index]);

        return (int) ((long) part2 * part3 % 1337);
    }

    public int myPow(int a, int k) {
        int result = 1;
        a %= 1337;

        while (k > 0) {
            if (k % 2 == 1) {
                result = (int) ((long) result * a % 1337);
            }

            a = (int) ((long) a * a % 1337);
            k /= 2;
        }

        return result;
    }
}
