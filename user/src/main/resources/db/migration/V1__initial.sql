create table t_user
(
    id           serial not null,
    created_date timestamp(6),
    deleted_date timestamp(6),
    updated_date timestamp(6),
    created_user varchar(255),
    deleted_user varchar(255),
    password     varchar(255),
    updated_user varchar(255),
    username     varchar(255),
    primary key (id)
);


insert into t_user
    (created_date, username, password)
values (current_timestamp, 'testuser', '$2a$10$chCrZNV8LlMODShZkBAkh.thcrwjM7pSPmcv1ycM7XQygBoUd27Lm');