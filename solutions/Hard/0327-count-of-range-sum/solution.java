// ──────────────────────────────────────────────────
// Problem  : 327. Count of Range Sum
// Difficulty: Hard
// Tags     : Array, Binary Search, Divide and Conquer, Binary Indexed Tree, Segment Tree, Merge Sort, Ordered Set, Treap
// Link     : https://leetcode.com/problems/count-of-range-sum/
// Runtime  : 65 ms (beats 19%)
// Memory   : 79436000 (beats 88%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        return mergeSort(sum, 0, sum.length, lower, upper);
    }

    public int mergeSort(long[] sum, int left, int right, int lower, int upper) {
        if (right - left <= 1) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = mergeSort(sum, left, mid, lower, upper)
                  + mergeSort(sum, mid, right, lower, upper);

        int j = mid, k = mid, t = mid;
        long[] temp = new long[right - left];
        int p = 0;

        for (int i = left; i < mid; i++) {
            while (j < right && sum[j] - sum[i] < lower) {
                j++;
            }
            while (k < right && sum[k] - sum[i] <= upper) {
                k++;
            }
            count += k - j;

            while (t < right && sum[t] < sum[i]) {
                temp[p++] = sum[t++];
            }
            temp[p++] = sum[i];
        }

        while (t < right) {
            temp[p++] = sum[t++];
        }

        System.arraycopy(temp, 0, sum, left, temp.length);
        return count;
    }
}
