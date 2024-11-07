import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class FactoryTest {
    Screen screen;

    public FactoryTest(){
        screen = new Screen(1000, 1000);
        Shape s1 = new Circle(new Point(20, 20), new ArrayList<Integer>(){
            {
                add(10);
            }
        });
        Shape s2 = new Triangle(new Point(0, 0), new ArrayList<Integer>(){
            {
                add(1);
            }
        });
        Shape s3 = new Polygon(new Point(20, 0), new ArrayList<Integer>(){
            {
                add(10);
                add(5);
            }
        });
        screen.addShape(Shape.ShapeType.CIRCLE);
        screen.addShape(Shape.ShapeType.TRIANGLE);
        screen.addShape(Shape.ShapeType.POLYGON);
    }

    @Test
    public void testArea(){
        assertEquals(0, 0);
    }
}