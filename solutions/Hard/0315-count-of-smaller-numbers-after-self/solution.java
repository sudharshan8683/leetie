// ──────────────────────────────────────────────────
// Problem  : 315. Count of Smaller Numbers After Self
// Difficulty: Hard
// Tags     : Array, Binary Search, Divide and Conquer, Binary Indexed Tree, Segment Tree, Merge Sort, Ordered Set, Treap
// Link     : https://leetcode.com/problems/count-of-smaller-numbers-after-self/
// Runtime  : 51 ms (beats 69%)
// Memory   : 104872000 (beats 32%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    private int[] count;
    private int[] indexes;
    private int[] tempIndexes;
    private int[] tempNums;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        indexes = new int[n];
        tempIndexes = new int[n];
        tempNums = new int[n];
        
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        
        mergeSort(nums, 0, n - 1);
        
        List<Integer> result = new ArrayList<>();
        for (int c : count) {
            result.add(c);
        }
        return result;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        
        int rightSmallerCount = 0;
        
        while (i <= mid && j <= right) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                tempIndexes[k++] = indexes[j++];
                rightSmallerCount++;
            } else {
                tempIndexes[k++] = indexes[i];
                count[indexes[i]] += rightSmallerCount;
                i++;
            }
        }
        
        while (i <= mid) {
            tempIndexes[k++] = indexes[i];
            count[indexes[i]] += rightSmallerCount;
            i++;
        }
        
        while (j <= right) {
            tempIndexes[k++] = indexes[j++];
        }
        
        for (int l = left; l <= right; l++) {
            indexes[l] = tempIndexes[l];
        }
    }
}