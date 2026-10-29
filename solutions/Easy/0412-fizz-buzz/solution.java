// ──────────────────────────────────────────────────
// Problem  : 412. Fizz Buzz
// Difficulty: Easy
// Tags     : Math, String, Simulation
// Link     : https://leetcode.com/problems/fizz-buzz/
// Runtime  : 1 ms (beats 100%)
// Memory   : 46056000 (beats 98%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public java.util.List<String> fizzBuzz(int n) {
        java.util.List<String> ans = new java.util.ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) ans.add("FizzBuzz");
            else if (i % 3 == 0) ans.add("Fizz");
            else if (i % 5 == 0) ans.add("Buzz");
            else ans.add(String.valueOf(i));
        }

        return ans;
    }
}
