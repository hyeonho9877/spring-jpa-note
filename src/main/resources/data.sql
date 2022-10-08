create table person(
    id integer not null,
    name varchar not null,
    location varchar,
    birth_data timestamp ,
    primary key(id)
);

insert into person values(10001, 'ranga', 'hyderabad', LOCALTIMESTAMP);
insert into person values(10002, 'james', 'new york', LOCALTIMESTAMP);
insert into person values(10003, 'susan', 'amsterdam', LOCALTIMESTAMP);