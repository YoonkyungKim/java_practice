package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import shapes.Shape;
import shapes.Parallelogram;
import shapes.ParallelogramException;
import shapes.Rectangle;
import shapes.Square;
import shapes.SquareException;
import shapes.Circle;
import shapes.CircleException;
import shapes.Triangle;
import shapes.TriangleException;

public class Main {
	//Read the file shapes.txt, create the shapes, and store them in the array
	public static Shape[] createShapes() {
		//Read the file to count the number of lines in shapes.txt
		String str;
		int lineCount = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))){
			while ((str = br.readLine()) != null) {	
				lineCount++;
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		//Make shapes array with lineCount size
		Shape[] shapes = new Shape[lineCount];
		//Read the file again to make shapes
		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))){
			//index of shapes array
			int i = 0;
			while ((str = br.readLine()) != null) {		
				String[] tokens = str.split(",");
				//Make a Shape only if the line is properly formatted and contains necessary number of values
				//Otherwise, ignore the line
				//since we don't use exception in each Shape's constructor yet, validate input values here
				if (tokens[0].equals("Circle") && tokens.length == 2) {
					double radius = Double.parseDouble(tokens[1]);
					try {
						shapes[i] = new Circle(radius);
						i++;
					} catch (CircleException e) {
						System.out.println(e.getMessage());
					}
				} else if (tokens[0].equals("Square") && tokens.length == 2) {
					double side = Double.parseDouble(tokens[1]);
					try {
						shapes[i] = new Square(side);
						i++;
					} catch (SquareException e) {
						System.out.println(e.getMessage());
					}
				} else if (tokens[0].equals("Rectangle") && tokens.length == 3) {
					double width = Double.parseDouble(tokens[1]);
					double length = Double.parseDouble(tokens[2]);
					try {
						shapes[i] = new Rectangle(width, length);
						i++;
					} catch (ParallelogramException e) {
						System.out.println(e.getMessage());
					}
				} else if (tokens[0].equals("Parallelogram") && tokens.length == 3) {
					double width = Double.parseDouble(tokens[1]);
					double length = Double.parseDouble(tokens[2]);
					try {
						shapes[i] = new Parallelogram(width, length);
						i++;
					} catch (ParallelogramException e) {
						System.out.println(e.getMessage());
					}
				} else if (tokens[0].equals("Triangle") && tokens.length == 4) {
					double sideA = Double.parseDouble(tokens[1]);
					double sideB = Double.parseDouble(tokens[2]);
					double sideC = Double.parseDouble(tokens[3]);
					try {
						shapes[i] = new Triangle(sideA, sideB, sideC);
						i++;
					} catch (TriangleException e) {
						System.out.println(e.getMessage());
					}
				}			
			}
			//Print the number of shapes created
			System.out.println();
			System.out.println(String.valueOf((int)i) + " shapes were created:");
			
			//Print each Shape with its calculated perimeter (and area if appropriate)
			//using enhanced for loop
			for (Shape shape : shapes) {
				if (shape != null) {
					System.out.println(shape);
					System.out.println();
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return shapes;	
	}
	
	public static void main(String[] args) {
		
		Shape[] shapes = createShapes();
	}
	
}
