package controller;

import java.util.Observable;
import java.util.Observer;

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
		if(arg0 instanceof MainView) 
		{
			if(arg1 instanceof MainView.CloseTheExcel)
			{
				dataExcelConn.closeFile();
			}
		}
	}

}
