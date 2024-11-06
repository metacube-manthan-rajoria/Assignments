import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Screen {
    private int xMax = 0;
    private int yMax = 0;

    private List<Shape> shapes;

    public Screen(int xMax, int yMax) {
        this.xMax = Math.abs(yMax);
        this.yMax = Math.abs(yMax);
        shapes = new ArrayList<Shape>();
    }

    public void addShape(Shape.ShapeType shape) {
        Scanner scanner = new Scanner(System.in);

        // Checking number of sides.
        int noOfSides = 0;
        if(shape == Shape.ShapeType.RECTANGLE || shape == Shape.ShapeType.POLYGON){
            noOfSides = 2;
        }else{
            noOfSides = 1;
        }

        // Taking origin
        double xCoordinateOrigin = 0;
        double yCoordinateOrigin = 0;
        System.out.print("Enter the x origin for " + shape + " : ");
        xCoordinateOrigin = scanner.nextDouble();
        System.out.print("Enter the y origin for " + shape + " : ");
        yCoordinateOrigin = scanner.nextDouble();

        // Taking sides
        List<Integer> sides = new ArrayList<>(noOfSides);
        for (int i = 0; i < noOfSides; i++) {
            if(shape == Shape.ShapeType.POLYGON && i == 1){
                System.out.print("Enter the number of sides in the " + shape + " : ");
            }else{
                System.out.print("Enter the length of side " + (i + 1) + " for " + shape + " : ");
            }
            
            Integer side = scanner.nextInt();
            sides.add(side);
        }
        scanner.close();

        // Creating corresponding shape
        Point p = new Point(xCoordinateOrigin, yCoordinateOrigin);
        Shape newShape = ShapeFactory.createShape(shape, p, sides);

        boolean isShapeInbound = isShapeInbound(newShape);

        if (isShapeInbound && newShape.isValid()) {
            System.out.println("Added " + shape + " at origin (" + p.getX() + "," + p.getY() + ")\n");
            shapes.add(newShape);
        } else {
            if(!newShape.isValid()){
                System.out.println("\nInvalid inputs for " + shape);
            }else{
                System.out.println(
                    "\nCannot add " + shape + " to screen : Shape out of bounds for (" + xMax + "," + yMax + ")");
            }
        }
    }

    public Shape getShape(int index) {
        if(shapes.size() == 0){
            System.out.println("\nCannot fetch the shape at index : " + index + " : Shape does not exist!");
            return null;
        }
        return shapes.get(index);
    }

    public void deleteShape(int index) {
        if(shapes.size() == 0){
            System.out.println("Cannot delete the shape at index : " + index + " : Shape does not exist!");
            return;
        }
        shapes.remove(index);
    }

    public void deleteAllShapeTypes(Shape.ShapeType shapeType) {
        for (int i = 0; i < shapes.size(); i++) {
            Shape.ShapeType currentShapeType = shapes.get(i).getShapeType();
            if (currentShapeType == shapeType) {
                shapes.remove(i);
            }
        }
    }

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
}
