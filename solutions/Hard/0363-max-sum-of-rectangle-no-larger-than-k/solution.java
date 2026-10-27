// ──────────────────────────────────────────────────
// Problem  : 363. Max Sum of Rectangle No Larger Than K
// Difficulty: Hard
// Tags     : Array, Binary Search, Matrix, Prefix Sum, Ordered Set
// Link     : https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
// Runtime  : 230 ms (beats 69%)
// Memory   : 46844000 (beats 72%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.*;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;

        for (int left = 0; left < cols; left++) {
            int[] sum = new int[rows];

            for (int right = left; right < cols; right++) {
                for (int r = 0; r < rows; r++) {
                    sum[r] += matrix[r][right];
                }

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int prefix = 0;

                for (int value : sum) {
                    prefix += value;

                    Integer target = set.ceiling(prefix - k);

                    if (target != null) {
                        max = Math.max(max, prefix - target);
                    }

                    set.add(prefix);
                }

                if (max == k) {
                    return k;
                }
            }
        }

        return max;
    }
}
