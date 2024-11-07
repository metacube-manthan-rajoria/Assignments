import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Screen {
    public enum ShapeSort {
        AREA,
        PERIMETER,
        TIMESTAMP,
        ORIGIN_DISTANCE
    }

    private int xMax = 0;
    private int yMax = 0;

    private List<Shape> shapes;

    public Screen(int xMax, int yMax) {
        this.xMax = Math.abs(yMax);
        this.yMax = Math.abs(yMax);
        shapes = new ArrayList<Shape>();
    }

    /**
     * Adds a given shape to list based on Shape.ShapeType
     * @param shape type of object
     */
    public void addShape(Shape.ShapeType shape) {
        Scanner scanner = new Scanner(System.in);

        // Checking number of sides.
        int noOfSides = 0;
        if (shape == Shape.ShapeType.RECTANGLE || shape == Shape.ShapeType.POLYGON) {
            noOfSides = 2;
        } else {
            noOfSides = 1;
        }

        // Taking origin
        double xCoordinateOrigin = 0;
        double yCoordinateOrigin = 0;
        System.out.print("\tEnter the x origin for " + shape + " : ");
        xCoordinateOrigin = scanner.nextDouble();
        System.out.print("\tEnter the y origin for " + shape + " : ");
        yCoordinateOrigin = scanner.nextDouble();

        // Taking sides
        List<Integer> sides = new ArrayList<>(noOfSides);
        for (int i = 0; i < noOfSides; i++) {
            if (shape == Shape.ShapeType.POLYGON && i == 1) {
                System.out.print("\tEnter the number of sides in the " + shape + " : ");
            } else {
                System.out.print("\tEnter the length of side " + (i + 1) + " for " + shape + " : ");
            }

            Integer side = scanner.nextInt();
            sides.add(side);
        }

        // Creating corresponding shape
        Point p = new Point(xCoordinateOrigin, yCoordinateOrigin);
        Shape newShape = ShapeFactory.createShape(shape, p, sides);

        boolean isShapeInbound = isShapeInbound(newShape);

        if (isShapeInbound && newShape.isValid()) {
            System.out.println("\tAdded " + shape + " at origin (" + p.getX() + "," + p.getY() + ") and Timestamp is : "
                    + newShape.getTimestamp() + "\n");
            shapes.add(newShape);
        } else {
            if (!newShape.isValid()) {
                System.out.println("\nInvalid inputs for " + shape);
            } else {
                System.out.println(
                        "\nCannot add " + shape + " to screen : Shape out of bounds for (" + xMax + "," + yMax + ")");
            }
        }
    }

    /**
     * Gives the shape from list based on given index
     * @param index of shape to get
     * @return Shape object
     */
    public Shape getShape(int index) {
        if (shapes.size() == 0) {
            System.out.println("\nCannot fetch the shape at index : " + index + " : Shape does not exist!");
            return null;
        }
        return shapes.get(index);
    }

    /**
     * Takes the index of the shape to delete
     * @param index of the shape
     */
    public void deleteShape(int index) {
        if (shapes.size() == 0) {
            System.out.println("Cannot delete the shape at index : " + index + " : Shape does not exist!");
            return;
        }
        shapes.remove(index);
    }

    /**
     * Deletes all shape of certain ShapeType
     * @param shapeType Shape.ShapeType to be deleted
     */
    public void deleteAllShapeTypes(Shape.ShapeType shapeType) {
        for (int i = 0; i < shapes.size(); i++) {
            Shape.ShapeType currentShapeType = shapes.get(i).getShapeType();
            if (currentShapeType == shapeType) {
                shapes.remove(i);
            }
        }
    }

    /**
     * Checks if the shape is inside screen and does not clip
     * @param shape shape object to be checked
     * @return true if shape is inside screen
     */
    private boolean isShapeInbound(Shape shape) {
        if (shape == null || !shape.isValid())
            return false;
        List<Point> allShapeVertex = shape.getVertexes();
        if (allShapeVertex.size() == 0 || allShapeVertex == null)
            return false;

        for (Point point : allShapeVertex) {
            if (point.getX() > xMax || point.getY() > yMax || point.getX() < 0 || point.getY() < 0)
                return false;
        }

        return true;
    }

    /**
     * Sorts shapes based on Screen.ShapeSort Type
     * @param sort ShapeSort Type
     * @return List<Shape> of sorted shapes
     */
    public List<Shape> sortShapes(ShapeSort sort) {
        List<Shape> shapesCopy = new ArrayList<Shape>();
        shapesCopy.addAll(shapes);

        if (sort == ShapeSort.AREA) {
            Collections.sort(shapesCopy, new Comparator<Shape>() {
                public int compare(Shape s1, Shape s2) {
                    double diff = s1.getArea() - s2.getArea();
                    if (diff == 0)
                        return 0;
                    else if (diff > 0)
                        return 1;
                    else
                        return -1;
                }
            });
        } else if (sort == ShapeSort.PERIMETER) {
            Collections.sort(shapesCopy, new Comparator<Shape>() {
                public int compare(Shape s1, Shape s2) {
                    double diff = s1.getPerimeter() - s2.getPerimeter();
                    if (diff == 0)
                        return 0;
                    else if (diff > 0)
                        return 1;
                    else
                        return -1;
                }
            });
        } else if (sort == ShapeSort.ORIGIN_DISTANCE) {
            Collections.sort(shapesCopy, new Comparator<Shape>() {
                public int compare(Shape s1, Shape s2) {
                    double diff = s1.getOrigin().distanceFromOrigin() - s2.getOrigin().distanceFromOrigin();
                    if (diff == 0)
                        return 0;
                    else if (diff > 0)
                        return 1;
                    else
                        return -1;
                }
            });
        } else {
            Collections.sort(shapesCopy, new Comparator<Shape>() {
                public int compare(Shape s1, Shape s2) {
                    long diff = s1.getTimestamp() - s2.getTimestamp();
                    if (diff == 0)
                        return 0;
                    else if (diff > 0)
                        return 1;
                    else
                        return -1;
                }
            });
        }

        shapes = shapesCopy;
        return shapesCopy;
    }
}
