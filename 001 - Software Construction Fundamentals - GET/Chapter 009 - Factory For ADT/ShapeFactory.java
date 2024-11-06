import java.util.List;

public class ShapeFactory {
    public static Shape createShape(Shape.ShapeType shape, Point p, List<Integer> sides) {
        if(shape == Shape.ShapeType.TRIANGLE){
            Shape newShape = new Triangle(p, sides);
        }else if(shape == Shape.ShapeType.RECTANGLE){
            Shape newShape = new Rectangle(p, sides);
        }else if(shape == Shape.ShapeType.POLYGON){
            Shape newShape = new Polygon(p, sides);
        }else{
            Shape newShape = new Circle(sp, sides);
        }

        Shape shape = new Rectangle(p, sides);
        return shape;
    }
}
