package students;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class StudentReadPanel extends JPanel {

	private static final long serialVersionUID = 3572328774697580822L;

	private static ArrayList<Student> students;

	private final JTextArea readStudentsArea;
	private final JButton readBtn;

	public StudentReadPanel() {
		students = new ArrayList<Student>();
		
		setLayout(new BorderLayout(3,3));
		setBorder(new EmptyBorder(5,5,5,5));
		
		JPanel textAreaPanel = new JPanel(new GridLayout(0, 1));
		JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
		
		readStudentsArea = new JTextArea();
		readBtn = new JButton("Read students");
		
		buttonPanel.add(readBtn);
		add(buttonPanel, BorderLayout.NORTH);

		textAreaPanel.add(new JScrollPane(readStudentsArea));	     
		add(textAreaPanel, BorderLayout.CENTER);
		
		ReadBtnHandler readBtnHandler = new ReadBtnHandler();
		readBtn.addActionListener(readBtnHandler);
	}
	
	private class ReadBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				// clear previous content of the readStudentsArea to avoid appending the text
				readStudentsArea.setText("");
				
				FileInputStream fis = new FileInputStream("file.out");
			
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				students = (ArrayList<Student>)ois.readObject();
							
				fis.close();
				
				if (students.isEmpty() == false) {
					for (int i = 0; i < students.size(); i++) {
						readStudentsArea.append("Student ID: " + Integer.toString(students.get(i).getStdID()) + "\n");
						readStudentsArea.append("First name: " + students.get(i).getFirstName() + "\n");
						readStudentsArea.append("Last name: " + students.get(i).getLastName() + "\n");
						readStudentsArea.append("Courses the student takes: " + students.get(i).getCourses() + "\n\n");							
					}
				} else {
					readStudentsArea.append("No students in the file.");
				}

				readStudentsArea.setEditable(false);
				 
			} catch (EOFException e) {
				JOptionPane.showMessageDialog(null, "No students to read.");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e);
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, e);
			} catch(Throwable e) {
				JOptionPane.showMessageDialog(null, e);
			}		
		}
	}
}



