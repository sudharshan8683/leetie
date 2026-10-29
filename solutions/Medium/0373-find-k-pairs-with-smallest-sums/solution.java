// ──────────────────────────────────────────────────
// Problem  : 373. Find K Pairs with Smallest Sums
// Difficulty: Medium
// Tags     : Array, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
// Runtime  : 30 ms (beats 94%)
// Memory   : 136636000 (beats 76%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
            return result;
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[] { nums1[i] + nums2[0], i, 0 });
        }
        
        while (k > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int u = curr[1];
            int v = curr[2];
            
            result.add(Arrays.asList(nums1[u], nums2[v]));
            k--;
            
            if (v + 1 < nums2.length) {
                minHeap.offer(new int[] { nums1[u] + nums2[v + 1], u, v + 1 });
            }
        }
        
        return result;
    }
}