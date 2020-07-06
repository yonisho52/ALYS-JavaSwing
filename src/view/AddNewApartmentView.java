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

import com.sun.xml.internal.ws.Closeable;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Panel;
import javax.swing.ImageIcon;

public class AddNewApartmentView extends Observable 
{
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
	protected boolean analystBool;
	
	protected boolean apartmentType = false;  // ground = false, building = true
	private JLabel roomatesLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel citywarningLabel;
	private JLabel streetLabel;
	private JLabel amountLabel;
	protected boolean citybool , streetbool , amountbool ,roomatestbool ,pricebool;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
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
	
//	public AddNewApartmentView(ShowAllApartmentView showAllApartmentView) {
//		this.showAllApartmentView = showAllApartmentView;
//		initialize();
//	}
	
	public void setShowAllApartmentView(ShowAllApartmentView showAllApartmentView)
	{
		this.showAllApartmentView = showAllApartmentView;
	}
	
	public void showAddNewApartmentView(String userName, boolean admin, boolean analyst)
	{
		this.adminBool = admin;
		this.connectedUser = userName;
		this.analystBool = analyst;
		frame.setVisible(true);
		//this.frame.setEnabled(true);
	}
	
	public void setMain(ShowAllApartmentView showAllApartmentView) 
	{
		this.showAllApartmentView = showAllApartmentView;
	}
	
