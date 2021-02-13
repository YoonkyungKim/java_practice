package shapes;

//Triangle: polygon that has 3 edges and 3 vertices. Sum of any two sides' lengths must be greater than the 3rd side's length.
//Triangle class directly implements interface Shape, 
//and it has three private fields of type double which indicate its 3 sides.
//It has 3-arg constructor that takes 3 double values (3 sides) as a parameter, 
//getters and setters, and overridden toString() method.
//Its overridden method perimeter() returns the sum of 3 sides, based on Triangle's perimeter formula.

public class Triangle implements Shape {
	private double sideA;
	private double sideB;
	private double sideC;
	
	public Triangle(double sideA, double sideB, double sideC) throws TriangleException {
		if (sideA > 0 && sideB > 0 && sideC > 0 &&
			sideA + sideB > sideC && sideB + sideC > sideA && sideA + sideC > sideB) {
			this.sideA = sideA;
			this.sideB = sideB;
			this.sideC = sideC;
		} else {
			throw new TriangleException("Invalid side(s)!");
		}
	}
	
	public double getSideA() {
		return sideA;
	}

	public void setSideA(double sideA) throws TriangleException {
		if (sideA > 0 && sideA + getSideB() > getSideC() && 
			sideA + getSideC() > getSideB() && getSideB() + getSideC() > sideA) {
			this.sideA = sideA;
		} else {
			throw new TriangleException("Invalid side!");
		}
	}

	public double getSideB() {
		return sideB;
	}

	public void setSideB(double sideB) throws TriangleException {
		if (sideB > 0 && sideB + getSideA() > getSideC() &&
			sideB + getSideC() > getSideA() && getSideA() + getSideC() > sideB) {
			this.sideB = sideB;
		} else {
			throw new TriangleException("Invalid side!");
		}
	}

	public double getSideC() {
		return sideC;
	}

	public void setSideC(double sideC) throws TriangleException {
		if (sideC > 0 && sideC + getSideA() > getSideB() &&
			sideC + getSideB() > getSideA() && getSideA() + getSideB() > sideC) {
			this.sideC = sideC;
		} else {
			throw new TriangleException("Invalid side!");
		}
	}
	
	@Override
	public double perimeter() {
		return getSideA() + getSideB() + getSideC();
	}
	
	@Override
	public String toString() {
		return String.format(getClass().getSimpleName() + " {s1=" + getSideA() + ", s2=" + 
							getSideB() + ", s3=" + getSideC() + "} perimeter = " + "%6g", perimeter());
	}
}
