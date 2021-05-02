insert into course(id,name,last_update_date,created_date) values(1001,'JPA 50',sysdate(),sysdate());--use single quotes not double
insert into course(id,name,last_update_date,created_date) values(1002,'JPA 51',sysdate(),sysdate());--use single quotes not double
insert into course(id,name,last_update_date,created_date) values(1003,'JPA 52',sysdate(),sysdate());--use single quotes not double


insert into passport(id,number)
values(40001,'E123456');
insert into passport(id,number)
values(40002,'N123457');
insert into passport(id,number)
values(40003,'L123890');

insert into student(id,name,passport_id)
values(20001,'Ranga',40001);
insert into student(id,name,passport_id)
values(20002,'Adam',40002);
insert into student(id,name,passport_id)
values(20003,'Jane',40003);

--insert into review(id,rating,description)
--values(50001,'5', 'Great Course');
--insert into review(id,rating,description)
--values(50002,'4', 'Wonderful Course');
--insert into review(id,rating,description)
--values(50003,'5', 'Awesome Course');


insert into review(id,rating,description,course_id)
values(50001,'5', 'Great Course',1001);
insert into review(id,rating,description,course_id)
values(50002,'4', 'Wonderful Course',1002);
insert into review(id,rating,description,course_id)
values(50003,'5', 'Awesome Course',1003);


insert into student_course(student_id,course_id)
values(20001,1001);
insert into student_course(student_id,course_id)
values(20002,1001);
insert into student_course(student_id,course_id)
values(20003,1001);
insert into student_course(student_id,course_id)
values(20001,1003);
