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
import java.awt.Font;
import java.awt.Color;

public class RegisterView extends Observable {

	MainView mainView;
	ShowAllApartmentView showAllApartmentView;
	
	private JFrame frame;
	private JTextField userName;
	private JTextField password;
	private JTextField validatePassword;
	private JTextField email;
	private JTextField phoneNumber;
	private JTextField firstName;
	private JTextField lastName;

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
	//check push
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
		
		JButton cancelButton = new JButton("\u05D7\u05D6\u05D5\u05E8");
		cancelButton.setBackground(Color.PINK);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainView.showMainView();
				frame.setVisible(false);
			}
		});
		
		cancelButton.setBounds(119, 350, 97, 25);
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
		regButton.setBackground(Color.PINK);
		regButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		regButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String newTenant[] = {userName.getText().toString(),password.getText().toString(),
						firstName.getText().toString(),lastName.getText().toString(), email.getText().toString(),
						phoneNumber.getText().toString()};
				setChanged();
				notifyObservers(newTenant);
				
				// after login show allApartmentView on the same user that register
				openShowAllApartmentView(arg0);

			}
		});
		regButton.setBounds(305, 350, 97, 25);
		frame.getContentPane().add(regButton);
		
		JLabel userNameLabel = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9");
		userNameLabel.setBounds(322, 82, 116, 16);
		frame.getContentPane().add(userNameLabel);
		
		JLabel passwordLabel = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0");
		passwordLabel.setBounds(320, 117, 58, 16);
		frame.getContentPane().add(passwordLabel);
		
		JLabel validatePasswordLabel = new JLabel("\u05D0\u05D9\u05DE\u05D5\u05EA \u05E1\u05D9\u05E1\u05DE\u05D0");
		validatePasswordLabel.setBounds(320, 155, 97, 16);
		frame.getContentPane().add(validatePasswordLabel);
		
		email = new JTextField();
		email.setBounds(192, 256, 116, 22);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel emailLabel = new JLabel("\u05D0\u05D9\u05DE\u05D9\u05D9\u05DC");
		emailLabel.setBounds(322, 262, 56, 16);
		frame.getContentPane().add(emailLabel);
		
		JLabel phoneLabel = new JLabel("\u05E4\u05DC\u05D0\u05E4\u05D5\u05DF");
		phoneLabel.setBounds(322, 291, 56, 16);
		frame.getContentPane().add(phoneLabel);
		
		phoneNumber = new JTextField();
		phoneNumber.setBounds(192, 291, 116, 22);
		frame.getContentPane().add(phoneNumber);
		phoneNumber.setColumns(10);
		
		JLabel firstNameLabel = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9");
		firstNameLabel.setBounds(320, 190, 82, 16);
		frame.getContentPane().add(firstNameLabel);
		
		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(192, 184, 116, 22);
		frame.getContentPane().add(firstName);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(192, 219, 116, 22);
		frame.getContentPane().add(lastName);
		
		JLabel lastNameLabel = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4");
		lastNameLabel.setBounds(320, 225, 118, 16);
		frame.getContentPane().add(lastNameLabel);
		
		JLabel lblNewLabel = new JLabel("\u05D4\u05E8\u05E9\u05DE\u05D4");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(222, 28, 86, 20);
		frame.getContentPane().add(lblNewLabel);
	}
	
	public void openShowAllApartmentView(MouseEvent arg0) {
	
		this.frame.setVisible(false); 
		showAllApartmentView.openShowAllApartment(userName.getText(),false);
	}
}
