import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

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

            while (true) {
                System.out.println(
                        "\nOperations ->\n" +
                                "0. Exit\n" +
                                "1. Add Shape\n" +
                                "2. Get Shape Attributes\n" +
                                "3. Delete Shape\n" +
                                "4. Delete all Shapes of certain types\n" +
                                "");

                System.out.print("Enter operation index : ");
                int userSelection = scanner.nextInt();

                if (userSelection <= 0) {
                    break;
                } else if (userSelection == 1) {
                    System.out.println(
                            "\n\tEnter type of shape to add ->\n" +
                                    "\t0. Triangle\n" +
                                    "\t1. Rectangle\n" +
                                    "\t2. Polygon\n" +
                                    "\t3. Circle\n");

                    System.out.print("\tEnter shape index : ");
                    int userShapeSelection = 0;
                    userShapeSelection = scanner.nextInt();

                    if (userShapeSelection == 0) {
                        screen.addShape(Shape.ShapeType.TRIANGLE);
                    } else if (userShapeSelection == 1) {
                        screen.addShape(Shape.ShapeType.RECTANGLE);
                    } else if (userShapeSelection == 2) {
                        screen.addShape(Shape.ShapeType.POLYGON);
                    } else {
                        screen.addShape(Shape.ShapeType.CIRCLE);
                    }
                } else if (userSelection == 2) {
                    System.out.print("Enter shape index : ");
                    int selectedShapeIndex = 0;
                    selectedShapeIndex = scanner.nextInt();

                    System.out.println(
                            "\n\tEnter type of attribute ->\n" +
                                    "\t0. Perimeter\n" +
                                    "\t1. Area\n" +
                                    "\t2. Timestamp\n" +
                                    "\t3. Origin\n" +
                                    "\t4. Is Point Enclosed\n" +
                                    "\t5. All Attributes\n");

                    System.out.print("\tEnter attribute index : ");
                    int userAttributeSelection = 0;
                    userAttributeSelection = scanner.nextInt();

                    Shape selectedShape = screen.getShape(selectedShapeIndex);
                    if (userAttributeSelection == 0) {
                        System.out.println("\tPerimeter : " + selectedShape.getPerimeter());
                    } else if (userAttributeSelection == 1) {
                        System.out.println("\tArea : " + selectedShape.getArea());
                    } else if (userAttributeSelection == 2) {
                        System.out.println("\tTimestamp : " + selectedShape.getTimestamp());
                    } else if (userAttributeSelection == 3) {
                        Point origin = selectedShape.getOrigin();
                        System.out.println("\tOrigin : ( " + origin.getX() + ", " + origin.getY() + " )");
                    } else if (userAttributeSelection == 4) {
                        System.out.print("\t\tEnter x coordinate for enclosed point to check : ");
                        int enclosedPointX = 0;
                        enclosedPointX = scanner.nextInt();
                        System.out.print("\t\tEnter y coordinate for enclosed point to check : ");
                        int enclosedPointY = 0;
                        enclosedPointY = scanner.nextInt();

                        Point enclosedPointCheck = new Point(enclosedPointX, enclosedPointY);
                        System.out.println(
                                "\t\tThe point " +
                                        (selectedShape.isPointEnclosed(enclosedPointCheck) ? "is" : "is not") +
                                        " enclosed in the shape");
                    } else {
                        System.out.println("\tPerimeter : " + selectedShape.getPerimeter());
                        System.out.println("\tArea : " + selectedShape.getArea());
                        System.out.println("\tTimestamp : " + selectedShape.getTimestamp());
                        Point origin = selectedShape.getOrigin();
                        System.out.println("\tOrigin : ( " + origin.getX() + ", " + origin.getY() + " )");

                        System.out.print("\t\tEnter x coordinate for enclosed point to check : ");
                        int enclosedPointX = 0;
                        enclosedPointX = scanner.nextInt();
                        System.out.print("\t\tEnter y coordinate for enclosed point to check : ");
                        int enclosedPointY = 0;
                        enclosedPointY = scanner.nextInt();

                        Point enclosedPointCheck = new Point(enclosedPointX, enclosedPointY);
                        System.out.println(
                                "\t\tThe point " +
                                        (selectedShape.isPointEnclosed(enclosedPointCheck) ? "is" : "is not") +
                                        " enclosed in the shape");
                    }
                } else if (userSelection == 3) {
                    System.out.print("Enter shape index to delete: ");
                    int selectedShapeIndex = 0;
                    selectedShapeIndex = scanner.nextInt();
                    screen.deleteShape(selectedShapeIndex);
                } else if (userSelection == 4) {
                    System.out.println(
                            "\n\tEnter type of shape to delete ->\n" +
                                    "\t0. Triangle\n" +
                                    "\t1. Rectangle\n" +
                                    "\t2. Polygon\n" +
                                    "\t3. Circle\n" +
                                    "\t4. Cancel Operation\n");

                    System.out.print("\tEnter shape Type to delete: ");
                    int selectedShapeTypeIndex = 0;
                    selectedShapeTypeIndex = scanner.nextInt();

                    if (selectedShapeTypeIndex == 0) {
                        screen.deleteAllShapeTypes(Shape.ShapeType.TRIANGLE);
                    } else if (selectedShapeTypeIndex == 1) {
                        screen.deleteAllShapeTypes(Shape.ShapeType.RECTANGLE);
                    } else if (selectedShapeTypeIndex == 2) {
                        screen.deleteAllShapeTypes(Shape.ShapeType.POLYGON);
                    } else if (selectedShapeTypeIndex == 3) {
                        screen.deleteAllShapeTypes(Shape.ShapeType.CIRCLE);
                    }
                } else {
                    continue;
                }
            }

            scanner.close();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Input Mismatch Error - Enter valid inputs.\n");
        } catch (NullPointerException e) {
            System.out.println("You are trying to access a null object : More details below\n" + e.getMessage() + "\n");
        } catch (Exception e) {
            System.out.println("We ran into an error : More details below\n");
            System.out.println(e.getMessage() + "\n");
        }
    }
}
