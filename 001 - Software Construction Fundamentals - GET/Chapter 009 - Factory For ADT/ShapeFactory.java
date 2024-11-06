import java.util.List;

public class ShapeFactory {
    public static Shape createShape(Shape.ShapeType shape, Point p, List<Integer> sides) {
        if(shape == Shape.ShapeType.TRIANGLE){
            Shape shape = new Triangle(p, sides);
        }else if(shape == Shape.ShapeType.RECTANGLE){
            Shape shape = new Rectangle(p, sides);
        }else if(shape == Shape.ShapeType.POLYGON){
            Shape shape = new Polygon(p, sides);
        }else{
            Shape shape = new Circle(sp, sides);
        }

        Shape shape = new Rectangle(p, sides);
        return shape;
    }
}
