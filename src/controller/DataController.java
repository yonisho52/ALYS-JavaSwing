package controller;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;

import model.*;
import view.*;

public class DataController implements Observer{
	
	static int userId=1;
	
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
			if(arg1 instanceof String[])
			{
				String[]arr = (String[])arg1; // unpack the arg
				Tenant newTenant = new Tenant(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], userId, false);
				dataExcelConn.addNewTenant(newTenant);
				userId++;
			}
		}
		
		if(arg0 instanceof RegisterView)   //// for register validation
		{
			if(arg1 instanceof String)
			{
				String userName = (String)arg1;
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


			}
		}
		
		if(arg0 instanceof DataExcelConn)     /// not connected to view
		{
			if(arg1 instanceof DataExcelConn.UserApartments)
			{
				JTable jTable = ((DataExcelConn.UserApartments) arg1).userApartmentTable;


			}
		}
		
		
		
		
		
	}

}



























