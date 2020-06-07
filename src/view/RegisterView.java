package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import javax.swing.JLabel;

public class RegisterView extends Observable{

	MainView mainView;
	ShowAllApartmentView showAllApartmentView;
	
	private JFrame frame;
	private JTextField userName;
	private JTextField password;
	private JTextField validatePassword;
	private JTextField email;
	private JTextField PhoneNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView window = new RegisterView();
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
	public void setMainView(MainView mainView) 
	{
		this.mainView = mainView;
	}
	public void showRegisterView() {frame.setVisible(true);}
	public RegisterView(ShowAllApartmentView showAllApartmentView) {
		this.showAllApartmentView = showAllApartmentView;
		initialize();
	}
	public RegisterView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 567, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton cancelButton = new JButton("\u05D1\u05D9\u05D8\u05D5\u05DC");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainView.showMainView();
				frame.setVisible(false);
			}
		});
		cancelButton.setBounds(119, 305, 97, 25);
		frame.getContentPane().add(cancelButton);
		
		userName = new JTextField();
		userName.setBounds(192, 79, 116, 22);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		password = new JTextField();
		password.setBounds(192, 114, 116, 22);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		validatePassword = new JTextField();
		validatePassword.setBounds(192, 149, 116, 22);
		frame.getContentPane().add(validatePassword);
		validatePassword.setColumns(10);
		
		JButton regButton = new JButton("\u05D4\u05D9\u05E8\u05E9\u05DD");
		regButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String users[] = {userName.getText().toString(),password.getText().toString()};
				setChanged();
				notifyObservers(users);
			}
		});
		regButton.setBounds(305, 305, 97, 25);
		frame.getContentPane().add(regButton);
		
		JLabel userNameLabel = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9");
		userNameLabel.setBounds(322, 82, 80, 16);
		frame.getContentPane().add(userNameLabel);
		
		JLabel passwordLabel = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0");
		passwordLabel.setBounds(320, 117, 58, 16);
		frame.getContentPane().add(passwordLabel);
		
		JLabel validatePasswordLabel = new JLabel("\u05D0\u05D9\u05DE\u05D5\u05EA \u05E1\u05D9\u05E1\u05DE\u05D0");
		validatePasswordLabel.setBounds(320, 155, 82, 16);
		frame.getContentPane().add(validatePasswordLabel);
		
		email = new JTextField();
		email.setBounds(192, 184, 116, 22);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel EmailLabel = new JLabel("\u05D0\u05D9\u05DE\u05D9\u05D9\u05DC");
		EmailLabel.setBounds(322, 190, 56, 16);
		frame.getContentPane().add(EmailLabel);
		
		JLabel phoneLabel = new JLabel("\u05E4\u05DC\u05D0\u05E4\u05D5\u05DF");
		phoneLabel.setBounds(322, 219, 56, 16);
		frame.getContentPane().add(phoneLabel);
		
		PhoneNumber = new JTextField();
		PhoneNumber.setBounds(192, 219, 116, 22);
		frame.getContentPane().add(PhoneNumber);
		PhoneNumber.setColumns(10);
	}
}
