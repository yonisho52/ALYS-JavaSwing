package view;

import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.RegisterView.AddUser;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

public class AddNewApartmentView extends Observable {
	
	ShowAllApartmentView showAllApartmentView;

	private JFrame frame;
	private JTextField cityTextFile;
	private JTextField streetTextFile;
	private JTextField priceTextField;
	private JComboBox propertyTypeComboBox;
	private JLabel floorCountLabel;
	private JLabel floorNumLabel;
	private JSpinner floorsBuildingSpinner;
	private JCheckBox gardenGroundCheckBox;
	private JLabel apartmentNumberLabel;
	private JSpinner apartmentNumberGroundSpinner;
	private JSpinner numOfRommatesSpinner;
	private JSpinner missingRoomatesSpinner;
	private JCheckBox elevatorCheckBox;
	private JCheckBox parkingCheckBox;
	private JCheckBox airCheckBox;
	private JCheckBox patioCheckBox;
	private JCheckBox mamadCheckBox;
	private JCheckBox storageCheckBox;	
	private JCheckBox accesibleCheckBox;	
	private JCheckBox furnitureCheckBox;
	private JCheckBox petCheckBox;
	private JTextArea descriptionTextArea;
	private JSpinner roomsSpinner;
	private JSpinner floorCountGroundSpinner;
	
	protected String connectedUser;
	protected boolean adminBool;
	
