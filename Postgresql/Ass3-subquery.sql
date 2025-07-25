select * from employee;
select * from department;

insert into employee(name,email,salary,hire_date) values ('Yash','ya@gmail.com',67000,'2020-12-01');

-- List all employees whose department name is either "Sales" or "IT" — using a subquery with IN (not a join).
select * from employee 
where dept_id in
(select id from department where name in ('Sales','IT'));

-- Show the names of departments that have at least one employee using EXISTS.
select d.name from department d where exists 
(select distinct e.id from employee e where d.id=e.dept_id );

-- List each employee's name and a remark column using CASE:
-- If salary ≥ 80000 → "High"
-- If salary between 50000 and 79999 → "Medium"
-- If salary < 50000 → "Low"
select name,
case
	when salary>=80000 then 'High'
	when salary>=50000 then 'Medium'
	else 'Low'
end as salary_range
from employee;

-- Show the name and department of all employees. If any employee has no department assigned, show "No Department" using COALESCE.
select e.name,COALESCE(d.name,'No department') 
from employee e
left join
department d
on e.dept_id=d.id;

-- Write a query to find employees who were hired earlier than all employees in the "IT" department using a correlated subquery.
select * from employee e
where e.hire_date < (
	select min(hire_date) from employee e join department d on e.dept_id=d.id where d.name='IT'
);























