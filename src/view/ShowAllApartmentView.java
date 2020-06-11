package view;

import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;

public class ShowAllApartmentView extends Observable {
	
	
	SearchDetailsView searchDetailsView;
	AddNewApartmentView addNewApartmentView;
	ShowUserApartmentView showUserApartmentView;
	MainView mainView;
	ShowAllUsersView showAllUsersView;

	private JFrame frame;
	private JTextField City;
	private JTextField ApartmentType;
	private JTextField LimitPrice;
	private JTextField StartPrice;
	private JLabel CityLabel;  /// example for all 
	private JLabel adminLabel;
	
	private JLabel userNameLabel;
	private JButton loginOrLogoutButton;
	private JButton addApartmentButton;
	private JButton watchApartmentButton;
	private JButton watchSearchResultButton;
	private JButton showAllUsersButton;
	
	protected String connectedUser;
	protected boolean adminBool;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAllApartmentView window = new ShowAllApartmentView();
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
	public ShowAllApartmentView(SearchDetailsView searchDetailsView,AddNewApartmentView addNewApartmentView,
			ShowUserApartmentView showUserApartmentView, ShowAllUsersView showAllUsersView) {
		this.searchDetailsView = searchDetailsView;
		this.addNewApartmentView = addNewApartmentView;
		this.showUserApartmentView = showUserApartmentView;
		this.showAllUsersView = showAllUsersView;
		initialize();
	}
	
	public ShowAllApartmentView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 840, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		City = new JTextField();
		City.setColumns(10);
		City.setBounds(508, 32, 116, 22);
		frame.getContentPane().add(City);
		
		CityLabel = new JLabel("\u05E2\u05D9\u05E8"); /// example for all
		CityLabel.setBounds(652, 35, 36, 16);
		frame.getContentPane().add(CityLabel);
		
		ApartmentType = new JTextField();
		ApartmentType.setColumns(10);
		ApartmentType.setBounds(508, 66, 116, 22);
		frame.getContentPane().add(ApartmentType);
		
		JLabel apartmentTypeLabel = new JLabel("\u05E8\u05D7\u05D5\u05D1");
		apartmentTypeLabel.setBounds(652, 69, 56, 16);
		frame.getContentPane().add(apartmentTypeLabel);
		
		JLabel numOfRoomatesLabel = new JLabel("\u05E1\u05D4\"\u05DB \u05E9\u05D5\u05EA\u05E4\u05D9\u05DD");
		numOfRoomatesLabel.setBounds(652, 108, 107, 16);
		frame.getContentPane().add(numOfRoomatesLabel);
		
		JLabel missingRoomatesLabel = new JLabel("\u05E9\u05D5\u05EA\u05E4\u05D9\u05DD \u05D7\u05E1\u05E8\u05D9\u05DD");
		missingRoomatesLabel.setBounds(652, 134, 116, 16);
		frame.getContentPane().add(missingRoomatesLabel);
		
		JLabel roomsLabel = new JLabel("\u05D7\u05D3\u05E8\u05D9\u05DD");
		roomsLabel.setBounds(652, 163, 56, 16);
		frame.getContentPane().add(roomsLabel);
		
		JLabel startPriceLabel = new JLabel("\u05DE\u05DE\u05D7\u05D9\u05E8");
		startPriceLabel.setBounds(652, 195, 56, 16);
		frame.getContentPane().add(startPriceLabel);
		
		JLabel limitPriceLabel = new JLabel("\u05E2\u05D3 \u05DE\u05D7\u05D9\u05E8");
		limitPriceLabel.setBounds(652, 227, 90, 16);
		frame.getContentPane().add(limitPriceLabel);
		
		LimitPrice = new JTextField();
		LimitPrice.setColumns(10);
		LimitPrice.setBounds(508, 224, 116, 22);
		frame.getContentPane().add(LimitPrice);
		
		StartPrice = new JTextField();
		StartPrice.setColumns(10);
		StartPrice.setBounds(508, 192, 116, 22);
		frame.getContentPane().add(StartPrice);
		
		JSpinner roomsSpinner = new JSpinner();
		roomsSpinner.setBounds(563, 166, 36, 22);
		frame.getContentPane().add(roomsSpinner);
		
		JSpinner missingRoomatesSpinner = new JSpinner();
		missingRoomatesSpinner.setBounds(563, 137, 36, 22);
		frame.getContentPane().add(missingRoomatesSpinner);
		
		JSpinner numOfRommatesspinner = new JSpinner();
		numOfRommatesspinner.setBounds(563, 108, 36, 22);
		frame.getContentPane().add(numOfRommatesspinner);
		
		JCheckBox elevatorCheckBox = new JCheckBox("\u05DE\u05E2\u05DC\u05D9\u05EA");
		elevatorCheckBox.setBounds(260, 159, 113, 25);
		frame.getContentPane().add(elevatorCheckBox);
		
