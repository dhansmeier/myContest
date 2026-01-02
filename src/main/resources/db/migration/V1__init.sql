create table tournament (
  id bigserial primary key,
  name text not null,
  event_date date,
  created_at timestamptz not null default now()
);
