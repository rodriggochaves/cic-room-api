# User schema
 
# --- !Ups

CREATE SEQUENCE user_id_seq;
CREATE TABLE users (
  id integer PRIMARY KEY NOT NULL DEFAULT nextval('user_id_seq'),
  name varchar(255),
  email varchar(255),
  password_digest varchar(255),
  role integer
);

-- 1 - normal student
-- 2 - coordinator
-- 3 - adminstrator

-- seeds

INSERT INTO users (name, email, password_digest, role) VALUES
  ('rodrigo', 'rodrigo@email.com', 'password', 2);
 
# --- !Downs
 
DROP TABLE users;
DROP SEQUENCE user_id_seq;