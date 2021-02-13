package shapes;
//import shapes.Rectangle;
//Square: quadrilateral with 4 equal sides and 4 equal angles.
//Square class directly extends (implements) interface Shape,
//and it has private field side of type double.
//It has 1-arg constructor that takes double value (side) as a parameter, getters and setters, and overridden toString() method.
//Its overridden method perimeter() returns the result of side * 4 based on Square's perimeter formula. 
//method calculateArea() returns object of interface ShapeArea using lambda expression
//and in toString() method, it calls calculateArea()'s return value's area() method

public class Square implements Shape {
	private double side;
	
	public Square(double side) throws SquareException {
		if (side > 0) {
			this.side = side;
		} else {
			throw new SquareException("Invalid side!");
		}
		
	}
	
	public double getSide() {
		return side;
	}

	public void setSide(double side) throws SquareException {
		if (side > 0) {
			this.side = side;
		} else {
			throw new SquareException("Invalid side!");
		}		
	}
	
	public ShapeArea calculateArea() {
		return () -> getSide() * getSide();
	}
	
	@Override
	public double perimeter() {
		return getSide() * 4;
	}
	
	@Override
	public String toString() {
		return String.format(getClass().getSimpleName() + " {s=" + 
					getSide() + "} perimeter = %6g, area = %6g ", 
					perimeter(), calculateArea().area());
	}
	
}
