// ──────────────────────────────────────────────────
// Problem  : 234. Palindrome Linked List
// Difficulty: Easy
// Tags     : Linked List, Two Pointers, Stack, Recursion
// Link     : https://leetcode.com/problems/palindrome-linked-list/
// Runtime  : 4 ms (beats 68%)
// Memory   : 93812000 (beats 95%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;

        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        while (prev != null) {
            if (head.val != prev.val) {
                return false;
            }

            head = head.next;
            prev = prev.next;
        }

        return true;
    }
}