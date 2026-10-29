// ──────────────────────────────────────────────────
// Problem  : 382. Linked List Random Node
// Difficulty: Medium
// Tags     : Linked List, Math, Reservoir Sampling, Randomized
// Link     : https://leetcode.com/problems/linked-list-random-node/
// Runtime  : 12 ms (beats 63%)
// Memory   : 48052000 (beats 74%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────



class Solution {
    ListNode head;
    Random rand;

    public Solution(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    public int getRandom() {
        ListNode curr = head;
        int result = 0;
        int count = 1;

        while (curr != null) {
            if (rand.nextInt(count) == 0) {
                result = curr.val;
            }
            count++;
            curr = curr.next;
        }

        return result;
    }
}
