package student;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	private static final long serialVersionUID = 1375358595658975360L;
	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses;
	
	public Student() {
		this.stdID = 0;
		this.firstName = "";
		this.lastName = "";
		this.courses = new ArrayList<String>();
	}

	public int getStdID() {
		return stdID;
	}

	public void setStdID(int stdID) throws IllegalArgumentException {
		if (stdID > 0) {
			this.stdID = stdID;
		} else {
			throw new IllegalArgumentException("Invalid student ID");
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws IllegalArgumentException {
		if (firstName != null && !firstName.trim().isEmpty()) {
			this.firstName = firstName;
		} else {
			throw new IllegalArgumentException("Invalid first name");
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws IllegalArgumentException {
		if (lastName != null && !lastName.trim().isEmpty()) {
			this.lastName = lastName;
		} else {
			throw new IllegalArgumentException("Invalid last name");
		}
	}

	public ArrayList<String> getCourses() {
		return new ArrayList<String>(courses);
	}
	
	public void setCourses(ArrayList<String> courses) throws IllegalArgumentException {
		if (courses != null && !courses.isEmpty()) {
			this.courses = new ArrayList<String>(courses);
		} else {
			throw new IllegalArgumentException("Invalid courses");
		}
		
	}
}
