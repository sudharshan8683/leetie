// ──────────────────────────────────────────────────
// Problem  : 225. Implement Stack using Queues
// Difficulty: Easy
// Tags     : Stack, Design, Queue
// Link     : https://leetcode.com/problems/implement-stack-using-queues/
// Runtime  : 1 ms (beats 88%)
// Memory   : 42628000 (beats 80%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class MyStack {
    java.util.Queue<Integer> q = new java.util.LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {
        q.add(x);

        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}