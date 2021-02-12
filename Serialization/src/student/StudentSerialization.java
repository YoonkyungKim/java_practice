package student;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.IOException;

public class StudentSerialization {
	
	private static ArrayList<Student> students;
	
	//Enter information for the students
	public static void enterStudents() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			students = new ArrayList<Student>();
			
			System.out.println("How many students would you like to enter? : ");
			int noOfStudents = (Integer.parseInt(reader.readLine()));

			for (int i = 0; i < noOfStudents; i++) {
				Student student = new Student();
				System.out.println("Enter student ID: ");
				student.setStdID(Integer.parseInt(reader.readLine()));
				System.out.println("Enter student first name: ");
				student.setFirstName(reader.readLine());
				System.out.println("Enter student last name: ");
				student.setLastName(reader.readLine());
				System.out.println("Enter student course names: ");
				String line;
				ArrayList<String> courseList = new ArrayList<String>();
				while ( (line = reader.readLine()).length() != 0 ) {
					courseList.add(line);
				}
				student.setCourses(courseList);
				students.add(student);
			}			
		} catch(IOException e) {
			System.err.println(e);
		} catch (NumberFormatException e) {
			System.err.println("Please enter the number.");
		}
	}
	
	//Serialize and save students to the file
	public static void serializeStudents() {
		try {
			FileOutputStream fos = new FileOutputStream("file.out");
			BufferedOutputStream bf = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bf);
//			ObjectOutputStream oos = new ObjectOutputStream(fos);			
			
			oos.writeObject(students);
			
			oos.flush();
			fos.close();
			
		} catch(IOException e) {
			System.err.println(e);
		} catch(Throwable e) {
			System.err.println(e);
		}
	}
	
	
	public static void main(String[] args) {
		enterStudents();
		serializeStudents();
	}

}
