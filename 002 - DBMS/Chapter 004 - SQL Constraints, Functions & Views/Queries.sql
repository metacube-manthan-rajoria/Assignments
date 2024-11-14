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

