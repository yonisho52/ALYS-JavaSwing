package view;

import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;

public class AddNewApartmentView extends Observable {
	

	ShowAllApartmentView showAllApartmentView;

	private JFrame frame;
	private JTextField City;
	private JTextField apartmentType;
	private JTextField StartPrice;
	private JTextField LimitPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewApartmentView window = new AddNewApartmentView();
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
	
	public AddNewApartmentView(ShowAllApartmentView showAllApartmentView) {
		this.showAllApartmentView = showAllApartmentView;
		initialize();
	}
	
	public AddNewApartmentView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 692, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton addButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05D4");
		addButton.setBounds(411, 390, 97, 25);
		frame.getContentPane().add(addButton);
		
		JButton CancelButton = new JButton("\u05D1\u05D9\u05D8\u05D5\u05DC");
		CancelButton.setBounds(237, 390, 97, 25);
		frame.getContentPane().add(CancelButton);
		
		JLabel addNewApartmentLabel = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05D3\u05D9\u05E8\u05D4 \u05D7\u05D3\u05E9\u05D4");
		addNewApartmentLabel.setBounds(293, 28, 118, 16);
		frame.getContentPane().add(addNewApartmentLabel);
		
		JLabel CityLabel = new JLabel("\u05E2\u05D9\u05E8");
		CityLabel.setBounds(485, 85, 36, 16);
		frame.getContentPane().add(CityLabel);
		
		JLabel apartmentTypeLabel = new JLabel("\u05E1\u05D5\u05D2 \u05D3\u05D9\u05E8\u05D4");
		apartmentTypeLabel.setBounds(485, 119, 56, 16);
		frame.getContentPane().add(apartmentTypeLabel);
		
		City = new JTextField();
		City.setBounds(348, 82, 116, 22);
		frame.getContentPane().add(City);
		City.setColumns(10);
		
		apartmentType = new JTextField();
		apartmentType.setBounds(348, 116, 116, 22);
		frame.getContentPane().add(apartmentType);
		apartmentType.setColumns(10);
		
		JLabel numOfRoomatesLabel = new JLabel("\u05E1\u05D4\"\u05DB \u05E9\u05D5\u05EA\u05E4\u05D9\u05DD");
		numOfRoomatesLabel.setBounds(485, 158, 90, 16);
		frame.getContentPane().add(numOfRoomatesLabel);
		
		JSpinner numOfRommatesspinner = new JSpinner();
		numOfRommatesspinner.setBounds(428, 155, 36, 22);
		frame.getContentPane().add(numOfRommatesspinner);
		
		JLabel MissingRoomatesLabel = new JLabel("\u05E9\u05D5\u05EA\u05E4\u05D9\u05DD \u05D7\u05E1\u05E8\u05D9\u05DD");
		MissingRoomatesLabel.setBounds(485, 187, 97, 16);
		frame.getContentPane().add(MissingRoomatesLabel);
		
		JSpinner MissingRoomatesSpinner = new JSpinner();
		MissingRoomatesSpinner.setBounds(428, 184, 36, 22);
		frame.getContentPane().add(MissingRoomatesSpinner);
		
		JLabel RoomsLabel = new JLabel("\u05D7\u05D3\u05E8\u05D9\u05DD");
		RoomsLabel.setBounds(485, 216, 56, 16);
		frame.getContentPane().add(RoomsLabel);
		
		JSpinner RoomsSpinner = new JSpinner();
		RoomsSpinner.setBounds(428, 213, 36, 22);
		frame.getContentPane().add(RoomsSpinner);
		
		JLabel StartPriceLabel = new JLabel("\u05DE\u05DE\u05D7\u05D9\u05E8");
		StartPriceLabel.setBounds(485, 245, 56, 16);
		frame.getContentPane().add(StartPriceLabel);
		
		StartPrice = new JTextField();
		StartPrice.setBounds(348, 242, 116, 22);
		frame.getContentPane().add(StartPrice);
		StartPrice.setColumns(10);
		
		JLabel LimitPriceLabel = new JLabel("\u05E2\u05D3 \u05DE\u05D7\u05D9\u05E8");
		LimitPriceLabel.setBounds(485, 277, 56, 16);
		frame.getContentPane().add(LimitPriceLabel);
		
		LimitPrice = new JTextField();
		LimitPrice.setBounds(348, 274, 116, 22);
		frame.getContentPane().add(LimitPrice);
		LimitPrice.setColumns(10);
		
		JCheckBox ElevatorCheckBox = new JCheckBox("\u05DE\u05E2\u05DC\u05D9\u05EA");
		ElevatorCheckBox.setBounds(165, 81, 113, 25);
		frame.getContentPane().add(ElevatorCheckBox);
		
		JCheckBox ParkingCheckBox = new JCheckBox("\u05D7\u05E0\u05D9\u05D4");
		ParkingCheckBox.setBounds(165, 115, 113, 25);
		frame.getContentPane().add(ParkingCheckBox);
		
		JCheckBox AirCheckBox = new JCheckBox("\u05DE\u05D9\u05D6\u05D5\u05D2");
		AirCheckBox.setBounds(165, 154, 113, 25);
		frame.getContentPane().add(AirCheckBox);
		
		JCheckBox PatioCheckBox = new JCheckBox("\u05DE\u05E8\u05E4\u05E1\u05EA");
		PatioCheckBox.setBounds(165, 187, 113, 25);
		frame.getContentPane().add(PatioCheckBox);
		
		JCheckBox MamadCheckBox = new JCheckBox("\u05DE\u05DE\"\u05D3");
		MamadCheckBox.setBounds(165, 225, 113, 25);
		frame.getContentPane().add(MamadCheckBox);
		
		JCheckBox StorageCheckBox = new JCheckBox("\u05DE\u05D7\u05E1\u05DF");
		StorageCheckBox.setBounds(48, 81, 113, 25);
		frame.getContentPane().add(StorageCheckBox);
		
		JCheckBox AccesibleCheckBox = new JCheckBox("\u05D2\u05D9\u05E9\u05D4 \u05DC\u05E0\u05DB\u05D9\u05DD");
		AccesibleCheckBox.setBounds(48, 115, 113, 25);
		frame.getContentPane().add(AccesibleCheckBox);
		
		JCheckBox FurnitureCheckBox = new JCheckBox("\u05DE\u05E8\u05D5\u05D4\u05D8\u05EA");
		FurnitureCheckBox.setBounds(48, 154, 113, 25);
		frame.getContentPane().add(FurnitureCheckBox);
		
		JCheckBox PetCheckBox = new JCheckBox("\u05D7\u05D9\u05D5\u05EA \u05DE\u05D7\u05DE\u05D3");
		PetCheckBox.setBounds(48, 187, 113, 25);
		frame.getContentPane().add(PetCheckBox);
	}
}
