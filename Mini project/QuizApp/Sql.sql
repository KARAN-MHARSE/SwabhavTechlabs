create table users (
	id serial primary key not null,
	name varchar(250) not null,
	role varchar(100) default 'Student',
	email varchar(250) not null,
	password varchar(250) not null
);
select * from users;

insert into users 
(name,role,email,password)
values ('Karan','Student','karan@gmail.com','1234');

select * from users where email='karan@gmail.com';



create table topic(
	id serial primary key not null,
	name varchar(250) not null
)

INSERT INTO topic (name) VALUES ('java');
INSERT INTO topic (name) VALUES ('sql');
INSERT INTO topic (name) VALUES ('python');

select * from topic;

create table question(
	id serial primary key not null,
	question TEXT not null,
	option1 text default 'N/A',
	option2 text default 'N/A',
	option3 text default 'N/A',
	option4 text default 'N/A',
	right_ans text default 'N/A',
	topic_id int not null,
	foreign key(topic_id) REFERENCES  topic(id)
	 on delete cascade
)

INSERT INTO question (question, option1, option2, option3, option4, right_ans, topic_id) VALUES
('Which keyword is used to inherit a class in Java?', 'this', 'extends', 'implements', 'super', 'extends', 1),
('Which method is the entry point of a Java program?', 'main()', 'start()', 'run()', 'init()', 'main()', 1),
('Which of these is not a primitive type in Java?', 'int', 'float', 'boolean', 'String', 'String', 1),
('What is the size of int in Java?', '4 bytes', '2 bytes', '8 bytes', 'Depends on system', '4 bytes', 1),
('Which package contains the Scanner class?', 'java.util', 'java.io', 'java.net', 'java.lang', 'java.util', 1),
('Which keyword is used to create an object?', 'class', 'new', 'this', 'static', 'new', 1),
('Which access modifier makes a member visible in all packages?', 'private', 'protected', 'public', 'default', 'public', 1),
('Which exception is a checked exception?', 'NullPointerException', 'IOException', 'ArithmeticException', 'ArrayIndexOutOfBoundsException', 'IOException', 1),
('Which collection class allows duplicates and maintains insertion order?', 'HashSet', 'TreeSet', 'ArrayList', 'HashMap', 'ArrayList', 1),
('Which feature of OOP allows reusing code?', 'Polymorphism', 'Inheritance', 'Encapsulation', 'Abstraction', 'Inheritance', 1);

INSERT INTO question (question, option1, option2, option3, option4, right_ans, topic_id) VALUES
('Which SQL keyword is used to retrieve data?', 'SELECT', 'GET', 'FETCH', 'SHOW', 'SELECT', 2),
('Which clause is used to filter rows?', 'WHERE', 'ORDER BY', 'GROUP BY', 'HAVING', 'WHERE', 2),
('Which function returns the number of rows?', 'COUNT()', 'SUM()', 'AVG()', 'ROWS()', 'COUNT()', 2),
('Which SQL statement is used to insert data?', 'INSERT INTO', 'ADD ROW', 'PUT', 'APPEND', 'INSERT INTO', 2),
('Which join returns all records from both tables?', 'INNER JOIN', 'LEFT JOIN', 'RIGHT JOIN', 'FULL JOIN', 'FULL JOIN', 2),
('Which keyword is used to remove a table?', 'DELETE', 'DROP', 'REMOVE', 'TRUNCATE', 'DROP', 2),
('Which operator is used for pattern matching?', 'LIKE', 'MATCH', 'FIND', 'SEARCH', 'LIKE', 2),
('Which SQL command changes table structure?', 'ALTER TABLE', 'UPDATE TABLE', 'MODIFY', 'CHANGE', 'ALTER TABLE', 2),
('Which function returns the current date?', 'GETDATE()', 'SYSDATE', 'NOW()', 'CURDATE()', 'NOW()', 2),
('Which constraint ensures unique values in a column?', 'PRIMARY KEY', 'FOREIGN KEY', 'UNIQUE', 'CHECK', 'UNIQUE', 2);


INSERT INTO question (question, option1, option2, option3, option4, right_ans, topic_id) VALUES
('Which keyword is used to define a function in Python?', 'func', 'def', 'function', 'lambda', 'def', 3),
('What is the output of type(3.0)?', '<class int>', '<class float>', '<class double>', '<class number>', '<class float>', 3),
('Which collection type is immutable?', 'list', 'dict', 'tuple', 'set', 'tuple', 3),
('Which keyword is used to handle exceptions?', 'catch', 'try', 'except', 'throw', 'except', 3),
('Which function is used to read input from the user?', 'read()', 'input()', 'scan()', 'get()', 'input()', 3),
('Which operator is used for exponentiation?', '^', '**', 'pow', 'exp', '**', 3),
('Which method is used to add an item to a list?', 'append()', 'add()', 'insert()', 'push()', 'append()', 3),
('Which statement is used to exit a loop?', 'stop', 'exit', 'break', 'return', 'break', 3),
('Which keyword is used to create a class in Python?', 'class', 'Class', 'object', 'struct', 'class', 3),
('Which library is used for data analysis?', 'numpy', 'pandas', 'matplotlib', 'scipy', 'pandas', 3);


select * from question;