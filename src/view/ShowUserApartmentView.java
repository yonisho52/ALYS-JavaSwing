package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;

import view.ShowAllUsersView.GetAllUsers;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ShowUserApartmentView extends Observable {


	ShowAllApartmentView showAllApartmentView;
	
	private JFrame frame;
	private JPanel panel;
	
	protected String connectedUser;
	protected boolean adminBool;
	protected boolean analystBool;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowUserApartmentView window = new ShowUserApartmentView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setShowAllApartmentView(ShowAllApartmentView showAllApartmentView)
	{
		this.showAllApartmentView = showAllApartmentView;
	}
	
	/**
	 * Create the application.
	 */
	public ShowUserApartmentView(ShowAllApartmentView showAllApartmentView) {
		

		this.showAllApartmentView = showAllApartmentView;
		initialize();
	}
	
	public ShowUserApartmentView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1066, 586);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel showApartmentsLabel = new JLabel("\u05E6\u05E4\u05D9\u05D9\u05D4 \u05D1\u05D3\u05D9\u05E8\u05D5\u05EA \u05DE\u05E9\u05EA\u05DE\u05E9\u05D9\u05DD");
		showApartmentsLabel.setBackground(Color.BLACK);
		showApartmentsLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		showApartmentsLabel.setBounds(198, 30, 214, 31);
		frame.getContentPane().add(showApartmentsLabel);
		
		JButton backButton = new JButton("\u05D7\u05D6\u05E8\u05D4");
		backButton.setBackground(Color.PINK);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAllApartmentView.openShowAllApartment(connectedUser, adminBool, analystBool); /////////////////
				frame.setVisible(false);
			}
		});
		backButton.setBounds(40, 495, 97, 25);
		frame.getContentPane().add(backButton);
		
		JButton editApartmentButton = new JButton("\u05E2\u05E8\u05D5\u05DA \u05D3\u05D9\u05E8\u05D4 \u05DE\u05E1\u05D5\u05DE\u05E0\u05EA");
		editApartmentButton.setBackground(Color.PINK);
		editApartmentButton.setBounds(403, 102, 194, 23);
		frame.getContentPane().add(editApartmentButton);
		
		JButton deleteButton = new JButton("\u05DE\u05D7\u05E7 \u05D3\u05D9\u05E8\u05D4 \u05DE\u05E1\u05D5\u05DE\u05E0\u05EA");
		deleteButton.setBackground(Color.PINK);
		deleteButton.setBounds(28, 100, 194, 25);
		frame.getContentPane().add(deleteButton);
		
		panel = new JPanel();
		panel.setBounds(10, 159, 1030, 309);
		frame.getContentPane().add(panel);
	}
	
	public void showShowUserApartmentView(String userName, boolean admin, boolean analyst)
	{
		this.adminBool = admin;
		this.connectedUser = userName;
		this.analystBool = analyst;
		frame.setVisible(true);
		setChanged();
		notifyObservers(userName);
	}
	
	
	
	public void crateAllUserApartments(JTable usersTable) {
		Dimension listSize = new Dimension(500, 500);
		usersTable.setBounds(10, 159, 1030, 309);
		JScrollPane scrollPane_1 = new JScrollPane(usersTable);
		scrollPane_1.setBounds(10, 159, 1030, 309);
		panel.add(scrollPane_1);
		this.frame.setVisible(true);
	}
	
	//inner class for the controller
//	public class GetAllUserApartment {
//		// controller notify
//		
//	}
	
	
}
