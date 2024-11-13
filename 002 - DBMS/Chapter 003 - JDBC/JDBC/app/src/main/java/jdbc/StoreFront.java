package jdbc;

import java.sql.*;

public class StoreFront {
    public enum OrderStatus {
        DELIVERED,
        SHIPPING,
        CANCELLED,
        RETURNED
    }

    private static final String DATABASE_NAME = "store_front";
    private static final String USERS_TABLE_NAME = "users";
    private static final String ORDERS_TABLE_NAME = "orders";
    private static final String PRODUCTS_TABLE_NAME = "products";
    private static final String CART_TABLE_NAME = "order_products";
    private static final String CATEGORIES_TABLE_NAME = "categories";
    private static final String IMAGES_TABLE_NAME = "images";
    private static final String ADDRESSES_TABLE_NAME = "addresses";
    private static final String ZIPCODES_TABLE_NAME = "zipcodes";

    private static final String DATABASE_URL = "jdbc:mysql://localhost/" + DATABASE_NAME;
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    public StoreFront() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Records getUserOrders(int userId, StoreFront.OrderStatus status) {
        try {
            StringBuilder query = new StringBuilder("SELECT ");
            query.append(ORDERS_TABLE_NAME + ".order_id,");
            query.append(ORDERS_TABLE_NAME + ".order_date,");
            query.append("SUM(" + PRODUCTS_TABLE_NAME + ".price * " + CART_TABLE_NAME + ".quantity) ");
            query.append("FROM " + ORDERS_TABLE_NAME + " ");
            query.append("JOIN " + CART_TABLE_NAME + " ON " + ORDERS_TABLE_NAME + ".order_id = " + CART_TABLE_NAME + ".order_id ");
            query.append("JOIN " + PRODUCTS_TABLE_NAME + " ON " + CART_TABLE_NAME + ".product_id = " + PRODUCTS_TABLE_NAME + ".product_id ");
            query.append("WHERE " + ORDERS_TABLE_NAME + ".user_id = " + userId + " ");
            query.append("AND " + ORDERS_TABLE_NAME + ".status LIKE \"" + status.toString().toLowerCase() + "\" ");
            query.append("GROUP BY " + ORDERS_TABLE_NAME + ".order_id ");
            query.append("ORDER BY " + ORDERS_TABLE_NAME + ".order_date");

            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query.toString());

            return new Records(results);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void addImagesToProduct(int productId) {
        String batchQuery = "INSERT INTO images (product_id, image_url) VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(batchQuery);

            for (int i = 0; i < 5; i++) {
                preparedStatement.setInt(1, productId);
                preparedStatement.setString(2, "https://example.com/images/product" + (int)(Math.random()*100) + ".jpg");
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int deleteUnpopularProducts(String date) {
        StringBuilder query = new StringBuilder(
            "DELETE FROM products " +
            "WHERE products.product_id IN (SELECT order_products.product_id " +
            "FROM order_products " +
            "JOIN orders ON orders.order_id = order_products.order_id " +
            "WHERE order_date < \"" + date + "\");");

        try {
            Statement statement = connection.createStatement();
            int results = statement.executeUpdate(query.toString());
            return results;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public Records getTopCategories(){
        StringBuilder query = new StringBuilder(
            "SELECT cat.category_id, cat.name " +
            "FROM categories as cat " +
            "WHERE cat.parent_category_id = 0;"
        );

        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query.toString());
            return new Records(results);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
