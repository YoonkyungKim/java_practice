package student;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.EOFException;

// Read Student objects from the file and display their information in the console
// to verify that they had been saved (and serialized) correctly
public class StudentDeserialization {
	private static ArrayList<Student> students;
	
	public static void deserializeStudents() {
		
		try {
			FileInputStream fis = new FileInputStream("file.out");
		
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			students = new ArrayList<Student>();
			
			students = (ArrayList<Student>)ois.readObject();
						
			fis.close();

			for (int i = 0; i < students.size(); i++) {
				System.out.println("Deserialized student " + (i+1) + ":");
				System.out.println("Student ID: " + students.get(i).getStdID());
				System.out.println("First name: " + students.get(i).getFirstName());
				System.out.println("Last name: " + students.get(i).getLastName());
				System.out.println("Courses the student takes: " + students.get(i).getCourses());
				System.out.println();
			}		
			
		} catch (EOFException e) {
			System.err.println("No students to read.");
		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		} catch(Throwable e) {
			System.err.println(e);
		}	
	}
	
	public static void main(String[] args) {
		deserializeStudents();		
	}
}