	protected boolean apartmentType=false;  // ground = false, building = true

	
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
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addThisApartment();	
			}
		});
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
		
		cityTextFile = new JTextField();
		cityTextFile.setBounds(348, 82, 116, 22);
		frame.getContentPane().add(cityTextFile);
		cityTextFile.setColumns(10);
		
		streetTextFile = new JTextField();
		streetTextFile.setBounds(348, 116, 116, 22);
		frame.getContentPane().add(streetTextFile);
		streetTextFile.setColumns(10);
		
		JLabel numOfRoomatesLabel = new JLabel("\u05E1\u05D4\"\u05DB \u05E9\u05D5\u05EA\u05E4\u05D9\u05DD");
		numOfRoomatesLabel.setBounds(485, 158, 116, 16);
		frame.getContentPane().add(numOfRoomatesLabel);
		
		numOfRommatesSpinner = new JSpinner();
		numOfRommatesSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		numOfRommatesSpinner.setBounds(428, 155, 36, 22);
		frame.getContentPane().add(numOfRommatesSpinner);
		
		JLabel missingRoomatesLabel = new JLabel("\u05E9\u05D5\u05EA\u05E4\u05D9\u05DD \u05D7\u05E1\u05E8\u05D9\u05DD");
		missingRoomatesLabel.setBounds(485, 187, 116, 16);
		frame.getContentPane().add(missingRoomatesLabel);
		
		missingRoomatesSpinner = new JSpinner();
		missingRoomatesSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		missingRoomatesSpinner.setBounds(428, 184, 36, 22);
		frame.getContentPane().add(missingRoomatesSpinner);
		
		JLabel roomsLabel = new JLabel("\u05D7\u05D3\u05E8\u05D9\u05DD");
		roomsLabel.setBounds(485, 216, 56, 16);
		frame.getContentPane().add(roomsLabel);
		
		roomsSpinner = new JSpinner();
		roomsSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		roomsSpinner.setBounds(428, 213, 36, 22);
		frame.getContentPane().add(roomsSpinner);
		
		JLabel priceLabel = new JLabel("\u05DE\u05DE\u05D7\u05D9\u05E8");
		priceLabel.setBounds(485, 245, 56, 16);
		frame.getContentPane().add(priceLabel);
		
		priceTextField = new JTextField();
		priceTextField.setBounds(348, 242, 116, 22);
		frame.getContentPane().add(priceTextField);
		priceTextField.setColumns(10);
		
		elevatorCheckBox = new JCheckBox("\u05DE\u05E2\u05DC\u05D9\u05EA");
		elevatorCheckBox.setBounds(165, 81, 113, 25);
		frame.getContentPane().add(elevatorCheckBox);
		
		parkingCheckBox = new JCheckBox("\u05D7\u05E0\u05D9\u05D4");
		parkingCheckBox.setBounds(165, 115, 113, 25);
		frame.getContentPane().add(parkingCheckBox);
		
		airCheckBox = new JCheckBox("\u05DE\u05D9\u05D6\u05D5\u05D2");
		airCheckBox.setBounds(165, 154, 113, 25);
		frame.getContentPane().add(airCheckBox);
		
		patioCheckBox = new JCheckBox("\u05DE\u05E8\u05E4\u05E1\u05EA");
		patioCheckBox.setBounds(165, 187, 113, 25);
		frame.getContentPane().add(patioCheckBox);
		
		mamadCheckBox = new JCheckBox("\u05DE\u05DE\"\u05D3");
		mamadCheckBox.setBounds(165, 225, 113, 25);
		frame.getContentPane().add(mamadCheckBox);
		
		storageCheckBox = new JCheckBox("\u05DE\u05D7\u05E1\u05DF");
		storageCheckBox.setBounds(48, 81, 113, 25);
		frame.getContentPane().add(storageCheckBox);
		
		accesibleCheckBox = new JCheckBox("\u05D2\u05D9\u05E9\u05D4 \u05DC\u05E0\u05DB\u05D9\u05DD");
		accesibleCheckBox.setBounds(48, 115, 113, 25);
		frame.getContentPane().add(accesibleCheckBox);
		
		furnitureCheckBox = new JCheckBox("\u05DE\u05E8\u05D5\u05D4\u05D8\u05EA");
		furnitureCheckBox.setBounds(48, 154, 113, 25);
		frame.getContentPane().add(furnitureCheckBox);
		
		petCheckBox = new JCheckBox("\u05D7\u05D9\u05D5\u05EA \u05DE\u05D7\u05DE\u05D3");
		petCheckBox.setBounds(48, 187, 113, 25);
		frame.getContentPane().add(petCheckBox);
		
		String apartmentType[] = {"דירת קרקע","דירה בבנין"};
		propertyTypeComboBox = new JComboBox(apartmentType);
		propertyTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"דירת קרקע", "דירה בבניין"}));
		propertyTypeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				groundOrBuilding(propertyTypeComboBox.getItemAt(propertyTypeComboBox.getSelectedIndex()).toString());
			}
		});
		propertyTypeComboBox.setEditable(true);
		propertyTypeComboBox.setBounds(312, 280, 171, 32);
		propertyTypeComboBox.setEditable(false);
		frame.getContentPane().add(propertyTypeComboBox);
		
		
		JLabel propertyTypeLabel = new JLabel("\u05E1\u05D5\u05D2 \u05D4\u05E0\u05DB\u05E1");
		propertyTypeLabel.setBounds(495, 286, 69, 20);
		frame.getContentPane().add(propertyTypeLabel);
		
		descriptionTextArea = new JTextArea();
		descriptionTextArea.setBounds(15, 260, 146, 71);
		frame.getContentPane().add(descriptionTextArea);
		
		JLabel descriptionLabel = new JLabel("\u05EA\u05D9\u05D0\u05D5\u05E8");
		descriptionLabel.setBounds(175, 262, 69, 20);
		frame.getContentPane().add(descriptionLabel);
		
		floorCountLabel = new JLabel("מספר קומות");
		floorCountLabel.setBounds(595, 344, 69, 16);
		frame.getContentPane().add(floorCountLabel);
		
		JLabel label_5 = new JLabel("\u05DB\u05E9\u05E1\u05D5\u05D2 \u05D4\u05E0\u05DB\u05E1 \u05D1\u05D9\u05EA \u05E7\u05E8\u05E7\u05E2");
		label_5.setBounds(505, 317, 127, 16);
		frame.getContentPane().add(label_5);
		
		floorNumLabel = new JLabel("\u05E7\u05D5\u05DE\u05D4");
		floorNumLabel.setBounds(584, 395, 56, 16);
		floorNumLabel.setVisible(false);
		frame.getContentPane().add(floorNumLabel);
		
		apartmentNumberLabel = new JLabel("מספר דירה");
		apartmentNumberLabel.setBounds(584, 455, 80, 16);
		apartmentNumberLabel.setVisible(false);
		frame.getContentPane().add(apartmentNumberLabel);
		
		JLabel label_5_1 = new JLabel("\u05DB\u05E9\u05E1\u05D5\u05D2 \u05D4\u05E0\u05DB\u05E1 \u05D1\u05D9\u05EA \u05D1\u05D1\u05E0\u05D9\u05D9\u05DF");
		label_5_1.setBounds(505, 371, 127, 16);
		frame.getContentPane().add(label_5_1);
		
		gardenGroundCheckBox = new JCheckBox("\u05D2\u05D9\u05E0\u05D4");
		gardenGroundCheckBox.setBounds(527, 423, 113, 25);
		gardenGroundCheckBox.setVisible(false);
		frame.getContentPane().add(gardenGroundCheckBox);
		
		floorsBuildingSpinner = new JSpinner();
		floorsBuildingSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		floorsBuildingSpinner.setBounds(528, 391, 36, 22);
		floorsBuildingSpinner.setVisible(false);
		frame.getContentPane().add(floorsBuildingSpinner);
		
		apartmentNumberGroundSpinner = new JSpinner();
		apartmentNumberGroundSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		apartmentNumberGroundSpinner.setBounds(528, 453, 36, 22);
		apartmentNumberGroundSpinner.setVisible(false);
		frame.getContentPane().add(apartmentNumberGroundSpinner);
		
		floorCountGroundSpinner = new JSpinner();
		floorCountGroundSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		floorCountGroundSpinner.setBounds(528, 340, 36, 25);
		frame.getContentPane().add(floorCountGroundSpinner);
	}
	
	public void groundOrBuilding(String type)
	{
		if(type.toString().equals("דירה בבנין"))
		{
				this.apartmentType = true;
				floorCountGroundSpinner.setVisible(false);
				floorCountGroundSpinner.setValue(0);
				
				floorCountLabel.setVisible(false);
				
				
				floorNumLabel.setVisible(true);
				floorsBuildingSpinner.setVisible(true);
				gardenGroundCheckBox.setVisible(true);
				apartmentNumberLabel.setVisible(true);
				apartmentNumberGroundSpinner.setVisible(true);
				
		}
		else if(type.toString().equals("דירת קרקע"))
		{
			this.apartmentType = false;
			floorCountGroundSpinner.setVisible(true);
			floorCountLabel.setVisible(true);
			
			floorNumLabel.setVisible(false);
			floorsBuildingSpinner.setVisible(false);
			floorsBuildingSpinner.setValue(0);
			
			gardenGroundCheckBox.setVisible(false);
			gardenGroundCheckBox.setSelected(false);
			
			apartmentNumberLabel.setVisible(false);
			apartmentNumberGroundSpinner.setVisible(false);
		}
	}
	
