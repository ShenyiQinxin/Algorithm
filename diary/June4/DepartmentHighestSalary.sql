
select dept.name department, emp.name employee, emp.salary salary
from employee emp inner join department dept on emp.departmentid=dept.id
where (emp.departmentid, emp.salary) in
(select departmentid, max(salary) max_salary from employee group by departmentid)