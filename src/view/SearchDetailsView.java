package view;

import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;

import view.ShowAllUsersView.GetAllUsers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;

public class SearchDetailsView extends Observable {
	
	ShowAllApartmentView showAllApartmentView;
	

	private JFrame frame;
	private JPanel panel;
	protected String connectedUser;
	protected boolean adminBool;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchDetailsView window = new SearchDetailsView();
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
	
	public SearchDetailsView(ShowAllApartmentView showAllApartmentView) {
	
		this.showAllApartmentView = showAllApartmentView;
		initialize();
	}
	
	public void showSearchDetailsView(String userName, boolean admin)
	{
		this.adminBool = admin;
		this.connectedUser = userName;
		frame.setVisible(true);
		setChanged();
		notifyObservers(new TopApartment()); // request to go to the excel file and give me all the users
		//this.frame.setEnabled(true);
	}
	public SearchDetailsView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 653, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel mostSearchedApartmentsLabel = new JLabel("\u05D4\u05D3\u05D9\u05E8\u05D5\u05EA \u05E9\u05D7\u05D9\u05E4\u05E9\u05D5 \u05D4\u05DB\u05D9 \u05D4\u05E8\u05D1\u05D4");
		mostSearchedApartmentsLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		mostSearchedApartmentsLabel.setBounds(186, 16, 255, 21);
		frame.getContentPane().add(mostSearchedApartmentsLabel);
		
		JButton backButton = new JButton("\u05D7\u05D6\u05E8\u05D4");
		backButton.setBackground(Color.PINK);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAllApartmentView.openShowAllApartment(connectedUser, adminBool); ///////////////
				frame.setVisible(false);
			}
		});
		backButton.setBounds(91, 107, 97, 25);
		frame.getContentPane().add(backButton);
		
		JButton printButton = new JButton("\u05D4\u05D3\u05E4\u05E1");
		printButton.setBackground(Color.PINK);
		printButton.setBounds(406, 107, 97, 25);
		frame.getContentPane().add(printButton);
		
		panel = new JPanel();
		panel.setBounds(40, 147, 564, 270);
		frame.getContentPane().add(panel);
	}
	
	public class TopApartment
	{
		
	}
	
	
	
	
}
