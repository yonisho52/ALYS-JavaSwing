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

public class ShowAllApartmentView extends Observable {
	
	
	SearchDetailsView searchDetailsView;
	AddNewApartmentView addNewApartmentView;
	ShowUserApartmentView showUserApartmentView;
	MainView mainView;

	private JFrame frame;
	private JTextField City;
	private JTextField ApartmentType;
	private JTextField LimitPrice;
	private JTextField StartPrice;
	private JLabel CityLabel;  /// example for all 
	

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
			ShowUserApartmentView showUserApartmentView) {
		this.searchDetailsView = searchDetailsView;
		this.addNewApartmentView = addNewApartmentView;
		this.showUserApartmentView = showUserApartmentView;
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
		frame.setBounds(100, 100, 747, 470);
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
		
		JLabel apartmentTypeLabel = new JLabel("\u05E1\u05D5\u05D2 \u05D3\u05D9\u05E8\u05D4");
		apartmentTypeLabel.setBounds(620, 72, 56, 16);
		frame.getContentPane().add(apartmentTypeLabel);
		
		JLabel numOfRoomatesLabel = new JLabel("\u05E1\u05D4\"\u05DB \u05E9\u05D5\u05EA\u05E4\u05D9\u05DD");
		numOfRoomatesLabel.setBounds(620, 111, 90, 16);
		frame.getContentPane().add(numOfRoomatesLabel);
		
		JLabel MissingRoomatesLabel = new JLabel("\u05E9\u05D5\u05EA\u05E4\u05D9\u05DD \u05D7\u05E1\u05E8\u05D9\u05DD");
		MissingRoomatesLabel.setBounds(620, 140, 97, 16);
		frame.getContentPane().add(MissingRoomatesLabel);
		
		JLabel RoomsLabel = new JLabel("\u05D7\u05D3\u05E8\u05D9\u05DD");
		RoomsLabel.setBounds(620, 169, 56, 16);
		frame.getContentPane().add(RoomsLabel);
		
		JLabel StartPriceLabel = new JLabel("\u05DE\u05DE\u05D7\u05D9\u05E8");
		StartPriceLabel.setBounds(620, 198, 56, 16);
		frame.getContentPane().add(StartPriceLabel);
		
		JLabel LimitPriceLabel = new JLabel("\u05E2\u05D3 \u05DE\u05D7\u05D9\u05E8");
		LimitPriceLabel.setBounds(620, 230, 56, 16);
		frame.getContentPane().add(LimitPriceLabel);
		
		LimitPrice = new JTextField();
		LimitPrice.setColumns(10);
		LimitPrice.setBounds(483, 227, 116, 22);
		frame.getContentPane().add(LimitPrice);
		
		StartPrice = new JTextField();
		StartPrice.setColumns(10);
		StartPrice.setBounds(483, 195, 116, 22);
		frame.getContentPane().add(StartPrice);
		
		JSpinner RoomsSpinner = new JSpinner();
		RoomsSpinner.setBounds(563, 166, 36, 22);
		frame.getContentPane().add(RoomsSpinner);
		
		JSpinner MissingRoomatesSpinner = new JSpinner();
		MissingRoomatesSpinner.setBounds(563, 137, 36, 22);
		frame.getContentPane().add(MissingRoomatesSpinner);
		
		JSpinner numOfRommatesspinner = new JSpinner();
		numOfRommatesspinner.setBounds(563, 108, 36, 22);
		frame.getContentPane().add(numOfRommatesspinner);
		
		JCheckBox ElevatorCheckBox = new JCheckBox("\u05DE\u05E2\u05DC\u05D9\u05EA");
		ElevatorCheckBox.setBounds(362, 35, 113, 25);
		frame.getContentPane().add(ElevatorCheckBox);
		
		JCheckBox ParkingCheckBox = new JCheckBox("\u05D7\u05E0\u05D9\u05D4");
		ParkingCheckBox.setBounds(362, 69, 113, 25);
		frame.getContentPane().add(ParkingCheckBox);
		
		JCheckBox AirCheckBox = new JCheckBox("\u05DE\u05D9\u05D6\u05D5\u05D2");
		AirCheckBox.setBounds(362, 108, 113, 25);
		frame.getContentPane().add(AirCheckBox);
		
		JCheckBox PatioCheckBox = new JCheckBox("\u05DE\u05E8\u05E4\u05E1\u05EA");
		PatioCheckBox.setBounds(362, 141, 113, 25);
		frame.getContentPane().add(PatioCheckBox);
		
		JCheckBox MamadCheckBox = new JCheckBox("\u05DE\u05DE\"\u05D3");
		MamadCheckBox.setBounds(362, 179, 113, 25);
		frame.getContentPane().add(MamadCheckBox);
		
		JCheckBox StorageCheckBox = new JCheckBox("\u05DE\u05D7\u05E1\u05DF");
		StorageCheckBox.setBounds(245, 35, 113, 25);
		frame.getContentPane().add(StorageCheckBox);
		
		JCheckBox AccesibleCheckBox = new JCheckBox("\u05D2\u05D9\u05E9\u05D4 \u05DC\u05E0\u05DB\u05D9\u05DD");
		AccesibleCheckBox.setBounds(245, 69, 113, 25);
		frame.getContentPane().add(AccesibleCheckBox);
		
		JCheckBox FurnitureCheckBox = new JCheckBox("\u05DE\u05E8\u05D5\u05D4\u05D8\u05EA");
		FurnitureCheckBox.setBounds(245, 108, 113, 25);
		frame.getContentPane().add(FurnitureCheckBox);
		
		JCheckBox PetCheckBox = new JCheckBox("\u05D7\u05D9\u05D5\u05EA \u05DE\u05D7\u05DE\u05D3");
		PetCheckBox.setBounds(245, 141, 113, 25);
		frame.getContentPane().add(PetCheckBox);
		
		JLabel SearchApartmentLabel = new JLabel("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05D3\u05D9\u05E8\u05D4");
		SearchApartmentLabel.setBounds(368, 4, 83, 16);
		frame.getContentPane().add(SearchApartmentLabel);
		
		JButton SearchButton = new JButton("\u05D7\u05E4\u05E9");
		SearchButton.setBounds(308, 226, 97, 25);
		frame.getContentPane().add(SearchButton);
		
		JList list = new JList();
		list.setBounds(12, 295, 661, 115);
		frame.getContentPane().add(list);
		
		JLabel SearchResultLabel = new JLabel("\u05EA\u05D5\u05E6\u05D0\u05D5\u05EA \u05D7\u05D9\u05E4\u05D5\u05E9 - \u05E8\u05E9\u05D9\u05DE\u05D4");
		SearchResultLabel.setBounds(308, 266, 143, 16);
		frame.getContentPane().add(SearchResultLabel);
		
		JButton loginOrLogoutButton = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8/\u05D4\u05EA\u05E0\u05EA\u05E7");
		loginOrLogoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainView.showMainView();
				frame.setVisible(false);
			}
		});
		loginOrLogoutButton.setBounds(38, 34, 128, 25);
		frame.getContentPane().add(loginOrLogoutButton);
		
		JButton AddApartmentButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05D3\u05D9\u05E8\u05D4 \u05D7\u05D3\u05E9\u05D4 - \u05DE\u05E0\u05D5\u05D9/\u05D0\u05D3\u05DE\u05D9\u05DF");
		AddApartmentButton.setBounds(12, 68, 227, 25);
		frame.getContentPane().add(AddApartmentButton);
		
		JButton WatchApartmentButton = new JButton("\u05E6\u05E4\u05D9\u05D9\u05D4 \u05D1\u05D3\u05D9\u05E8\u05D5\u05EA \u05E9\u05DC\u05DA - \u05DE\u05E0\u05D5\u05D9");
		WatchApartmentButton.setBounds(22, 107, 182, 25);
		frame.getContentPane().add(WatchApartmentButton);
		
		JButton WatchSearchResultButton = new JButton("\u05E6\u05E4\u05D9\u05D9\u05D4 \u05D1\u05E0\u05EA\u05D5\u05E0\u05D9 \u05D7\u05D9\u05E4\u05D5\u05E9 - \u05D0\u05D3\u05DE\u05D9\u05DF");
		WatchSearchResultButton.setBounds(12, 141, 210, 25);
		frame.getContentPane().add(WatchSearchResultButton);
		
		JButton PrintSearchResultButton = new JButton("\u05D4\u05D3\u05E4\u05E1\u05EA \u05EA\u05D5\u05E6\u05D0\u05D5\u05EA \u05D7\u05D9\u05E4\u05D5\u05E9");
		PrintSearchResultButton.setBounds(38, 179, 184, 25);
		frame.getContentPane().add(PrintSearchResultButton);
	}
	
	public void setMainView(MainView mainView) { // know who to return when event handler (back)
		this.mainView = mainView;
	}
	
	public void openShowAllApartment() {
		frame.setVisible(true);
	}

}