		JCheckBox parkingCheckBox = new JCheckBox("\u05D7\u05E0\u05D9\u05D4");
		parkingCheckBox.setBounds(260, 35, 113, 25);
		frame.getContentPane().add(parkingCheckBox);
		
		JCheckBox airCheckBox = new JCheckBox("\u05DE\u05D9\u05D6\u05D5\u05D2");
		airCheckBox.setBounds(260, 65, 113, 25);
		frame.getContentPane().add(airCheckBox);
		
		JCheckBox patioCheckBox = new JCheckBox("\u05DE\u05E8\u05E4\u05E1\u05EA");
		patioCheckBox.setBounds(260, 98, 113, 25);
		frame.getContentPane().add(patioCheckBox);
		
		JCheckBox mamadCheckBox = new JCheckBox("\u05DE\u05DE\"\u05D3");
		mamadCheckBox.setBounds(260, 130, 113, 25);
		frame.getContentPane().add(mamadCheckBox);
		
		JCheckBox storageCheckBox = new JCheckBox("\u05DE\u05D7\u05E1\u05DF");
		storageCheckBox.setBounds(77, 130, 113, 25);
		frame.getContentPane().add(storageCheckBox);
		
		JCheckBox accesibleCheckBox = new JCheckBox("\u05D2\u05D9\u05E9\u05D4 \u05DC\u05E0\u05DB\u05D9\u05DD");
		accesibleCheckBox.setBounds(77, 35, 145, 25);
		frame.getContentPane().add(accesibleCheckBox);
		
		JCheckBox furnitureCheckBox = new JCheckBox("\u05DE\u05E8\u05D5\u05D4\u05D8\u05EA");
		furnitureCheckBox.setBounds(77, 65, 113, 25);
		frame.getContentPane().add(furnitureCheckBox);
		
		JCheckBox petCheckBox = new JCheckBox("\u05D7\u05D9\u05D5\u05EA \u05DE\u05D7\u05DE\u05D3");
		petCheckBox.setBounds(77, 98, 113, 25);
		frame.getContentPane().add(petCheckBox);
		
		JLabel searchApartmentLabel = new JLabel("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05D3\u05D9\u05E8\u05D4");
		searchApartmentLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		searchApartmentLabel.setBounds(335, 4, 116, 19);
		frame.getContentPane().add(searchApartmentLabel);
		
		JButton searchButton = new JButton("\u05D7\u05E4\u05E9");
		searchButton.setBackground(Color.PINK);
		searchButton.setBounds(392, 299, 97, 25);
		frame.getContentPane().add(searchButton);
		
		JLabel searchResultLabel = new JLabel("\u05EA\u05D5\u05E6\u05D0\u05D5\u05EA \u05D7\u05D9\u05E4\u05D5\u05E9 - \u05E8\u05E9\u05D9\u05DE\u05D4");
		searchResultLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		searchResultLabel.setBounds(428, 342, 196, 16);
		frame.getContentPane().add(searchResultLabel);
		
