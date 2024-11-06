public interface Shape{
    enum ShapeType{
        TRIANGLE,
        RECTANGLE,
        POLYGON,
        CIRCLE
    }

    public double getArea();
    public double getPerimeter();
    public double getOrigin();
    public double isPointEnclosed(Point p);
    public double isPointEnclosed(double x, double y);
}