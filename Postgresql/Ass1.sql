create table employee(
	id serial primary key,
	name varchar(30) not null,
	email varchar(30) not null,
	dept varchar(30),
	salary numeric(10,2) default 30000,
	hire_date date default CURRENT_DATE
);

insert into employee (name,email,dept,salary,hire_date) values
('Karan','k@gmail.com','Sales',50000,'2022-07-19'),
('Sachin','s@gmail.com','Production',80000,'2022-12-19'),
('Akash','a@gmail.com','Marketing',40000,'2024-07-19'),
('Prathamesh','p@gmail.com','Develoment',90000,'2023-01-19'),
('Jayesh','j@gmail.com','IT',50000,'2025-01-10'),
('Jitendra','ji@gmail.com','Maitenance',20000,'2022-07-19'),
('Vaman','v@gmail.com','Sales',40000,'2022-07-19');

-- List the names of all employees in the "Sales" department.
select name from employee where dept='Sales';

-- Show all employee details who were hired after January 1, 2020.
select * from employee where hire_date>'2020-01-01';

-- Get the names and salaries of employees earning more than ₹50,000, sorted by salary in descending order
select name,salary from employee 
where salary>50000
order by salary desc;

-- Find the number of employees in each department.
select dept,count(id) as number_of_employees
from employee
group by dept;

-- Display the details of the employee who has the highest salary.
select * from employee
order by salary desc
limit 1;


















