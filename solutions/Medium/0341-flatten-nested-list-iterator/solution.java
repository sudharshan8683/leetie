// ──────────────────────────────────────────────────
// Problem  : 341. Flatten Nested List Iterator
// Difficulty: Medium
// Tags     : Stack, Tree, Depth-First Search, Design, Queue, Iterator
// Link     : https://leetcode.com/problems/flatten-nested-list-iterator/
// Runtime  : 3 ms (beats 72%)
// Memory   : 47460000 (beats 98%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        flatten(nestedList, list);
        iterator = list.iterator();
    }

    public void flatten(List<NestedInteger> nestedList, List<Integer> list) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                list.add(ni.getInteger());
            } else {
                flatten(ni.getList(), list);
            }
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}
