CREATE OR REPLACE PROCEDURE print_name()
LANGUAGE plpgsql
AS $$
BEGIN
  RAISE NOTICE 'My name is Karan';
END;
$$;


create procedure add_new_student( p_roll_number integer, p_name text,  p_age integer, p_percentage numeric)
language plpgsql
as $$
begin
	insert into student (roll_number,name,age,percentage)
	values ( p_roll_number, p_name, p_age, p_percentage);
end;
$$;

call add_new_student(1020,'Snehal',22,89);

create procedure get_student_by_roll_number(p_roll_number integer)
language plpgsql
as $$
begin
	perform * from student where roll_number = p_roll_number;
end;
$$;

call get_student_by_roll_number(1);

-- update percentage 

create or replace procedure update_percentage(
	in p_roll_number integer,
	inout p_percentage numeric
)
language plpgsql
as $$
begin
	update student
	set percentage=p_percentage
	where roll_number=p_roll_number;
	
	select percentage into p_percentage
	from student
	where roll_number=p_roll_number;
end;
$$;

call update_percentage(1,78);

-- procedure to return the all subject opted by a student whose student id is given
create or replace procedure get_subject_names(
	in p_roll_number integer
)
language plpgsql
as $$
declare
	subject_name text;
begin
	raise notice 'Subjects:';
	
	for subject_name in
		select name from subject su where su.student_id= p_roll_number
	loop
		raise notice '%' ,subject_name;
	end loop;
end;
$$;

call get_subject_names(1);


-- write a procedure that accept student_id and returns name and percentage
create or replace procedure get_name_percentage(
	in p_student_id integer,
	out p_name text,
	out p_percentage numeric
)
language plpgsql
as $$
begin
	select name,percentage
	into p_name,p_percentage
	from student
	where id= p_student_id;
end;
$$;

CALL get_name_percentage(1);  -- This will display result set


do $$
declare
	p_name text;
	p_percentage numeric;
	BEGIN
		CALL get_name_percentage(1,p_name,p_percentage);
		raise notice 'name: %', p_name;
		raise notice 'percentage: %', p_percentage;
	end;
$$;


-- 11 update student age and return updated age
create or replace procedure update_age(
	p_student_id int,
	inout p_age int
)
language plpgsql
as $$
begin
	update student 
	set age = p_age
	where id=p_student_id;
	
	select age 
	into p_age
	from student
	where id=p_student_id;
end;
$$;

call update_age(2,18)
			

-- 12 insert subject and also check already present or not
create or replace procedure add_subject
(
	p_student_id int,
	inout p_subject_name varchar
)
language plpgsql
as $$
declare
	v_subject_name varchar(30);
	v_student_id int;
begin
	select su.name ,st.id
	into v_subject_name,v_student_id
	from subject su
	join student st on st.id = su.student_id
	where su.name= p_subject_name;
	
	if(v_subject_name) then
		raise notice 'subject already present';
	else 
		insert into subject (id,name,student_id)
		values (100,p_subject_name,v_student_id);
		raise notice 'Successfully added';
	end if;
	
end;
$$;

call add_subject(2,'Java');


-- 13 create student and profile 
select * from profile;
create or replace procedure create_new_student_and_profile(
	p_roll_number int,
	p_name text,
	p_age int,
	p_percentage numeric,
	p_city varchar(20),
	p_mobile_number bigint
)
language plpgsql
as $$
declare 
	v_student_id int;
	v_max_subject_id int;
begin
	insert into student (roll_number,name,age,percentage)values
	(p_roll_number,p_name,p_age,p_percentage);
	
	select id 
	into v_student_id
	from student
	where name= p_name;
	
	select max(id) 
	into v_max_subject_id
	from profile;
	
	insert into profile values
	(v_max_subject_id+1,p_city,p_mobile_number,v_student_id);
	
	raise notice 'Succesfully inserted';
end;
$$;


call create_new_student_and_profile(120,'Vaibhav',34,89,'Mumbai',1234567890);

-- 14 add logs of updated percentage
create table audit
(
	id  serial,
	student_id int,
	old_percentage numeric,
	new_percentage numeric,
	updated_at date DEFAULT current_date
);

create or replace procedure update_log(
	p_student_id int,
	p_new_percentage numeric
)
language plpgsql
as $$
declare 
	v_old_percentage numeric;
begin
	select percentage 
	into v_old_percentage
	from student
	where id=p_student_id;
	
	if(v_old_percentage is null) then
		raise notice 'Wrong roll number';
	else
		update student
		set percentage = v_old_percentage
		where id = p_student_id;

		insert into audit(student_id,old_percentage,new_percentage)
		values (p_student_id,v_old_percentage,p_new_percentage);
	
		raise notice 'Succesfully updated';
	end if;
end;
$$;

call update_log(782,78);

-- 15 delete all records of student
create or replace procedure delete_student(
	p_student_id int
)
language plpgsql
as $$
declare
	v_student_id int;
begin
	select id 
	into v_student_id
	from student 
	where id = p_student_id;
	
	if(v_student_id is null) then
		raise notice 'No student found';
	else 
		delete from subject
		where student_id = p_student_id;

		delete from profile
		where student_id = p_student_id;

		delete from student_course
		where student_id = p_student_id;

		delete from student
		where id=p_student_id;

		raise notice 'successfully deleted';
	end if;
end;
$$;

call delete_student(1);
