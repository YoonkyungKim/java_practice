package students;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StudentSavePanel extends JPanel {
	
	private static final long serialVersionUID = -1441082869570288508L;
	
	private static ArrayList<Student> students;
	private static ArrayList<String> courseList;
	
	private final JLabel stdIDLabel;
	private final JLabel fNameLabel;
	private final JLabel lNameLabel;
	private final JLabel courseLabel;
	
	private final JTextField stdIDTextField;
	private final JTextField fNameTextField;
	private final JTextField lNameTextField;
	private final JTextField courseTextField;
	
	private final JButton addCourseBtn;
	private final JButton saveButton;
	private final JButton submitButton;

	public StudentSavePanel() {
		
		setLayout(new BorderLayout(3,3));
		setBorder(new EmptyBorder(5,5,5,5));
		
		students = new ArrayList<Student>();
		courseList = new ArrayList<String>();
		
		JPanel labels = new JPanel(new GridLayout(0, 1));
		JPanel textFields = new JPanel(new GridLayout(0, 1));
		JPanel buttons = new JPanel(new GridLayout(0, 1));
		
		add(labels, BorderLayout.WEST);
		add(textFields, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
		
		stdIDLabel = new JLabel("Enter student ID");
		labels.add(stdIDLabel);
		
		stdIDTextField = new JTextField(20);
		textFields.add(stdIDTextField);
		
		fNameLabel = new JLabel("Enter first name");
		labels.add(fNameLabel);

		fNameTextField = new JTextField(20);
		textFields.add(fNameTextField);
		
		lNameLabel = new JLabel("Enter last name");
		labels.add(lNameLabel);

		lNameTextField = new JTextField(20);
		textFields.add(lNameTextField);
		
		courseLabel = new JLabel("Enter courses");
		labels.add(courseLabel);
		
		courseTextField = new JTextField(20);
		textFields.add(courseTextField);
		
		addCourseBtn = new JButton("Add more course");
		buttons.add(addCourseBtn);
		
		saveButton = new JButton("Save student");
		buttons.add(saveButton);

		submitButton = new JButton("Submit students");
		buttons.add(submitButton);		
		
		// register event handlers
		AddCourseBtnHandler addCourseHandler = new AddCourseBtnHandler();
		SaveBtnHandler saveHandler = new SaveBtnHandler();
		SubmitBtnHandler submitHandler = new SubmitBtnHandler();
		
		addCourseBtn.addActionListener(addCourseHandler);
		saveButton.addActionListener(saveHandler);
		submitButton.addActionListener(submitHandler);
	}
	
	private void addStudent() {
		Student student = new Student();
		student.setStdID(Integer.parseInt(stdIDTextField.getText()));
		student.setFirstName(fNameTextField.getText());
		student.setLastName(lNameTextField.getText());	
		String course;
		course = courseTextField.getText();
		courseList.add(course);
		student.setCourses(courseList);
		students.add(student);
	}
	
	private void clearTextFields() {
		stdIDTextField.setText("");
		fNameTextField.setText("");
		lNameTextField.setText("");
		courseTextField.setText("");
	}
	
	private class AddCourseBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			String course;
			course = courseTextField.getText();
			courseList.add(course);
			courseTextField.setText("");
		}
	}	
	
	private class SaveBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				addStudent();
				clearTextFields();				
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter the number for student ID.");	
			} catch(IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());	
			} finally {
				courseList.clear();
			}
		}
	}
	
	private class SubmitBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				FileOutputStream fos = new FileOutputStream("file.out");
				BufferedOutputStream bf = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bf);
				
				// if the user has added some students (students ArrayList is not empty)
				// and the TextFields are empty,
				// serialize the students right away			
				if ((stdIDTextField.getText().trim().isEmpty() && fNameTextField.getText().trim().isEmpty() && 
					lNameTextField.getText().trim().isEmpty() && courseTextField.getText().trim().isEmpty()) &&
					!students.isEmpty()) {				
					oos.writeObject(students);
					
				// otherwise, add the student to the ArrayList and serialize it
				} else {
					addStudent();		
					
					oos.writeObject(students);
				}
				
				oos.flush();
				fos.close();
				
				clearTextFields();
				// once students are serialized, students ArrayList is cleared
				students.clear();
				
			} catch(IOException e) {
				JOptionPane.showMessageDialog(null, e);
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter the number for student ID.");
			} catch(IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());	
			} catch(Throwable e) {
				JOptionPane.showMessageDialog(null, e);
			} finally {
				courseList.clear();
			}
		}
	}	
	
}