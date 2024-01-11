# https://leetcode.com/problems/market-analysis-i/description/
# Write a solution to find for each user, the join date and the number of orders they made as a buyer in 2019.

/*
[틀림]
SELECT u.user_id AS 'buyer_id', u.join_date, if(YEAR(order_date) = 2019, COUNT(order_date) , 0) AS 'orders_in_2019'
FROM Users u, Orders o
WHERE o.buyer_id = u.user_id 
GROUP BY user_id
ORDER BY user_id;
*/

SELECT u.user_id AS 'buyer_id', join_date, IFNULL(COUNT(order_date), 0) AS 'orders_in_2019'
FROM Users u LEFT JOIN Orders o ON o.buyer_id = u.user_id AND YEAR(order_date) = 2019
GROUP BY user_id