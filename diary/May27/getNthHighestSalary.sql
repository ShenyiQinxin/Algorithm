CREATE FUNCTION getNthHighestSalary(N IN NUMBER) RETURN NUMBER IS
result NUMBER;
BEGIN
    /* Write your PL/SQL query statement below */
    select salary into result from (
        select salary,rownum r1 from
            (select distinct salary from Employee order by salary desc)
        )
    where r1 = n;
    RETURN result;
END;
/*
Use "rownum" in subqueries.
1st query: order of salary in desc,
2nd query: get rownum as r1 of ordered table in 1st query;
3rd query: make r1 fixed.
Note: use "distinct" to output null value.
*/