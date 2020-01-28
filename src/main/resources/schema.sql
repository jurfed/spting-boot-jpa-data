DROP TABLE IF EXISTS email;
DROP TABLE IF EXISTS Address;
DROP TABLE IF EXISTS Person;

create table Person(
person_id serial primary key,
person_name varchar(255),
person_surname varchar(255)
);

create table Address(
    addr_id serial primary key,
    street varchar(255),
    personId int references Person(person_id) ON DELETE CASCADE null
);

create table email(
    mail_id serial primary key,
    mail_name varchar(255),
    mail_person int references Person(person_id)  ON DELETE CASCADE null
);

