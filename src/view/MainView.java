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

public class MainView extends Observable {

	RegisterView registerView;
	ShowAllApartmentView showAllApartmentView;
	
	private JFrame frame;
	private JTextField userNameTextField;
	private JTextField passTextField;
	private JLabel failLabel;
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

	/**
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
			public void mouseClicked(MouseEvent arg0) {

			//	String [] user = {userNameTextField.toString(),passTextField.toString()};
				String [] user = {userNameTextField.getText(),passTextField.getText()};
				System.out.println();
				setChanged();
				notifyObservers(user);
				
			}
		});
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		loginButton.setBounds(284, 264, 97, 25);
		frame.getContentPane().add(loginButton);
		
		JButton registerButton = new JButton("\u05D4\u05D9\u05E8\u05E9\u05DD");
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
		registerButton.setBounds(284, 313, 97, 25);
		frame.getContentPane().add(registerButton);
		
		JButton guestViewButton = new JButton("\u05E6\u05E4\u05D9\u05D9\u05D4 \u05DC\u05DC\u05D0 \u05DE\u05E0\u05D5\u05D9");
		guestViewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {  ////// send to the function down becuase problem with the initialize function
				openShowAllApartment();
			}
		});
		guestViewButton.setBounds(198, 362, 183, 25);
		frame.getContentPane().add(guestViewButton);
		
		JLabel userName = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9");
		userName.setBounds(398, 70, 120, 30);
		frame.getContentPane().add(userName);
		
		JLabel password = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0");
		password.setBounds(408, 120, 56, 16);
		frame.getContentPane().add(password);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(270, 74, 116, 22);
		frame.getContentPane().add(userNameTextField);
		userNameTextField.setColumns(10);
		
		passTextField = new JTextField();
		passTextField.setColumns(10);
		passTextField.setBounds(270, 117, 116, 22);
		frame.getContentPane().add(passTextField);
		
		failLabel = new JLabel("\u05E0\u05DB\u05E9\u05DC");
		failLabel.setBounds(306, 184, 46, 14);
		frame.getContentPane().add(failLabel);
		failLabel.setVisible(false);
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
	public void openShowAllApartment() {  //// this function
		showAllApartmentView.setMainView(this);
		userNameTextField.setText(""); // to eraize the field when you come back
		this.frame.setVisible(false); 
		showAllApartmentView.openShowAllApartment();
	}
	
	public void loginValid(boolean valid)
	{
		if(valid)
		{
			openShowAllApartment(); //////from here send userName
		}
		else
		{
			failLabel.setVisible(true);
		}
	}
}

















