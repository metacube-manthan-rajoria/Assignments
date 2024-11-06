import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class Triangle implements Shape {
    private final int NUMBER_OF_SIDES = 1;
    private final int NUMBER_OF_VERTEX = 3;

    private Point p;
    private List<Integer> sides = new ArrayList<Integer>(NUMBER_OF_SIDES);
    private List<Point> shapeVertexes;
    long timeStamp = 0;
    boolean isValid = true;

    public Triangle(Point p, List<Integer> sides) {
        if (sides.size() != NUMBER_OF_SIDES || p == null) {
            isValid = false;
        }

        this.p = p;
        this.sides = sides;
        this.shapeVertexes = new ArrayList<Point>(NUMBER_OF_VERTEX);
        timeStamp = System.nanoTime();
        makeVertexes();
    }

    private void makeVertexes() {
        if (!isValid)
            return;

        double side = sides.get(0);

        Point p1 = new Point(p.getX(), p.getY());
        Point p2 = new Point(p.getX() + side, p.getY());

        double p3x = p.getX() + (side * Math.cos((Math.PI * 1) / 3));
        double p3y = p.getY() + (side * Math.sin((Math.PI * 2) / 3));
        Point p3 = new Point(p3x, p3y);

        shapeVertexes.add(p1);
        shapeVertexes.add(p2);
        shapeVertexes.add(p3);
    }

    public List<Point> getVertexes() {
        List<Point> copyShapeVertexes = new ArrayList<Point>();
        for (Point p : shapeVertexes) {
            copyShapeVertexes.add(p);
        }
        return copyShapeVertexes;
    }

    public double getArea() {
        if (isValid) {
            double area = (Math.pow(3, 0.5) * Math.pow(sides.get(0), 2)) / 4;
            return area;
        }
        return -1;
    }

    public double getPerimeter() {
        if (isValid) {
            double perimeter = sides.get(0) * 3;
            return perimeter;
        }
        return -1;
    }

    public Point getOrigin() {
        return new Point(p.getX(), p.getY());
    }

    public boolean isPointEnclosed(Point p) {
        Path2D path = new Path2D.Double();
 
        // Move to the first point in the polygon
        path.moveTo(shapeVertexes.get(0).getX(), shapeVertexes.get(0).getY());
 
        // Connect the points in the polygon
        for (int i = 1; i < shapeVertexes.size(); i++) {
            path.lineTo(shapeVertexes.get(i).getX(), shapeVertexes.get(i).getY());
        }
 
        path.closePath();
 
        // Create a Point2D object for the test point
        Point2D testPoint = new Point2D.Double(p.getX(), p.getY());
 
        // Check if the test point is inside the polygon
        return path.contains(testPoint);
    }

    public boolean isPointEnclosed(double x, double y) {
        Point p = new Point(x, y);
        return isPointEnclosed(p);
    }

    public boolean isValid() {
        return isValid;
    }

    public Shape.ShapeType getShapeType() {
        return Shape.ShapeType.TRIANGLE;
    }

    public long getTimestamp() {
        return this.timeStamp;
    }
}