//	ALL toghter 
//	String [] buildingApartment = {cityTextFile.getText().toString(),apartmentTypeTextFile.getText().toString(),numOfRommatesSpinner.getValue().toString(),
//			missingRoomatesSpinner.getValue().toString(), roomsSpinner.getValue().toString(), priceTextField.getText().toString(), descriptionTextArea.getText().toString(),
//			propertyTypeComboBox.getItemAt(propertyTypeComboBox.getSelectedIndex()).toString(), floorsBuildingSpinner.getValue().toString(),
//			String.valueOf(gardenGroundCheckBox.isSelected()), apartmentNumberGroundSpinner.getValue().toString(), floorCountGroundSpinner.getValue().toString(),
//			String.valueOf(elevatorCheckBox.isSelected()), String.valueOf(parkingCheckBox.isSelected()), String.valueOf(airCheckBox.isSelected()), 
//			String.valueOf(patioCheckBox.isSelected()), String.valueOf(mamadCheckBox.isSelected()), String.valueOf(storageCheckBox.isSelected()), 
//			String.valueOf(accesibleCheckBox.isSelected()), String.valueOf(furnitureCheckBox.isSelected()), String.valueOf(petCheckBox.isSelected())};
	

	
	public void addThisApartment() 
	{
		if(apartmentType) // true = building // missed apartmentType and floor count
		{
		String [] buildingApartment = {cityTextFile.getText().toString(),streetTextFile.getText().toString(),numOfRommatesSpinner.getValue().toString(),
				missingRoomatesSpinner.getValue().toString(), roomsSpinner.getValue().toString(), priceTextField.getText().toString(), descriptionTextArea.getText().toString(),
				floorsBuildingSpinner.getValue().toString(), String.valueOf(gardenGroundCheckBox.isSelected()), apartmentNumberGroundSpinner.getValue().toString(), 
				String.valueOf(elevatorCheckBox.isSelected()), String.valueOf(parkingCheckBox.isSelected()), String.valueOf(airCheckBox.isSelected()), 
				String.valueOf(patioCheckBox.isSelected()), String.valueOf(mamadCheckBox.isSelected()), String.valueOf(storageCheckBox.isSelected()), 
				String.valueOf(accesibleCheckBox.isSelected()), String.valueOf(furnitureCheckBox.isSelected()), String.valueOf(petCheckBox.isSelected()), connectedUser};
		
		setChanged();
		notifyObservers(new AddBuilding(buildingApartment));

		}
		else // false = ground
		{
			String [] groundApartment = {cityTextFile.getText().toString(),streetTextFile.getText().toString(),numOfRommatesSpinner.getValue().toString(),
					missingRoomatesSpinner.getValue().toString(), roomsSpinner.getValue().toString(), priceTextField.getText().toString(), descriptionTextArea.getText().toString(),
					floorCountGroundSpinner.getValue().toString(),String.valueOf(elevatorCheckBox.isSelected()), String.valueOf(parkingCheckBox.isSelected()), 
					String.valueOf(airCheckBox.isSelected()), String.valueOf(patioCheckBox.isSelected()), String.valueOf(mamadCheckBox.isSelected()),
					String.valueOf(storageCheckBox.isSelected()), String.valueOf(accesibleCheckBox.isSelected()), String.valueOf(furnitureCheckBox.isSelected()), 
					String.valueOf(petCheckBox.isSelected()), connectedUser};
			
			setChanged();
			notifyObservers(new AddGround(groundApartment));
			
		}
	
//		this.frame.setVisible(false); 
//		showAllApartmentView.openShowAllApartment(userName.getText(),false);	

	}
	
	public class AddGround
	{
		public String [] ground;
		public AddGround(String [] groundApartment)
		{
			this.ground = groundApartment;
		}
	}
	
	public class AddBuilding
	{
		public String [] building;
		public AddBuilding(String [] building)
		{
			this.building = building;
		}
	}
	

	
	
	
	
}
