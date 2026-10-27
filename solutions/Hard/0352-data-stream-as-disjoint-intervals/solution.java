// ──────────────────────────────────────────────────
// Problem  : 352. Data Stream as Disjoint Intervals
// Difficulty: Hard
// Tags     : Hash Table, Binary Search, Union-Find, Design, Data Stream, Ordered Set
// Link     : https://leetcode.com/problems/data-stream-as-disjoint-intervals/
// Runtime  : 24 ms (beats 20%)
// Memory   : 44724000 (beats 95%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.*;

class SummaryRanges {
    TreeSet<Integer> set;

    public SummaryRanges() {
        set = new TreeSet<>();
    }

    public void addNum(int value) {
        set.add(value);
    }

    public int[][] getIntervals() {
        List<int[]> list = new ArrayList<>();

        for (int num : set) {
            if (list.isEmpty() || num > list.get(list.size() - 1)[1] + 1) {
                list.add(new int[]{num, num});
            } else {
                list.get(list.size() - 1)[1] = num;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
