# Problem Statement
Design a class Area to calculate areas for different shapes. It should support following methods
- Method to return area of a Triangle. Method will receive width and height as double and return computed value as double.
- Method to return area of a Rectangle. Method will receive width and height as double and return computed value as double.
- Method to return area of a Square. Method will receive width as double and return computed value as double.
- Method to return area of a Circle. Method will receive radius as double and return computed value as double.

<br>
Assuming that height, width and radius will be greater than zero write proper specification for each method created above. Also assume that these methods may throw ArithmeticException.

# AreaCalculator

```java
class AreaCalculator{
	public double getAreaOfTriangle(double height, double width){
		try{
			if(height < 0 || width < 0) throw new ArithmeticException("Invalid Parameters");
			return (0.5 * width * height);
		}catch(ArithmeticException e){
			return -1;
		}
	}
	public double getAreaOfRectangle(double height, double width){
		try{
			if(height < 0 || width < 0) throw new ArithmeticException("Invalid Parameters");
			return height * width;
		}catch(ArithmeticException e){
			return -1;
		}
	}
	public double getAreaOfSquare(double side){
		return getAreaOfRectangle(side, side);
	}
	public double getAreaOfCircle(double radius){
		try{
			if(radius < 0) throw new ArithmeticException("Invalid Parameter");
			return Math.PI * Math.pow(radius, 2);
		}catch(ArithmeticException e){
			return -1;
		}
	}
}
class Assignment {
	public static void main(String[] args) {
		AreaCalculator ac = new AreaCalculator();
		System.out.println(ac.getAreaOfTriangle(10, 20));
		System.out.println(ac.getAreaOfRectangle(10, 20));
		System.out.println(ac.getAreaOfSquare(10));
		System.out.println(ac.getAreaOfCircle(-2));
	}
}
```