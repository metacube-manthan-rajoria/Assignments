// import java.awt.geom.Path2D;
// import java.awt.geom.Point2D;
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;
// import java.util.Scanner;

// public class Triangle implements Shape{
//     private final int NUMBER_OF_SIDES = 3;

//     private Point p;
//     private List<Integer> side = new ArrayList<Integer>(NUMBER_OF_SIDES);
//     boolean isValid = true;

//     public Triangle(Point p, int sides[]){
//         if(sides.length != NUMBER_OF_SIDES || p == null){
//             isValid = false;
//         }

//         Scanner scanner = new Scanner(System.in);
//         for(int i = 0; i<NUMBER_OF_SIDES; i++){
//             side
//         }
//     }

//     public double getArea(){
//         return 0.0;
//     }
//     public double getPerimeter(){
//         return 0.0;
//     }
//     public double getOrigin(){
//         return 0.0;
//     }
//     public double isPointEnclosed(Point p){
//         Path2D path = new Path2D.Double();
 
//         // Move to the first point in the polygon
//         path.moveTo(polygon.get(0).x, polygon.get(0).y);
 
//         // Connect the points in the polygon
//         for (int i = 1; i < polygon.size(); i++) {
//             path.lineTo(polygon.get(i).x, polygon.get(i).y);
//         }
 
//         // Close the path
//         path.closePath();
 
//         // Create a Point2D object for the test point
//         Point2D testPoint = new Point2D.Double(point.x, point.y);
 
//         // Check if the test point is inside the polygon
//         return path.contains(testPoint);
//     }
//     public double isPointEnclosed(long x, long y){
//         return 0.0;
//     }
// }