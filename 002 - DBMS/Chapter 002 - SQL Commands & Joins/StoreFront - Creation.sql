create database store_front;

use store_front;

create table users(
	user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    first_name VARCHAR(100) NOT NULL, 
    middle_name VARCHAR(100), 
    last_name VARCHAR(100), 
    email VARCHAR(320) NOT NULL, 
    user_type VARCHAR(20) NOT NULL
);

create table products(
	product_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(200) NOT NULL, 
    category INT,
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL
);

create table images(
	product_id INT NOT NULL, 
    product_url VARCHAR(1000) NOT NULL
);

create table addresses(
	user_id INT NOT NULL, 
    address_line1 VARCHAR(100) NOT NULL, 
    address_line2 VARCHAR(100), 
    zipcode VARCHAR(15) NOT NULL
);

create table zipcodes(
	code_id VARCHAR(15) NOT NULL PRIMARY KEY,
	city VARCHAR(170) NOT NULL,
    state VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL
);










