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
            System.out.println();

            if (xMax <= 5 || yMax <= 5) {
                scanner.close();
                throw new IllegalArgumentException("Screen Dimentions too low.");
            }

            Screen screen = new Screen(xMax, yMax);

            while(true){
                System.out.println(
                    "\nOperations ->\n" +
                    "0. Exit\n" +
                    "1. Add Shape\n" +
                    "2. Get Shape Attributes\n" +
                    "3. Delete Shape\n" +
                    "4. Delete all Shapes of certain types\n" +
                    ""
                );

                System.out.print("Enter operation index : ");
                int userSelection = scanner.nextInt();

                if(userSelection <= 0){
                    break;
                }else if(userSelection == 1){
                    System.out.println(
                        "\n\tEnter type of shape to add ->\n" +
                        "\t0. Triangle\n" +
                        "\t1. Rectangle\n" +
                        "\t2. Polygon\n" +
                        "\t3. Circle\n"
                    );

                    System.out.print("\tEnter shape index : ");
                    int userShapeSelection = 0;
                    userShapeSelection = scanner.nextInt();

                    if(userShapeSelection == 0){
                        screen.addShape(Shape.ShapeType.TRIANGLE);
                    }else if(userShapeSelection == 1){
                        screen.addShape(Shape.ShapeType.RECTANGLE);
                    }else if(userShapeSelection == 2){
                        screen.addShape(Shape.ShapeType.POLYGON);
                    }else{
                        screen.addShape(Shape.ShapeType.CIRCLE);
                    }
                }else if(userSelection == 2){
                    System.out.print("Enter shape index : ");
                    int selectedShapeIndex = 0;
                    selectedShapeIndex = scanner.nextInt();

                    System.out.println(
                        "\tEnter type of attribute ->\n" +
                        "\t0. Perimeter\n" +
                        "\t1. Area\n" +
                        "\t2. Timestamp\n" +
                        "\t3. Origin\n"
                    );

                    int userAttributeSelection = 0;
                    userAttributeSelection = scanner.nextInt();

                    Shape selectedShape = screen.getShape(selectedShapeIndex);
                    if(userAttributeSelection == 0){
                        System.out.println("Perimeter : " + selectedShape.getPerimeter());
                    }else if(userAttributeSelection == 1){
                        System.out.println("Area : " + selectedShape.getArea());
                    }else if(userAttributeSelection == 2){
                        System.out.println("Timestamp : " + selectedShape.getTimestamp());
                    }else{
                        Point origin = selectedShape.getOrigin();
                        System.out.println("Origin : ( " + origin.getX() + ", " + origin.getY() + " )");
                    }
                }else if(userSelection == 3){
                    System.out.print("Enter shape index to delete: ");
                    int selectedShapeIndex = 0;
                    selectedShapeIndex = scanner.nextInt();
                    screen.deleteShape(selectedShapeIndex);
                }else if(userSelection == 4){
                    System.out.print("Enter shape Type to delete: ");
                    int selectedShapeIndex = 0;
                    selectedShapeIndex = scanner.nextInt();
                    screen.deleteShape(selectedShapeIndex);
                }else{
                    continue;
                }
            }

            scanner.close();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("Input Mismatch Error - Enter valid inputs.\n");
        } catch (NullPointerException e) {
            System.out.println("You are trying to access a null object : More details below\n" + e.getMessage() + "\n");
        } catch (Exception e){
            System.out.println("We ran into an error : More details below\n");
            System.out.println(e.getMessage() + "\n");
        }
    }
}
