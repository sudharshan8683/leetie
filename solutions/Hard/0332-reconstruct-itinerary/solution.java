// ──────────────────────────────────────────────────
// Problem  : 332. Reconstruct Itinerary
// Difficulty: Hard
// Tags     : Array, String, Depth-First Search, Graph Theory, Sorting, Heap (Priority Queue), Eulerian Circuit, Eulerian Path, Semi-Eulerian Graph
// Link     : https://leetcode.com/problems/reconstruct-itinerary/
// Runtime  : 6 ms (beats 79%)
// Memory   : 46376000 (beats 98%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> ans = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
               .offer(ticket.get(1));
        }

        dfs("JFK");
        Collections.reverse(ans);

        return ans;
    }

    public void dfs(String airport) {
        PriorityQueue<String> pq = map.get(airport);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }

        ans.add(airport);
    }
}
