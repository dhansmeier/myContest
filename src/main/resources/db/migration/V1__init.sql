create extension if not exists pgcrypto;

create table tournaments (
  id uuid primary key,
  name text not null,
  event_date date,
  created_at timestamptz not null default now()
);
