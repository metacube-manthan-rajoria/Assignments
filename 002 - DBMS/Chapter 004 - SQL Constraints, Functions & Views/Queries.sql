/*
Task 2 - Query 2
*/
create table price_sort(ranges varchar(100), count int);

INSERT INTO price_sort (ranges, count)
SELECT "0-100", COUNT(products.product_id) 
FROM products 
WHERE products.price >= 0 AND products.price <= 100;

INSERT INTO price_sort (ranges, count)
SELECT "101-500", COUNT(products.product_id) 
FROM products 
WHERE products.price >= 101 AND products.price <= 500;

INSERT INTO price_sort (ranges, count)
SELECT "Above 500", COUNT(products.product_id) 
FROM products 
WHERE products.price > 500;

/*
Task 3 - Query 1
*/
SELECT users.user_id, CONCAT(users.first_name, " ", users.last_name), COUNT(orders.order_id)
FROM users
JOIN orders ON orders.user_id = users.user_id
WHERE orders.order_date > "2023-11-01"
GROUP BY users.user_id;

/*
Task 3 - Query 2
*/
SELECT orders.user_id, sum(products.price * order_products.quantity)
FROM orders
JOIN order_products ON orders.order_id = order_products.order_id
JOIN products ON order_products.product_id = products.product_id
GROUP BY orders.user_id
ORDER BY 2 DESC
LIMIT 10;

/*
Task 3 - Query 3
*/
SELECT products.product_id, products.name, count(order_products.order_id)
FROM products
JOIN order_products ON order_products.product_id = products.product_id
JOIN orders ON orders.order_id = order_products.order_id
WHERE orders.order_date > "2023-10-01"
GROUP BY products.product_id
ORDER BY 3 DESC, products.product_id ASC
LIMIT 20;

/*
Task 3 - Query 6
*/
SELECT products.name from products
JOIN categories ON products.category = categories.category_id
WHERE categories.name LIKE "Laptops";


/*
Task 3 - Query 7
*/
SELECT p.product_id, COUNT(orders.status)
FROM products as p
JOIN order_products ON p.product_id = order_products.product_id
JOIN orders ON order_products.order_id = orders.order_id
WHERE orders.status = "cancelled"
GROUP BY p.product_id
ORDER BY 2 DESC
LIMIT 10;

/*
Task 4 - Query 1
*/
CREATE DATABASE FormAutoFillDemo;
USE FormAutoFillDemo;
CREATE TABLE zipcodes(zipcode VARCHAR(15) NOT NULL PRIMARY KEY);
CREATE TABLE cities(
    zipcode VARCHAR(15) NOT NULL,
    city VARCHAR(170) NOT NULL,
    FOREIGN KEY(zipcode) REFERENCES zipcodes(zipcode)
);
CREATE TABLE states(
    zipcode VARCHAR(15) NOT NULL,
    state VARCHAR(100) NOT NULL,
    FOREIGN KEY(zipcode) REFERENCES zipcodes(zipcode)
);

INSERT INTO zipcodes VALUES
("62701"),
("53703"),
("73301"),
("98101"),
("80201"),
("85001"),
("97201"),
("33101"),
("30301"),
("2101"),
("10001"),
("90001"),
("60601"),
("94101"),
("75201"),
("77001"),
("19101"),
("92101"),
("89101"),
("32801"),
("28201"),
("46201"),
("43201"),
("37201"),
("21201"),
("53201"),
("64101"),
("84101"),
("45201"),
("23450"),
("85701"),
("93701"),
("95801"),
("90801"),
("66101"),
("85201"),
("23451"),
("30302"),
("80901"),
("68101"),
("27601"),
("33102"),
("44101"),
("74101"),
("94601"),
("55401"),
("67201"),
("70112"),
("76010"),
("93301"),
("33601"),
("96801"),
("92801"),
("92701"),
("78401"),
("92501"),
("95201"),
("89014"),
("63101"),
("15201"),
("45202"),
("99501"),
("27401"),
("75023"),
("68501"),
("32802"),
("91910"),
("7302"),
("76101"),
("14201"),
("55101"),
("85224"),
("78040"),
("53704"),
("27701"),
("92602"),
("23320"),
("85250"),
("91201"),
("89501"),
("85233"),
("33010"),
("75040"),
("83701"),
("70801"),
("32301"),
("50301"),
("36601"),
("49501"),
("84102"),
("92647"),
("66204"),
("37901"),
("1601"),
("98660"),
("85280"),
("33904"),
("57101"),
("1101"),
("61601"),
("39201");

