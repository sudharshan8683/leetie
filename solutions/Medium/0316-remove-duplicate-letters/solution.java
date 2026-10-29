// ──────────────────────────────────────────────────
// Problem  : 316. Remove Duplicate Letters
// Difficulty: Medium
// Tags     : String, Stack, Greedy, Monotonic Stack
// Link     : https://leetcode.com/problems/remove-duplicate-letters/
// Runtime  : 3 ms (beats 30%)
// Memory   : 42948000 (beats 96%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        boolean[] seen = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            
            if (seen[curr]) continue;
            
            while (!stack.isEmpty() && stack.peek() > curr && i < lastIndex[stack.peek()]) {
                seen[stack.pop()] = false;
            }
            
            stack.push(curr);
            seen[curr] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : stack) {
            sb.append((char) (num + 'a'));
        }
        
        return sb.toString();
    }
}