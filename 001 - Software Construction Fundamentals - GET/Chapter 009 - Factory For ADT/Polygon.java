import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class Polygon implements Shape {
    private final int NUMBER_OF_SIDES = 2;
    private int NUMBER_OF_VERTEX = -1;

    private Point p;
    private List<Integer> sides = new ArrayList<Integer>(NUMBER_OF_SIDES);
    private List<Point> shapeVertexes;
    long timeStamp = 0;
    boolean isValid = true;

    public Polygon(Point p, List<Integer> sides) {
        if (sides.size() != NUMBER_OF_SIDES || p == null)
            isValid = false;

        this.p = p;
        this.sides = sides;
        this.NUMBER_OF_VERTEX = sides.get(1);
        if (this.NUMBER_OF_VERTEX <= 4)
            isValid = false;
        this.shapeVertexes = new ArrayList<Point>(NUMBER_OF_VERTEX);
        timeStamp = System.nanoTime();
        makeVertexes();
    }

    private void makeVertexes() {
        if (!isValid)
            return;

        double side = sides.get(0);

        Point firstPoint = new Point(p.getX(), p.getY());
        Point secondPoint = new Point(p.getX() + side, p.getY());
        shapeVertexes.add(firstPoint);
        shapeVertexes.add(secondPoint);

        int angle = 2;
        double lastX = p.getX() + side;
        double lastY = p.getY();
        for (int i = 0; i < NUMBER_OF_VERTEX - 2; i++) {
            double vpx = lastX + (side * Math.cos((Math.PI * angle) / NUMBER_OF_VERTEX));
            double vpy = lastY + (side * Math.sin((Math.PI * angle) / NUMBER_OF_VERTEX));
            lastX = vpx;
            lastY = vpy;

            Point vertexPoint = new Point(vpx, vpy);
            shapeVertexes.add(vertexPoint);
            angle = angle + 2;
        }
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
            double numerator = Math.pow(sides.get(0), 2) * NUMBER_OF_VERTEX;
            double denominator = 4 * Math.tan(Math.PI / NUMBER_OF_VERTEX);
            double area = numerator / denominator;
            return area;
        }
        return -1;
    }

    public double getPerimeter() {
        if (isValid) {
            double perimeter = sides.get(0) * NUMBER_OF_VERTEX;
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
        return Shape.ShapeType.POLYGON;
    }

    public long getTimestamp() {
        return this.timeStamp;
    }
}
