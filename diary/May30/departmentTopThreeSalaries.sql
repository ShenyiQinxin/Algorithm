# find employees who earn the top three salaries in each of the department.

select d.name department, e.name employee, e.salary salary
select * from (
    select employee.*, 
    dense_rank() over (partition by departmentid order by salary desc) rn 
    from employee)
    where rn<=3
) e
inner join department d
on e.departmentid = d.id