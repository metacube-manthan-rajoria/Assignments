CREATE DATABASE store_front;

USE store_front;

/*
Part 1
*/
CREATE TABLE users(
	user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    first_name VARCHAR(100) NOT NULL, 
    middle_name VARCHAR(100), 
    last_name VARCHAR(100), 
    email VARCHAR(320) NOT NULL, 
    user_type ENUM(
        'customer',
        'administrator'
    ) NOT NULL
);

CREATE TABLE categories(
	category_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    parent_category_id INT
);

CREATE TABLE products(
	product_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(200) NOT NULL, 
    date_added DATETIME DEFAULT CURRENT_TIMESTAMP,
    category INT,
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    FOREIGN KEY (category) REFERENCES categories(category_id)
);

CREATE TABLE images(
	product_id INT NOT NULL, 
    image_url VARCHAR(1000),
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE
);

CREATE TABLE zipcodes(
	zipcode_id VARCHAR(15) NOT NULL PRIMARY KEY,
	city VARCHAR(170) NOT NULL,
    state VARCHAR(100) NOT NULL
);

CREATE TABLE addresses(
	address_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	user_id INT NOT NULL, 
    address_line1 VARCHAR(100) NOT NULL, 
    address_line2 VARCHAR(100), 
    zipcode VARCHAR(15) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (zipcode) REFERENCES zipcodes(zipcode_id)
);

CREATE TABLE orders (
    order_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL, 
    order_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status ENUM(
        'shipping',
        'returned',
        'delivered',
        'cancelled'
    ),
    address_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (address_id) REFERENCES addresses(address_id)
);

CREATE TABLE order_products (
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(product_id)  ON DELETE CASCADE
);

/*
Part 2
*/
SHOW TABLES;

/*
Part 3
*/
DROP TABLE products;

/*
Part 4
*/
CREATE TABLE products(
	product_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(200) NOT NULL, 
    date_added DATETIME DEFAULT CURRENT_TIMESTAMP,
    category INT,
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    FOREIGN KEY (category) REFERENCES categories(category_id)
);
