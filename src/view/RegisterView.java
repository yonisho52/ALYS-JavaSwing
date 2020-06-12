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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	JTextField passwordLabel;
	private JLabel validatePasswordLabel;
	
	private JLabel existUser;
	private JLabel PasswordEnterLabel_1;
	
	private JLabel mismatchPassword;
	private JLabel star1;
	private JLabel star2;
	private JLabel star3;
	private JLabel star4;
	private JLabel star5;
	private JLabel star6;
	private JLabel missingText;
	
	protected boolean userbool , passwordbool , firstNamebool , lastNamebool , phonebool;
	private JLabel firstnamelable;
	private JLabel lastnamelable;
	private JLabel phonelable;
	

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
	
	public class CheckExsistUser
	{
		public String userNameCheck;
		public CheckExsistUser(String userCheck)
		{
			this.userNameCheck = userCheck;
		}
	}
	
	public class AddUser
	{
		public String [] userName;
		public AddUser(String [] user)
		{
			this.userName = user;
		}
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
		userName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				setChanged();
				notifyObservers(new CheckExsistUser(userName.getText()));
			}
		});
		userName.setBounds(192, 79, 116, 22);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		password = new JTextField();
		password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkIfEmptyPassword();
			}
		});
		password.setBounds(192, 114, 116, 22);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		validatePassword = new JTextField();
		validatePassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
