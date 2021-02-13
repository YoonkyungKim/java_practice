package shapes;

//Parallelogram: quadrilateral that has two pairs of sides parallel to each other.
//Parallelogram class directly implements interface Shape, 
//and it has two private double type fields width and length.
//It has 2-arg constructor that takes width and length as a parameter, getters and setters, and overridden toString() method.
//Its overridden method perimeter() returns the result of 2 * (width + length), based on Parallelogram's perimeter formula.

public class Parallelogram implements Shape {
	private double width;
	private double length;
	
	public Parallelogram(double width, double length) throws ParallelogramException {
		if (width > 0 && length > 0) {
			this.width = width;
			this.length = length;
		} else {
			throw new ParallelogramException("Invalid side(s)!");
		}
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) throws ParallelogramException {
		if (width > 0) {
			this.width = width;
		} else {
			throw new ParallelogramException("Invalid side!");
		}
	}
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) throws ParallelogramException {
		if (length > 0) {
			this.length = length;
		} else {
			throw new ParallelogramException("Invalid side!");
		}
	}
	
	@Override
	public double perimeter() {
		return (getWidth() + getLength()) * 2;
	}
	
	@Override
	public String toString() {
		return String.format("%s {r=%.1f, l=%.1f} perimeter = %6g",
					getClass().getSimpleName(), getWidth(), getLength(), perimeter());
	}
}
