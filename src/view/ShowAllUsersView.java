package view;

import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class ShowAllUsersView extends Observable{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAllUsersView window = new ShowAllUsersView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShowAllUsersView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 821, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton deleteUserButton = new JButton("\u05DE\u05D7\u05E7");
		deleteUserButton.setBounds(136, 332, 97, 25);
		frame.getContentPane().add(deleteUserButton);
		
		JButton returnButton = new JButton("\u05D7\u05D6\u05D5\u05E8");
		returnButton.setBounds(27, 332, 97, 25);
		frame.getContentPane().add(returnButton);
		
		JFormattedTextField usersTextField = new JFormattedTextField();
		usersTextField.setBounds(45, 76, 697, 222);
		frame.getContentPane().add(usersTextField);
	}
}
