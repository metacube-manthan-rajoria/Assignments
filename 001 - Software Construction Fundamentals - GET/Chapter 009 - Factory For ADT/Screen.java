import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Screen {
    private int xMax = 0;
    private int yMax = 0;

    private List<Shape> shapes;

    public Screen(int xMax, int yMax){
        this.xMax = Math.abs(yMax);
        this.yMax = Math.abs(yMax);
        shapes = new ArrayList<Shape>();
    }

    public void addShape(Shape.ShapeType shape){
        Scanner scanner = new Scanner(System.in);

        // Checking number of sides.
        int noOfSides = 0;
        if(shape == Shape.ShapeType.TRIANGLE || shape == Shape.ShapeType.POLYGON){
            noOfSides = 1;
        }else if(shape == Shape.ShapeType.RECTANGLE) {
            noOfSides = 2;
        }else if(shape == Shape.ShapeType.CIRCLE){
            noOfSides = 0;
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
        for(int i = 0; i<noOfSides; i++){
            System.out.print("Enter the side " + (i+1) + " for " + shape + " : ");
            Integer side = scanner.nextInt();
            sides.add(side);
        }
        scanner.close();

        // Creating corresponding shape
        Point p = new Point(xCoordinateOrigin, yCoordinateOrigin);
        Shape newShape = ShapeFactory.createShape(shape, p, sides);

        // TODO : Check if shape if addadble(inblounds of xMax and yMax)


        System.out.println("Added " + shape + " at origin (" + p.getX() + "," + p.getY() +")\n");
        shapes.add(newShape);
    }

    public Shape getShape(int index){
        return shapes.get(index);
    }

    public void deleteShape(int index){
        shapes.remove(index);
    }
    public void deleteAllShapeTypes(Shape.ShapeType shapeType){

    }

    // TODO : add code here later
    private boolean isShapeInbounds(Shape shape){
        return true;
    }
    
}
