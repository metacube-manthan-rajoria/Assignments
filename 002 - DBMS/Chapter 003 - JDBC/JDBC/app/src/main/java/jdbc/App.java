package jdbc;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            StoreFront storeFront = new StoreFront();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter userId to search for orders : ");
            int userId1 = scanner.nextInt();
            System.out.print("Enter productId to add 5 images : ");
            int productId1 = scanner.nextInt();

            Records userOrders1 = storeFront.getUserOrders(
                userId1,
                StoreFront.OrderStatus.DELIVERED
            );
            userOrders1.printRecords();

            storeFront.addImagesToProduct(productId1);

            int deletedRecords = storeFront.deleteUnpopularProducts("2023-10-07");
            System.out.println("Deleted records : " + deletedRecords);

            scanner.close();
        } catch (Exception e) {
            System.out.println("We ran into a error :\n" + e.getMessage());
        }
    }
}
