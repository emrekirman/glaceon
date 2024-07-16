create table t_product
(
    id           serial not null,
    created_date timestamp(6),
    deleted_date timestamp(6),
    updated_date timestamp(6),
    code         varchar(255),
    created_user varchar(255),
    deleted_user varchar(255),
    name         varchar(255),
    updated_user varchar(255),
    primary key (id)
);
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
create table t_transaction
(
    discount_rate numeric(38, 2),
    id            serial not null,
    movement      smallint check (movement between 0 and 1),
    piece         numeric(38, 2),
    product_id    integer,
    total_amount  numeric(38, 2),
    unit_id       integer,
    unit_price    numeric(38, 2),
    created_date  timestamp(6),
    deleted_date  timestamp(6),
    updated_date  timestamp(6),
    created_user  varchar(255),
    deleted_user  varchar(255),
    updated_user  varchar(255),
    primary key (id)
);
create table t_unit
(
    id           serial not null,
    created_date timestamp(6),
    deleted_date timestamp(6),
    updated_date timestamp(6),
    code         varchar(255),
    created_user varchar(255),
    deleted_user varchar(255),
    name         varchar(255),
    updated_user varchar(255),
    primary key (id)
);
alter table if exists t_transaction
    add constraint FKm8o0niril295b8c1crjoq3vkb foreign key (product_id) references t_product;
alter table if exists t_transaction
    add constraint FKsj01t9phq86rkbh10x40imgfe foreign key (unit_id) references t_unit;


insert into t_unit (created_date, code, name)
values (current_timestamp, 'kg', 'KG');

insert into t_unit (created_date, code, name)
values (current_timestamp, 'box', 'BOX');

insert into t_system_parameter (created_date, code, value)
values (current_timestamp, 'user.service.url', 'http://localhost:8081')
