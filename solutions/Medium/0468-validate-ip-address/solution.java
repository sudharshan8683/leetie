// ──────────────────────────────────────────────────
// Problem  : 468. Validate IP Address
// Difficulty: Medium
// Tags     : String
// Link     : https://leetcode.com/problems/validate-ip-address/
// Runtime  : 1 ms (beats 93%)
// Memory   : 42172000 (beats 98%)
// Language : java
// Copyright: (c) 2026 sudharshan8683. All rights reserved.
// Synced by: leetie
// ──────────────────────────────────────────────────

class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            String[] a = queryIP.split("\\.", -1);

            if (a.length != 4) return "Neither";

            for (String s : a) {
                if (s.length() == 0 || s.length() > 3)
                    return "Neither";

                if (s.length() > 1 && s.charAt(0) == '0')
                    return "Neither";

                for (char c : s.toCharArray()) {
                    if (!Character.isDigit(c))
                        return "Neither";
                }

                int n = Integer.parseInt(s);
                if (n > 255) return "Neither";
            }
            return "IPv4";
        }

        if (queryIP.contains(":")) {
            String[] a = queryIP.split(":", -1);

            if (a.length != 8) return "Neither";

            for (String s : a) {
                if (s.length() < 1 || s.length() > 4)
                    return "Neither";

                for (char c : s.toCharArray()) {
                    if (!Character.isDigit(c) &&
                        !(c >= 'a' && c <= 'f') &&
                        !(c >= 'A' && c <= 'F'))
                        return "Neither";
                }
            }
            return "IPv6";
        }

        return "Neither";
    }
}