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
	private JTextField limitPrice;
	private JTextField startPrice;
	private JLabel CityLabel;  /// example for all 
	private JLabel adminLabel;
	private JComboBox cityComboBox;
	private JComboBox propertyTypecomboBox;
	private JSpinner missingRoomatesSpinner;
	
	private JLabel userNameLabel;
	private JButton loginOrLogoutButton;
	private JButton addApartmentButton;
	private JButton watchApartmentButton;
	private JButton watchSearchResultButton;
	private JButton showAllUsersButton;
	private JLabel lblNewLabel;
	
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
		frame.setBounds(100, 100, 880, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		CityLabel = new JLabel("\u05E2\u05D9\u05E8"); /// example for all
		CityLabel.setBounds(658, 219, 36, 16);
		frame.getContentPane().add(CityLabel);
		
		JLabel missingRoomatesLabel = new JLabel("שותפים כניסה לדירה");
		missingRoomatesLabel.setBounds(617, 259, 157, 16);
		frame.getContentPane().add(missingRoomatesLabel);
		
		JLabel startPriceLabel = new JLabel("\u05DE\u05DE\u05D7\u05D9\u05E8");
		startPriceLabel.setBounds(663, 310, 56, 16);
		frame.getContentPane().add(startPriceLabel);
		
		JLabel limitPriceLabel = new JLabel("\u05E2\u05D3 \u05DE\u05D7\u05D9\u05E8");
		limitPriceLabel.setBounds(663, 342, 90, 16);
		frame.getContentPane().add(limitPriceLabel);
		
		limitPrice = new JTextField();
		limitPrice.setColumns(10);
		limitPrice.setBounds(519, 339, 116, 22);
		frame.getContentPane().add(limitPrice);
		
		startPrice = new JTextField();
		startPrice.setColumns(10);
		startPrice.setBounds(519, 307, 116, 22);
		frame.getContentPane().add(startPrice);
		
		missingRoomatesSpinner = new JSpinner();
		missingRoomatesSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		missingRoomatesSpinner.setBounds(569, 256, 36, 22);
		frame.getContentPane().add(missingRoomatesSpinner);
		
		JLabel searchApartmentLabel = new JLabel("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05D3\u05D9\u05E8\u05D4");
		searchApartmentLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		searchApartmentLabel.setBounds(363, 31, 116, 19);
		frame.getContentPane().add(searchApartmentLabel);
		
		JButton searchButton = new JButton("\u05D7\u05E4\u05E9");
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				searchButtonCliecked(propertyTypecomboBox.getSelectedIndex(), cityComboBox.getSelectedItem().toString(),
						missingRoomatesSpinner.getValue().toString(), startPrice.getText().toString(), limitPrice.getText().toString());
			}
		});
		searchButton.setBackground(Color.PINK);
		searchButton.setBounds(544, 385, 97, 25);
		frame.getContentPane().add(searchButton);
		
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
		loginOrLogoutButton.setBounds(10, 91, 97, 25);
		frame.getContentPane().add(loginOrLogoutButton);
		
		addApartmentButton = new JButton("הוספת דירה");
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
		addApartmentButton.setBounds(203, 91, 97, 25);
		frame.getContentPane().add(addApartmentButton);
		
		watchApartmentButton = new JButton("הדירות שלך");
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
		
		watchApartmentButton.setBounds(309, 91, 107, 25);
		frame.getContentPane().add(watchApartmentButton);
		
		watchSearchResultButton = new JButton("נתוני חיפוש");
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
		watchSearchResultButton.setBounds(10, 127, 116, 25);
		frame.getContentPane().add(watchSearchResultButton);
		
		JButton printSearchResultButton = new JButton("הדפס");
		printSearchResultButton.setBackground(Color.PINK);
		printSearchResultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		printSearchResultButton.setBounds(117, 91, 76, 25);
		frame.getContentPane().add(printSearchResultButton);
		
		showAllUsersButton = new JButton("כל המשתמשים");
		showAllUsersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		showAllUsersButton.setBackground(Color.PINK);
		showAllUsersButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				openShowAllUserView(arg0);
			}
		});
		showAllUsersButton.setBounds(10, 163, 116, 25);
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

		
		propertyTypecomboBox.setBounds(514, 156, 116, 32);
		frame.getContentPane().add(propertyTypecomboBox);
		
		JLabel propertyTypeLabel = new JLabel("\u05E1\u05D5\u05D2 \u05D4\u05E0\u05DB\u05E1");
		propertyTypeLabel.setBounds(645, 158, 69, 20);
		frame.getContentPane().add(propertyTypeLabel);
		
		userNameLabel = new JLabel("user name here");
		userNameLabel.setBounds(772, 31, 36, 25);
		frame.getContentPane().add(userNameLabel);
		userNameLabel.setText("guest");
		
		adminLabel = new JLabel("Admin");
		adminLabel.setBounds(772, 57, 46, 14);
		frame.getContentPane().add(adminLabel);
		
		cityComboBox = new JComboBox();
		
		cityComboBox.setBounds(557, 217, 90, 20);
		frame.getContentPane().add(cityComboBox);
		
		JButton showAllApartmentButton = new JButton("הצג את כל הדירות");
		showAllApartmentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setChanged();
				notifyObservers(new CreateAllApartmentTable());
			}
		});
		showAllApartmentButton.setBackground(Color.PINK);
		showAllApartmentButton.setBounds(363, 385, 131, 25);
		frame.getContentPane().add(showAllApartmentButton);
	}
	
	public void openAddNewApartmentView(MouseEvent arg0)
	{
		addNewApartmentView.setShowAllApartmentView(this);
		this.frame.setEnabled(false);
		addNewApartmentView.showAddNewApartmentView(connectedUser,adminBool, analystBool);
	}
	
	public void openShowAllUserView(MouseEvent arg0)
	{
		showAllUsersView.setShowAllApartmentView(this);
		this.frame.setEnabled(false);
		showAllUsersView.showAllUsersView(connectedUser,adminBool, analystBool);
	}
	
	public void openShowUserApartmentView(MouseEvent arg0)
	{
		showUserApartmentView.setShowAllApartmentView(this);
		this.frame.setEnabled(false);
		showUserApartmentView.showShowUserApartmentView(connectedUser,adminBool, analystBool);
	}
	public void openSearchDetailsView(MouseEvent arg0)
	{
		searchDetailsView.setShowAllApartmentView(this);
		this.frame.setEnabled(false);
		searchDetailsView.showSearchDetailsView(connectedUser,adminBool, analystBool);
	}
	
	public void setMainView(MainView mainView) { // know who to return when event handler (back)
		this.mainView = mainView;
	}
	
	public void openShowAllApartment(String userName, boolean userType, boolean analyst) {  //0 - ground, 1 - building
		this.connectedUser = userName;
		this.adminBool = userType;
		this.analystBool = analyst;
		frame.setVisible(true);
		this.frame.setEnabled(true);
		userType();
		setChanged();
		notifyObservers(new PropertType());
	}
	

	
	public void propertyTypeComboBox()
	{
		cityComboBox.removeAllItems();
		setChanged();
		notifyObservers(new CityShow(propertyTypecomboBox.getSelectedIndex()));		
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
	
	
	
	public void userType() { 
		
		watchSearchResultButton.setVisible(false);
		showAllUsersButton.setVisible(false);
		adminLabel.setText(""); // not admin
		
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
			else if(analystBool)
			{
				adminLabel.setText("אנליסט");
				watchSearchResultButton.setVisible(true);
			}
		}
	}
	
	public void loginOrLogout() {
		
		this.connectedUser=null;
		this.adminBool = false;
		this.analystBool = false;
		mainView.showMainView();
		frame.setVisible(false);
	}
	
	public void createAllApartment(JTable apartmentTable)
	{
		JFrame tableFrame=new JFrame();
		//create table
		JScrollPane scrollPane = new JScrollPane(apartmentTable);
		tableFrame.getContentPane().add(scrollPane);
		tableFrame.setSize(1500,500);
		tableFrame.setVisible(true);
//		JScrollPane scrollPane_1 = new JScrollPane(apartmentTable);
//		panel.add(scrollPane_1);
//		this.frame.setVisible(true);
	}
	
	public void loadCities(String [] cities)
	{
		for (int i=0;i<cities.length;i++)
		{
			cityComboBox.addItem(cities[i]);
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
	
	public void searchButtonCliecked(int type, String city, String missedRoomate, String startPrice, String limiPrice)
	{
		String [] search = new String[5];
		String typeStr = "בניין";
		int i=0;
		if(type==0) {typeStr = "קרקע";}

		search[i++] = typeStr;
		search[i++] = city;
		search[i++] = missedRoomate;
		search[i++] = startPrice;
		search[i++] = limiPrice;
		setChanged();
		notifyObservers(new Search(search));
	}
	
	public void showSearch(JTable searchTable)
	{
		JFrame tableFrame=new JFrame();
		//create table
		JScrollPane scrollPane = new JScrollPane(searchTable);
		tableFrame.getContentPane().add(scrollPane);
		tableFrame.setSize(1500,500);
		tableFrame.setVisible(true);
//		JScrollPane scrollPane_2 = new JScrollPane(searchTable);
//		panel_1.add(scrollPane_2);
//		this.frame.setVisible(true);
	}
	
	public class Search 
	{
		public String [] search;
		public int propretyType;
		public Search(String [] arr) {
			this.search = arr;
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
	
	public class CreateAllApartmentTable {}
}
