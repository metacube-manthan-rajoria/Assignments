import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            int xMax = 0;
            int yMax = 0;
            System.out.println("Enter Screen Size ->");
            System.out.print("Length in x axis : ");
            xMax = scanner.nextInt();
            System.out.print("Length in y axis : ");
            yMax = scanner.nextInt();

            if (xMax <= 5 || yMax <= 5) {
                scanner.close();
                throw new IllegalArgumentException("Screen Dimentions too low.");
            }

            Screen screen = new Screen(xMax, yMax);
            screen.addShape(Shape.ShapeType.CIRCLE);
            

            

            scanner.close();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("Input Mismatch Error - Enter valid inputs.");
        } catch (Exception e){
            System.out.println("We ran into an error");
            System.out.println(e.getMessage() + "\n");
        }

    }

}
