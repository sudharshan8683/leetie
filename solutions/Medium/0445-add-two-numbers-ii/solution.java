// ──────────────────────────────────────────────────
// Problem  : 445. Add Two Numbers II
// Difficulty: Medium
// Tags     : Linked List, Math, Stack
// Link     : https://leetcode.com/problems/add-two-numbers-ii/
// Runtime  : 6 ms (beats 3%)
// Memory   : 46312000 (beats 70%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();

        while (l1 != null) {
            a.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            b.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;

        while (!a.isEmpty() || !b.isEmpty() || carry > 0) {
            int sum = carry;

            if (!a.isEmpty()) sum += a.pop();
            if (!b.isEmpty()) sum += b.pop();

            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;

            carry = sum / 10;
        }
        return head;
    }
}
