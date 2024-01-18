#https://leetcode.com/problems/game-play-analysis-iv/?envType=study-plan-v2&envId=top-sql-50
/*
[틀린 답안]
SELECT ROUND((COUNT(a1.player_id) / (SELECT COUNT(DISTINCT a.player_id) FROM activity a)), 2) AS fraction 
FROM activity a1 INNER JOIN activity a2
ON a1.event_date = a2.event_date + 1
AND a1.player_id = a2.player_id;
*/ 

WITH
    a2 AS (SELECT player_id, MIN(event_date) AS min_date FROM activity GROUP BY player_id)

SELECT ROUND((COUNT(a1.player_id) / (SELECT COUNT(DISTINCT a.player_id) FROM activity a)), 2) AS fraction 
FROM activity a1 INNER JOIN a2
ON a2.min_date = DATE_SUB(a1.event_date, INTERVAL 1 DAY)
AND a1.player_id = a2.player_id;