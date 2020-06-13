package view;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

public class MainView extends Observable {

	RegisterView registerView;
	ShowAllApartmentView showAllApartmentView;
	
	private JFrame frame;
	private JTextField userNameTextField;
	private JPasswordField passTextField;
	JLabel failLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the application.
	 */
	
	public MainView(RegisterView registerView,ShowAllApartmentView showAllApartmentView) {
		this.registerView = registerView;
		this.showAllApartmentView = showAllApartmentView;
		initialize();
		try {
			//MainView window = new MainView();
			this.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public MainView() {
		
		
	
		initialize();
	}

	public class CloseTheExcel {
		// for the controller 
	}
	
	public class CreateAllApartmentTable {
		// for the controller 
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 674, 472);
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setChanged();
				notifyObservers(new CloseTheExcel());
				System.exit(0);
			}
		});

		frame.getContentPane().setLayout(null);
		
		JButton loginButton = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8\u05D5\u05EA");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//	String [] user = {userNameTextField.toString(),passTextField.toString()};
				String [] user = {userNameTextField.getText(),passTextField.getText()};
				setChanged();
				notifyObservers(user);
			}
		});
		loginButton.setBackground(Color.PINK);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		loginButton.setBounds(224, 175, 169, 25);
		frame.getContentPane().add(loginButton);
		
		JButton registerButton = new JButton("\u05D4\u05D9\u05E8\u05E9\u05DD");
		registerButton.setBackground(Color.PINK);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				openRegisterView(arg0);
			}
		});
		registerButton.setBounds(212, 313, 169, 25);
		frame.getContentPane().add(registerButton);
		
		JButton guestViewButton = new JButton("\u05E6\u05E4\u05D9\u05D9\u05D4 \u05DC\u05DC\u05D0 \u05DE\u05E0\u05D5\u05D9");
		guestViewButton.setBackground(Color.PINK);
		guestViewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {  ////// send to the function down becuase problem with the initialize function
				openShowAllApartment(null,false);
			}
		});
		guestViewButton.setBounds(212, 362, 169, 25);
		frame.getContentPane().add(guestViewButton);
		
		JLabel userName = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9");
		userName.setBounds(343, 74, 120, 30);
		frame.getContentPane().add(userName);
		
		JLabel password = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0");
		password.setBounds(364, 120, 56, 16);
		frame.getContentPane().add(password);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(212, 74, 116, 22);
		frame.getContentPane().add(userNameTextField);
		userNameTextField.setColumns(10);
		
		passTextField = new JPasswordField();
		passTextField.setColumns(10);
		passTextField.setBounds(212, 117, 116, 22);
		frame.getContentPane().add(passTextField);
		
		JLabel lblNewLabel = new JLabel("\u05E2\u05D3\u05D9\u05D9\u05DF \u05DC\u05D0 \u05E0\u05E8\u05E9\u05DE\u05EA?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(224, 280, 157, 20);
		frame.getContentPane().add(lblNewLabel);
		
		failLabel = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9 \u05D0\u05D5 \u05E1\u05D9\u05E1\u05DE\u05D0 \u05DC\u05D0 \u05E0\u05DB\u05D5\u05E0\u05D9\u05DD");
		failLabel.setBounds(193, 224, 169, 16);
		failLabel.setForeground(Color.RED);
		failLabel.setVisible(false);
		failLabel.setFont(failLabel.getFont().deriveFont(failLabel.getFont().getStyle() | Font.BOLD));
		frame.getContentPane().add(failLabel);
	}

	protected void openRegisterView(MouseEvent arg0) {
		registerView.setMainView(this); //know who is the main view- in order to come back later
	//	this.frame.setVisible(false);
		this.frame.setEnabled(false); // lock the 'this' (main) window
		registerView.showRegisterView();
	}
	public void showMainView() {
		frame.setVisible(true);
		this.frame.setEnabled(true);
	}
	
	public void openShowAllApartment(String userName, boolean userType) {  //// userType - true = admin
		showAllApartmentView.setMainView(this);
		userNameTextField.setText(""); // to eraize the field when you come back
		passTextField.setText("");
		this.frame.setVisible(false); 
		showAllApartmentView.openShowAllApartment(userName,userType);
		setChanged();
		notifyObservers(new CreateAllApartmentTable());
		
	}
	
	public void loginValid(boolean valid, boolean admin) {
		
		if(valid)
		{
			openShowAllApartment(userNameTextField.getText(),admin); //////from here send userName
		}
		else
		{
			failLabel.setVisible(true);
		}
		
	}
}
