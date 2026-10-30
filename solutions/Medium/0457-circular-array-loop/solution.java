// ──────────────────────────────────────────────────
// Problem  : 457. Circular Array Loop
// Difficulty: Medium
// Tags     : Array, Hash Table, Two Pointers, Floyd's Cycle Finding Algorithm
// Link     : https://leetcode.com/problems/circular-array-loop/
// Runtime  : 0 ms (beats 100%)
// Memory   : 41596000 (beats 100%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            int slow = i, fast = i;
            boolean forward = nums[i] > 0;

            while (true) {
                int next = (slow + nums[slow] % n + n) % n;

                if (nums[next] == 0 || (nums[next] > 0) != forward)
                    break;

                slow = next;

                int f1 = (fast + nums[fast] % n + n) % n;

                if (nums[f1] == 0 || (nums[f1] > 0) != forward)
                    break;

                int f2 = (f1 + nums[f1] % n + n) % n;

                if (nums[f2] == 0 || (nums[f2] > 0) != forward)
                    break;

                fast = f2;

                if (slow == fast) {
                    if (slow != (slow + nums[slow] % n + n) % n)
                        return true;
                    break;
                }
            }

            int j = i;
            while (nums[j] != 0 && (nums[j] > 0) == forward) {
                int next = (j + nums[j] % n + n) % n;
                nums[j] = 0;
                j = next;
            }
        }
        return false;
    }
}