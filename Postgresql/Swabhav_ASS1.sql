-- #1. Display all employee names in ascending order
select ename from emp
order by ename desc;

-- #2. Display all employees(all columns) in department 20 and 30
select* from emp
where deptno=10 or deptno=20;

-- #3. Display all the employees who are managers
select * from emp
where job = 'MANAGER';

-- #4. Display all the employees whose salary is between 2000 and 5000
select * from emp
where sal between 2000 and 5000;

-- #5. Display all the employees whose commission is null
select * from emp
where comm is null;

-- #6. Display emp_name,salary,comission,ctc(calculated column)
select ename,sal,comm,(sal+comm) as ctc from emp;

-- #7. Display hire_date, current_date, tenure(calculated col) of the empl
select ename ,hiredate,current_date as current_date,extract
(year from current_date)-extract(year from hiredate) as tenure from emp;

-- #8. Display all the employees whose name starts with s
select * from emp 
where ename like 'S%';

-- #9. Display unique department numbers from the employee table
select distinct deptno
from emp;

-- #10. Display emp_name and job in lower case
select lower(ename) as emp_name, lower(job) as job_role from emp;

-- #11. Select top 3 salary earning employee
select * from
(
	select *,
	dense_rank() over(order by sal desc) as rnk
	from emp
  ) s
  where rnk <=3;
  
-- #12. Select clerks and Managers in department 10
select * from emp
where deptno =10 and job in ('MANAGER','CLERK');

-- #13. Display all clerks in asscending order of the department number 
select * from emp
where job = 'CLERK'
order by deptno;

-- #14. Display All employees in the same dept of 'SCOTT' 
select * from emp
where deptno = (
	select deptno from emp where ename = 'SCOTT'
);

-- #15. Employees having same designation of SMITH
select * from emp
where job = (
	select job from emp where ename = 'SMITH'
);

-- #18. Employee who are reproting under KING
select * from emp
where mgr = (
	select empno from emp where ename='KING'
);

-- #19. Employees who have same salary of BLAKE
select * from emp
where sal = (
	select sal from emp where ename = 'BLAKE'
);

-- #20. Display departmentwise number of employees
select deptno, count(empno) as emp_count
from emp
group by deptno;

-- #21. Display jobwise number of employees
select job, count(empno) as emp_count
from emp
group by job;

-- #22. Display deptwise jobwise number of employees
select deptno,job,count(empno)
from emp
group by deptno,job;

-- #23. Display deptwise  employees greater than  3 
select deptno,count(empno)
from emp
group by deptno
having count(empno) > 3;

-- #24. Display designation wise employees count greater than 3 
select job,count(empno)
from emp
group by job
having count(empno) > 3;

-- #25. Display Employee name,deptname and location
select e.ename,d.dname,d.loc
from emp e
inner join dept d
on e.deptno = d.deptno;

-- #27. dipslay all deptnames where there are no employees
select d.dname 
from dept d
where  not exists (
select 1 from emp e where d.deptno=e.deptno );

-- #28. display deptname wise employee count greater than 3, display in descending order of deptname
select d.dname,count(e.empno) as employee_count
from emp e
join dept d on e.deptno=d.deptno
group by d.dname
having count(e.empno) >3;

-- #29. Display all the empname and their manager names
select e.ename as employee_name, COALESCE( m.ename ,'No Manager') as manager_name
from emp e
left join emp m
on e.mgr = m.empno;

-- 30. Display empname,deptname and manager name as bossname , order by bossname
select 
	e.ename as emp_name,
	d.dname,
	m.ename as bossname
from emp e
inner join dept d on e.deptno=d.deptno
left join emp m on e.mgr = m.empno
order by bossname;

-- #31. Display Dname, employee name and names of their managers






















