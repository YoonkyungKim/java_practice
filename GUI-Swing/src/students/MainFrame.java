package students;

import java.awt.GridLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = -6565020522310165420L;

	public MainFrame() {
		super("Read or Save Students");
		
		setLayout(new GridLayout(0,2));
		
		StudentSavePanel serializePanel = new StudentSavePanel();		
		add(serializePanel);
		
		StudentReadPanel deserializePanel = new StudentReadPanel();
		add(deserializePanel);
	}
	
	
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(600, 250);
		mainFrame.setVisible(true);
	}
	
}