		loginOrLogoutButton = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8/\u05D4\u05EA\u05E0\u05EA\u05E7");
		loginOrLogoutButton.setBackground(Color.PINK);
		loginOrLogoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loginOrLogout();
				
//				mainView.showMainView();
//				frame.setVisible(false);
			}
		});
		loginOrLogoutButton.setBounds(10, 311, 227, 25);
		frame.getContentPane().add(loginOrLogoutButton);
		
		addApartmentButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05D3\u05D9\u05E8\u05D4 \u05D7\u05D3\u05E9\u05D4 - \u05DE\u05E0\u05D5\u05D9/\u05D0\u05D3\u05DE\u05D9\u05DF");
		addApartmentButton.setBackground(Color.PINK);
		addApartmentButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
			}
		});
		addApartmentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				openAddNewApartmentView(arg0);
			}
		});
		addApartmentButton.setBounds(10, 352, 267, 25);
		frame.getContentPane().add(addApartmentButton);
		
		watchApartmentButton = new JButton("\u05E6\u05E4\u05D9\u05D9\u05D4 \u05D1\u05D3\u05D9\u05E8\u05D5\u05EA \u05E9\u05DC\u05DA - \u05DE\u05E0\u05D5\u05D9");
		watchApartmentButton.setBackground(Color.PINK);
		watchApartmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		watchApartmentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				openShowUserApartmentView(arg0);
				showUserApartmentView.showShowUserApartmentView(connectedUser,adminBool);
				frame.setVisible(false);
			}
		});
		
		watchApartmentButton.setBounds(10, 393, 227, 25);
		frame.getContentPane().add(watchApartmentButton);
		
		watchSearchResultButton = new JButton("\u05E6\u05E4\u05D9\u05D9\u05D4 \u05D1\u05E0\u05EA\u05D5\u05E0\u05D9 \u05D7\u05D9\u05E4\u05D5\u05E9 - \u05D0\u05D3\u05DE\u05D9\u05DF");
		watchSearchResultButton.setBackground(Color.PINK);
		watchSearchResultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		watchSearchResultButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				openSearchDetailsView(arg0);
				searchDetailsView.showSearchDetailsView(connectedUser,adminBool);
				frame.setVisible(false);
			}});
		watchSearchResultButton.setBounds(10, 434, 227, 25);
		frame.getContentPane().add(watchSearchResultButton);
		
		JButton printSearchResultButton = new JButton("\u05D4\u05D3\u05E4\u05E1\u05EA \u05EA\u05D5\u05E6\u05D0\u05D5\u05EA \u05D7\u05D9\u05E4\u05D5\u05E9");
		printSearchResultButton.setBackground(Color.PINK);
		printSearchResultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		printSearchResultButton.setBounds(10, 516, 227, 25);
		frame.getContentPane().add(printSearchResultButton);
		
		showAllUsersButton = new JButton("\u05D4\u05E6\u05D2 \u05D0\u05EA \u05DB\u05DC \u05D4\u05DE\u05E9\u05EA\u05DE\u05E9\u05D9\u05DD");
		showAllUsersButton.setBackground(Color.PINK);
		showAllUsersButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				openShowAllUserView(arg0);
			}
		});
		showAllUsersButton.setBounds(10, 475, 227, 25);
		frame.getContentPane().add(showAllUsersButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(563, 283, -84, 8);
		frame.getContentPane().add(comboBox);
		
		JComboBox propertyTypecomboBox = new JComboBox();
		propertyTypecomboBox.setEditable(true);
		propertyTypecomboBox.setBounds(508, 265, 116, 32);
		frame.getContentPane().add(propertyTypecomboBox);
		
		JLabel propertyTypeLabel = new JLabel("\u05E1\u05D5\u05D2 \u05D4\u05E0\u05DB\u05E1");
		propertyTypeLabel.setBounds(662, 271, 69, 20);
		frame.getContentPane().add(propertyTypeLabel);
		
		userNameLabel = new JLabel("user name here");
		userNameLabel.setBounds(712, 11, 102, 25);
		frame.getContentPane().add(userNameLabel);
		userNameLabel.setText("guest");
		
		adminLabel = new JLabel("אדמין");
		adminLabel.setBounds(712, 36, 46, 14);
		frame.getContentPane().add(adminLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(299, 372, 491, 202);
		frame.getContentPane().add(panel);
//		changeTheUser();
//		if(connectedUser==null)
//		{
//			userNameLabel.setText("guest");
//		}
//		else
//		{
//			System.out.println(connectedUser.toString() + " the user!");
//			userNameLabel.setText(connectedUser.toString());
//		}
		
	}
	
	public void openAddNewApartmentView(MouseEvent arg0)
	{
		addNewApartmentView.setShowAllApartmentView(this);
		this.frame.setEnabled(false);
		addNewApartmentView.showAddNewApartmentView(connectedUser,adminBool);
	}
	
	public void openShowAllUserView(MouseEvent arg0)
	{
		showAllUsersView.setShowAllApartmentView(this);
		this.frame.setEnabled(false);
		showAllUsersView.showAllUsersView(connectedUser,adminBool);
	}
	
	public void openShowUserApartmentView(MouseEvent arg0)
	{
		showUserApartmentView.setShowAllApartmentView(this);
		this.frame.setEnabled(false);
		showUserApartmentView.showShowUserApartmentView(connectedUser,adminBool);
	}
	public void openSearchDetailsView(MouseEvent arg0)
	{
		searchDetailsView.setShowAllApartmentView(this);
		this.frame.setEnabled(false);
		searchDetailsView.showSearchDetailsView(connectedUser,adminBool);
	}
	
	public void setMainView(MainView mainView) { // know who to return when event handler (back)
		this.mainView = mainView;
	}
	
	public void openShowAllApartment(String userName, boolean userType) {
		this.connectedUser = userName;
		this.adminBool = userType;
		frame.setVisible(true);
		this.frame.setEnabled(true);
		userType();
	}
	
//	public void openShowAllApartment() {
//		changeTheUser();
//		frame.setVisible(true);
//		this.frame.setEnabled(true);
//	}
	
	
	public void userType() { 
		
		if(connectedUser==null)
		{
			loginOrLogoutButton.setText("התחבר");
			userNameLabel.setText("שלום אורח");
			adminLabel.setText("לא אדמין");
			addApartmentButton.setVisible(false);
			watchApartmentButton.setVisible(false);
			watchSearchResultButton.setVisible(false);
			showAllUsersButton.setVisible(false);
		}
		else
		{
			loginOrLogoutButton.setText("התנתק");
			userNameLabel.setText(connectedUser.toString() + " שלום");
			addApartmentButton.setVisible(true);
			watchApartmentButton.setVisible(true);
			
			if(adminBool)
			{
				adminLabel.setText("אדמין");
				showAllUsersButton.setVisible(true);
				watchSearchResultButton.setVisible(true);
			}
		}
	}
	
	public void loginOrLogout() {
		
		this.connectedUser=null;
		mainView.showMainView();
		frame.setVisible(false);
	}
}
