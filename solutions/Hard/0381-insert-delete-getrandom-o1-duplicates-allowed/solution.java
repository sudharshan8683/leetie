// ──────────────────────────────────────────────────
// Problem  : 381. Insert Delete GetRandom O(1) - Duplicates allowed
// Difficulty: Hard
// Tags     : Array, Hash Table, Math, Design, Randomized
// Link     : https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
// Runtime  : 28 ms (beats 95%)
// Memory   : 98344000 (beats 91%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.*;

class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random rand;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean result = !map.containsKey(val);
        map.putIfAbsent(val, new HashSet<>());
        map.get(val).add(list.size());
        list.add(val);
        return result;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }

        int removeIndex = map.get(val).iterator().next();
        int lastIndex = list.size() - 1;
        int lastVal = list.get(lastIndex);

        map.get(val).remove(removeIndex);

        if (removeIndex != lastIndex) {
            list.set(removeIndex, lastVal);
            map.get(lastVal).remove(lastIndex);
            map.get(lastVal).add(removeIndex);
        }

        list.remove(lastIndex);

        if (map.get(val).isEmpty()) {
            map.remove(val);
        }

        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
