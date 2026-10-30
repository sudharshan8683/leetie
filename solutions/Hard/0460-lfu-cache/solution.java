// ──────────────────────────────────────────────────
// Problem  : 460. LFU Cache
// Difficulty: Hard
// Tags     : Hash Table, Linked List, Design, Doubly-Linked List
// Link     : https://leetcode.com/problems/lfu-cache/
// Runtime  : 62 ms (beats 44%)
// Memory   : 137616000 (beats 34%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class LFUCache {
    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
            freq = 1;
        }
    }

    class ListNode {
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        int size = 0;

        ListNode() {
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0) return null;
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Map<Integer, ListNode> freqMap = new HashMap<>();
    int capacity, minFreq = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            update(node);
            return;
        }

        if (map.size() == capacity) {
            ListNode list = freqMap.get(minFreq);
            Node removed = list.removeLast();
            map.remove(removed.key);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        freqMap.computeIfAbsent(1, k -> new ListNode()).add(node);
        minFreq = 1;
    }

    public void update(Node node) {
        int freq = node.freq;
        ListNode list = freqMap.get(freq);
        list.remove(node);

        if (freq == minFreq && list.size == 0)
            minFreq++;

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new ListNode()).add(node);
    }
}