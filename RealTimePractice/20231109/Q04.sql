#https://leetcode.com/problems/investments-in-2016/description/?envType=study-plan-v2&envId=top-sql-50

SELECT round(sum(tiv_2016), 2) as tiv_2016
FROM Insurance
WHERE tiv_2015 IN (
  SELECT tiv_2015
  FROM Insurance
  GROUP BY tiv_2015
  HAVING count(pid) > 1
) AND (lat, lon) IN (
  SELECT lat, lon
  FROM Insurance
  GROUP BY lat, lon
  HAVING count(pid) = 1
)