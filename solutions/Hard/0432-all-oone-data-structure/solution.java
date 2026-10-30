// ──────────────────────────────────────────────────
// Problem  : 432. All O`one Data Structure
// Difficulty: Hard
// Tags     : Hash Table, Linked List, Design, Doubly-Linked List
// Link     : https://leetcode.com/problems/all-oone-data-structure/
// Runtime  : 78 ms (beats 59%)
// Memory   : 78864000 (beats 58%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class AllOne {
    class Bucket {
        int count;
        Set<String> keys = new HashSet<>();
        Bucket prev, next;

        Bucket(int count) {
            this.count = count;
        }
    }

    Map<String, Bucket> map = new HashMap<>();
    Bucket head = new Bucket(0);
    Bucket tail = new Bucket(0);

    public AllOne() {
        head.next = tail;
        tail.prev = head;
    }

    void insertAfter(Bucket a, Bucket b) {
        b.next = a.next;
        b.prev = a;
        a.next.prev = b;
        a.next = b;
    }

    void remove(Bucket b) {
        b.prev.next = b.next;
        b.next.prev = b.prev;
    }

    public void inc(String key) {
        Bucket old = map.get(key);
        Bucket next;

        if (old == null) {
            next = head.next;

            if (next == tail || next.count != 1) {
                next = new Bucket(1);
                insertAfter(head, next);
            }
        } else {
            next = old.next;

            if (next == tail || next.count != old.count + 1) {
                next = new Bucket(old.count + 1);
                insertAfter(old, next);
            }

            old.keys.remove(key);

            if (old.keys.isEmpty()) remove(old);
        }

        next.keys.add(key);
        map.put(key, next);
    }

    public void dec(String key) {
        Bucket old = map.get(key);

        old.keys.remove(key);

        if (old.count == 1) {
            map.remove(key);
        } else {
            Bucket prev = old.prev;

            if (prev == head || prev.count != old.count - 1) {
                prev = new Bucket(old.count - 1);
                insertAfter(old.prev, prev);
            }

            prev.keys.add(key);
            map.put(key, prev);
        }

        if (old.keys.isEmpty()) remove(old);
    }

    public String getMaxKey() {
        if (tail.prev == head) return "";
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.keys.iterator().next();
    }
}