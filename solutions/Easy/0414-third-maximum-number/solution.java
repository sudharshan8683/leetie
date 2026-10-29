// ──────────────────────────────────────────────────
// Problem  : 414. Third Maximum Number
// Difficulty: Easy
// Tags     : Array, Sorting
// Link     : https://leetcode.com/problems/third-maximum-number/
// Runtime  : 3 ms (beats 58%)
// Memory   : 44516000 (beats 78%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int thirdMax(int[] nums) {
        Long first = null, second = null, third = null;

        for (int n : nums) {
            long x = n;

            if ((first != null && x == first) ||
                (second != null && x == second) ||
                (third != null && x == third)) {
                continue;
            }

            if (first == null || x > first) {
                third = second;
                second = first;
                first = x;
            } else if (second == null || x > second) {
                third = second;
                second = x;
            } else if (third == null || x > third) {
                third = x;
            }
        }

        return third == null ? first.intValue() : third.intValue();
    }
}
