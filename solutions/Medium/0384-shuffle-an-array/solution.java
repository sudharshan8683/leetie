// ──────────────────────────────────────────────────
// Problem  : 384. Shuffle an Array
// Difficulty: Medium
// Tags     : Array, Math, Design, Randomized
// Link     : https://leetcode.com/problems/shuffle-an-array/
// Runtime  : 53 ms (beats 42%)
// Memory   : 51896000 (beats 91%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.*;

class Solution {
    int[] original;
    Random rand;

    public Solution(int[] nums) {
        original = nums.clone();
        rand = new Random();
    }

    public int[] reset() {
        return original.clone();
    }

    public int[] shuffle() {
        int[] arr = original.clone();

        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return arr;
    }
}
