class AreaCalculator{
	/**
	 * Calculates the area of a triangle
	 * @param height height of the triangle
	 * @param width width of the triangle
	 * @throws ArithmeticException if height < 0 or width < 0
	 * @return double area of triangle
	 */
	public double getAreaOfTriangle(double height, double width){
		try{
			if(height < 0 || width < 0) throw new ArithmeticException("Invalid Parameters");
			return (0.5 * width * height);
		}catch(ArithmeticException e){
			return -1;
		}
	}

	/**
	 * Calculates the area of a rectangle
	 * @param height height of the rectangle
	 * @param width width of the rectangle
	 * @throws ArithmeticException if height < 0 or width < 0
	 * @return double area of rectangle
	 */
	public double getAreaOfRectangle(double height, double width){
		try{
			if(height < 0 || width < 0) throw new ArithmeticException("Invalid Parameters");
			return height * width;
		}catch(ArithmeticException e){
			return -1;
		}
	}

	/**
	 * Calculates the area of a Square using getAreaOfRectangle() function
	 * @param side Length of side of square
	 * @throws ArithmeticException if side < 0
	 * @return double area of square
	 */
	public double getAreaOfSquare(double side){
		return getAreaOfRectangle(side, side);
	}

	/**
	 * Calculates the area of a circle
	 * @param radius radius of the circle
	 * @throws ArithmeticException if radius < 0
	 * @return double area of the circle
	 */
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
