package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;

import view.ShowAllUsersView.DeleteUser;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Panel;

public class ShowUserApartmentView extends Observable 
{
	ShowAllApartmentView showAllApartmentView;
	
	private JFrame frame;
	private JPanel panel;
	private JTable userApartmentsTable;
	JLabel confirmdeleteLabel;
	
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
		frame.setBounds(100, 100, 939, 561);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(119, 136, 153));
		panel_1.setBounds(0, 0, 926, 516);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel showApartmentsLabel = new JLabel("\u05E6\u05E4\u05D9\u05D9\u05D4 \u05D1\u05D3\u05D9\u05E8\u05D5\u05EA \u05DE\u05E9\u05EA\u05DE\u05E9\u05D9\u05DD");
		showApartmentsLabel.setForeground(new Color(255, 255, 255));
		showApartmentsLabel.setBounds(346, 24, 240, 31);
		panel_1.add(showApartmentsLabel);
		showApartmentsLabel.setBackground(Color.BLACK);
		showApartmentsLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		panel.setBounds(12, 80, 892, 334);
		panel_1.add(panel);
		
		JButton backButton = new JButton("\u05D7\u05D6\u05E8\u05D4");
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		backButton.setBounds(12, 26, 163, 31);
		panel_1.add(backButton);
		backButton.setBackground(new Color(169, 169, 169));
		
		JButton editApartmentButton = new JButton("\u05E2\u05E8\u05D5\u05DA \u05D3\u05D9\u05E8\u05D4 \u05DE\u05E1\u05D5\u05DE\u05E0\u05EA");
		editApartmentButton.setBounds(531, 442, 208, 46);
		panel_1.add(editApartmentButton);
		editApartmentButton.setForeground(new Color(255, 255, 255));
		editApartmentButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		editApartmentButton.setBackground(new Color(169, 169, 169));
		
		JButton deleteButton = new JButton("\u05DE\u05D7\u05E7 \u05D3\u05D9\u05E8\u05D4 \u05DE\u05E1\u05D5\u05DE\u05E0\u05EA");
		deleteButton.setBounds(245, 442, 208, 46);
		panel_1.add(deleteButton);
		deleteButton.setForeground(new Color(255, 255, 255));
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				deleteUserApartment();
			}
		});
		deleteButton.setBackground(new Color(169, 169, 169));
		
		confirmdeleteLabel = new JLabel("\u05E0\u05DE\u05D7\u05E7");
		confirmdeleteLabel.setBounds(327, 489, 46, 14);
		panel_1.add(confirmdeleteLabel);
		confirmdeleteLabel.setForeground(new Color(255, 255, 255));
		confirmdeleteLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userApartmentsTable.removeAll();/////////
				panel.removeAll();
				showAllApartmentView.openShowAllApartment(connectedUser, adminBool, analystBool);
				frame.setVisible(false);
			}
		});
	}
	
	public void showShowUserApartmentView(String userName, boolean admin, boolean analyst)
	{
		this.adminBool = admin;
		this.connectedUser = userName;
		this.analystBool = analyst;
		this.confirmdeleteLabel.setVisible(false);
		frame.setVisible(true);
		setChanged();
		notifyObservers(new ShowUserApartments(userName));
	}
	
	public void crateAllUserApartments(JTable userApartments) {
		this.userApartmentsTable = userApartments;
		
		Dimension listSize = new Dimension(500, 500);
		userApartmentsTable.setBounds(10, 159, 1030, 309);
		JScrollPane scrollPane_1 = new JScrollPane(userApartmentsTable);
		scrollPane_1.setBounds(10, 159, 1030, 309);
		panel.add(scrollPane_1);
		this.frame.setVisible(true);
	}
	
	public void confirmApartmentDelete()
	{
		this.userApartmentsTable.removeAll();
		this.panel.removeAll();
		setChanged();
		notifyObservers(new ShowUserApartments(connectedUser));
		this.confirmdeleteLabel.setVisible(true);

		System.out.println(" delete apartment ");
	}
	
	public void deleteUserApartment()
	{
		int index = this.userApartmentsTable.getSelectedRow();
		setChanged();
		notifyObservers(new DeleteUserApartment(connectedUser,index));
	}
	
	/////// inner classes
	
	public class ShowUserApartments
	{
		public String userName;
		public ShowUserApartments(String user)
		{
			this.userName = user;
		}
	}
	
	public class DeleteUserApartment
	{
		public int row;
		public String userName;
		public DeleteUserApartment(String user, int index)
		{
			this.userName = user;
			this.row = index;
		}
	}
}





