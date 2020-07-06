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
import java.awt.Panel;
import javax.swing.ImageIcon;

public class ShowAllApartmentView extends Observable 
{
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
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
		

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
		frame.setBounds(100, 100, 788, 655);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(119, 136, 153));
		panel.setForeground(new Color(0, 153, 153));
		panel.setBounds(0, 0, 774, 612);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton showAllApartmentButton = new JButton("הצג את כל הדירות");
		showAllApartmentButton.setBounds(12, 91, 247, 63);
		showAllApartmentButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		showAllApartmentButton.setForeground(new Color(255, 255, 255));
		panel.add(showAllApartmentButton);
		showAllApartmentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setChanged();
				notifyObservers(new CreateAllApartmentTable());
			}
		});
		showAllApartmentButton.setBackground(new Color(219, 112, 147));
		
		watchSearchResultButton = new JButton("נתוני חיפוש");
		watchSearchResultButton.setBounds(12, 309, 247, 63);
		watchSearchResultButton.setForeground(new Color(255, 255, 255));
		watchSearchResultButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(watchSearchResultButton);
		watchSearchResultButton.setBackground(new Color(219, 112, 147));
		
		showAllUsersButton = new JButton("כל המשתמשים");
		showAllUsersButton.setBounds(12, 385, 247, 63);
		showAllUsersButton.setForeground(new Color(255, 255, 255));
		showAllUsersButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(showAllUsersButton);
		showAllUsersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		showAllUsersButton.setBackground(new Color(219, 112, 147));
		
		JButton printSearchResultButton = new JButton("הדפס");
		printSearchResultButton.setBounds(12, 461, 247, 63);
		printSearchResultButton.setForeground(new Color(255, 255, 255));
		printSearchResultButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(printSearchResultButton);
		printSearchResultButton.setBackground(new Color(219, 112, 147));
		
		watchApartmentButton = new JButton("הדירות שלך");
		watchApartmentButton.setBounds(12, 167, 247, 61);
		panel.add(watchApartmentButton);
		watchApartmentButton.setForeground(new Color(255, 255, 255));
		watchApartmentButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		watchApartmentButton.setBackground(new Color(219, 112, 147));
		
		addApartmentButton = new JButton("הוספת דירה");
		addApartmentButton.setBounds(12, 241, 247, 55);
		panel.add(addApartmentButton);
		addApartmentButton.setForeground(new Color(255, 255, 255));
		addApartmentButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		addApartmentButton.setBackground(new Color(219, 112, 147));
		
		loginOrLogoutButton = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8/\u05D4\u05EA\u05E0\u05EA\u05E7");
		loginOrLogoutButton.setBounds(12, 537, 247, 55);
		panel.add(loginOrLogoutButton);
		loginOrLogoutButton.setForeground(new Color(255, 255, 255));
		loginOrLogoutButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		loginOrLogoutButton.setBackground(new Color(219, 112, 147));
		
		JLabel searchApartmentLabel = new JLabel("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05D3\u05D9\u05E8\u05D4");
		searchApartmentLabel.setBounds(582, 47, 150, 29);
		panel.add(searchApartmentLabel);
		searchApartmentLabel.setForeground(new Color(255, 255, 255));
		searchApartmentLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ShowAllApartmentView.class.getResource("/Images/icons8-search-95.png")));
		lblNewLabel_1.setBounds(443, 13, 95, 85);
		panel.add(lblNewLabel_1);
		
		JLabel propertyTypeLabel = new JLabel("\u05E1\u05D5\u05D2 \u05D4\u05E0\u05DB\u05E1");
		propertyTypeLabel.setBounds(580, 171, 90, 20);
		panel.add(propertyTypeLabel);
		propertyTypeLabel.setForeground(new Color(255, 255, 255));
		propertyTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		propertyTypecomboBox = new JComboBox();
		propertyTypecomboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		propertyTypecomboBox.setBounds(433, 167, 116, 32);
		panel.add(propertyTypecomboBox);
		
		JButton searchButton = new JButton("\u05D7\u05E4\u05E9");
		searchButton.setForeground(new Color(255, 255, 255));
		searchButton.setBounds(392, 495, 122, 38);
		panel.add(searchButton);
		searchButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				searchButtonCliecked(propertyTypecomboBox.getSelectedIndex(), cityComboBox.getSelectedItem().toString(),
						missingRoomatesSpinner.getValue().toString(), startPrice.getText().toString(), limitPrice.getText().toString());
			}
		});
		searchButton.setBackground(new Color(219, 112, 147));
		
		CityLabel = new JLabel("\u05E2\u05D9\u05E8"); /// example for all
		CityLabel.setBounds(634, 216, 36, 16);
		panel.add(CityLabel);
		CityLabel.setForeground(new Color(255, 255, 255));
		CityLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel missingRoomatesLabel = new JLabel("שותפים כניסה לדירה");
		missingRoomatesLabel.setBounds(490, 271, 188, 16);
		panel.add(missingRoomatesLabel);
		missingRoomatesLabel.setForeground(new Color(255, 255, 255));
		missingRoomatesLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel startPriceLabel = new JLabel("\u05DE\u05DE\u05D7\u05D9\u05E8");
		startPriceLabel.setBounds(604, 323, 74, 16);
		panel.add(startPriceLabel);
		startPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		startPriceLabel.setForeground(new Color(255, 255, 255));
		
		JLabel limitPriceLabel = new JLabel("\u05E2\u05D3 \u05DE\u05D7\u05D9\u05E8");
		limitPriceLabel.setBounds(588, 377, 90, 16);
		panel.add(limitPriceLabel);
		limitPriceLabel.setForeground(new Color(255, 255, 255));
		limitPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		limitPrice = new JTextField();
		limitPrice.setBounds(433, 371, 116, 32);
		panel.add(limitPrice);
		limitPrice.setColumns(10);
		
		startPrice = new JTextField();
		startPrice.setBounds(433, 317, 116, 32);
		panel.add(startPrice);
		startPrice.setColumns(10);
		
		missingRoomatesSpinner = new JSpinner();
		missingRoomatesSpinner.setBounds(432, 270, 36, 22);
		panel.add(missingRoomatesSpinner);
		missingRoomatesSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(444, 395, -87, 20);
		panel.add(comboBox);
		
		userNameLabel = new JLabel("user name here");
		userNameLabel.setBounds(75, 47, 104, 25);
		panel.add(userNameLabel);
		userNameLabel.setForeground(new Color(255, 255, 255));
		userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		userNameLabel.setText("guest");
		
		adminLabel = new JLabel("Admin");
		adminLabel.setBounds(114, 26, 65, 14);
		panel.add(adminLabel);
		adminLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		adminLabel.setForeground(new Color(255, 255, 255));
		
		cityComboBox = new JComboBox();
		cityComboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		cityComboBox.setBounds(433, 212, 116, 32);
		panel.add(cityComboBox);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ShowAllApartmentView.class.getResource("/Images/icons8-male-user-50.png")));
		lblNewLabel_2.setBounds(195, 13, 64, 51);
		panel.add(lblNewLabel_2);
		propertyTypecomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				propertyTypeComboBox();
				
			}
		});
		loginOrLogoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loginOrLogout();
				
//				mainView.showMainView();
//				frame.setVisible(false);
			}
		});
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
		printSearchResultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		showAllUsersButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				openShowAllUserView(arg0);
			}
		});
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