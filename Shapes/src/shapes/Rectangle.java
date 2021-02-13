package shapes;

//Rectangle: quadrilateral that has 4 right angles.
//Rectangle class inherits from (extends) Parallelogram class.
//it doesn't have its own additional field, so it doesn't have any getters/setters.
//Its 2-arg constructor calls super class (Parallelogram)'s 2-arg constructor with received parameter values.
//Rectangle's perimeter formula is the same as its super class Parallelogram's, 
//so it doesn't have overridden perimeter() method here
//method calculateArea() returns object of interface ShapeArea using lambda expression
//and in toString() method, it calls calculateArea()'s return value's area() method

public class Rectangle extends Parallelogram {
	
	public Rectangle(double width, double length) throws ParallelogramException {
		super(width, length);				
	}
	
	public ShapeArea calculateArea() {
		return () -> getWidth() * getLength();
	}
	
	@Override
	public String toString() {
		return String.format("%s {r=%.1f, l=%.1f} perimeter = %6g, area = %6g",
					getClass().getSimpleName(), getWidth(), getLength(), 
					perimeter(), calculateArea().area());
	}
}
