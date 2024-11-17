# Problem Statement

### Task 1
With respect to StoreFront application identify, apply and list the constraints you would apply on the columns for the tables created.


### Task 2
Write SQL scripts for the following:
Display the list of products (Id, Title, Count of Categories) which fall in more than one Category.
Display Count of products as per below price range:

| Range in Rs. | Count |
|--------------|-------|
| 0 - 100      |       |
| 101 - 500    |       |
| Above 500    |       |

Display the Categories along with number of products under each category.

### Task 3
Write SQL scripts for the following:

- Display Shopper’s information along with number of orders he/she placed during last 30 days.
- Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
- Display top 20 Products which are ordered most in last 60 days along with numbers.
- Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
- Mark the products as Inactive which are not ordered in last 90 days.
- Given a category search keyword, display all the Products present in this category/categories. 
- Display top 10 Items which were cancelled most.

### Task 4
Consider a form where providing a Zip Code populates associated City and State. 

Create appropriate tables and relationships for the same and write a SQL query for that returns a Resultset containing Zip Code, City Names and States ordered by State Name and City Name. (Create 3 tables to store State, District/City & Zip code separately)

### Task 5
- Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.
- Use the above view to display the Products(Items) which are in ‘shipped’ state.
- Use the above view to display the top 5 most selling products.


```sql
/* Demo Data for Task 2 - Query 1,3 */
INSERT INTO products (name) VALUES
('Product A'),
('Product B'),
('Product C'),
('Product D'),
('Product E'),
('Product F'),
('Product G'),
('Product H'),
('Product I'),
('Product J'),
('Product K'),
('Product L'),
('Product M'),
('Product N'),
('Product O'),
('Product P'),
('Product Q'),
('Product R'),
('Product S'),
('Product T'),
('Product U'),
('Product V'),
('Product W'),
('Product X'),
('Product Y'),
('Product Z'),
('Product AA'),
('Product AB'),
('Product AC'),
('Product AD'),
('Product AE'),
('Product AF'),
('Product AG'),
('Product AH'),
('Product AI'),
('Product AJ'),
('Product AK'),
('Product AL'),
('Product AM'),
('Product AN'),
('Product AO'),
('Product AP'),
('Product AQ'),
('Product AR'),
('Product AS'),
('Product AT'),
('Product AU'),
('Product AV'),
('Product AW'),
('Product AX'),
('Product AY'),
('Product AZ'),
('Product BA'),
('Product BB'),
('Product BC'),
('Product BD'),
('Product BE'),
('Product BF'),
('Product BG'),
('Product BH');

INSERT INTO product_categories(product_id, category_id) VALUES
(54, 28),
(54, 2),
(12, 7),
(28, 7),
(37, 5),
(37, 1),
(37, 4),
(9, 4),
(48, 6),
(45, 2),
(34, 2),
(33, 1),
(27, 3),
(48, 4),
(8, 6),
(34, 4),
(20, 5),
(23, 5),
(14, 8),
(22, 9),
(1, 9),
(25, 4),
(25, 2),
(41, 4),
(57, 6),
(1, 7),
(8, 9),
(53, 4),
(11, 3),
(51, 1),
(50, 1),
(29, 5),
(51, 5),
(14, 3),
(27, 4),
(54, 5),
(52, 7),
(40, 9),
(31, 2),
(55, 1),
(1, 8),
(38, 2),
(22, 4),
(18, 4),
(38, 6),
(59, 2),
(58, 8),
(42, 9),
(26, 7),
(55, 6),
(24, 8),
(27, 9),
(42, 8),
(48, 1),
(17, 2),
(2, 12),
(3, 2),
(4, 9),
(5, 21),
(6, 13),
(7, 25),
(10, 1),
(13, 6),
(15, 17),
(16, 18),
(19, 29),
(21, 31),
(30, 4),
(32, 13),
(35, 23),
(36, 24),
(39, 25),
(43, 7),
(44, 8),
(46, 15),
(47, 19),
(49, 22),
(56, 28),
(60, 30);
```