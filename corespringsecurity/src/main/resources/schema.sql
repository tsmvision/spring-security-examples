create table access_ip
(
    ip_id      bigint generated by default as identity,
    ip_address varchar(255) not null,
    primary key (ip_id)
);

create table account
(
    id       bigint generated by default as identity,
    age      varchar(255),
    email    varchar(255),
    password varchar(255),
    username varchar(255),
    primary key (id)
);

create table account_role
(
    id         bigint generated by default as identity,
    role_id    bigint,
    account_id bigint,
    primary key (id)
);

create table resources
(
    resource_id   bigint generated by default as identity,
    http_method   varchar(255),
    order_num     integer,
    resource_name varchar(255),
    primary key (resource_id)
);

create table role
(
    role_id   bigint generated by default as identity,
    role_desc varchar(255),
    role_name varchar(255),
    primary key (role_id)
);

create table role_hierarchy
(
    id          bigint generated by default as identity,
    child_name  varchar(255),
    parent_name bigint,
    primary key (id)
);

create table role_resources
(
    id          bigint generated by default as identity,
    resource_id bigint,
    role_id     bigint,
    primary key (id)
);

alter table account_role
    add constraint FK__account_role__role_id
        foreign key (role_id)
            references role;

alter table account_role
    add constraint FK__account_role_account_id
        foreign key (account_id)
            references account;

alter table role_hierarchy
    add constraint FK__role_hierarchy_parent_name
        foreign key (parent_name)
            references role_hierarchy;

alter table role_resources
    add constraint FK__role_resources__resource_id
        foreign key (resource_id)
            references resources;

alter table role_resources
    add constraint FK__role_resources__role_id
        foreign key (role_id)
            references role;