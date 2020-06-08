package controller;

import java.util.Observable;
import java.util.Observer;

import model.*;
import view.*;

public class DataController implements Observer{
	public RegisterView registerView;
	public DataExcelConn dataExcelConn;
	public SearchDetailsView searchDetailsView;
	public AddNewApartmentView addNewApartmentView;
	public ShowUserApartmentView showUserApartmentView;
	public MainView mainView;
	public ShowAllApartmentView showAllApartmentView;
	
	public DataController(DataExcelConn dataExcelConn,RegisterView registerView, SearchDetailsView searchDetailsView, 
			AddNewApartmentView addNewApartmentView,ShowUserApartmentView showUserApartmentView, MainView mainView, 
			ShowAllApartmentView showAllApartmentView) {
		this.dataExcelConn = dataExcelConn;
		this.registerView = registerView;
		this.searchDetailsView = searchDetailsView;
		this.addNewApartmentView = addNewApartmentView;
		this.showUserApartmentView = showUserApartmentView;
		this.mainView = mainView;
		this.showAllApartmentView = showAllApartmentView;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof RegisterView)
		{
			if(arg1 instanceof String[])
			{
				String[]arr=(String[])arg1; // unpack the arg
				Tenant user=new Tenant(arr[0],arr[1]);
				dataExcelConn.addNewTenant(user);
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
