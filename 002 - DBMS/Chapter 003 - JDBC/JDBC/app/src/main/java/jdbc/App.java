package jdbc;

import java.sql.ResultSet;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            StoreFront storeFront = new StoreFront();
            Scanner scanner = new Scanner(System.in);

            int userId1 = scanner.nextInt();
            ResultSet userOrders1 = storeFront.getUserOrders(
                userId1,
                StoreFront.OrderStatus.DELIVERED
            );

            printResultSet(userOrders1);

            scanner.close();
        } catch (Exception e) {
            System.out.println("We ran into a error :\n" + e.getMessage());
        }
    }

    public static void printResultSet(ResultSet results) {
        if (results == null) {
            System.out.println("Cannot print ResultSet : Invalid Set");
            return;
        }

        try {
            int columnCount = results.getMetaData().getColumnCount();

            while (results.next()) {
                for(int i = 1; i<=columnCount; i++){
                    int type = results.getMetaData().getColumnType(i);

                    if(type == 4){
                        // Integer
                        System.out.print(results.getInt(i) + (i == columnCount ? "" : ", "));
                    }else if(type == 3){
                        // Double
                        System.out.print(results.getDouble(i) + (i == columnCount ? "" : ", "));
                    }else if(type == 12){
                        System.out.print(results.getString(i) + (i == columnCount ? "" : ", "));
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
