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
SELECT products.product_id, products.name, count(images.image_url)
FROM products
WHERE products.product_id = images.product_id
GROUP BY products.product_id;


SELECT orders.order_id, orders.order_date, SUM(products.price * order_products.quantity)
FROM orders
JOIN order_products ON orders.order_id = order_products.order_id
JOIN products ON order_products.product_id = products.product_id
GROUP BY orders.order_id
ORDER BY orders.order_id;