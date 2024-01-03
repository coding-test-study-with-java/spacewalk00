# https://leetcode.com/problems/monthly-transactions-i/submissions/
SELECT 
DATE_FORMAT(trans_date, '%Y-%m') AS month, 
country, 
COUNT(*) AS trans_count,
COUNT(CASE WHEN state='approved' THEN 1 END) AS approved_count,
SUM(amount) AS trans_total_amount,
#SUM(if(state='approved', amount, 0)) as approved_total_amount
SUM(CASE WHEN state='approved' THEN amount END) AS approved_total_amount 
FROM Transactions t
GROUP BY month, country;