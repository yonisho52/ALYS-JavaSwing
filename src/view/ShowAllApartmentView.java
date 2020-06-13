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
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ShowAllApartmentView extends Observable {
	
	
	SearchDetailsView searchDetailsView;
	AddNewApartmentView addNewApartmentView;
	ShowUserApartmentView showUserApartmentView;
	MainView mainView;
	ShowAllUsersView showAllUsersView;

	private JFrame frame;
	private JTextField LimitPrice;
	private JTextField StartPrice;
	private JLabel CityLabel;  /// example for all 
	private JLabel adminLabel;
	private JPanel panel;
	private JComboBox cityComboBox;
	private JComboBox propertyTypecomboBox;
	
	private JLabel userNameLabel;
	private JButton loginOrLogoutButton;
	private JButton addApartmentButton;
	private JButton watchApartmentButton;
	private JButton watchSearchResultButton;
	private JButton showAllUsersButton;
	
	protected String connectedUser;
	protected boolean adminBool;
	private JComboBox missingRoomatesComboBox;
	private JComboBox numOfRommatesComboBox;


	public static void main(String[] args) 
	{
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

	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 840, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		CityLabel = new JLabel("\u05E2\u05D9\u05E8"); /// example for all
		CityLabel.setBounds(652, 94, 36, 16);
		frame.getContentPane().add(CityLabel);
		
		JLabel numOfRoomatesLabel = new JLabel("\u05E1\u05D4\"\u05DB \u05E9\u05D5\u05EA\u05E4\u05D9\u05DD");
		numOfRoomatesLabel.setBounds(652, 164, 107, 16);
		frame.getContentPane().add(numOfRoomatesLabel);
		
		JLabel missingRoomatesLabel = new JLabel("\u05E9\u05D5\u05EA\u05E4\u05D9\u05DD \u05D7\u05E1\u05E8\u05D9\u05DD");
		missingRoomatesLabel.setBounds(652, 134, 116, 16);
		frame.getContentPane().add(missingRoomatesLabel);
		
		JLabel roomsLabel = new JLabel("\u05D7\u05D3\u05E8\u05D9\u05DD");
		roomsLabel.setBounds(652, 196, 56, 16);
		frame.getContentPane().add(roomsLabel);
		
		JLabel startPriceLabel = new JLabel("\u05DE\u05DE\u05D7\u05D9\u05E8");
		startPriceLabel.setBounds(652, 223, 56, 16);
		frame.getContentPane().add(startPriceLabel);
		
		JLabel limitPriceLabel = new JLabel("\u05E2\u05D3 \u05DE\u05D7\u05D9\u05E8");
		limitPriceLabel.setBounds(652, 255, 90, 16);
		frame.getContentPane().add(limitPriceLabel);
		
		LimitPrice = new JTextField();
		LimitPrice.setColumns(10);
		LimitPrice.setBounds(508, 252, 116, 22);
		frame.getContentPane().add(LimitPrice);
		
		StartPrice = new JTextField();
		StartPrice.setColumns(10);
		StartPrice.setBounds(508, 220, 116, 22);
		frame.getContentPane().add(StartPrice);
		
		JSpinner roomsSpinner = new JSpinner();
		roomsSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		roomsSpinner.setBounds(563, 194, 36, 22);
		frame.getContentPane().add(roomsSpinner);
		
		JSpinner missingRoomatesSpinner = new JSpinner();
		missingRoomatesSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		missingRoomatesSpinner.setBounds(563, 131, 36, 22);
		frame.getContentPane().add(missingRoomatesSpinner);
		
		JSpinner numOfRommatesspinner = new JSpinner();
		numOfRommatesspinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		numOfRommatesspinner.setBounds(563, 161, 36, 22);
		frame.getContentPane().add(numOfRommatesspinner);
		
		JLabel searchApartmentLabel = new JLabel("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05D3\u05D9\u05E8\u05D4");
		searchApartmentLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		searchApartmentLabel.setBounds(335, 4, 116, 19);
		frame.getContentPane().add(searchApartmentLabel);
		
		JButton searchButton = new JButton("\u05D7\u05E4\u05E9");
		searchButton.setBackground(Color.PINK);
		searchButton.setBounds(335, 269, 97, 25);
		frame.getContentPane().add(searchButton);
		
		JLabel searchResultLabel = new JLabel("\u05EA\u05D5\u05E6\u05D0\u05D5\u05EA \u05D7\u05D9\u05E4\u05D5\u05E9 - \u05E8\u05E9\u05D9\u05DE\u05D4");
		searchResultLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		searchResultLabel.setBounds(290, 335, 196, 16);
		frame.getContentPane().add(searchResultLabel);
		
		loginOrLogoutButton = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8/\u05D4\u05EA\u05E0\u05EA\u05E7");
		loginOrLogoutButton.setBackground(Color.PINK);
		loginOrLogoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loginOrLogout();
			}
		});
		loginOrLogoutButton.setBounds(10, 31, 227, 25);
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
		addApartmentButton.setBounds(10, 101, 267, 25);
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
			}
		});
		
		watchApartmentButton.setBounds(10, 136, 227, 25);
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
				//searchDetailsView.showSearchDetailsView(connectedUser,adminBool);
				//frame.setVisible(false);
			}});
		watchSearchResultButton.setBounds(10, 172, 227, 25);
		frame.getContentPane().add(watchSearchResultButton);
		
		JButton printSearchResultButton = new JButton("\u05D4\u05D3\u05E4\u05E1\u05EA \u05EA\u05D5\u05E6\u05D0\u05D5\u05EA \u05D7\u05D9\u05E4\u05D5\u05E9");
		printSearchResultButton.setBackground(Color.PINK);
		printSearchResultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		printSearchResultButton.setBounds(10, 65, 227, 25);
		frame.getContentPane().add(printSearchResultButton);
		
		showAllUsersButton = new JButton("\u05D4\u05E6\u05D2 \u05D0\u05EA \u05DB\u05DC \u05D4\u05DE\u05E9\u05EA\u05DE\u05E9\u05D9\u05DD");
		showAllUsersButton.setBackground(Color.PINK);
		showAllUsersButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				openShowAllUserView(arg0);
			}
		});
		showAllUsersButton.setBounds(10, 208, 227, 25);
		frame.getContentPane().add(showAllUsersButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(563, 283, -84, 8);
		frame.getContentPane().add(comboBox);
		
		propertyTypecomboBox = new JComboBox();
		propertyTypecomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				propertyTypeComboBox();
			}
		});

		
		propertyTypecomboBox.setBounds(508, 31, 116, 32);
		frame.getContentPane().add(propertyTypecomboBox);
		
		JLabel propertyTypeLabel = new JLabel("\u05E1\u05D5\u05D2 \u05D4\u05E0\u05DB\u05E1");
		propertyTypeLabel.setBounds(639, 33, 69, 20);
		frame.getContentPane().add(propertyTypeLabel);
		
		userNameLabel = new JLabel("user name here");
		userNameLabel.setBounds(744, 4, 36, 25);
		frame.getContentPane().add(userNameLabel);
		userNameLabel.setText("guest");
		
		adminLabel = new JLabel("אדמין");
		adminLabel.setBounds(744, 36, 46, 14);
		frame.getContentPane().add(adminLabel);
		
		panel = new JPanel();
		panel.setBounds(10, 372, 780, 202);
		frame.getContentPane().add(panel);
		
		cityComboBox = new JComboBox();
		
		cityComboBox.setBounds(551, 92, 90, 20);
		frame.getContentPane().add(cityComboBox);	
		
		missingRoomatesComboBox = new JComboBox();

		missingRoomatesComboBox.setBounds(463, 132, 90, 20);
		
		frame.getContentPane().add(missingRoomatesComboBox);
		
		numOfRommatesComboBox = new JComboBox();
		numOfRommatesComboBox.setBounds(463, 162, 90, 20);
		frame.getContentPane().add(numOfRommatesComboBox);
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
	
	public void openShowAllApartment(String userName, boolean userType)  //0 - ground, 1 - building
	{ 
		this.connectedUser = userName;
		this.adminBool = userType;
		frame.setVisible(true);
		this.frame.setEnabled(true);
		userType();
		setChanged();
		notifyObservers(new PropertType());
	}
	
	public void propertyTypeComboBox()
	{
		numOfRommatesComboBox.removeAllItems();
		missingRoomatesComboBox.removeAllItems();
		cityComboBox.removeAllItems();
		setChanged();
		notifyObservers(new CityShow(propertyTypecomboBox.getSelectedIndex()));
		
		numOfRommatesComboBox.removeAllItems();
		missingRoomatesComboBox.removeAllItems();

		setChanged();
		notifyObservers(new MissedRommateNumShow(propertyTypecomboBox.getSelectedIndex(), cityComboBox.getSelectedItem().toString()));
		
		numOfRommatesComboBox.removeAllItems();
		
//		setChanged();
//		notifyObservers(new numOfRommates(propertyTypecomboBox.getSelectedIndex(), cityComboBox.getSelectedItem().toString()));
//		//numOfRommates
	}
	
	public class NumOfRommates
	{
		public String missedRommates;
		public String city;
		public int propretyType;
		public NumOfRommates(int typeSelected, String citySelected) {
			this.propretyType = typeSelected;
			this.city = citySelected;
		}
	}
	
	public void userType() 
	{ 
		watchSearchResultButton.setVisible(false);
		showAllUsersButton.setVisible(false);
		adminLabel.setText("לא אדמין");
		
		if(connectedUser==null)
		{
			loginOrLogoutButton.setText("התחבר");
			userNameLabel.setText("שלום אורח");
			addApartmentButton.setVisible(false);
			watchApartmentButton.setVisible(false);
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
	
	public void loginOrLogout() 
	{
		this.connectedUser=null;
		mainView.showMainView();
		frame.setVisible(false);
	}
	
	public void createAllApartment(JTable apartmentTable)
	{
		JScrollPane scrollPane_1 = new JScrollPane(apartmentTable);
		panel.add(scrollPane_1);
		this.frame.setVisible(true);
	}
	
	public void loadCities(String [] cities)
	{
		for (int i=0;i<cities.length;i++)
		{
			cityComboBox.addItem(cities[i]);
		}
	}
	
	public void loadmissingRoomates(String [] numOfMissingRommates)
	{
		for (int i=0;i<numOfMissingRommates.length;i++)
		{
			missingRoomatesComboBox.addItem(numOfMissingRommates[i]);
		}
	}

	
	public void loadPropertType(Boolean [] type)
	{
		if(type[0])
		{
			propertyTypecomboBox.addItem("דירת קרקע");
		}
		if(type[1])
		{
			propertyTypecomboBox.addItem("דירה בבניין");
		}
	}
	
	public class MissedRommateNumShow 
	{
		public String city;
		public int propretyType;
		public MissedRommateNumShow(int typeSelected, String citySelected) {
			this.propretyType = typeSelected;
			this.city = citySelected;
		}
	}
	
	public class CityShow 
	{
		public int index;
		public CityShow(int type) {
			this.index = type;
		}
	}
	
	public class PropertType {}
}
