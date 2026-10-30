// ──────────────────────────────────────────────────
// Problem  : 466. Count The Repetitions
// Difficulty: Hard
// Tags     : Two Pointers, String, Dynamic Programming
// Link     : https://leetcode.com/problems/count-the-repetitions/
// Runtime  : 3 ms (beats 63%)
// Memory   : 42160000 (beats 95%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int[] repeat = new int[s2.length() + 1];
        int[] count = new int[s2.length() + 1];

        int j = 0, cnt = 0;

        for (int k = 1; k <= n1; k++) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;

                    if (j == s2.length()) {
                        j = 0;
                        cnt++;
                    }
                }
            }

            repeat[k] = j;
            count[k] = cnt;

            for (int start = 0; start < k; start++) {
                if (repeat[start] == j) {
                    int prefix = count[start];
                    int pattern = (count[k] - count[start]) *
                        ((n1 - start) / (k - start));
                    int suffix = count[start +
                        (n1 - start) % (k - start)] - count[start];

                    return (prefix + pattern + suffix) / n2;
                }
            }
        }
        return count[n1] / n2;
    }
}