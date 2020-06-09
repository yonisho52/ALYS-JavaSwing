package driver;

import model.*;
import view.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import controller.*;

public class driver 
{
	
	//// show to lilach
	
	public static void main (String[] args)  {
		
		DataExcelConn dataExcelConn = new DataExcelConn();

//		try {
//			FileOutputStream fileOut = new FileOutputStream("DataBase.xlsx");
//			dataExcelConn.workBook.write(fileOut);
//			dataExcelConn.workBook.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		ShowUserApartmentView showUserApartmentView = new ShowUserApartmentView();
		SearchDetailsView searchDetailsView = new SearchDetailsView();
		AddNewApartmentView addNewApartmentView = new AddNewApartmentView();
		ShowAllUsersView showAllUsersView = new ShowAllUsersView();
		///// 3 line above for the next line
		ShowAllApartmentView showAllApartmentView = new ShowAllApartmentView(searchDetailsView, addNewApartmentView, 
				showUserApartmentView, showAllUsersView);

		RegisterView registerView = new RegisterView(showAllApartmentView);

		MainView mainView = new MainView(registerView,showAllApartmentView);

		DataController dataController = new DataController(dataExcelConn, registerView, searchDetailsView, 
				 addNewApartmentView, showUserApartmentView,  mainView, showAllApartmentView, showAllUsersView);
		
		
		// add observer for the controller's watch
		mainView.addObserver(dataController);
		searchDetailsView.addObserver(dataController);
		addNewApartmentView.addObserver(dataController);		
		showUserApartmentView.addObserver(dataController);
		showAllApartmentView.addObserver(dataController);		
		dataExcelConn.addObserver(dataController);
		registerView.addObserver(dataController);
		showAllUsersView.addObserver(dataController);

	}
}
