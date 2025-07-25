-- 6. find students with no profile
select * from student st 
where not exists (
	select 1 from profile p where p.student_id= st.id
);

-- 7.list students with mobile number and city
select st.roll_number
		,st.name
		,COALESCE(p.mobile_number,'0')
		,COALESCE(p.city,'NA')
from student st
left join profile p
on st.id=p.student_id;

-- 8.list all subjects taken by students from mumbai
select su.name
from student st
join subject su on st.id = su.student_id
join profile p on st.id= p.student_id
where p.city='Mumbai';

-- 9.get average pecetange of students per city
select p.city, avg(st.percentage) as average_percentage
from profile p
left join student st on st.id = p.student_id
group by p.city;

-- 10.find students who are enrolled in BSC_Maths and live in pune
select st.roll_number,st.name,c.name,p.city
from student st
join student_course sc on sc.student_id=st.id
join course c on c.id = sc.course_id
join profile p on p.student_id = st.id
where c.name = 'BSc Mathematics' and p.city='Pune';

-- 11. get names of students who have taken both Physics and maths
select st.name 
from student st
join subject su1 on su1.student_id = st.id
join subject su2 on su2.student_id = st.id
where su1.name='Physics' and su2.name='Mathematics';

-- 12. show students who are not enrolled in any course
select * from student st
where not exists (
	select 1 from student_course sc where sc.student_id=st.id
)	

-- 13.Display city wise count of students enrolled in more than one subject
select p.city,count(distinct st.id)
from student st
join subject su on su.student_id=st.id
join profile p on p.student_id = st.id
group by p.city
having count(su.id)>1;

-- 14.for each student show their roll number,name,city and all courses and subjects
select 
	st.roll_number,
	st.name,
	COALESCE(p.city,'Not available'),
	COALESCE(string_agg( distinct c.name,','),'Not courses') as courses,
	COALESCE(string_agg(distinct su.name,','),'No subjects') as subjects
from student st
left join profile p on p.student_id = st.id
left join subject su on su.student_id = st.id
left join student_course sc on sc.student_id=st.id
left join course c on c.id = sc.course_id
group by st.name,p.city,st.roll_number;

-- 15. find top 3 students with the highest percentage in each city
select * from (
		select 
			p.city,
			st.name,
			st.percentage,
			rank() over(partition by p.city order by st.percentage desc) as rnk
		from student st
		join profile p on p.student_id=st.id
		order by p.city
) as sy
where rnk < 4;

-- 16. list of students who exactly takes 3 subjects
select st.roll_number,st.name
from student st
join subject su on su.student_id = st.id
group by st.name, st.roll_number
having count(su.id) = 3;

-- 17.show courses that no students are enrolled in
select c.name from course c
where not exists (
	select 1 from student_course sc where c.id = sc.course_id
)

-- 18.list students who shared same student
select
	st.percentage,
	string_agg(st.name,',') as students
from student st
group by st.percentage
order by st.percentage desc;

-- 19. display the number of courses and subjects each students is enrolled in
select 
	st.name,
	count(sc.id) as total_courses,
	count(su.id) as total_subjects
from student st
left join subject su on su.student_id = st.id
left join student_course sc on sc.student_id = st.id
group by st.name;