	public AddNewApartmentView() 
	{
		initialize();
	}

	
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 856, 758);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String apartmentType[] = {"דירת קרקע","דירה בבנין"};
		
		Panel panel = new Panel();
		panel.setBackground(new Color(119, 136, 153));
		panel.setBounds(0, 0, 841, 719);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton cancelButton = new JButton("\u05D7\u05D6\u05E8\u05D4");
		cancelButton.setBounds(12, 13, 116, 37);
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		cancelButton.setForeground(new Color(255, 255, 255));
		panel.add(cancelButton);
		cancelButton.setBackground(new Color(169, 169, 169));
		
		JLabel cityLabel = new JLabel("\u05E2\u05D9\u05E8");
		cityLabel.setBounds(721, 146, 36, 16);
		panel.add(cityLabel);
		cityLabel.setForeground(new Color(255, 255, 255));
		cityLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		cityTextFile = new JTextField();
		cityTextFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cityTextFile.setBounds(562, 143, 138, 25);
		panel.add(cityTextFile);
		cityTextFile.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				checkIfCityEmpty();
			}
		});
		cityTextFile.setColumns(10);
		
		citywarningLabel = new JLabel("הכנס עיר");
		citywarningLabel.setBounds(463, 152, 63, 16);
		panel.add(citywarningLabel);
		citywarningLabel.setForeground(Color.RED);
		
		JLabel addressLabel = new JLabel("\u05E8\u05D7\u05D5\u05D1");
		addressLabel.setBounds(714, 185, 49, 16);
		panel.add(addressLabel);
		addressLabel.setForeground(new Color(255, 255, 255));
		addressLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		streetTextFile = new JTextField();
		streetTextFile.setBounds(562, 182, 138, 25);
		panel.add(streetTextFile);
		streetTextFile.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkIfStreetEmpty();
			}
		});
		streetTextFile.setColumns(10);
		
		streetLabel = new JLabel("הכנס רחוב");
		streetLabel.setBounds(457, 186, 69, 16);
		panel.add(streetLabel);
		streetLabel.setForeground(Color.RED);
		
		lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setBounds(763, 146, 14, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.RED);
		
		lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setBounds(763, 185, 14, 16);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.RED);
		
		JLabel numOfRoomatesLabel = new JLabel("\u05E1\u05D4\"\u05DB \u05E9\u05D5\u05EA\u05E4\u05D9\u05DD");
		numOfRoomatesLabel.setBounds(651, 224, 106, 16);
		panel.add(numOfRoomatesLabel);
		numOfRoomatesLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		numOfRoomatesLabel.setForeground(new Color(255, 255, 255));
		
		numOfRommatesSpinner = new JSpinner();
		numOfRommatesSpinner.setBounds(590, 220, 36, 22);
		panel.add(numOfRommatesSpinner);
		numOfRommatesSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel missingRoomatesLabel = new JLabel("\u05E9\u05D5\u05EA\u05E4\u05D9\u05DD \u05D7\u05E1\u05E8\u05D9\u05DD");
		missingRoomatesLabel.setBounds(641, 257, 116, 16);
		panel.add(missingRoomatesLabel);
		missingRoomatesLabel.setForeground(new Color(255, 255, 255));
		missingRoomatesLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		missingRoomatesSpinner = new JSpinner();
		missingRoomatesSpinner.setBounds(590, 255, 36, 22);
		panel.add(missingRoomatesSpinner);
		missingRoomatesSpinner.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				System.out.println("yoni");
			}
		});
		missingRoomatesSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel roomsLabel = new JLabel("\u05D7\u05D3\u05E8\u05D9\u05DD");
		roomsLabel.setBounds(701, 292, 56, 16);
		panel.add(roomsLabel);
		roomsLabel.setForeground(new Color(255, 255, 255));
		roomsLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		roomsSpinner = new JSpinner();
		roomsSpinner.setBounds(590, 290, 36, 22);
		panel.add(roomsSpinner);
		roomsSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel priceLabel = new JLabel("מחיר");
		priceLabel.setBounds(714, 333, 49, 16);
		panel.add(priceLabel);
		priceLabel.setForeground(new Color(255, 255, 255));
		priceLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		priceTextField = new JTextField();
		priceTextField.setBounds(562, 330, 138, 25);
		panel.add(priceTextField);
		priceTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkIfAmountEmpty();
				checkValidPrice();
			}
		});
		priceTextField.setColumns(10);
		
		roomatesLabel = new JLabel("מס' גדול מסה\"כ שותפים!");
		roomatesLabel.setBounds(420, 254, 156, 25);
		panel.add(roomatesLabel);
		roomatesLabel.setForeground(Color.RED);
		roomatesLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setBounds(763, 333, 26, 16);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setForeground(Color.RED);
		
		amountLabel = new JLabel("הכנס מחיר תקין");
		amountLabel.setBounds(444, 334, 106, 16);
		panel.add(amountLabel);
		amountLabel.setForeground(Color.RED);
		
		JButton addButton = new JButton("\u05D4\u05D5\u05E1\u05E4\u05D4");
		addButton.setBounds(84, 612, 133, 52);
		panel.add(addButton);
		addButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		addButton.setForeground(new Color(255, 255, 255));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addThisApartment();	
			}
		});
		addButton.setBackground(new Color(169, 169, 169));
		
		JLabel descriptionLabel = new JLabel("\u05EA\u05D9\u05D0\u05D5\u05E8");
		descriptionLabel.setBounds(329, 292, 49, 20);
		panel.add(descriptionLabel);
		descriptionLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		descriptionLabel.setForeground(new Color(255, 255, 255));
		
		descriptionTextArea = new JTextArea();
		descriptionTextArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		descriptionTextArea.setBounds(44, 325, 336, 143);
		panel.add(descriptionTextArea);
		
		elevatorCheckBox = new JCheckBox("\u05DE\u05E2\u05DC\u05D9\u05EA");
		elevatorCheckBox.setBounds(284, 150, 80, 25);
		elevatorCheckBox.setBackground(new Color(119, 136, 153));
		panel.add(elevatorCheckBox);
		elevatorCheckBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		elevatorCheckBox.setForeground(new Color(255, 255, 255));
		
		parkingCheckBox = new JCheckBox("\u05D7\u05E0\u05D9\u05D4");
		parkingCheckBox.setBounds(182, 220, 69, 25);
		parkingCheckBox.setBackground(new Color(119, 136, 153));
		panel.add(parkingCheckBox);
		parkingCheckBox.setForeground(new Color(255, 255, 255));
		parkingCheckBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		airCheckBox = new JCheckBox("\u05DE\u05D9\u05D6\u05D5\u05D2");
		airCheckBox.setBounds(295, 185, 69, 25);
		airCheckBox.setBackground(new Color(119, 136, 153));
		panel.add(airCheckBox);
		airCheckBox.setForeground(new Color(255, 255, 255));
		airCheckBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		patioCheckBox = new JCheckBox("\u05DE\u05E8\u05E4\u05E1\u05EA");
		patioCheckBox.setBounds(84, 146, 88, 25);
		patioCheckBox.setBackground(new Color(119, 136, 153));
		panel.add(patioCheckBox);
		patioCheckBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		patioCheckBox.setForeground(new Color(255, 255, 255));
		
		mamadCheckBox = new JCheckBox("\u05DE\u05DE\"\u05D3");
		mamadCheckBox.setBounds(201, 185, 69, 25);
		mamadCheckBox.setBackground(new Color(119, 136, 153));
		panel.add(mamadCheckBox);
		mamadCheckBox.setForeground(new Color(255, 255, 255));
		mamadCheckBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		storageCheckBox = new JCheckBox("\u05DE\u05D7\u05E1\u05DF");
		storageCheckBox.setBounds(182, 147, 80, 25);
		storageCheckBox.setBackground(new Color(119, 136, 153));
		panel.add(storageCheckBox);
		storageCheckBox.setForeground(new Color(255, 255, 255));
		storageCheckBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		accesibleCheckBox = new JCheckBox("\u05D2\u05D9\u05E9\u05D4 \u05DC\u05E0\u05DB\u05D9\u05DD");
		accesibleCheckBox.setBounds(257, 220, 121, 25);
		accesibleCheckBox.setBackground(new Color(119, 136, 153));
		panel.add(accesibleCheckBox);
		accesibleCheckBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		accesibleCheckBox.setForeground(new Color(255, 255, 255));
		
		furnitureCheckBox = new JCheckBox("\u05DE\u05E8\u05D5\u05D4\u05D8\u05EA");
		furnitureCheckBox.setBounds(84, 185, 106, 25);
		furnitureCheckBox.setBackground(new Color(119, 136, 153));
		panel.add(furnitureCheckBox);
		furnitureCheckBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		furnitureCheckBox.setForeground(new Color(255, 255, 255));
		
		petCheckBox = new JCheckBox("\u05D7\u05D9\u05D5\u05EA \u05DE\u05D7\u05DE\u05D3");
		petCheckBox.setBounds(59, 220, 113, 25);
		petCheckBox.setBackground(new Color(119, 136, 153));
		panel.add(petCheckBox);
		petCheckBox.setForeground(new Color(255, 255, 255));
		petCheckBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		JLabel propertyTypeLabel = new JLabel("\u05E1\u05D5\u05D2 \u05D4\u05E0\u05DB\u05E1");
		propertyTypeLabel.setBounds(678, 414, 80, 20);
		panel.add(propertyTypeLabel);
		propertyTypeLabel.setForeground(new Color(255, 255, 255));
		propertyTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setBounds(758, 415, 19, 16);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setForeground(Color.RED);
		propertyTypeComboBox = new JComboBox(apartmentType);
		propertyTypeComboBox.setBounds(516, 405, 147, 32);
		panel.add(propertyTypeComboBox);
		propertyTypeComboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		propertyTypeComboBox.setForeground(new Color(0, 0, 0));
		propertyTypeComboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		
		propertyTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"דירת קרקע", "דירה בבניין"}));
		propertyTypeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				groundOrBuilding(propertyTypeComboBox.getItemAt(propertyTypeComboBox.getSelectedIndex()).toString());
			}
		});
		propertyTypeComboBox.setEditable(true);
		propertyTypeComboBox.setEditable(false);
		
		floorCountLabel = new JLabel("מספר קומות");
		floorCountLabel.setBounds(645, 481, 95, 16);
		panel.add(floorCountLabel);
		floorCountLabel.setForeground(new Color(255, 255, 255));
		floorCountLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		floorCountGroundSpinner = new JSpinner();
		floorCountGroundSpinner.setBounds(595, 478, 36, 25);
		panel.add(floorCountGroundSpinner);
		floorCountGroundSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel label_5 = new JLabel("\u05DB\u05E9\u05E1\u05D5\u05D2 \u05D4\u05E0\u05DB\u05E1 \u05D1\u05D9\u05EA \u05E7\u05E8\u05E7\u05E2");
		label_5.setBounds(605, 452, 146, 16);
		label_5.setForeground(new Color(255, 255, 255));
		panel.add(label_5);
		
		JLabel label_5_1 = new JLabel("\u05DB\u05E9\u05E1\u05D5\u05D2 \u05D4\u05E0\u05DB\u05E1 \u05D1\u05D9\u05EA \u05D1\u05D1\u05E0\u05D9\u05D9\u05DF");
		label_5_1.setBounds(605, 508, 146, 16);
		panel.add(label_5_1);
		label_5_1.setForeground(new Color(255, 255, 255));
		
		floorNumLabel = new JLabel("\u05E7\u05D5\u05DE\u05D4");
		floorNumLabel.setBounds(694, 537, 49, 16);
		panel.add(floorNumLabel);
		floorNumLabel.setForeground(new Color(255, 255, 255));
		floorNumLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		floorsBuildingSpinner = new JSpinner();
		floorsBuildingSpinner.setBounds(646, 535, 36, 22);
		panel.add(floorsBuildingSpinner);
		floorsBuildingSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		gardenGroundCheckBox = new JCheckBox("\u05D2\u05D9\u05E0\u05D4");
		gardenGroundCheckBox.setBounds(551, 533, 80, 25);
		panel.add(gardenGroundCheckBox);
		gardenGroundCheckBox.setForeground(new Color(255, 255, 255));
		gardenGroundCheckBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		gardenGroundCheckBox.setBackground(new Color(119, 136, 153));
		
		apartmentNumberGroundSpinner = new JSpinner();
		apartmentNumberGroundSpinner.setBounds(561, 572, 36, 22);
		panel.add(apartmentNumberGroundSpinner);
		apartmentNumberGroundSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		apartmentNumberLabel = new JLabel("מספר דירה");
		apartmentNumberLabel.setBounds(645, 574, 87, 16);
		panel.add(apartmentNumberLabel);
		apartmentNumberLabel.setForeground(new Color(255, 255, 255));
		apartmentNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel addNewApartmentLabel = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05D3\u05D9\u05E8\u05D4 \u05D7\u05D3\u05E9\u05D4");
		addNewApartmentLabel.setBounds(307, 51, 231, 28);
		panel.add(addNewApartmentLabel);
		addNewApartmentLabel.setForeground(Color.WHITE);
		addNewApartmentLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddNewApartmentView.class.getResource("/Images/icons8-plus-95.png")));
		lblNewLabel.setBounds(550, 13, 90, 97);
		panel.add(lblNewLabel);
		apartmentNumberLabel.setVisible(false);
		apartmentNumberGroundSpinner.setVisible(false);
		gardenGroundCheckBox.setVisible(false);
		floorsBuildingSpinner.setVisible(false);
		floorNumLabel.setVisible(false);
		amountLabel.setVisible(false);
		roomatesLabel.setVisible(false);
		streetLabel.setVisible(false);
		citywarningLabel.setVisible(false);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAllApartmentView.openShowAllApartment(connectedUser, adminBool, analystBool); ///////
				frame.setVisible(false);
				reasetAddApartment();
			}
		});
	}
	
	public void groundOrBuilding(String type)
	{
		if(type.toString().equals("דירה בבניין"))
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
		checkIfBiggerThanRoomates();
		if (citybool && streetbool && amountbool && roomatestbool)
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
			
			this.frame.setVisible(false); 
			showAllApartmentView.openShowAllApartment(cityTextFile.getText(),adminBool,analystBool);	
		}
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
	
	public void checkIfCityEmpty()
	{
		if(cityTextFile.getText().toString().equals(""))	
		{
			citywarningLabel.setVisible(true);
			this.citybool =false;
		}
		else
		{
			citywarningLabel.setVisible(false);
			this.citybool =true;
		}
	}
	
	public void checkIfStreetEmpty()
	{
		if(streetTextFile.getText().toString().equals(""))	
		{
			streetLabel.setVisible(true);
			this.streetbool =false;
		}
		else
		{
			streetLabel.setVisible(false);
			this.streetbool =true;
		}
	}
	
	public void checkIfAmountEmpty()
	{
		if(priceTextField.getText().toString().equals(""))	
		{
			amountLabel.setVisible(true);
			this.amountbool =false;
		}
		else
		{
			amountLabel.setVisible(false);
			this.amountbool =true;
		}
	}

	public void checkIfBiggerThanRoomates()
	{
		int missing = (Integer)missingRoomatesSpinner.getValue();
		int roomates = (Integer)numOfRommatesSpinner.getValue();
		
		if(missing > roomates)	
		{
			roomatesLabel.setVisible(true);
			this.roomatestbool =false;
		}
		else
		{
			roomatesLabel.setVisible(false);
			this.roomatestbool =true;
		}
	}
	
	public void reasetAddApartment()
	{
		cityTextFile.setText("");
		streetTextFile.setText("");
		priceTextField.setText("");
		descriptionTextArea.setText("");
		
		roomatesLabel.setVisible(false);
		citywarningLabel.setVisible(false);
		streetLabel.setVisible(false);
		amountLabel.setVisible(false);
		
		elevatorCheckBox.setSelected(false);
		parkingCheckBox.setSelected(false);
		airCheckBox.setSelected(false);
		patioCheckBox.setSelected(false);
		mamadCheckBox.setSelected(false);
		storageCheckBox.setSelected(false);	
		accesibleCheckBox.setSelected(false);	
		furnitureCheckBox.setSelected(false);
		petCheckBox.setSelected(false);
		gardenGroundCheckBox.setSelected(false);
		
		numOfRommatesSpinner.setValue(0);
		roomsSpinner.setValue(0);
		floorCountGroundSpinner.setValue(0);
		apartmentNumberGroundSpinner.setValue(0);
		numOfRommatesSpinner.setValue(0);
		missingRoomatesSpinner.setValue(0);
		
	}
	
	public void checkValidPrice()
	{
		for(int i=0 ; i < priceTextField.getText().length(); i++)
		{
			String arr = priceTextField.getText();
			if(arr.charAt(i) < '0' || arr.charAt(i) > '9')
			{
				amountLabel.setVisible(true);
				this.pricebool = false;
			}
		}
	}
}