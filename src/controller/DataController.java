package controller;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;

import model.*;
import view.*;
import view.RegisterView.CheckExsistUser;

public class DataController implements Observer
{
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
		
		if(arg0 instanceof MainView) 
		{
			if(arg1 instanceof MainView.CloseTheExcel)
			{
				dataExcelConn.closeFile();
			}
			else if(arg1 instanceof String[])
			{
				String [] user = (String[])arg1;
				dataExcelConn.checkValidPass(user[0], user[1]);
			}
		}
		
		else if(arg0 instanceof RegisterView)
		{
			if(arg1 instanceof RegisterView.AddUser)
			{
				String[] arr = ((RegisterView.AddUser) arg1).userName;
				Tenant newTenant = new Tenant(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], false, false);
				dataExcelConn.addNewTenant(newTenant);
			}
		
			else if(arg1 instanceof RegisterView.CheckExsistUser)   //// for register validation
			{
				String userName = ((RegisterView.CheckExsistUser) arg1).userNameCheck;

				dataExcelConn.checkExsistUser(userName);
			}
		}

		else if(arg0 instanceof ShowAllUsersView)
		{
			if(arg1 instanceof ShowAllUsersView.GetAllUsers)
			{
				dataExcelConn.getAllUsers();
			}
			
			else if(arg1 instanceof ShowAllUsersView.DeleteUser)
			{
				int index = ((ShowAllUsersView.DeleteUser) arg1).row;
				dataExcelConn.deleteUser(index);
			}
		}
				

		else if(arg0 instanceof ShowAllApartmentView) 
		{
			if(arg1 instanceof ShowAllApartmentView.CreateAllApartmentTable)
			{
				dataExcelConn.getAllApartments();
			}
			
			else if(arg1 instanceof ShowAllApartmentView.CityShow)
			{
				int index = ((ShowAllApartmentView.CityShow) arg1).index;
				dataExcelConn.citysShow(index);
			}
			
			else if(arg1 instanceof ShowAllApartmentView.PropertType)
			{
				dataExcelConn.propertShow();
			}
			
			else if(arg1 instanceof ShowAllApartmentView.MissedRommateNumShow)
			{
				int type = ((ShowAllApartmentView.MissedRommateNumShow) arg1).propretyType;
				String city = ((ShowAllApartmentView.MissedRommateNumShow) arg1).city;
				dataExcelConn.missedRommateShow(type,city);
			}
			
			else if(arg1 instanceof ShowAllApartmentView.Search)
			{
				String [] arr = ((ShowAllApartmentView.Search) arg1).search;
				dataExcelConn.searchApartment(arr);
			}
		}
		
		else if(arg0 instanceof ShowUserApartmentView) 
		{
			if(arg1 instanceof ShowUserApartmentView.ShowUserApartments)
			{
				String user = ((ShowUserApartmentView.ShowUserApartments) arg1).userName;
				dataExcelConn.createUserApartmnetTable(user);
			}
			
			else if(arg1 instanceof ShowUserApartmentView.DeleteUserApartment)
			{
				String userName = ((ShowUserApartmentView.DeleteUserApartment) arg1).userName;
				int index = ((ShowUserApartmentView.DeleteUserApartment) arg1).row;
				dataExcelConn.deleteUserApartment(userName, index);
			}
		}

		
		else if(arg0 instanceof SearchDetailsView) 
		{
			if(arg1 instanceof SearchDetailsView.TopApartment)
			{
				dataExcelConn.topApartment();
			}
		}
		
		
		else if(arg0 instanceof AddNewApartmentView)
		{
			if(arg1 instanceof AddNewApartmentView.AddGround)
			{
				String[] arr = ((AddNewApartmentView.AddGround) arg1).ground;
				Ground newGround = new Ground(Integer.parseInt(arr[7]));
				newGround.setPropertyID(dataExcelConn.getTheLastApartmentId());
				newGround.setUserId(arr[17]);
				newGround.setSearchCount();
				newGround.setCity(arr[0]);
				newGround.setAddress(arr[1]);
				newGround.setNumOfRoomMate(Integer.parseInt(arr[2]));
				newGround.setRoomMateMiss(Integer.parseInt(arr[3]));
				newGround.setRooms((int)Double.parseDouble(arr[4]));
				newGround.setPrice((int)Double.parseDouble(arr[5]));
				newGround.setDescription(arr[6]);
				//newGround.setPropertyType();
				newGround.setElevator(Boolean.parseBoolean(arr[8]));
				newGround.setParking(Boolean.parseBoolean(arr[9]));
				newGround.setAirCon(Boolean.parseBoolean(arr[10]));
				newGround.setPatio(Boolean.parseBoolean(arr[11]));
				newGround.setMamad(Boolean.parseBoolean(arr[12]));
				newGround.setStorage(Boolean.parseBoolean(arr[13]));
				newGround.setAccesible(Boolean.parseBoolean(arr[14]));
				newGround.setFurniture(Boolean.parseBoolean(arr[15]));
				newGround.setPet(Boolean.parseBoolean(arr[16]));
				
				dataExcelConn.addNewApartmentGround(newGround);
			}
			
			else if(arg1 instanceof AddNewApartmentView.AddBuilding)
			{
				String[] arr = ((AddNewApartmentView.AddBuilding) arg1).building;
				Building newBuilding = new Building((int)Double.parseDouble(arr[7]), Boolean.parseBoolean(arr[8]), (int)Double.parseDouble(arr[9]));
				newBuilding.setPropertyID(dataExcelConn.getTheLastApartmentId());
				newBuilding.setUserId(arr[19]);
				newBuilding.setSearchCount();
				newBuilding.setCity(arr[0]);
				newBuilding.setAddress(arr[1]);
				newBuilding.setNumOfRoomMate(Integer.parseInt(arr[2]));
				newBuilding.setRoomMateMiss(Integer.parseInt(arr[3]));
				newBuilding.setRooms((int)Double.parseDouble(arr[4]));
				newBuilding.setPrice((int)Double.parseDouble(arr[5]));
				newBuilding.setDescription(arr[6]);
				newBuilding.setElevator(Boolean.parseBoolean(arr[10]));
				newBuilding.setParking(Boolean.parseBoolean(arr[11]));
				newBuilding.setAirCon(Boolean.parseBoolean(arr[12]));
				newBuilding.setPatio(Boolean.parseBoolean(arr[13]));
				newBuilding.setMamad(Boolean.parseBoolean(arr[14]));
				newBuilding.setStorage(Boolean.parseBoolean(arr[15]));
				newBuilding.setAccesible(Boolean.parseBoolean(arr[16]));
				newBuilding.setFurniture(Boolean.parseBoolean(arr[17]));
				newBuilding.setPet(Boolean.parseBoolean(arr[18]));
				
				dataExcelConn.addNewApartmentBuilding(newBuilding);
			}
		}

		
		///// data to view
		
		else if(arg0 instanceof DataExcelConn)
		{
			if(arg1 instanceof DataExcelConn.UsersTable)
			{
				JTable jTable = ((DataExcelConn.UsersTable) arg1).usersTable;
				showAllUsersView.crateAllUsers(jTable);
			}
			
			else if(arg1 instanceof DataExcelConn.CheckValidPassClass)
			{
				boolean validUser = ((DataExcelConn.CheckValidPassClass) arg1).validPass;
				boolean admin = ((DataExcelConn.CheckValidPassClass) arg1).userType;
				boolean analyst = ((DataExcelConn.CheckValidPassClass) arg1).analystType;
				mainView.loginValid(validUser, admin, analyst);
			}
			
			else if(arg1 instanceof DataExcelConn.ExistsUser)
			{
				boolean exsistUser = ((DataExcelConn.ExistsUser) arg1).exixst;
				registerView.userValid(exsistUser); 
			}
			
			else if(arg1 instanceof DataExcelConn.UserApartments)
			{
				JTable jTable = ((DataExcelConn.UserApartments) arg1).userApartmentTable;
				showUserApartmentView.crateAllUserApartments(jTable);	
			}
			
			else if(arg1 instanceof DataExcelConn.ShowAllApartments)
			{
				JTable jTable = ((DataExcelConn.ShowAllApartments) arg1).allApartmentTable;
				showAllApartmentView.createAllApartment(jTable);
			}
			
			else if(arg1 instanceof DataExcelConn.CityShowRep)
			{
				String arr[] = ((DataExcelConn.CityShowRep) arg1).cityList;
				showAllApartmentView.loadCities(arr);
			}
			
			else if(arg1 instanceof DataExcelConn.PropertType)
			{
				Boolean arr[] = ((DataExcelConn.PropertType) arg1).propertType;
				showAllApartmentView.loadPropertType(arr);
			}
			
			else if(arg1 instanceof DataExcelConn.ShowSearchTable)
			{
				JTable jTable = ((DataExcelConn.ShowSearchTable) arg1).searchTable;
				showAllApartmentView.showSearch(jTable);
			}
			
			else if(arg1 instanceof DataExcelConn.TopApartment)
			{
				JTable jTable = ((DataExcelConn.TopApartment) arg1).topTable;
				searchDetailsView.showTop(jTable);
			}
			
			else if(arg1 instanceof DataExcelConn.ConfirmDelete)
			{
				showAllUsersView.confirmUserDelete();
			}
			
			else if(arg1 instanceof DataExcelConn.ConfirmDeletedUserApartment)
			{
				showUserApartmentView.confirmApartmentDelete();
			}
		}		
	}

}