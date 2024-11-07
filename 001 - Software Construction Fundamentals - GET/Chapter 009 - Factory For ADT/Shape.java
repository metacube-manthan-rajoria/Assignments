import java.util.List;

public interface Shape{
    enum ShapeType{
        TRIANGLE,
        RECTANGLE,
        POLYGON,
        CIRCLE
    }

    /**
     * Generates copy of all the vertexes of a shape from origin and angle
     * @return List<Point> with all vertexes
     */
    public List<Point> getVertexes();

    /**
     * Gives the area of shape
     * @return double area
     */
    public double getArea();
    /**
     * Gives the perimeter of shape
     * @return double perimeter
     */
    public double getPerimeter();
    /**
     * Returns the origin coordinates of the shape
     * @return Point object
     */
    public Point getOrigin();

    /**
     * Takes a point and checks if it is present inside a shape
     * @param p Point object to be checked
     * @return true if point inside shape else otherwise
     */
    public boolean isPointEnclosed(Point p);
    /**
     * Takes a point and checks if it is present inside a shape
     * @param x x coordinate to be checked
     * @param y y coordinate to be checked
     * @return true if point inside shape else otherwise
     */
    public boolean isPointEnclosed(double x, double y);
    
    /**
     * Check is created shape is valid shape
     * @return boolean, true if shape is valid
     */
    public boolean isValid();

    /**
     * Gives the Shape.ShapeType of object
     * @return Shape.ShapeType
     */
    public Shape.ShapeType getShapeType();

    /**
     * Gives the timestamp at the time of shape creation in nanoseconds
     * @return long timestamp in nanoseconds
     */
    public long getTimestamp();
}