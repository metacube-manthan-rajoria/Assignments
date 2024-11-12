package jdbc;

import java.sql.*;

public class StoreFront {
    public enum OrderStatus{
        DELIVERED,
        SHIPPING,
        CANCELLED,
        RETURNED
    }

    private static final String DATABASE_NAME = "store_front";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/" + DATABASE_NAME;
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    public StoreFront(){
        try{
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public ResultSet getUserOrders(int userId, StoreFront.OrderStatus status){
        try{
            String QUERY = "SELECT first_name, last_name FROM users";

            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(QUERY);

            return results;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
