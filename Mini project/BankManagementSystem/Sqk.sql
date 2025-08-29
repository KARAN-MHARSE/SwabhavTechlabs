select * from users;
select * from account;
select * from document;

create or replace function request_for_new_account(
	p_user_id int,
	p_account_type varchar,
	p_account_no varchar,
	p_adhar_no bigint,
	p_pan_no varchar,
) returns boolean as $$
declare
	existing_count int;
begin
	-- 1.Check account is already exist
	select count(*) into existing_count
	from account
	where user_id= p_user_id and type=p_account_type;
	
	if existing_count > 0 then
		return false;
	end if;
	
	-- 2. Update adhar and pancard details in user table 
	update users 
	set adhar_no= p_adhar_no,
		pan_no = p_pan_no 
	where id = p_user_id;
	
	-- 3. Insert new account into account table
	insert into account(account_number,type)
	values (p_account_no,p_account_type);
	return true;
end ;
$$ language plpgsql;
	
	
_
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	