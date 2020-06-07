package controller;

import java.util.Observable;
import java.util.Observer;

import model.*;
import view.*;

public class DataController implements Observer{
	public RegisterView view;
	public DataExcelConn data;
	
	public DataController(DataExcelConn dataExcelConn,RegisterView registerView) {
		data = dataExcelConn;
		view=registerView;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof RegisterView)
		{
			if(arg1 instanceof String[])
			{
				String[]arr=(String[])arg1;
				Tenant user=new Tenant(arr[0],arr[1]);
				data.addNewTenant(user);
			}
		}
		
	}

}
