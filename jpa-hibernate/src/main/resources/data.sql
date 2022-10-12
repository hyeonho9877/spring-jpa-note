insert into course(id, name, created_at, modified_at, is_deleted)
values (10001, 'JPA in 50 Steps', LOCALTIMESTAMP, LOCALTIMESTAMP, false);

insert into course(id, name, created_at, modified_at, is_deleted)
values (10002, 'Spring in 50 Steps', LOCALTIMESTAMP, LOCALTIMESTAMP, false);

insert into course(id, name, created_at, modified_at, is_deleted)
values (10003, 'Spring Boot in 50 Steps', LOCALTIMESTAMP, LOCALTIMESTAMP, false);


insert into passport(id, number)
values (40001, 'E123456');

insert into passport(id, number)
values (40002, 'N123456');

insert into passport(id, number)
values (40003, 'L123456');

insert into student(id, name, passport_id)
values (20001, 'Ranga', 40001);

insert into student(id, name, passport_id)
values (20002, 'Adam', 40002);

insert into student(id, name, passport_id)
values (20003, 'Jane', 40003);



insert into review(id, rating, description, course_id)
values (50001, '5', 'great course', 10001);

insert into review(id, rating, description, course_id)
values (50002, '4', 'wonderful course', 10001);

insert into review(id, rating, description, course_id)
values (50003, '5', 'good course', 10003);

insert into enroll(student, course)
values (20001, 10001);

insert into enroll(student, course)
values (20002, 10001);

insert into enroll(student, course)
values (20003, 10001);

insert into enroll(student, course)
values (20001, 10003);