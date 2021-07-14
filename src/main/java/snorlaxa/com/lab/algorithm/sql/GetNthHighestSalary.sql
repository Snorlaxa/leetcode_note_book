-- 第N大的薪水
-- 编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
-- n = 2 时，应返回第二高的薪水 200。如果不存在第 n 高的薪水，那么查询应返回 null
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N:=N-1;
  RETURN (
      # Write your MySQL query statement below.
      select distinct(salary)
      from employee
      group by salary
      order by salary desc
      limit N,1
  );
END