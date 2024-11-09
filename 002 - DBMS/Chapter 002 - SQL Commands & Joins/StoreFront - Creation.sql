create database store_front;

use store_front;

create table users(user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR(100) NOT NULL, middle_name VARCHAR(100), last_name VARCHAR(100), email VARCHAR(320) NOT NULL, user_type VARCHAR(20));
