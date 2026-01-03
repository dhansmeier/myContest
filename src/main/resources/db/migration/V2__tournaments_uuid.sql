create extension if not exists pgcrypto;

alter table tournaments add column id_uuid uuid;

update tournaments
set id_uuid = gen_random_uuid()
where id_uuid is null;

alter table tournaments drop constraint tournaments_pkey;
alter table tournaments drop column id;

alter table tournaments rename column id_uuid to id;
alter table tournaments add primary key (id);
