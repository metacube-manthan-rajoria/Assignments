package jdbc;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            StoreFront storeFront = new StoreFront();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter userId to search for orders : ");
            int userId1 = scanner.nextInt();
            Records userOrders1 = storeFront.getUserOrders(
                userId1,
                StoreFront.OrderStatus.DELIVERED
            );
            userOrders1.printRecords();

            scanner.close();
        } catch (Exception e) {
            System.out.println("We ran into a error :\n" + e.getMessage());
        }
    }

    
}
