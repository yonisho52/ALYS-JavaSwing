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

public class RegisterView extends Observable{

	MainView mainView;
	ShowAllApartmentView showAllApartmentView;
	
	private JFrame frame;
	private JTextField userName;
	private JTextField password;
	private JTextField textField_2;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u05D1\u05D9\u05D8\u05D5\u05DC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainView.showMainView();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(176, 186, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		userName = new JTextField();
		userName.setBounds(135, 52, 116, 22);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		password = new JTextField();
		password.setBounds(135, 87, 116, 22);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(135, 122, 116, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton regButton = new JButton("\u05D4\u05D9\u05E8\u05E9\u05DD");
		regButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String users[] = {userName.getText().toString(),password.getText().toString()};
				setChanged();
				notifyObservers(users);
			}
		});
		regButton.setBounds(49, 186, 97, 25);
		frame.getContentPane().add(regButton);
	}

}
