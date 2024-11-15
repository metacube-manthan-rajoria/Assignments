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

INSERT INTO cities VALUES
("62701", "Springfield"),
("53703", "Madison"),
("73301", "Austin"),
("98101", "Seattle"),
("80201", "Denver"),
("85001", "Phoenix"),
("97201", "Portland"),
("33101", "Miami"),
("30301", "Atlanta"),
("2101", "Boston"),
("10001", "New York"),
("90001", "Los Angeles"),
("60601", "Chicago"),
("94101", "San Francisco"),
("75201", "Dallas"),
("77001", "Houston"),
("19101", "Philadelphia"),
("92101", "San Diego"),
("89101", "Las Vegas"),
("32801", "Orlando"),
("28201", "Charlotte"),
("46201", "Indianapolis"),
("43201", "Columbus"),
("37201", "Nashville"),
("21201", "Baltimore"),
("53201", "Milwaukee"),
("64101", "Kansas City"),
("84101", "Salt Lake City"),
("45201", "Cincinnati"),
("23450", "Virginia Beach"),
("85701", "Tucson"),
("93701", "Fresno"),
("95801", "Sacramento"),
("90801", "Long Beach"),
("66101", "Kansas City"),
("85201", "Mesa"),
("23451", "Virginia Beach"),
("30302", "Atlanta"),
("80901", "Colorado Springs"),
("68101", "Omaha"),
("27601", "Raleigh"),
("33102", "Miami"),
("44101", "Cleveland"),
("74101", "Tulsa"),
("94601", "Oakland"),
("55401", "Minneapolis"),
("67201", "Wichita"),
("70112", "New Orleans"),
("76010", "Arlington"),
("93301", "Bakersfield"),
("33601", "Tampa"),
("96801", "Honolulu"),
("92801", "Anaheim"),
("92701", "Santa Ana"),
("78401", "Corpus Christi"),
("92501", "Riverside"),
("95201", "Stockton"),
("89014", "Henderson"),
("63101", "St. Louis"),
("15201", "Pittsburgh"),
("45202", "Cincinnati"),
("99501", "Anchorage"),
("27401", "Greensboro"),
("75023", "Plano"),
("68501", "Lincoln"),
("32802", "Orlando"),
("91910", "Chula Vista"),
("7302", "Jersey City"),
("76101", "Fort Worth"),
("14201", "Buffalo"),
("55101", "St. Paul"),
("85224", "Chandler"),
("78040", "Laredo"),
("53704", "Madison"),
("27701", "Durham"),
("92602", "Irvine"),
("23320", "Chesapeake"),
("85250", "Scottsdale"),
("91201", "Glendale"),
("89501", "Reno"),
("85233", "Gilbert"),
("33010", "Hialeah"),
("75040", "Garland"),
("83701", "Boise"),
("70801", "Baton Rouge"),
("32301", "Tallahassee"),
("50301", "Des Moines"),
("36601", "Mobile"),
("49501", "Grand Rapids"),
("84102", "Salt Lake City"),
("92647", "Huntington Beach"),
("66204", "Overland Park"),
("37901", "Knoxville"),
("1601", "Worcester"),
("98660", "Vancouver"),
("85280", "Tempe"),
("33904", "Cape Coral"),
("57101", "Sioux Falls"),
("1101", "Springfield"),
("61601", "Peoria"),
("39201", "Jackson");

INSERT INTO states VALUES
("62701", "Illinois"),
("53703", "Wisconsin"),
("73301", "Texas"),
("98101", "Washington"),
("80201", "Colorado"),
("85001", "Arizona"),
("97201", "Oregon"),
("33101", "Florida"),
("30301", "Georgia"),
("2101", "Massachusetts"),
("10001", "New York"),
("90001", "California"),
("60601", "Illinois"),
("94101", "California"),
("75201", "Texas"),
("77001", "Texas"),
("19101", "Pennsylvania"),
("92101", "California"),
("89101", "Nevada"),
("32801", "Florida"),
("28201", "North Carolina"),
("46201", "Indiana"),
("43201", "Ohio"),
("37201", "Tennessee"),
("21201", "Maryland"),
("53201", "Wisconsin"),
("64101", "Missouri"),
("84101", "Utah"),
("45201", "Ohio"),
("23450", "Virginia"),
("85701", "Arizona"),
("93701", "California"),
("95801", "California"),
("90801", "California"),
("66101", "Kansas"),
("85201", "Arizona"),
("23451", "Virginia"),
("30302", "Georgia"),
("80901", "Colorado"),
("68101", "Nebraska"),
("27601", "North Carolina"),
("33102", "Florida"),
("44101", "Ohio"),
("74101", "Oklahoma"),
("94601", "California"),
("55401", "Minnesota"),
("67201", "Kansas"),
("70112", "Louisiana"),
("76010", "Texas"),
("93301", "California"),
("33601", "Florida"),
("96801", "Hawaii"),
("92801", "California"),
("92701", "California"),
("78401", "Texas"),
("92501", "California"),
("95201", "California"),
("89014", "Nevada"),
("63101", "Missouri"),
("15201", "Pennsylvania"),
("45202", "Ohio"),
("99501", "Alaska"),
("27401", "North Carolina"),
("75023", "Texas"),
("68501", "Nebraska"),
("32802", "Florida"),
("91910", "California"),
("7302", "New Jersey"),
("76101", "Texas"),
("14201", "New York"),
("55101", "Minnesota"),
("85224", "Arizona"),
("78040", "Texas"),
("53704", "Wisconsin"),
("27701", "North Carolina"),
("92602", "California"),
("23320", "Virginia"),
("85250", "Arizona"),
("91201", "California"),
("89501", "Nevada"),
("85233", "Arizona"),
("33010", "Florida"),
("75040", "Texas"),
("83701", "Idaho"),
("70801", "Louisiana"),
("32301", "Florida"),
("50301", "Iowa"),
("36601", "Alabama"),
("49501", "Michigan"),
("84102", "Utah"),
("92647", "California"),
("66204", "Kansas"),
("37901", "Tennessee"),
("1601", "Massachusetts"),
("98660", "Washington"),
("85280", "Arizona"),
("33904", "Florida"),
("57101", "South Dakota"),
("1101", "Massachusetts"),
("61601", "Illinois"),
("39201", "Mississippi");

SELECT zipcodes.zipcode AS zipcode, cities.city AS city, states.state AS state
FROM zipcodes
JOIN cities ON cities.zipcode = zipcodes.zipcode
JOIN states ON states.zipcode = zipcodes.zipcode;

/*
Task 5 - Query 1
*/
CREATE VIEW recent_orders AS
SELECT 
	orders.order_id,
    products.product_id,
    products.price,
	users.user_id, 
	concat(users.first_name, " ", users.last_name) AS user_name,
    users.email,
    orders.order_date,
    orders.status
FROM orders
JOIN users ON users.user_id = orders.user_id
JOIN order_products ON order_products.order_id = orders.order_id
JOIN products ON products.product_id = order_products.product_id
WHERE orders.order_date >= DATE_SUB("2023-11-21", INTERVAL 30 DAY)
ORDER BY orders.order_date;

/*
Task 5 - Query 2
*/
select order_id, product_id
FROM recent_orders
where status LIKE "delivered";