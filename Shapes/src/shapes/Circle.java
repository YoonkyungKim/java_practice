package shapes;

//Circle: round plane figure with all points on the boundary equidistant from the center.
//Circle class directly implements interface Shape,
//and it has private field radius of type double.
//It has 1-arg constructor that takes double value (radius) as a parameter, getters and setters, and overridden toString() method.
//Its overridden method perimeter() calculates 2 * radius * π (PI) and return the result based on circle's perimeter formula.
//method calculateArea() returns object of interface ShapeArea using lambda expression
//and in toString() method, it calls calculateArea()'s return value's area() method

public class Circle implements Shape {
	private double radius;

	public Circle(double radius) throws CircleException {
		if (radius > 0) {
			this.radius = radius;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) throws CircleException {
		if (radius > 0) {
			this.radius = radius;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}
	
	public ShapeArea calculateArea() {
		return () -> Math.PI * getRadius() * getRadius();
	}
	
	@Override
	public double perimeter() {
		return 2 * getRadius() * Math.PI;
	}
	
	@Override
	public String toString() {
		return String.format(getClass().getSimpleName() + " {r=" + 
							getRadius() + "} perimeter = " + "%6g, area = %6g", 
							perimeter(), calculateArea().area());
	}	
}
