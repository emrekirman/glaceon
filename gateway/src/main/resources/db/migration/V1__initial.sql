create table t_system_parameter
(
    id           serial not null,
    created_date timestamp(6),
    deleted_date timestamp(6),
    updated_date timestamp(6),
    code         varchar(255),
    created_user varchar(255),
    deleted_user varchar(255),
    description  varchar(255),
    updated_user varchar(255),
    value        varchar(255),
    primary key (id)
);
