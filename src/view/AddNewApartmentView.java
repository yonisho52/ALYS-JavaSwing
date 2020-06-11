package view;

import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class AddNewApartmentView extends Observable {
	
	ShowAllApartmentView showAllApartmentView;

	private JFrame frame;
	private JTextField City;
	private JTextField apartmentType;
	private JTextField priceTextField;
	
	protected String connectedUser;
	protected boolean adminBool;
	private JTextField floorNumGroundtextField;

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
	
//	public AddNewApartmentView(ShowAllApartmentView showAllApartmentView) {
//		this.showAllApartmentView = showAllApartmentView;
//		initialize();
//	}
	
	public void setShowAllApartmentView(ShowAllApartmentView showAllApartmentView)
	{
		this.showAllApartmentView = showAllApartmentView;
	}
	
	public void showAddNewApartmentView(String userName, boolean admin)
	{
		this.adminBool = admin;
		this.connectedUser = userName;
		frame.setVisible(true);
		//this.frame.setEnabled(true);
	}
	
	public void setMain(ShowAllApartmentView showAllApartmentView) {
		this.showAllApartmentView = showAllApartmentView;
	}
	
	public AddNewApartmentView() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 738, 562);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton addButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05D4");
		addButton.setBackground(Color.PINK);
		addButton.setBounds(175, 418, 97, 25);
		frame.getContentPane().add(addButton);
		
		JButton cancelButton = new JButton("\u05D7\u05D6\u05E8\u05D4");
		cancelButton.setBackground(Color.PINK);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAllApartmentView.openShowAllApartment(connectedUser, adminBool); ///////
				frame.setVisible(false);
			}
		});
		cancelButton.setBounds(48, 418, 97, 25);
		frame.getContentPane().add(cancelButton);
		
		JLabel addNewApartmentLabel = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05D3\u05D9\u05E8\u05D4 \u05D7\u05D3\u05E9\u05D4");
		addNewApartmentLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		addNewApartmentLabel.setBounds(293, 28, 171, 16);
		frame.getContentPane().add(addNewApartmentLabel);
		
		JLabel cityLabel = new JLabel("\u05E2\u05D9\u05E8");
		cityLabel.setBounds(485, 85, 36, 16);
		frame.getContentPane().add(cityLabel);
		
		JLabel addressLabel = new JLabel("\u05E8\u05D7\u05D5\u05D1");
		addressLabel.setBounds(485, 119, 90, 16);
		frame.getContentPane().add(addressLabel);
		
		City = new JTextField();
		City.setBounds(348, 82, 116, 22);
		frame.getContentPane().add(City);
		City.setColumns(10);
		
		apartmentType = new JTextField();
		apartmentType.setBounds(348, 116, 116, 22);
		frame.getContentPane().add(apartmentType);
		apartmentType.setColumns(10);
		
		JLabel numOfRoomatesLabel = new JLabel("\u05E1\u05D4\"\u05DB \u05E9\u05D5\u05EA\u05E4\u05D9\u05DD");
		numOfRoomatesLabel.setBounds(485, 158, 116, 16);
		frame.getContentPane().add(numOfRoomatesLabel);
		
		JSpinner numOfRommatesSpinner = new JSpinner();
		numOfRommatesSpinner.setBounds(428, 155, 36, 22);
		frame.getContentPane().add(numOfRommatesSpinner);
		
		JLabel missingRoomatesLabel = new JLabel("\u05E9\u05D5\u05EA\u05E4\u05D9\u05DD \u05D7\u05E1\u05E8\u05D9\u05DD");
		missingRoomatesLabel.setBounds(485, 187, 116, 16);
		frame.getContentPane().add(missingRoomatesLabel);
		
		JSpinner missingRoomatesSpinner = new JSpinner();
		missingRoomatesSpinner.setBounds(428, 184, 36, 22);
		frame.getContentPane().add(missingRoomatesSpinner);
		
		JLabel roomsLabel = new JLabel("\u05D7\u05D3\u05E8\u05D9\u05DD");
		roomsLabel.setBounds(485, 216, 56, 16);
		frame.getContentPane().add(roomsLabel);
		
		JSpinner roomsSpinner = new JSpinner();
		roomsSpinner.setBounds(428, 213, 36, 22);
		frame.getContentPane().add(roomsSpinner);
		
		JLabel priceLabel = new JLabel("\u05DE\u05DE\u05D7\u05D9\u05E8");
		priceLabel.setBounds(485, 245, 56, 16);
		frame.getContentPane().add(priceLabel);
		
		priceTextField = new JTextField();
		priceTextField.setBounds(348, 242, 116, 22);
		frame.getContentPane().add(priceTextField);
		priceTextField.setColumns(10);
		
		JCheckBox elevatorCheckBox = new JCheckBox("\u05DE\u05E2\u05DC\u05D9\u05EA");
		elevatorCheckBox.setBounds(165, 81, 113, 25);
		frame.getContentPane().add(elevatorCheckBox);
		
		JCheckBox parkingCheckBox = new JCheckBox("\u05D7\u05E0\u05D9\u05D4");
		parkingCheckBox.setBounds(165, 115, 113, 25);
		frame.getContentPane().add(parkingCheckBox);
		
		JCheckBox airCheckBox = new JCheckBox("\u05DE\u05D9\u05D6\u05D5\u05D2");
		airCheckBox.setBounds(165, 154, 113, 25);
		frame.getContentPane().add(airCheckBox);
		
		JCheckBox patioCheckBox = new JCheckBox("\u05DE\u05E8\u05E4\u05E1\u05EA");
		patioCheckBox.setBounds(165, 187, 113, 25);
		frame.getContentPane().add(patioCheckBox);
		
		JCheckBox mamadCheckBox = new JCheckBox("\u05DE\u05DE\"\u05D3");
		mamadCheckBox.setBounds(165, 225, 113, 25);
		frame.getContentPane().add(mamadCheckBox);
		
		JCheckBox storageCheckBox = new JCheckBox("\u05DE\u05D7\u05E1\u05DF");
		storageCheckBox.setBounds(48, 81, 113, 25);
		frame.getContentPane().add(storageCheckBox);
		
		JCheckBox accesibleCheckBox = new JCheckBox("\u05D2\u05D9\u05E9\u05D4 \u05DC\u05E0\u05DB\u05D9\u05DD");
		accesibleCheckBox.setBounds(48, 115, 113, 25);
		frame.getContentPane().add(accesibleCheckBox);
		
		JCheckBox furnitureCheckBox = new JCheckBox("\u05DE\u05E8\u05D5\u05D4\u05D8\u05EA");
		furnitureCheckBox.setBounds(48, 154, 113, 25);
		frame.getContentPane().add(furnitureCheckBox);
		
		JCheckBox petCheckBox = new JCheckBox("\u05D7\u05D9\u05D5\u05EA \u05DE\u05D7\u05DE\u05D3");
		petCheckBox.setBounds(48, 187, 113, 25);
		frame.getContentPane().add(petCheckBox);
		
		JComboBox propertyTypeComboBox = new JComboBox();
		propertyTypeComboBox.setEditable(true);
		propertyTypeComboBox.setBounds(312, 280, 171, 32);
		frame.getContentPane().add(propertyTypeComboBox);
		
		JLabel propertyTypeLabel = new JLabel("\u05E1\u05D5\u05D2 \u05D4\u05E0\u05DB\u05E1");
		propertyTypeLabel.setBounds(495, 286, 69, 20);
		frame.getContentPane().add(propertyTypeLabel);
		
		JTextArea descriptiontextArea = new JTextArea();
		descriptiontextArea.setBounds(15, 260, 146, 71);
		frame.getContentPane().add(descriptiontextArea);
		
		JLabel descriptionLabel = new JLabel("\u05EA\u05D9\u05D0\u05D5\u05E8");
		descriptionLabel.setBounds(175, 262, 69, 20);
		frame.getContentPane().add(descriptionLabel);
		
		JLabel floorNumLabel = new JLabel("\u05DB\u05DE\u05D5\u05EA \u05E7\u05D5\u05DE\u05D5\u05EA");
		floorNumLabel.setBounds(595, 344, 69, 16);
		frame.getContentPane().add(floorNumLabel);
		
		floorNumGroundtextField = new JTextField();
		floorNumGroundtextField.setColumns(10);
		floorNumGroundtextField.setBounds(458, 341, 116, 22);
		frame.getContentPane().add(floorNumGroundtextField);
		
		JLabel label_5 = new JLabel("\u05DB\u05E9\u05E1\u05D5\u05D2 \u05D4\u05E0\u05DB\u05E1 \u05D1\u05D9\u05EA \u05E7\u05E8\u05E7\u05E2");
		label_5.setBounds(505, 317, 127, 16);
		frame.getContentPane().add(label_5);
		
		JLabel floorNumLabel_1 = new JLabel("\u05E7\u05D5\u05DE\u05D4");
		floorNumLabel_1.setBounds(584, 395, 56, 16);
		frame.getContentPane().add(floorNumLabel_1);
		
		JLabel floorNumLabel_1_2 = new JLabel("\u05DE\u05DE\u05D7\u05D9\u05E8");
		floorNumLabel_1_2.setBounds(584, 455, 56, 16);
		frame.getContentPane().add(floorNumLabel_1_2);
		
		JLabel label_5_1 = new JLabel("\u05DB\u05E9\u05E1\u05D5\u05D2 \u05D4\u05E0\u05DB\u05E1 \u05D1\u05D9\u05EA \u05D1\u05D1\u05E0\u05D9\u05D9\u05DF");
		label_5_1.setBounds(505, 371, 127, 16);
		frame.getContentPane().add(label_5_1);
		
		JCheckBox gardenGroundCheckBox = new JCheckBox("\u05D2\u05D9\u05E0\u05D4");
		gardenGroundCheckBox.setBounds(527, 423, 113, 25);
		frame.getContentPane().add(gardenGroundCheckBox);
		
		JSpinner floorsBuildingSpinner = new JSpinner();
		floorsBuildingSpinner.setBounds(528, 391, 36, 22);
		frame.getContentPane().add(floorsBuildingSpinner);
		
		JSpinner apartmentNumberGroundSpinner = new JSpinner();
		apartmentNumberGroundSpinner.setBounds(528, 453, 36, 22);
		frame.getContentPane().add(apartmentNumberGroundSpinner);
	}
}