//				if (!(password.getText().equals(validatePassword.getText()) ))
//				{
//					mismatchPassword.setVisible(true);
//				}
				checkIfEmptyPasswordValid();
			}
		});
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
//				String newTenant[] = {userName.getText().toString(),password.getText().toString(),
//						firstName.getText().toString(),lastName.getText().toString(), email.getText().toString(),
//						phoneNumber.getText().toString()};
//				
//				setChanged();
//				notifyObservers(newTenant);
				
				// after login show allApartmentView on the same user that register
				openShowAllApartmentView(arg0);
				

			}
		});
		regButton.setBounds(305, 350, 97, 25);
		frame.getContentPane().add(regButton);
		
		JLabel userNameLabel = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9");
		userNameLabel.setBounds(322, 82, 82, 16);
		frame.getContentPane().add(userNameLabel);
		
		JLabel passwordLabel = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0");
		passwordLabel.setBounds(320, 117, 58, 16);
		frame.getContentPane().add(passwordLabel);
		
		validatePasswordLabel = new JLabel("\u05D0\u05D9\u05DE\u05D5\u05EA \u05E1\u05D9\u05E1\u05DE\u05D0");
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
		phoneNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkIfEmptyphone();
			}
		});
		phoneNumber.setBounds(192, 291, 116, 22);
		frame.getContentPane().add(phoneNumber);
		phoneNumber.setColumns(10);
		
		JLabel firstNameLabel = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9");
		firstNameLabel.setBounds(320, 190, 82, 16);
		frame.getContentPane().add(firstNameLabel);
		
		firstName = new JTextField();
		firstName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkIfEmptyfirstName();
			}
		});
		firstName.setColumns(10);
		firstName.setBounds(192, 184, 116, 22);
		frame.getContentPane().add(firstName);
		
		lastName = new JTextField();
		lastName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkIfEmptylastName();
			}
		});
		lastName.setColumns(10);
		lastName.setBounds(192, 219, 116, 22);
		frame.getContentPane().add(lastName);
		
		JLabel lastNameLabel = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4");
		lastNameLabel.setBounds(320, 225, 82, 16);
		frame.getContentPane().add(lastNameLabel);
		
		JLabel lblNewLabel = new JLabel("\u05D4\u05E8\u05E9\u05DE\u05D4");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(222, 28, 86, 20);
		frame.getContentPane().add(lblNewLabel);
		
		existUser = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9 \u05EA\u05E4\u05D5\u05E1/\u05E8\u05D9\u05E7");
		existUser.setForeground(Color.RED);
		existUser.setBounds(36, 82, 144, 16);
		existUser.setVisible(false);
		existUser.setFont(existUser.getFont().deriveFont(existUser.getFont().getStyle() | Font.BOLD));
		frame.getContentPane().add(existUser);
		
		mismatchPassword = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0 \u05DC\u05D0 \u05EA\u05D5\u05D0\u05DE\u05EA. \u05E8\u05D9\u05E7\u05D4");
		mismatchPassword.setForeground(Color.RED);
		mismatchPassword.setBounds(24, 152, 154, 16);
		mismatchPassword.setVisible(false);
		mismatchPassword.setFont(mismatchPassword.getFont().deriveFont(mismatchPassword.getFont().getStyle() | Font.BOLD));
		frame.getContentPane().add(mismatchPassword);
		
		star1 = new JLabel("*");
		star1.setFont(new Font("Tahoma", Font.BOLD, 17));
		star1.setForeground(Color.RED);
		star1.setBounds(418, 82, 18, 16);
		frame.getContentPane().add(star1);
		
		star2 = new JLabel("*");
		star2.setForeground(Color.RED);
		star2.setFont(new Font("Tahoma", Font.BOLD, 17));
		star2.setBounds(418, 117, 18, 16);
		frame.getContentPane().add(star2);
		
		star3 = new JLabel("*");
		star3.setForeground(Color.RED);
		star3.setFont(new Font("Tahoma", Font.BOLD, 17));
		star3.setBounds(418, 155, 18, 16);
		frame.getContentPane().add(star3);
		
		star4 = new JLabel("*");
		star4.setForeground(Color.RED);
		star4.setFont(new Font("Tahoma", Font.BOLD, 17));
		star4.setBounds(418, 188, 18, 16);
		frame.getContentPane().add(star4);
		
		star5 = new JLabel("*");
		star5.setFont(new Font("Tahoma", Font.BOLD, 17));
		star5.setForeground(Color.RED);
		star5.setBounds(418, 220, 18, 16);
		frame.getContentPane().add(star5);
		
		star6 = new JLabel("*");
		star6.setForeground(Color.RED);
		star6.setFont(new Font("Tahoma", Font.BOLD, 17));
		star6.setBounds(418, 291, 29, 16);
		frame.getContentPane().add(star6);
		
		missingText = new JLabel("\u05E0\u05D0 \u05DC\u05DE\u05DC\u05D0 \u05D0\u05EA \u05D4\u05E4\u05E8\u05D8\u05D9\u05DD \u05D4\u05DE\u05E1\u05D5\u05DE\u05E0\u05D9\u05DD \u05D1\u05DB\u05D5\u05DB\u05D1\u05D9\u05EA!");
		missingText.setForeground(Color.RED);
		missingText.setBounds(142, 321, 260, 16);
		missingText.setVisible(false);
		missingText.setFont(missingText.getFont().deriveFont(missingText.getFont().getStyle() | Font.BOLD));
		frame.getContentPane().add(missingText);
		
		PasswordEnterLabel_1 = new JLabel("\u05D4\u05DB\u05E0\u05E1 \u05E1\u05D9\u05E1\u05DE\u05D0");
		PasswordEnterLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		PasswordEnterLabel_1.setForeground(Color.RED);
		PasswordEnterLabel_1.setBounds(93, 119, 82, 16);
		PasswordEnterLabel_1.setVisible(false);
		frame.getContentPane().add(PasswordEnterLabel_1);
		
		firstnamelable = new JLabel("\u05D4\u05DB\u05E0\u05E1 \u05E9\u05DD \u05E4\u05E8\u05D8\u05D9");
		firstnamelable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		firstnamelable.setForeground(Color.RED);
		firstnamelable.setBounds(78, 190, 97, 16);
		firstnamelable.setVisible(false);
		
		frame.getContentPane().add(firstnamelable);
		
		lastnamelable = new JLabel("\u05D4\u05DB\u05E0\u05E1 \u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4");
		lastnamelable.setForeground(Color.RED);
		lastnamelable.setBounds(59, 222, 116, 16);
		frame.getContentPane().add(lastnamelable);
		lastnamelable.setVisible(false);
		
		phonelable = new JLabel("\u05D4\u05DB\u05E0\u05E1 \u05D8\u05DC\u05E4\u05D5\u05DF");
		phonelable.setForeground(Color.RED);
		phonelable.setBounds(78, 291, 97, 16);
		frame.getContentPane().add(phonelable);
		phonelable.setVisible(false);
	}
	
	public void openShowAllApartmentView(MouseEvent arg0) {
	
		if(firstNamebool && lastNamebool && passwordbool && phonebool && userbool)
		{
			String newTenant[] = {userName.getText().toString(),password.getText().toString(),
			firstName.getText().toString(),lastName.getText().toString(), email.getText().toString(),
			phoneNumber.getText().toString()};
			setChanged();
			notifyObservers(new AddUser(newTenant));
			this.frame.setVisible(false); 
			showAllApartmentView.openShowAllApartment(userName.getText(),false);	
		}
		else 
		{
			
		}
	}
	
	
	public void userValid(boolean exist)   /// exist = false - the user name are free
	{
		if ((exist) || (userName.getText().toString().equals("")))
		{
			this.userbool = false;
			this.existUser.setVisible(true);
		}
		else 
		{
			this.userbool = true;
			existUser.setVisible(false);
		}
	}
	
	public void checkIfEmptyPassword()
	{
		if(password.getText().toString().equals("")) {PasswordEnterLabel_1.setVisible(true);}
		else {PasswordEnterLabel_1.setVisible(false);}
			
	}
	public void checkIfEmptyPasswordValid()
	{
		if (!(password.getText().equals(validatePassword.getText()) ) || validatePassword.getText().toString().equals("") )
		{
			mismatchPassword.setVisible(true);
			this.passwordbool = false;

		}
		else 
			{
				mismatchPassword.setVisible(false);
				this.passwordbool = true;
			}
//		if(validatePassword.getText().toString().equals(""))	
//		{
//			
//			mismatchPassword.setVisible(true);
//		}
			
	}
	
	public void checkIfEmptyfirstName()
	{
		if(firstName.getText().toString().equals(""))	
		{
			firstnamelable.setVisible(true);
			this.firstNamebool = false;
		}
		else
		{
			firstnamelable.setVisible(false);
			this.firstNamebool = true;
		}
			
	}
	
	public void checkIfEmptylastName()
	{
		if(lastName.getText().toString().equals(""))	
		{
			lastnamelable.setVisible(true);
			this.lastNamebool = false;
		}
		else
		{
			lastnamelable.setVisible(false);
			this.lastNamebool = true;
		}
			
	}
	public void checkIfEmptyphone()
	{
		if(phoneNumber.getText().toString().equals(""))	
		{
			phonelable.setVisible(true);
			this.phonebool =false;
		}
		else
		{
			phonelable.setVisible(false);
			this.phonebool =true;
		}
			
	}
}






