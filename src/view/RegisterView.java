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
import javax.swing.JPasswordField;
import java.awt.Panel;
import javax.swing.ImageIcon;

public class RegisterView extends Observable 
{
	MainView mainView;
	ShowAllApartmentView showAllApartmentView;
	
	private JFrame frame;
	private JTextField userName;
	private JPasswordField password;
	private JPasswordField validatePassword;
	private JTextField email;
	private JTextField phoneNumber;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField passwordLabel;
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
	private JLabel firstnamelable;
	private JLabel lastnamelable;
	private JLabel phonelable;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private Panel panel;
	private JLabel userMenPhoto;
	
	protected boolean userbool , passwordbool , firstNamebool , lastNamebool , phonebool;

	
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
	
	public void setMainView(MainView mainView) 
	{
		this.mainView = mainView;
	}
	
	public void showRegisterView() {frame.setVisible(true);}
	
	public RegisterView(ShowAllApartmentView showAllApartmentView) 
	{
		this.showAllApartmentView = showAllApartmentView;
		initialize();
	}
	
	public RegisterView() {
		initialize();
	}

	private void initialize() 
	{
		frame = new JFrame();
		frame.setBackground(new Color(169, 169, 169));
		frame.setBounds(100, 100, 545, 633);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new Panel();
		panel.setBackground(new Color(219, 112, 147));
		panel.setBounds(0, 0, 527, 586);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		userName = new JTextField();
		userName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userName.setBounds(196, 196, 130, 28);
		panel.add(userName);
		userName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				setChanged();
				notifyObservers(new CheckExsistUser(userName.getText()));
			}
		});
		userName.setColumns(10);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password.setBounds(196, 231, 130, 28);
		panel.add(password);
		password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkIfEmptyPassword();
			}
		});
		password.setColumns(10);
		
		validatePassword = new JPasswordField();
		validatePassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		validatePassword.setBounds(196, 266, 130, 28);
		panel.add(validatePassword);
		validatePassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				checkIfEmptyPasswordValid();
			}
		});
		validatePassword.setColumns(10);
		
		JLabel userNameLabel = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9");
		userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		userNameLabel.setForeground(new Color(255, 255, 255));
		userNameLabel.setBounds(346, 198, 100, 16);
		panel.add(userNameLabel);
		
		JLabel passwordLabel_1 = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0");
		passwordLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordLabel_1.setForeground(new Color(255, 255, 255));
		passwordLabel_1.setBounds(344, 233, 58, 16);
		panel.add(passwordLabel_1);
		
		validatePasswordLabel = new JLabel("\u05D0\u05D9\u05DE\u05D5\u05EA \u05E1\u05D9\u05E1\u05DE\u05D0");
		validatePasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		validatePasswordLabel.setForeground(new Color(255, 255, 255));
		validatePasswordLabel.setBounds(344, 271, 97, 16);
		panel.add(validatePasswordLabel);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		email.setBounds(196, 373, 130, 28);
		panel.add(email);
		email.setColumns(10);
		
		JLabel emailLabel = new JLabel("\u05D0\u05D9\u05DE\u05D9\u05D9\u05DC");
		emailLabel.setForeground(new Color(255, 255, 255));
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailLabel.setBounds(346, 378, 56, 16);
		panel.add(emailLabel);
		
		JLabel phoneLabel = new JLabel("\u05E4\u05DC\u05D0\u05E4\u05D5\u05DF");
		phoneLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		phoneLabel.setForeground(new Color(255, 255, 255));
		phoneLabel.setBounds(346, 407, 56, 16);
		panel.add(phoneLabel);
		
		phoneNumber = new JTextField();
		phoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phoneNumber.setBounds(196, 408, 130, 28);
		panel.add(phoneNumber);
		phoneNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkIfEmptyphone();
			}
		});
		phoneNumber.setColumns(10);
		
		JLabel firstNameLabel = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9");
		firstNameLabel.setForeground(new Color(255, 255, 255));
		firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		firstNameLabel.setBounds(344, 306, 82, 16);
		panel.add(firstNameLabel);
		
		firstName = new JTextField();
		firstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstName.setBounds(196, 301, 130, 28);
		panel.add(firstName);
		firstName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkIfEmptyfirstName();
			}
		});
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastName.setBounds(196, 336, 130, 28);
		panel.add(lastName);
		lastName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkIfEmptylastName();
			}
		});
		lastName.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4");
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lastNameLabel.setForeground(new Color(255, 255, 255));
		lastNameLabel.setBounds(344, 341, 82, 16);
		panel.add(lastNameLabel);
		
		JLabel lblNewLabel = new JLabel("\u05D4\u05E8\u05E9\u05DE\u05D4");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(217, 135, 81, 36);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		existUser = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9 \u05EA\u05E4\u05D5\u05E1/\u05E8\u05D9\u05E7");
		existUser.setBounds(40, 199, 144, 16);
		panel.add(existUser);
		existUser.setForeground(Color.RED);
		existUser.setVisible(false);
		existUser.setFont(existUser.getFont().deriveFont(existUser.getFont().getStyle() | Font.BOLD));
		
		mismatchPassword = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0 \u05DC\u05D0 \u05EA\u05D5\u05D0\u05DE\u05EA. \u05E8\u05D9\u05E7\u05D4");
		mismatchPassword.setBounds(28, 269, 154, 16);
		panel.add(mismatchPassword);
		mismatchPassword.setForeground(Color.RED);
		mismatchPassword.setVisible(false);
		mismatchPassword.setFont(mismatchPassword.getFont().deriveFont(mismatchPassword.getFont().getStyle() | Font.BOLD));
		
		star1 = new JLabel("*");
		star1.setBounds(450, 198, 18, 16);
		panel.add(star1);
		star1.setFont(new Font("Tahoma", Font.BOLD, 17));
		star1.setForeground(Color.RED);
		
		star2 = new JLabel("*");
		star2.setBounds(450, 233, 18, 16);
		panel.add(star2);
		star2.setForeground(Color.RED);
		star2.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		star3 = new JLabel("*");
		star3.setBounds(450, 271, 18, 16);
		panel.add(star3);
		star3.setForeground(Color.RED);
		star3.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		star4 = new JLabel("*");
		star4.setBounds(450, 304, 18, 16);
		panel.add(star4);
		star4.setForeground(Color.RED);
		star4.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		star5 = new JLabel("*");
		star5.setBounds(450, 336, 18, 16);
		panel.add(star5);
		star5.setFont(new Font("Tahoma", Font.BOLD, 17));
		star5.setForeground(Color.RED);
		
		star6 = new JLabel("*");
		star6.setBounds(450, 407, 16, 16);
		panel.add(star6);
		star6.setForeground(Color.RED);
		star6.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		missingText = new JLabel("\u05E0\u05D0 \u05DC\u05DE\u05DC\u05D0 \u05D0\u05EA \u05D4\u05E4\u05E8\u05D8\u05D9\u05DD \u05D4\u05DE\u05E1\u05D5\u05DE\u05E0\u05D9\u05DD \u05D1\u05DB\u05D5\u05DB\u05D1\u05D9\u05EA!");
		missingText.setBounds(142, 446, 260, 16);
		panel.add(missingText);
		missingText.setForeground(Color.RED);
		missingText.setVisible(false);
		missingText.setFont(missingText.getFont().deriveFont(missingText.getFont().getStyle() | Font.BOLD));
		
		PasswordEnterLabel_1 = new JLabel("\u05D4\u05DB\u05E0\u05E1 \u05E1\u05D9\u05E1\u05DE\u05D0");
		PasswordEnterLabel_1.setBounds(97, 236, 82, 16);
		panel.add(PasswordEnterLabel_1);
		PasswordEnterLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		PasswordEnterLabel_1.setForeground(Color.RED);
		
		firstnamelable = new JLabel("\u05D4\u05DB\u05E0\u05E1 \u05E9\u05DD \u05E4\u05E8\u05D8\u05D9");
		firstnamelable.setBounds(82, 307, 97, 16);
		panel.add(firstnamelable);
		firstnamelable.setFont(new Font("Tahoma", Font.BOLD, 13));
		firstnamelable.setForeground(Color.RED);
		
		lastnamelable = new JLabel("\u05D4\u05DB\u05E0\u05E1 \u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4");
		lastnamelable.setBounds(63, 339, 116, 16);
		panel.add(lastnamelable);
		lastnamelable.setFont(new Font("Tahoma", Font.BOLD, 13));
		lastnamelable.setForeground(Color.RED);
		
		phonelable = new JLabel("\u05D4\u05DB\u05E0\u05E1 \u05D8\u05DC\u05E4\u05D5\u05DF \u05EA\u05E7\u05D9\u05DF");
		phonelable.setBounds(62, 413, 116, 16);
		panel.add(phonelable);
		phonelable.setFont(new Font("Tahoma", Font.BOLD, 13));
		phonelable.setForeground(Color.RED);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(74, 351, 56, 16);
		panel.add(lblNewLabel_1);
		
		JButton regButton = new JButton("\u05D4\u05D9\u05E8\u05E9\u05DD");
		regButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		regButton.setForeground(new Color(255, 255, 255));
		regButton.setBounds(196, 473, 120, 50);
		panel.add(regButton);
		regButton.setBackground(new Color(169, 169, 169));
		
		JButton cancelButton = new JButton("\u05D7\u05D6\u05D5\u05E8");
		cancelButton.setForeground(new Color(255, 255, 255));
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		cancelButton.setBounds(11, 14, 97, 36);
		panel.add(cancelButton);
		cancelButton.setBackground(new Color(169, 169, 169));
		
		userMenPhoto = new JLabel("");
		userMenPhoto.setIcon(new ImageIcon(RegisterView.class.getResource("/Images/icons8-male-user-100.png")));
		userMenPhoto.setBounds(206, 22, 104, 100);
		panel.add(userMenPhoto);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainView.showMainView();
				frame.setVisible(false);
				resetRegisterForm();
			}
		});
		regButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		regButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				openShowAllApartmentView(arg0);
			}
		});
		phonelable.setVisible(false);
		lastnamelable.setVisible(false);
		firstnamelable.setVisible(false);
		PasswordEnterLabel_1.setVisible(false);
		
	}
	
	public void openShowAllApartmentView(MouseEvent arg0)
	{
		if(firstNamebool && lastNamebool && passwordbool && phonebool && userbool)
		{
			String newTenant[] = {userName.getText().toString(),password.getText().toString(),
			firstName.getText().toString(),lastName.getText().toString(), email.getText().toString(),
			phoneNumber.getText().toString()};
			setChanged();
			notifyObservers(new AddUser(newTenant));
			this.frame.setVisible(false); 
			showAllApartmentView.openShowAllApartment(userName.getText(),false,false);	
		}
		
		else 
		{
			missingText.setVisible(true);
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
	
	public void resetRegisterForm()
	{
		userName.setText("");
		password.setText("");
		validatePassword.setText("");
		email.setText("");
		phoneNumber.setText("");
		firstName.setText("");
		lastName.setText("");
		mismatchPassword.setVisible(false);
		phonelable.setVisible(false);
		existUser.setVisible(false);
		PasswordEnterLabel_1.setVisible(false);
		firstnamelable.setVisible(false);
		lastnamelable.setVisible(false);
		missingText.setVisible(false);
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
			
		for(int i=0 ; i < phoneNumber.getText().length(); i++)
		{
			String arr = phoneNumber.getText();
			if(arr.charAt(i) < '0' || arr.charAt(i) > '9')
			{
				phonelable.setVisible(true);
				this.phonebool = false;
			}
		}
	}


	////// inner classes 
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
	
}