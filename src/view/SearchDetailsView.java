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
import javax.swing.JScrollPane;
import java.awt.Panel;

public class SearchDetailsView extends Observable 
{
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
	
	public void showSearchDetailsView(String userName, boolean admin, boolean analyst)
	{
		this.adminBool = admin;
		this.connectedUser = userName;
		this.analystBool = analyst;
		frame.setVisible(true);
		setChanged();
		notifyObservers(new TopApartment()); 
	}
	public SearchDetailsView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 751, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(219, 112, 147));
		panel_1.setBounds(0, 0, 741, 489);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel mostSearchedApartmentsLabel = new JLabel("\u05D4\u05D3\u05D9\u05E8\u05D5\u05EA \u05E9\u05D7\u05D9\u05E4\u05E9\u05D5 \u05D4\u05DB\u05D9 \u05D4\u05E8\u05D1\u05D4");
		mostSearchedApartmentsLabel.setForeground(new Color(255, 255, 255));
		mostSearchedApartmentsLabel.setBounds(236, 13, 238, 21);
		panel_1.add(mostSearchedApartmentsLabel);
		mostSearchedApartmentsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		panel = new JPanel();
		panel.setBackground(new Color(219, 112, 147));
		panel.setBounds(94, 47, 564, 299);
		panel_1.add(panel);
		
		JButton backButton = new JButton("\u05D7\u05D6\u05E8\u05D4");
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		backButton.setBounds(236, 375, 125, 35);
		panel_1.add(backButton);
		backButton.setBackground(new Color(169, 169, 169));
		
		JButton printButton = new JButton("\u05D4\u05D3\u05E4\u05E1");
		printButton.setForeground(new Color(255, 255, 255));
		printButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		printButton.setBounds(396, 375, 125, 35);
		panel_1.add(printButton);
		printButton.setBackground(new Color(169, 169, 169));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAllApartmentView.openShowAllApartment(connectedUser, adminBool, analystBool); ///////////////
				frame.setVisible(false);
			}
		});
	}
	
	public void showTop(JTable table)
	{
		JScrollPane scrollPane_2 = new JScrollPane(table);
		panel.add(scrollPane_2);
		this.frame.setVisible(true);
	}
	
	/// inner classes
	
	public class TopApartment{}
	
	
}