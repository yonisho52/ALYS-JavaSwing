package driver;

import model.*;
import view.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import controller.*;

public class driver 
{

	public static void main (String[] args) {
		
		DataExcelConn dataExcelConn = new DataExcelConn();

		try {
			FileOutputStream fileOut = new FileOutputStream("DataBase.xlsx");
			dataExcelConn.workBook.write(fileOut);
			dataExcelConn.workBook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RegisterView registerView = new RegisterView();

		DataController dataController = new DataController(dataExcelConn,registerView);
		
		dataExcelConn.addObserver(dataController);
		registerView.addObserver(dataController);
		
		
		SearchDetailsView searchDetailsView = new SearchDetailsView();
		AddNewApartmentView addNewApartmentView = new AddNewApartmentView();
		ShowAllApartmentView showAllApartmentView = new ShowAllApartmentView();
		ShowUserApartmentView showUserApartmentView = new ShowUserApartmentView();

		MainView mainView = new MainView(registerView,showAllApartmentView);
		
	}
}
