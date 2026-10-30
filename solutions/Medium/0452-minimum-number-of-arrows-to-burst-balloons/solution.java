// ──────────────────────────────────────────────────
// Problem  : 452. Minimum Number of Arrows to Burst Balloons
// Difficulty: Medium
// Tags     : Array, Greedy, Sorting
// Link     : https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
// Runtime  : 53 ms (beats 47%)
// Memory   : 95048000 (beats 90%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, (a, b) ->
            Integer.compare(a[1], b[1]));

        int ans = 1;
        long end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                ans++;
                end = points[i][1];
            }
        }
        return ans;
    }
}