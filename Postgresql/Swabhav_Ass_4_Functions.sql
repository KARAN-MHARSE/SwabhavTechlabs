-- 1. Get student details
create or replace function get_student_details(
	p_student_id int
) returns text
language plpgsql
as $$
declare
	v_roll_number int;
	v_student_name text;
begin
	select
		roll_number,name
	into
		v_roll_number,v_student_name
	from student
	where id = p_student_id;
	
	return 'Roll: [' || v_roll_number || '] -name [' || v_student_name || ']';
end;
$$;

select roll_number,get_student_details(id) AS student_details from student;


-- 2. Write a function get_grade that takes a percentage as input and returns grade
create or replace function get_grade(
	p_student_id int
) returns text
language plpgsql
as $$
declare
	v_percentage numeric;
begin
	select percentage
	into v_percentage
	from student
	where id=p_student_id;
	
	if(v_percentage is null) then
		return 'Student number not exist';
	else
		if v_percentage>=90 then return 'A';
		elsif v_percentage>=75 then return 'B';
		elsif v_percentage>=50 then return 'C';
		else return 'D';
		end if;
	end if;
end;
$$;

select name,get_grade(2) as grade from student;

-- 3.Get Age Category
create or replace function get_age_category(
	p_student_id int
) returns text
language plpgsql
as $$
declare
	v_age int;
begin
	select age
	into v_age
	from student
	where id=p_student_id;
	
	if(v_age is null) then return 'Student not exist';
	elsif ( v_age<20) then return 'Teen';
	elsif(v_age<40) then return 'Adult';
	else return 'Senior';
	end if;	
end;
$$;

select name,get_age_category(id) age_category from student;

-- 4. Check Pass or Fail
create or replace function is_passed(
	p_student_id int
) returns text
language plpgsql
as $$
declare
	v_percentage numeric;
begin
	select percentage
	into v_percentage
	from student
	where id = p_student_id;
	
	if(v_percentage is null) then return 'Student marks not found';
	elsif(v_percentage >=40) then return 'Pass';
	else return 'Failed';
	end if;
end;
$$;

select name,is_passed(id) as passing_status from student;

-- 5. Get Subject Count for a Student
create or replace function subject_count(
	p_student_id int
) returns int
language plpgsql
as $$
declare
	v_student_count int;
begin
	select count(su.id)
	into v_student_count
	from subject su
	where su.student_id = p_student_id;
	
	return v_student_count;
end;
$$;

select name, subject_count(id) as total_subjects from student order by total_subjects desc;

-- 6. Get Course Count
create or replace function course_count(
	p_student_id int
) returns int
language plpgsql
as $$
declare
	v_course_count int;
begin
	select count(distinct sc.course_id)
	into v_course_count
	from student_course sc
	where sc.student_id = p_student_id;
	
	return v_course_count;
end;
$$;

select name, course_count(id) as total_courses from student ;

-- 7. Get Mobile Number
create or replace function get_mobile_by_student(
	p_student_id int
) returns bigint
language plpgsql
as $$
declare
	v_mobile_number bigint;
begin
	select mobile_number 
	into v_mobile_number
	from profile
	where student_id = p_student_id;
	
	return v_mobile_number;
end;
$$;

select name,COALESCE(get_mobile_by_student(id), '0') from student;

-- 8. Average Percentage by City
create or replace function average_percentage_by_city(
	p_city varchar(40)
) returns numeric
language plpgsql
as $$
declare 
	v_average_percentage numeric;
begin
	select avg(st.percentage)
	into v_average_percentage
	from student st
	right join profile p on p.student_id = st.id
	where p.city = p_city;
	
	return v_average_percentage;
end;
$$;

select city,average_percentage_by_city(city)
from profile;

-- 9. Get Highest Percentage Among All Students
create or replace function get_top_percentage_student()
returns RECORD
language plpgsql
as $$
declare
	rec record;
begin
	select name,percentage
	into rec
	from student
	where percentage = (select max(percentage) from student)
	limit 1;
	return rec;
end;
$$;

select get_top_percentage_student() as student_detail;

-- 10. Get Student Status
create or replace function get_student_status(
	p_student_id int
) returns text
language plpgsql
as $$
declare
	v_percentage numeric;
begin
	select percentage
	into v_percentage
	from student 
	where id = p_student_id;
	
	if v_percentage is null then return 'Percentage not found';
	elsif v_percentage >=90 then return 'Excellent';
	elsif v_percentage >=75 then return 'Good';
	elsif v_percentage >=40 then return 'Average';
	else return 'Poor';
	end if;	
end;
$$;

select name, get_student_status(id) as percentage_status from student;
