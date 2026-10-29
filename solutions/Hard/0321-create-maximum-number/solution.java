// ──────────────────────────────────────────────────
// Problem  : 321. Create Maximum Number
// Difficulty: Hard
// Tags     : Array, Two Pointers, Stack, Greedy, Monotonic Stack
// Link     : https://leetcode.com/problems/create-maximum-number/
// Runtime  : 7 ms (beats 76%)
// Memory   : 46104000 (beats 90%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] best = new int[k];
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, best, 0)) {
                best = candidate;
            }
        }
        return best;
    }

    private int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && res[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int i = 0, j = 0, r = 0;
        while (r < k) {
            res[r++] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}