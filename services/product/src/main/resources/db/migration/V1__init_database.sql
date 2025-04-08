create table if not exists category
(
    id integer not null primary key,
    description varchar(225),
    name varchar(225);

);

create table if not exists product
(
    id integer not null primary key,
    name varchar(225),
    description varchar(225),
    available_quantity double precision not null,
    price numeric(38, 2),
    category-id integer
            constraint fk_category references category
);

create sequence if not exists category_seq increment by 50;
create sequence if not exists product_seq increment by 50;