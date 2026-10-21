// ──────────────────────────────────────────────────
// Problem  : 223. Rectangle Area
// Difficulty: Medium
// Tags     : Math, Geometry
// Link     : https://leetcode.com/problems/rectangle-area/
// Runtime  : 4 ms (beats 8%)
// Memory   : 43924000 (beats 92%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);

        int overlapWidth = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int overlapHeight = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));

        return area1 + area2 - overlapWidth * overlapHeight;
    }
}