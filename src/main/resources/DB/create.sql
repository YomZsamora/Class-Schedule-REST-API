CREATE DATABASE class_schedule;
\c class_schedule;

CREATE TABLE IF NOT EXISTS sessions (
  id SERIAL PRIMARY KEY,
  session_name varchar,
  description varchar,
  cohort_id int,
  module_id int,
  start_time date,
  end_time date
);

CREATE TABLE IF NOT EXISTS students (
  id SERIAL PRIMARY KEY,
  name varchar,
  cohort_id int,
  track varchar,
  uid varchar
);

CREATE TABLE IF NOT EXISTS cohort (
  id SERIAL PRIMARY KEY,
  name varchar,
  start_date date
);

CREATE TABLE IF NOT EXISTS module (
  id SERIAL PRIMARY KEY,
  name varchar
);

CREATE TABLE IF NOT EXISTS technical_mentors (
  id SERIAL PRIMARY KEY,
  name varchar,
  uid varchar
);

CREATE TABLE IF NOT EXISTS comments (
  id SERIAL PRIMARY KEY,
  student_id int,
  content varchar
);

CREATE TABLE IF NOT EXISTS comments_sessions (
  id SERIAL PRIMARY KEY,
  comment_id int,
  session_id int
);

ALTER TABLE sessions ADD FOREIGN KEY (cohort_id) REFERENCES cohort (id);

ALTER TABLE comments_sessions ADD FOREIGN KEY (session_id) REFERENCES sessions (id);

ALTER TABLE comments_sessions ADD FOREIGN KEY (comment_id) REFERENCES comments (id);

ALTER TABLE students ADD FOREIGN KEY (cohort_id) REFERENCES cohort (id);

ALTER TABLE sessions ADD FOREIGN KEY (module_id) REFERENCES module (id);

CREATE DATABASE class_schedule_test WITH TEMPLATE class_schedule;
