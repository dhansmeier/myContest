create extension if not exists pgcrypto;

create table tournaments (
  id uuid primary key default gen_random_uuid(),
  name text not null,
  event_date date,
  created_at timestamptz not null default now()
);

insert into tournaments (name, event_date, created_at)
select name, event_date, created_at
from tournament;

drop table tournament;
