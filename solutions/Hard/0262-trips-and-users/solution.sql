-- ──────────────────────────────────────────────────
-- Problem  : 262. Trips and Users
-- Difficulty: Hard
-- Tags     : Database
-- Link     : https://leetcode.com/problems/trips-and-users/
-- Runtime  : 896 ms (beats 9%)
-- Memory   : 0B (beats 100%)
-- Language : mysql
-- Copyright: (c) 2026 sudharshan8683. All rights reserved.
-- Synced by: leetie
-- ──────────────────────────────────────────────────

SELECT 
    request_at AS Day,
    ROUND(
        SUM(CASE WHEN status IN ('cancelled_by_client', 'cancelled_by_driver') THEN 1 ELSE 0 END) / COUNT(*), 
        2
    ) AS `Cancellation Rate`
FROM Trips
WHERE client_id NOT IN (
        SELECT users_id 
        FROM Users 
        WHERE banned = 'Yes' AND role = 'client'
    )
  AND driver_id NOT IN (
        SELECT users_id 
        FROM Users 
        WHERE banned = 'Yes' AND role = 'driver'
    )
  AND request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY request_at;