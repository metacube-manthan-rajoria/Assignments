import java.util.ArrayList;
import java.util.List;

public class Circle implements Shape {
    private final int NUMBER_OF_SIDES = 1;
    private final int NUMBER_OF_VERTEX = 4;

    private Point p;
    private List<Integer> sides = new ArrayList<Integer>(NUMBER_OF_SIDES);
    private List<Point> shapeVertexes;
    long timeStamp = 0;
    boolean isValid = true;

    public Circle(Point p, List<Integer> sides) {
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

        Point p1 = new Point(p.getX(), p.getY() - sides.get(0));
        Point p2 = new Point(p.getX() + sides.get(0), p.getY());
        Point p3 = new Point(p.getX(), p.getY() + sides.get(0));
        Point p4 = new Point(p.getX() - sides.get(0), p.getY());

        shapeVertexes.add(p1);
        shapeVertexes.add(p2);
        shapeVertexes.add(p3);
        shapeVertexes.add(p4);
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
            double area = Math.PI * Math.pow(sides.get(0), 2);
            return area;
        }
        return -1;
    }

    public double getPerimeter() {
        if (isValid) {
            double perimeter = 2 * Math.PI * sides.get(0);
            return perimeter;
        }
        return -1;
    }

    public Point getOrigin() {
        return new Point(p.getX(), p.getY());
    }

    public double isPointEnclosed(Point p) {
        // Path2D path = new Path2D.Double();

        // // Move to the first point in the polygon
        // path.moveTo(polygon.get(0).x, polygon.get(0).y);

        // // Connect the points in the polygon
        // for (int i = 1; i < polygon.size(); i++) {
        // path.lineTo(polygon.get(i).x, polygon.get(i).y);
        // }

        // // Close the path
        // path.closePath();

        // // Create a Point2D object for the test point
        // Point2D testPoint = new Point2D.Double(point.x, point.y);

        // // Check if the test point is inside the polygon
        // return path.contains(testPoint);
        return 0.0;
    }

    public double isPointEnclosed(double x, double y) {
        return 0.0;
    }

    public boolean isValid() {
        return isValid;
    }

    public Shape.ShapeType getShapeType() {
        return Shape.ShapeType.CIRCLE;
    }

    public long getTimestamp() {
        return this.timeStamp;
    }
}
