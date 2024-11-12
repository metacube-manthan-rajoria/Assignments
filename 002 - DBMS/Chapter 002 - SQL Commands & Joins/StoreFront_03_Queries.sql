/* Task 2 - Query 2
Display Id, Title, Category Title, Price of the products 
which are Active and recently added products should be at top.
*/
SELECT products.product_id, products.name, categories.name, products.price 
FROM products, categories 
WHERE products.category = categories.category_id AND (products.stock > 0) 
ORDER BY products.date_added DESC;

/* Task 2 - Query 3
Display the list of products which don't have any images.
*/
SELECT products.product_id, products.name, images.image_url
FROM products
JOIN images ON products.product_id = images.product_id
WHERE images.image_url IS NULL;

/* Task 2 - Query 4
Display all Id, Title and Parent Category Title for all the Categories listed, 
sorted by Parent Category Title and then Category Title. 
(If Category is top category then Parent Category Title column should display “Top Category” as value.)
*/


/* Task 2 - Query 5
Display Id, Title, Parent Category Title of all the leaf Categories 
(categories which are not parent of any other category)
*/


/* Task 2 - Query 6
Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
*/
SELECT products.name, products.price
FROM products
JOIN categories On categories.category_id = products.category
WHERE categories.name LIKE "Laptops";

/* Task 2 - Query 7
Display the list of Products whose Quantity on hand (Inventory) is under 50.
*/
SELECT products.product_id, products.name, products.stock
FROM products
WHERE products.stock < 50;


/* Task 3 - Query 1
Display Recent 50 Orders placed (Id, Order Date, Order Total).
*/
SELECT orders.order_id, orders.order_date, SUM(products.price * order_products.quantity)
FROM orders
JOIN order_products ON orders.order_id = order_products.order_id
JOIN products ON order_products.product_id = products.product_id
GROUP BY orders.order_id
ORDER BY orders.order_id DESC
LIMIT 50;

/* Task 3 - Query 2
Display 10 most expensive Orders.
*/
SELECT orders.order_id, SUM(products.price * order_products.quantity) as Total
FROM orders
JOIN order_products ON orders.order_id = order_products.order_id
JOIN products ON order_products.product_id = products.product_id
GROUP BY orders.order_id
ORDER BY 2 DESC
LIMIT 10;

/* Task 3 - Query 3
Display all the Orders which are placed more than 10 days old 
and one or more items from those orders are still not shipped.
*/
SELECT orders.order_id, orders.order_date 
FROM orders
WHERE orders.order_date < "2023-10-10" 
AND orders.status = "shipping";

/* Task 3 - Query 4
Display list of shoppers which haven't ordered anything since last month.
*/
SELECT users.user_id, users.first_name, users.last_name, orders.order_date
FROM users
JOIN orders ON users.user_id = orders.user_id
WHERE orders.order_date < "2023-11-01"
AND users.user_type = "customer";

