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
	private JTable searchResultTable;
	

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
		City.setBounds(483, 35, 116, 22);
		frame.getContentPane().add(City);
		
		CityLabel = new JLabel("\u05E2\u05D9\u05E8"); /// example for all
		CityLabel.setBounds(620, 38, 36, 16);
		frame.getContentPane().add(CityLabel);
		
		ApartmentType = new JTextField();
		ApartmentType.setColumns(10);
		ApartmentType.setBounds(483, 69, 116, 22);
		frame.getContentPane().add(ApartmentType);
		
		JLabel apartmentTypeLabel = new JLabel("\u05E8\u05D7\u05D5\u05D1");
		apartmentTypeLabel.setBounds(620, 72, 56, 16);
		frame.getContentPane().add(apartmentTypeLabel);
		
		JLabel numOfRoomatesLabel = new JLabel("\u05E1\u05D4\"\u05DB \u05E9\u05D5\u05EA\u05E4\u05D9\u05DD");
		numOfRoomatesLabel.setBounds(620, 111, 107, 16);
		frame.getContentPane().add(numOfRoomatesLabel);
		
		JLabel missingRoomatesLabel = new JLabel("\u05E9\u05D5\u05EA\u05E4\u05D9\u05DD \u05D7\u05E1\u05E8\u05D9\u05DD");
		missingRoomatesLabel.setBounds(620, 140, 116, 16);
		frame.getContentPane().add(missingRoomatesLabel);
		
		JLabel roomsLabel = new JLabel("\u05D7\u05D3\u05E8\u05D9\u05DD");
		roomsLabel.setBounds(620, 169, 56, 16);
		frame.getContentPane().add(roomsLabel);
		
		JLabel startPriceLabel = new JLabel("\u05DE\u05DE\u05D7\u05D9\u05E8");
		startPriceLabel.setBounds(620, 198, 56, 16);
		frame.getContentPane().add(startPriceLabel);
		
		JLabel limitPriceLabel = new JLabel("\u05E2\u05D3 \u05DE\u05D7\u05D9\u05E8");
		limitPriceLabel.setBounds(620, 230, 90, 16);
		frame.getContentPane().add(limitPriceLabel);
		
		LimitPrice = new JTextField();
		LimitPrice.setColumns(10);
		LimitPrice.setBounds(483, 227, 116, 22);
		frame.getContentPane().add(LimitPrice);
		
		StartPrice = new JTextField();
		StartPrice.setColumns(10);
		StartPrice.setBounds(483, 195, 116, 22);
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
		elevatorCheckBox.setBounds(362, 35, 113, 25);
		frame.getContentPane().add(elevatorCheckBox);
		
		JCheckBox parkingCheckBox = new JCheckBox("\u05D7\u05E0\u05D9\u05D4");
		parkingCheckBox.setBounds(362, 69, 113, 25);
		frame.getContentPane().add(parkingCheckBox);
		
		JCheckBox airCheckBox = new JCheckBox("\u05DE\u05D9\u05D6\u05D5\u05D2");
		airCheckBox.setBounds(362, 108, 113, 25);
		frame.getContentPane().add(airCheckBox);
		
		JCheckBox patioCheckBox = new JCheckBox("\u05DE\u05E8\u05E4\u05E1\u05EA");
		patioCheckBox.setBounds(362, 141, 113, 25);
		frame.getContentPane().add(patioCheckBox);
		
		JCheckBox mamadCheckBox = new JCheckBox("\u05DE\u05DE\"\u05D3");
		mamadCheckBox.setBounds(362, 179, 113, 25);
		frame.getContentPane().add(mamadCheckBox);
		
		JCheckBox storageCheckBox = new JCheckBox("\u05DE\u05D7\u05E1\u05DF");
		storageCheckBox.setBounds(77, 25, 113, 25);
		frame.getContentPane().add(storageCheckBox);
		
		JCheckBox accesibleCheckBox = new JCheckBox("\u05D2\u05D9\u05E9\u05D4 \u05DC\u05E0\u05DB\u05D9\u05DD");
		accesibleCheckBox.setBounds(77, 59, 145, 25);
		frame.getContentPane().add(accesibleCheckBox);
		
		JCheckBox furnitureCheckBox = new JCheckBox("\u05DE\u05E8\u05D5\u05D4\u05D8\u05EA");
		furnitureCheckBox.setBounds(77, 98, 113, 25);
		frame.getContentPane().add(furnitureCheckBox);
		
		JCheckBox petCheckBox = new JCheckBox("\u05D7\u05D9\u05D5\u05EA \u05DE\u05D7\u05DE\u05D3");
		petCheckBox.setBounds(77, 131, 113, 25);
		frame.getContentPane().add(petCheckBox);
		
		JLabel searchApartmentLabel = new JLabel("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05D3\u05D9\u05E8\u05D4");
		searchApartmentLabel.setBounds(368, 4, 83, 16);
		frame.getContentPane().add(searchApartmentLabel);
		
		JButton searchButton = new JButton("\u05D7\u05E4\u05E9");
		searchButton.setBounds(378, 357, 97, 25);
		frame.getContentPane().add(searchButton);
		
		JLabel searchResultLabel = new JLabel("\u05EA\u05D5\u05E6\u05D0\u05D5\u05EA \u05D7\u05D9\u05E4\u05D5\u05E9 - \u05E8\u05E9\u05D9\u05DE\u05D4");
		searchResultLabel.setBounds(363, 420, 196, 16);
		frame.getContentPane().add(searchResultLabel);
		
		JButton loginOrLogoutButton = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8/\u05D4\u05EA\u05E0\u05EA\u05E7");
		loginOrLogoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainView.showMainView();
				frame.setVisible(false);
			}
		});
		loginOrLogoutButton.setBounds(53, 171, 212, 25);
		frame.getContentPane().add(loginOrLogoutButton);
		
		JButton addApartmentButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05D3\u05D9\u05E8\u05D4 \u05D7\u05D3\u05E9\u05D4 - \u05DE\u05E0\u05D5\u05D9/\u05D0\u05D3\u05DE\u05D9\u05DF");
		addApartmentButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
			}
		});
		addApartmentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				addNewApartmentView.showAddNewApartmentView();
				frame.setVisible(false);
				
			}
		});
		addApartmentButton.setBounds(35, 205, 267, 25);
		frame.getContentPane().add(addApartmentButton);
		
		JButton watchApartmentButton = new JButton("\u05E6\u05E4\u05D9\u05D9\u05D4 \u05D1\u05D3\u05D9\u05E8\u05D5\u05EA \u05E9\u05DC\u05DA - \u05DE\u05E0\u05D5\u05D9");
		watchApartmentButton.setBounds(53, 244, 212, 25);
		frame.getContentPane().add(watchApartmentButton);
		
		JButton watchSearchResultButton = new JButton("\u05E6\u05E4\u05D9\u05D9\u05D4 \u05D1\u05E0\u05EA\u05D5\u05E0\u05D9 \u05D7\u05D9\u05E4\u05D5\u05E9 - \u05D0\u05D3\u05DE\u05D9\u05DF");
		watchSearchResultButton.setBounds(47, 278, 218, 25);
		frame.getContentPane().add(watchSearchResultButton);
		
		JButton printSearchResultButton = new JButton("\u05D4\u05D3\u05E4\u05E1\u05EA \u05EA\u05D5\u05E6\u05D0\u05D5\u05EA \u05D7\u05D9\u05E4\u05D5\u05E9");
		printSearchResultButton.setBounds(53, 357, 212, 25);
		frame.getContentPane().add(printSearchResultButton);
		
		JButton showAllUsersButton = new JButton("\u05D4\u05E6\u05D2 \u05D0\u05EA \u05DB\u05DC \u05D4\u05DE\u05E9\u05EA\u05DE\u05E9\u05D9\u05DD");
		showAllUsersButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				openShowAllUsersView();
			}
		});
		showAllUsersButton.setBounds(53, 319, 212, 25);
		frame.getContentPane().add(showAllUsersButton);
		
		searchResultTable = new JTable();
		searchResultTable.setBounds(77, 446, 676, 106);
		frame.getContentPane().add(searchResultTable);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(563, 283, -84, 8);
		frame.getContentPane().add(comboBox);
		
		JComboBox propertyTypecomboBox = new JComboBox();
		propertyTypecomboBox.setEditable(true);
		propertyTypecomboBox.setBounds(483, 281, 116, 32);
		frame.getContentPane().add(propertyTypecomboBox);
		
		JLabel propertyTypeLabel = new JLabel("\u05E1\u05D5\u05D2 \u05D4\u05E0\u05DB\u05E1");
		propertyTypeLabel.setBounds(620, 283, 69, 20);
		frame.getContentPane().add(propertyTypeLabel);

	}
	
	
	
	public void setMainView(MainView mainView) { // know who to return when event handler (back)
		this.mainView = mainView;
	}
	
	public void openShowAllApartment() {
		//showAllUsersView.showAllUsersView();
		frame.setVisible(true);
		this.frame.setEnabled(true);
	}
	
	
	public void openShowAllUsersView() {
		showAllUsersView.showAllUsersVeiw();	
	}

}
