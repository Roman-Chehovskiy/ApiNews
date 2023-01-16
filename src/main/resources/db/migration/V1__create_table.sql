create table sources (
                         id serial primary key,
                         source varchar(100));

create table topics (
                        id serial primary key,
                        id_source integer not null,
                        topic varchar(100));

create table news (
                      id serial primary key,
                      id_topic integer not null,
                      item varchar(250));