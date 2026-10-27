// ──────────────────────────────────────────────────
// Problem  : 355. Design Twitter
// Difficulty: Medium
// Tags     : Hash Table, Linked List, Design, Heap (Priority Queue)
// Link     : https://leetcode.com/problems/design-twitter/
// Runtime  : 31 ms (beats 76%)
// Memory   : 55804000 (beats 95%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.*;

class Twitter {
    Map<Integer, Set<Integer>> follow;
    Map<Integer, List<int[]>> tweets;
    int time;

    public Twitter() {
        follow = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>())
              .add(new int[]{tweetId, time++});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        Set<Integer> users = new HashSet<>();
        users.add(userId);

        if (follow.containsKey(userId)) {
            users.addAll(follow.get(userId));
        }

        for (int user : users) {
            List<int[]> list = tweets.get(user);

            if (list != null) {
                for (int i = list.size() - 1; i >= Math.max(0, list.size() - 10); i--) {
                    pq.offer(list.get(i));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty() && ans.size() < 10) {
            ans.add(pq.poll()[0]);
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            follow.computeIfAbsent(followerId, k -> new HashSet<>())
                  .add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (follow.containsKey(followerId)) {
            follow.get(followerId).remove(followeeId);
        }
    }
}
