// ──────────────────────────────────────────────────
// Problem  : 328. Odd Even Linked List
// Difficulty: Medium
// Tags     : Linked List
// Link     : https://leetcode.com/problems/odd-even-linked-list/
// Runtime  : 0 ms (beats 100%)
// Memory   : 45716000 (beats 96%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
