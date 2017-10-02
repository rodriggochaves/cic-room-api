# Room schema
 
# --- !Ups

CREATE SEQUENCE rooms_id_seq;

CREATE TABLE rooms (
  id integer PRIMARY KEY NOT NULL DEFAULT nextval('rooms_id_seq'),
  product_no integer REFERENCES users (id)
);
 
# --- !Downs

DROP TABLE rooms;
DROP SEQUENCE rooms_id_seq;
