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
import java.awt.Panel;
import javax.swing.ImageIcon;

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
	
//	public class CreateAllApartmentTable {
//		// for the controller 
//	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 805, 594);
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setChanged();
				notifyObservers(new CloseTheExcel());
				System.exit(0);
			}
		});

		frame.getContentPane().setLayout(null);
		
		Panel panelMainDark = new Panel();
		panelMainDark.setBackground(new Color(0, 153, 204));
		panelMainDark.setBounds(0, 0, 390, 547);
		frame.getContentPane().add(panelMainDark);
		panelMainDark.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(384, 0, 403, 547);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton loginButton = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8\u05D5\u05EA");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setBounds(64, 241, 201, 38);
		panel.add(loginButton);
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//	String [] user = {userNameTextField.toString(),passTextField.toString()};
				String [] user = {userNameTextField.getText(),passTextField.getText()};
				setChanged();
				notifyObservers(user);
			}
		});
		loginButton.setBackground(new Color(0, 153, 204));
		
		passTextField = new JPasswordField();
		passTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passTextField.setBackground(new Color(255, 255, 255));
		passTextField.setBounds(83, 187, 149, 30);
		panel.add(passTextField);
		passTextField.setColumns(10);
		
		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userNameTextField.setBackground(new Color(255, 255, 255));
		userNameTextField.setBounds(83, 144, 149, 30);
		panel.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JLabel userName = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9");
		userName.setFont(new Font("Tahoma", Font.BOLD, 16));
		userName.setForeground(new Color(255, 255, 255));
		userName.setBounds(244, 143, 100, 30);
		panel.add(userName);
		
		JLabel password = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0");
		password.setFont(new Font("Tahoma", Font.BOLD, 16));
		password.setForeground(new Color(255, 255, 255));
		password.setBounds(246, 193, 63, 16);
		panel.add(password);
		
		failLabel = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9 \u05D0\u05D5 \u05E1\u05D9\u05E1\u05DE\u05D0 \u05DC\u05D0 \u05E0\u05DB\u05D5\u05E0\u05D9\u05DD");
		failLabel.setBounds(83, 291, 169, 16);
		panel.add(failLabel);
		failLabel.setForeground(Color.RED);
		failLabel.setVisible(false);
		failLabel.setFont(failLabel.getFont().deriveFont(failLabel.getFont().getStyle() | Font.BOLD));
		
		JButton registerButton = new JButton("\u05D4\u05D9\u05E8\u05E9\u05DD");
		registerButton.setBounds(122, 426, 143, 38);
		panel.add(registerButton);
		registerButton.setForeground(new Color(255, 255, 255));
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		registerButton.setBackground(new Color(0, 153, 204));
		
		JLabel lblNewLabel = new JLabel("\u05E2\u05D3\u05D9\u05D9\u05DF \u05DC\u05D0 \u05E0\u05E8\u05E9\u05DE\u05EA?");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(122, 393, 143, 20);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton guestViewButton = new JButton("\u05E6\u05E4\u05D9\u05D9\u05D4 \u05DC\u05DC\u05D0 \u05DE\u05E0\u05D5\u05D9");
		guestViewButton.setBounds(242, 13, 149, 30);
		panel.add(guestViewButton);
		guestViewButton.setForeground(new Color(255, 255, 255));
		guestViewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		guestViewButton.setBackground(new Color(0, 153, 204));
		guestViewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {  ////// send to the function down becuase problem with the initialize function
				openShowAllApartment(null,false,false);
			}
		});
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
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
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
	
	public void openShowAllApartment(String userName, boolean userType, boolean analyst) {  //// userType - true = admin
		showAllApartmentView.setMainView(this);
		userNameTextField.setText(""); // to eraize the field when you come back
		passTextField.setText("");
		this.frame.setVisible(false); 
		showAllApartmentView.openShowAllApartment(userName,userType,analyst);
//		setChanged();
//		notifyObservers(new CreateAllApartmentTable());
		
	}
	
	public void loginValid(boolean valid, boolean admin, boolean analyst) {
		
		if(valid)
		{
			openShowAllApartment(userNameTextField.getText(),admin,analyst); //////from here send userName
		}
		else
		{
			failLabel.setVisible(true);
		}
		
	}
}
