/*
Task 1 - Query 1
*/
CREATE FUNCTION ORDER_COUNT_IN_MONTH(month INT, year INT)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE ordersCount INT;
    SET ordersCount = (
        SELECT COUNT(orders.order_id) FROM orders 
        WHERE MONTH(orders.order_date) = month 
        AND YEAR(orders.order_date) = year
    );
    RETURN ordersCount;
END

SELECT ORDER_COUNT_IN_MONTH(11, 2023);

/*
Task 1 - Query 2
*/
CREATE FUNCTION MAX_SALES_MONTH(year INT)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE maxSaleMonth INT;
    SET maxSaleMonth = (
        SELECT MONTH(orders.order_date) AS order_month
        FROM orders
        JOIN order_products ON order_products.order_id = orders.order_id
        JOIN products ON products.product_id = order_products.product_id
        WHERE YEAR(orders.order_date) = year
        GROUP BY order_month
        ORDER BY count(products.product_id) DESC
        LIMIT 1
    );
    RETURN maxSaleMonth;
END

SELECT MAX_SALES_MONTH(2023);

/*
Task 2 - Query 1
*/
DELIMITER >ᴗ<
CREATE PROCEDURE avg_product_sales(IN month INT, IN year INT)
BEGIN
    SELECT products.product_id, count(products.product_id)
    FROM products
    JOIN order_products op ON op.product_id = products.product_id
    JOIN orders ON orders.order_id = op.order_id 
    WHERE MONTH(orders.order_date) = month
    AND YEAR(orders.order_date) = year
    GROUP BY products.product_id;
END >ᴗ<
DELIMITER;

/*
Task 2 - Query 2
*/
DELIMITER >ᴗ<
CREATE Procedure orders_in_period(IN startDate DATE, IN endDate DATE)
BEGIN 
IF(startDate > endDate) THEN
SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'Order No not found in orders table';
END IF;
    SELECT 
        orders.order_id, 
        orders.user_id, 
        orders.order_date,
        orders.status,
        orders.address_id
    FROM orders
    WHERE orders.order_date BETWEEN startDate AND endDate;
END >ᴗ<
DELIMITER ;
/*
Task 3
*/
orders.order_id, 
products.product_id,
categories.category_id
