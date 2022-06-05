BEGIN;
SET search_path TO hiber,public;
DROP TABLE IF EXISTS purchases CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS consumers CASCADE;

CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), cost numeric(6, 2));
INSERT INTO products (title, cost) VALUES ('milk', 130.20);
INSERT INTO products (title, cost) VALUES ('coffee', 1200);
INSERT INTO products (title, cost) values ('cheese',3000);
INSERT INTO products (title, cost) VALUES ('bread', 25.20);
INSERT INTO products (title, cost) VALUES ('tea', 500);
INSERT INTO products (title, cost) values ('meat',2500);


CREATE TABLE consumers (id bigserial PRIMARY KEY, name VARCHAR(255));
insert into consumers (name) values ('Pavel');
insert into consumers (name) values ('Ivan');
insert into consumers (name) values ('Alex');
insert into consumers (name) values ('Dmitry');


CREATE TABLE purchases (consumer_id bigint, product_id bigint, FOREIGN KEY (product_id) REFERENCES products (id), FOREIGN KEY (consumer_id) REFERENCES consumers (id));
INSERT INTO purchases (consumer_id, product_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(3, 4),
(3, 5),
(3, 6),
(4, 3),
(4, 5),
(4, 6);
COMMIT;



