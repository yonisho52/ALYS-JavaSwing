package controller;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;

import model.*;
import view.*;
import view.RegisterView.CheckExsistUser;

public class DataController implements Observer{
	
	
	public RegisterView registerView;
	public DataExcelConn dataExcelConn;
	public SearchDetailsView searchDetailsView;
	public AddNewApartmentView addNewApartmentView;
	public ShowUserApartmentView showUserApartmentView;
	public MainView mainView;
	public ShowAllApartmentView showAllApartmentView;
	public ShowAllUsersView showAllUsersView;

	
	public DataController(DataExcelConn dataExcelConn,RegisterView registerView, SearchDetailsView searchDetailsView, 
			AddNewApartmentView addNewApartmentView,ShowUserApartmentView showUserApartmentView, MainView mainView, 
			ShowAllApartmentView showAllApartmentView, ShowAllUsersView showAllUsersView) {
		
		this.dataExcelConn = dataExcelConn;
		this.registerView = registerView;
		this.searchDetailsView = searchDetailsView;
		this.addNewApartmentView = addNewApartmentView;
		this.showUserApartmentView = showUserApartmentView;
		this.mainView = mainView;
		this.showAllApartmentView = showAllApartmentView;
		this.showAllUsersView = showAllUsersView;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		/// view to data
		
		if(arg0 instanceof RegisterView)
		{
			if(arg1 instanceof RegisterView.AddUser)
			{
				String[] arr = ((RegisterView.AddUser) arg1).userName;
				Tenant newTenant = new Tenant(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], false);
				dataExcelConn.addNewTenant(newTenant);
			}
			
			if(arg1 instanceof RegisterView.CheckExsistUser)   //// for register validation
			{
				String userName = ((RegisterView.CheckExsistUser) arg1).userNameCheck;

				dataExcelConn.checkExsistUser(userName);
			}
		}

		
		if(arg0 instanceof MainView) 
		{
			if(arg1 instanceof MainView.CloseTheExcel)
			{
				dataExcelConn.closeFile();
			}
			
		}
		if(arg0 instanceof ShowAllUsersView)
			if(arg1 instanceof ShowAllUsersView.GetAllUsers)
			{
				dataExcelConn.getAllUsers();
			}
		
		//update new if - instance of addNewApartment button - important!!!!!!!!!!!!!!!!!!!!!!!!!!! (we think) - wrong
		
		if(arg0 instanceof MainView) 
		{
			if(arg1 instanceof String[])
			{
				String [] user = (String[])arg1;
				dataExcelConn.checkValidPass(user[0], user[1]);
			}
		}
		
		if(arg0 instanceof MainView) 
		{
			if(arg1 instanceof MainView.CreateAllApartmentTable)
			{
				dataExcelConn.getAllApartments();
			}
		}
		
		if(arg0 instanceof ShowUserApartmentView) 
		{
			if(arg1 instanceof String)
			{
				String user = (String)arg1;
				dataExcelConn.showUserApartments(user);
			}
		}
		
//		String [] groundApartment = {cityTextFile.getText().toString(),streetTextFile.getText().toString(),numOfRommatesSpinner.getValue().toString(),
//				missingRoomatesSpinner.getValue().toString(), roomsSpinner.getValue().toString(), priceTextField.getText().toString(), descriptionTextArea.getText().toString(),
//				floorCountGroundSpinner.getValue().toString(),String.valueOf(elevatorCheckBox.isSelected()), String.valueOf(parkingCheckBox.isSelected()), 
//				String.valueOf(airCheckBox.isSelected()), String.valueOf(patioCheckBox.isSelected()), String.valueOf(mamadCheckBox.isSelected()),
//				String.valueOf(storageCheckBox.isSelected()), String.valueOf(accesibleCheckBox.isSelected()), String.valueOf(furnitureCheckBox.isSelected()), 
//				String.valueOf(petCheckBox.isSelected()), connectedUser};
		
		
		if(arg0 instanceof AddNewApartmentView)
		{
			if(arg1 instanceof AddNewApartmentView.AddGround)
			{
				//String[]arr = (String[])arg1; // unpack the arg
				String[] arr = ((AddNewApartmentView.AddGround) arg1).ground;
				Ground newGround = new Ground();
				newGround.setPropertyID(dataExcelConn.getTheLastApartmentId());
				newGround.setUserId(arr[17]);
				newGround.setSearchCount();
				newGround.setCity(arr[0]);
				newGround.setAddress(arr[1]);
				newGround.setNumOfRoomMate(Integer.parseInt(arr[2]));
				newGround.setRoomMateMiss(Integer.parseInt(arr[3]));
				newGround.setRooms(Integer.parseInt(arr[4]));
				newGround.setPrice(Integer.parseInt(arr[5]));
				newGround.setDescription(arr[6]);
				newGround.setPropertyType();
				newGround.setElevator(Boolean.parseBoolean(arr[8]));
				newGround.setParking(Boolean.parseBoolean(arr[9]));
				newGround.setAirCon(Boolean.parseBoolean(arr[10]));
				newGround.setPatio(Boolean.parseBoolean(arr[11]));
				newGround.setMamad(Boolean.parseBoolean(arr[12]));
				newGround.setStorage(Boolean.parseBoolean(arr[13]));
				newGround.setAccesible(Boolean.parseBoolean(arr[14]));
				newGround.setFurniture(Boolean.parseBoolean(arr[15]));
				newGround.setPet(Boolean.parseBoolean(arr[16]));
				
				
				//dataExcelConn.addNewTenant(newTenant);
				//userId++;
			}
		}

		
		///// data to view
		
		if(arg0 instanceof DataExcelConn)
		{
			if(arg1 instanceof DataExcelConn.UsersTable)
			{
				JTable jTable = ((DataExcelConn.UsersTable) arg1).usersTable;
				showAllUsersView.crateAllUsers(jTable);
			}
		}
		
		if(arg0 instanceof DataExcelConn)   /// not connected to view
		{
			if(arg1 instanceof DataExcelConn.ApartmentsTable)
			{
				JTable jTable = ((DataExcelConn.ApartmentsTable) arg1).apartmentsTable;
	//			showAllUsersView.crateAllUsers(jTable);
			}
		}
		
		if(arg0 instanceof DataExcelConn)   
		{
			if(arg1 instanceof DataExcelConn.CheckValidPassClass)
			{
				boolean validUser = ((DataExcelConn.CheckValidPassClass) arg1).validPass;
				boolean admin = ((DataExcelConn.CheckValidPassClass) arg1).userType;
				mainView.loginValid(validUser,admin);
			}
		}
		
		if(arg0 instanceof DataExcelConn)    //// for register validation /// not connected to view
		{
			if(arg1 instanceof DataExcelConn.ExistsUser)
			{
				boolean exsistUser = ((DataExcelConn.ExistsUser) arg1).exixst;
				registerView.userValid(exsistUser); 
			}
		}
		
		if(arg0 instanceof DataExcelConn)     /// not connected to view
		{
			if(arg1 instanceof DataExcelConn.UserApartments)
			{
				JTable jTable = ((DataExcelConn.UserApartments) arg1).userApartmentTable;
				showUserApartmentView.crateAllUserApartments(jTable);	
			}
		}
		
		
		
		if(arg0 instanceof DataExcelConn)     /// not connected to view
		{
			if(arg1 instanceof DataExcelConn.ShowAllApartments)
			{
				JTable jTable = ((DataExcelConn.ShowAllApartments) arg1).allApartmentTable;
				showAllApartmentView.createAllApartment(jTable);
			}
		}
		
		
		
	}

}



























