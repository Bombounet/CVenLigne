create table users(
    id bigint auto_increment,
    constraint users_pk
        primary key (id),
    first_name TEXT not null,
    last_name TEXT not null,
    birth_day int null,
    birth_month int null,
    birth_year int null,
    phone_number int null,
    email TEXT not null,
    bio TEXT not null,
    address TEXT not null,
    city TEXT not null,
    country TEXT not null,
    postcode int null

);

create table experiences(
    id bigint auto_increment,
    constraint experiences_pk
        primary key (id),
    name TEXT not null,
    place TEXT not null,
    description TEXT not null,
    year TEXT null,
    user_id bigint not null,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

create table competences(
    id bigint auto_increment,
    constraint competences_pk
        primary key (id),
    name TEXT not null,
    user_id bigint not null,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

create table formations(
    id bigint auto_increment,
    constraint formation_pk
        primary key (id),
    name TEXT not null,
    place TEXT not null,
    description TEXT not null,
    year TEXT null,
    user_id bigint not null,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

create table projets(
    id bigint auto_increment,
    constraint formation_pk
        primary key (id),
    name TEXT not null,
    place TEXT not null,
    description TEXT not null,
    year TEXT null,
    user_id bigint not null,
    FOREIGN KEY (user_id) REFERENCES users(id)
);


