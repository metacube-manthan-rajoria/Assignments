CREATE DATABASE LinqSqlConsole
USE LinqSqlConsole

CREATE TABLE Category(
	CategoryId INT PRIMARY KEY IDENTITY(1,1),
	CategoryTitle VARCHAR(100)
)

CREATE TABLE Product(
	ProductId INT IDENTITY(1,1), 
	ProductTitle VARCHAR(100), 
	CategoryId INT,
	FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId)
)

INSERT INTO Category(CategoryTitle) VALUES ('Clothing')
INSERT INTO Category(CategoryTitle) VALUES ('Utencils')
INSERT INTO Category(CategoryTitle) VALUES ('Electronics')
INSERT INTO Category(CategoryTitle) VALUES ('Groceries')
INSERT INTO Category(CategoryTitle) VALUES ('Furniture')
INSERT INTO Category(CategoryTitle) VALUES ('Appliances')
INSERT INTO Category(CategoryTitle) VALUES ('Toys')
INSERT INTO Category(CategoryTitle) VALUES ('Cosmetics')

SELECT * FROM Category

INSERT INTO Product(ProductTitle, CategoryId) VALUES ('Iphone 15', 3);
INSERT INTO Product(ProductTitle, CategoryId) VALUES ('Rog Phone 9', 3);
INSERT INTO Product(ProductTitle, CategoryId) VALUES ('Prestige Oven', 2);
INSERT INTO Product(ProductTitle, CategoryId) VALUES ('Sofa Set', 5);
INSERT INTO Product(ProductTitle, CategoryId) VALUES ('Washing Machine', 6);
INSERT INTO Product(ProductTitle, CategoryId) VALUES ('Ponds Face Cream', 8);
INSERT INTO Product(ProductTitle, CategoryId) VALUES ('Hotwheels Race Car', 7);
INSERT INTO Product(ProductTitle, CategoryId) VALUES ('Ashirwad Flour', 4);
INSERT INTO Product(ProductTitle, CategoryId) VALUES ('Lackme Sunlight', 8);
INSERT INTO Product(ProductTitle, CategoryId) VALUES ('Kurkure', 4);
INSERT INTO Product(ProductTitle, CategoryId) VALUES ('Boat Earphones', 3);

SELECT * FROM Product