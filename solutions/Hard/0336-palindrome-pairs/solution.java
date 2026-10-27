// ──────────────────────────────────────────────────
// Problem  : 336. Palindrome Pairs
// Difficulty: Hard
// Tags     : Array, Hash Table, String, Trie, Hash Function
// Link     : https://leetcode.com/problems/palindrome-pairs/
// Runtime  : 1392 ms (beats 13%)
// Memory   : 60108000 (beats 93%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            for (int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);

                if (isPalindrome(left)) {
                    String rev = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(rev) && map.get(rev) != i) {
                        ans.add(Arrays.asList(map.get(rev), i));
                    }
                }

                if (j != word.length() && isPalindrome(right)) {
                    String rev = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(rev) && map.get(rev) != i) {
                        ans.add(Arrays.asList(i, map.get(rev)));
                    }
                }
            }
        }

        return ans;
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
