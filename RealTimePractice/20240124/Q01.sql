#https://leetcode.com/problems/restaurant-growth/
/*
첫 번째 컬럼 구하는 방법 1
SELECT c2.visited_on, 
FROM Customer c1 INNER JOIN Customer c2
ON c2.visited_on = DATE_ADD(c1.visited_on, INTERVAL 6 DAY)
GROUP BY (c2.visited_on);

*/
/*
첫 번째 컬럼 구하는 방법 2
SELECT visited_on
FROM Customer c
WHERE visited_on >= (
    SELECT DATE_ADD(MIN(visited_on), INTERVAL 6 DAY)
    FROM Customer #01-07
)
GROUP BY visited_on;
*/

SELECT visited_on, 
(
    SELECT SUM(amount)
    FROM Customer
    WHERE visited_on BETWEEN DATE_SUB(c.visited_on, INTERVAL 6 DAY) AND c.visited_on
) as amount, 

ROUND(
(
    SELECT SUM(amount) / 7
    FROM Customer
    WHERE visited_on BETWEEN DATE_SUB(c.visited_on, INTERVAL 6 DAY) AND c.visited_on
) , 2 ) as average_amount
FROM Customer c

WHERE visited_on >= (
    SELECT DATE_ADD(MIN(visited_on), INTERVAL 6 DAY)
    FROM Customer #01-07
)
GROUP BY visited_on;
