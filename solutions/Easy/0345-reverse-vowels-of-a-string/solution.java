// ──────────────────────────────────────────────────
// Problem  : 345. Reverse Vowels of a String
// Difficulty: Easy
// Tags     : Two Pointers, String
// Link     : https://leetcode.com/problems/reverse-vowels-of-a-string/
// Runtime  : 4 ms (beats 34%)
// Memory   : 46080000 (beats 90%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────


class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (left < right && "aeiouAEIOU".indexOf(arr[left]) == -1) {
                left++;
            }

            while (left < right && "aeiouAEIOU".indexOf(arr[right]) == -1) {
                right--;
            }

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }
}
