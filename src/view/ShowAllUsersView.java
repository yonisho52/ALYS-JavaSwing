package view;

import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class ShowAllUsersView extends Observable
{
	private JFrame frame;
	ShowAllApartmentView showAllApartmentView;
	ShowAllUsersView showAllUsersView;
	JPanel panel;
	JTable usersTable;
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
					ShowAllUsersView window = new ShowAllUsersView();
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
	
	public ShowAllUsersView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 821, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(219, 112, 147));
		panel_1.setBounds(0, 0, 803, 377);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05EA\u05E6\u05D5\u05D2\u05EA \u05DE\u05E9\u05EA\u05DE\u05E9\u05D9\u05DD");
		lblNewLabel.setBounds(303, 13, 181, 20);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		panel = new JPanel();
		panel.setBackground(new Color(219, 112, 147));
		panel.setBounds(64, 80, 679, 195);
		panel_1.add(panel);
		
		JButton deleteUserButton = new JButton("\u05DE\u05D7\u05E7");
		deleteUserButton.setBounds(341, 288, 121, 37);
		panel_1.add(deleteUserButton);
		deleteUserButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		deleteUserButton.setForeground(new Color(255, 255, 255));
		deleteUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteUserButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteUser();
			}
		});
		deleteUserButton.setBackground(new Color(169, 169, 169));
		
		JButton returnButton  = new JButton("\u05D7\u05D6\u05D5\u05E8");
		returnButton.setBounds(12, 7, 121, 37);
		panel_1.add(returnButton);
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		returnButton.setForeground(new Color(255, 255, 255));
		returnButton.setBackground(new Color(169, 169, 169));
		
		confirmdeleteLabel = new JLabel("\u05E0\u05DE\u05D7\u05E7 \u05D1\u05D4\u05E6\u05DC\u05D7\u05D4");
		confirmdeleteLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		confirmdeleteLabel.setForeground(new Color(255, 255, 255));
		confirmdeleteLabel.setBounds(351, 333, 121, 14);
		panel_1.add(confirmdeleteLabel);
		returnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAllApartmentView.openShowAllApartment(connectedUser, adminBool, analystBool);
				frame.setVisible(false);
				
			}
		});
	}

	public void deleteUser()
	{
		int index = this.usersTable.getSelectedRow();
		index++;

		
		setChanged();
		notifyObservers(new DeleteUser(index));
		setChanged();
		notifyObservers(new GetAllUsers());
	}
	
	public void showAllUsersView(String userName, boolean admin,boolean analyst) {
		this.adminBool = admin;
		this.connectedUser = userName;
		this.analystBool = analyst;
		this.confirmdeleteLabel.setVisible(false);
		frame.setVisible(true);
		setChanged();
		notifyObservers(new GetAllUsers()); // request to go to the excel file and give me all the users
	}
	
	
	public void crateAllUsers(JTable usersTable1) {
		
//		JFrame tableFrame=new JFrame();
//		//create table
//		JScrollPane scrollPane = new JScrollPane(usersTable);
//		tableFrame.getContentPane().add(scrollPane);
//		tableFrame.setSize(500,700);
//		tableFrame.setVisible(true);
		
		
		this.usersTable = usersTable1;
		JScrollPane scrollPane_1 = new JScrollPane(usersTable);
		panel.add(scrollPane_1);
		this.frame.setVisible(true);
	}
	
	public void confirmUserDelete()
	{
		this.confirmdeleteLabel.setVisible(true);
		this.usersTable.updateUI();
		System.out.println(" deleted ! and also his apartment ");
		
	}
	

	//inner class for the controller
	public class GetAllUsers {
		// controller notify
	}
	
	public class DeleteUser
	{
		public int row;
		public DeleteUser(int index)
		{
			this.row = index;
		}
	}
}