// ──────────────────────────────────────────────────
// Problem  : 220. Contains Duplicate III
// Difficulty: Hard
// Tags     : Array, Sliding Window, Sorting, Bucket Sort, Ordered Set
// Link     : https://leetcode.com/problems/contains-duplicate-iii/
// Runtime  : 141 ms (beats 32%)
// Memory   : 111792000 (beats 82%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        java.util.TreeSet<Long> set = new java.util.TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
Long low = set.ceiling(num - valueDiff);
        if (low != null && low <= num + valueDiff) {
return true;
}
set.add(num);
if (set.size() > indexDiff) {
    set.remove((long) nums[i - indexDiff]);
}
}
return false;
 }
}