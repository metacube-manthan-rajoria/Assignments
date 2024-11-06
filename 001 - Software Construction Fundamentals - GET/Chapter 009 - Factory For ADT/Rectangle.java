import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape{
    private final int NUMBER_OF_SIDES = 2;
    private final int NUMBER_OF_COORDINATES = 4;

    private Point p;
    private List<Integer> sides = new ArrayList<Integer>(NUMBER_OF_SIDES);
    private List<Point> shapeCoordinates;
    boolean isValid = true;

    public Rectangle(Point p, List<Integer> sides){
        if(sides.size() != NUMBER_OF_SIDES || p == null){
            isValid = false;
        }

        this.p = p;
        this.sides = sides;
        this.shapeCoordinates = new ArrayList<Point>(NUMBER_OF_COORDINATES);
        makeCoordinates();
    }

    private void makeCoordinates(){
        if(!isValid) return;

        Point p1 = new Point(p.getX(), p.getY());
        Point p2 = new Point(p.getX() + sides.get(0), p.getY());
        Point p3 = new Point(p.getX() + sides.get(0), p.getY() + sides.get(1));
        Point p4 = new Point(p.getX(), p.getY() + sides.get(1));

        shapeCoordinates.add(p1);
        shapeCoordinates.add(p2);
        shapeCoordinates.add(p3);
        shapeCoordinates.add(p4);
    }

    public double getArea(){
        if(isValid){
            double area = sides.get(0) * sides.get(1);
            return area;
        }
        return -1;
    }

    public double getPerimeter(){
        if(isValid){
            double perimeter = (sides.get(0) + sides.get(1))*2;
            return perimeter;
        }
        return -1;
    }

    public Point getOrigin(){
        return new Point(p.getX(), p.getY());
    }

    public double isPointEnclosed(Point p){
        // Path2D path = new Path2D.Double();
 
        // // Move to the first point in the polygon
        // path.moveTo(polygon.get(0).x, polygon.get(0).y);
 
        // // Connect the points in the polygon
        // for (int i = 1; i < polygon.size(); i++) {
        //     path.lineTo(polygon.get(i).x, polygon.get(i).y);
        // }
 
        // // Close the path
        // path.closePath();
 
        // // Create a Point2D object for the test point
        // Point2D testPoint = new Point2D.Double(point.x, point.y);
 
        // // Check if the test point is inside the polygon
        // return path.contains(testPoint);
        return 0.0;
    }
    public double isPointEnclosed(double x, double y){
        return 0.0;
    }
}
