# https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends/
# UNION과 OR의 용도 차이? ..
/* 
1) 틀린 답안
SELECT requester_id as id,
( SELECT COUNT(*)
FROM RequestAccepted
WHERE id = requester_id or id = accepter_id ) as num
FROM RequestAccepted
GROUP BY requester_id
ORDER BY num DESC LIMIT 1;

2) 고친 답안
select requester_id as id,
    (select count(*) from RequestAccepted  where (requester_id = id or accepter_id = id)) as num
from RequestAccepted
group by requester_id
union 
select accepter_id as id,
    (select count(*) from RequestAccepted  where (requester_id = id or accepter_id = id)) as num
from RequestAccepted
group by accepter_id
order by num desc limit 1;
*/

WITH all_id AS (
    SELECT requester_id AS id
    FROM RequestAccepted
    UNION ALL
    SELECT accepter_id AS id
    FROM RequestAccepted
)

SELECT id, COUNT(*) AS num
FROM all_id
GROUP BY id
ORDER BY num DESC
LIMIT 1;

