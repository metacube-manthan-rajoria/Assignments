public interface Shape{
    enum ShapeType{
        TRIANGLE,
        RECTANGLE,
        POLYGON,
        CIRCLE
    }

    public double getArea();
    public double getPerimeter();
    public Point getOrigin();
    public double isPointEnclosed(Point p);
    public double isPointEnclosed(double x, double y);
    public boolean isValid();
    public Shape.ShapeType getShapeType();
}