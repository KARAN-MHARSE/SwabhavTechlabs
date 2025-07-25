select * from employee;
select dept from employee group by dept;


create table department(
	id serial primary key,
	name varchar(30) not null
);

insert into department(name) values
('Sales'),('Production'),('Marketing'),('Maitenance'),('Develoment'),('IT');

select * from employee;
select * from department;

alter table  employee
add column dept_id int;

update employee e
set dept_id= (
select id from department d where e.dept=d.name
);

alter table employee
drop column dept;

-- List all employee names along with their department names.
select e.name as employee_name,d.name as dept_name from employee e
join department d
on e.dept_id=d.id;

-- Display the name and salary of employees who earn more than the average salary.
select name,salary from employee
where salary > (
select avg(salary) from employee
);

-- Find the total salary spent for each department, sorted by total salary in descending order.
select d.name as dept_name, sum(e.salary) as total_salary_spent
from employee e
join
department d
on d.id=e.dept_id
group by d.name
order by sum(e.salary) desc;

-- Show the names of employees who were hired in the same year as "Sachin".
select name from employee
where EXTRACT(Year from hire_date)=(
select EXTRACT(Year from hire_date) from employee where name='Sachin'
);


-- List all employees along with department names. If an employee doesn't belong to any department, still show their name with "No Department".
select 
	e.name,
	case
		when e.dept_id is not null then d.name
		else 'No Department'
	end
	from employee e
	join department d
	on e.dept_id=d.id;

