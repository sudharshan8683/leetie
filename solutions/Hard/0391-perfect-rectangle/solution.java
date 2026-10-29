// ──────────────────────────────────────────────────
// Problem  : 391. Perfect Rectangle
// Difficulty: Hard
// Tags     : Array, Hash Table, Math, Geometry, Sweep Line
// Link     : https://leetcode.com/problems/perfect-rectangle/
// Runtime  : 39 ms (beats 62%)
// Memory   : 55220000 (beats 86%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        long area = 0;
        java.util.Set<String> set = new java.util.HashSet<>();

        for (int[] r : rectangles) {
            minX = Math.min(minX, r[0]);
            minY = Math.min(minY, r[1]);
            maxX = Math.max(maxX, r[2]);
            maxY = Math.max(maxY, r[3]);

            area += (long) (r[2] - r[0]) * (r[3] - r[1]);

            String[] points = {
                r[0] + "," + r[1],
                r[0] + "," + r[3],
                r[2] + "," + r[1],
                r[2] + "," + r[3]
            };

            for (String p : points) {
                if (!set.add(p)) {
                    set.remove(p);
                }
            }
        }

        long totalArea = (long) (maxX - minX) * (maxY - minY);

        if (area != totalArea || set.size() != 4) {
            return false;
        }

        return set.contains(minX + "," + minY)
            && set.contains(minX + "," + maxY)
            && set.contains(maxX + "," + minY)
            && set.contains(maxX + "," + maxY);
    }
}
