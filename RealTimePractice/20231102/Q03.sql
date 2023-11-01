/*
https://leetcode.com/problems/product-sales-analysis-iii/?envType=study-plan-v2&envId=top-sql-50
테스트 케이스만 맞음.
*/

# Write your MySQL query statement below
SELECT s.product_id, MIN(s.year) AS first_year, s.quantity, s.price
FROM Sales s left join Product p ON s.product_id = p.product_id
GROUP BY s.product_id;