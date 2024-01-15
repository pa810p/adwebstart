CREATE USER adwebstart WITH PASSWORD 'adwebstart';
CREATE DATABASE adwebstart;
ALTER DATABASE adwebstart OWNER TO adwebstart;

GRANT ALL PRIVILEGES ON DATABASE adwebstart TO adwebstart;

-- Connect to the 'mydatabase' database
\c -U adwebstart adwebstart

DROP TABLE IF EXISTS product;
DROP SEQUENCE IF EXISTS product_id_seq;

CREATE SEQUENCE product_id_seq start 1 increment 1 minvalue 1 cache 1;

CREATE TABLE IF NOT EXISTS product (
  id int4 DEFAULT nextval('product_id_seq') NOT NULL,
  product_id UUID NOT NULL,
  name TEXT,
  price NUMERIC(15,2)
);



