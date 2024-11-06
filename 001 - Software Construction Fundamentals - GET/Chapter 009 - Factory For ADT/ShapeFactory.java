import java.util.List;

public class ShapeFactory {
    public static Shape createShape(Shape.ShapeType shape, Point p, List<Integer> sides) {
        Shape newShape;

        if(shape == Shape.ShapeType.TRIANGLE){
            newShape = new Triangle(p, sides);
        }else if(shape == Shape.ShapeType.RECTANGLE){
            newShape = new Rectangle(p, sides);
        }else if(shape == Shape.ShapeType.POLYGON){
            newShape = new Polygon(p, sides);
        }else{
            newShape = new Circle(p, sides);
        }

        return newShape;
    }
}
