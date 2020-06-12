package model;

import java.io.*;
import java.util.*;

import javax.swing.JTable;

import org.apache.poi.*;
import org.apache.poi.ss.usermodel.*;  
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// add new user
// check existing user
// add new apartment
// search apartment
// show all apartments
// show user apartments



public class DataExcelConn extends Observable{
	
	Sheet users,apartments;
	private static String[] usersColumns = {"שם משתמש","סיסמא","שם פרטי","שם משפחה","מייל","טלפון","ID","admin"};
	private static String[] apartmentsColumns = {"שם משתמש","עיר","רחוב","סהכ שותפים","שותפים חסרים","חדרים","מחיר","תיאור","סוג הנכס","קומה","גינה","מספר דירה","מספר קומות","מעלית","חניה","מיזוג","מרפסת","ממד","מחסן","גישה לנכים","מרוהטת","חיות מחמד"};
	FileOutputStream fileOutputStream;
	int usersRow, apartmentsRow;
	public Workbook workBook;
	File file = new File("DataBase.xlsx");
	FileInputStream fileInputStream;
	Cell cellCompar;
	DataFormatter dataFormatter = new DataFormatter();
	static DataExcelConn dataExcelConn = new DataExcelConn();
	protected String connectedUser = null; //Save log which user connected
	
	public class CheckValidPassClass
	{
		/// inner class for checking if the user name and pass are correct;
		public boolean validPass;
		public boolean userType;
		public CheckValidPassClass(boolean valid, boolean admin)
		{
			this.validPass = valid;
			this.userType = admin;
		}
	}
	
	public static DataExcelConn getDataExcelConn() 
	{

		return dataExcelConn;
	}


	public class ExistsUser
	{
		/// inner class for checking if the user name exists;
		public boolean exixst;
		public ExistsUser(boolean valid)
		{
			this.exixst = valid;
		}
	}
	
	public class UsersTable
	{
		public JTable usersTable;
		public UsersTable(JTable table)
		{
			this.usersTable = table;
		}
	}
	
	public class ApartmentsTable
	{
		public JTable apartmentsTable;
		public ApartmentsTable(JTable table)
		{
			this.apartmentsTable = table;
		}
	}
	
	public class UserApartments
	{
		public JTable userApartmentTable;
		public UserApartments(JTable table)
		{
			this.userApartmentTable = table;
		}
	}
	
	private DataExcelConn() 
	{	
	
	if(file.exists()) {
		try {
			fileInputStream = new FileInputStream(file);
			workBook = WorkbookFactory.create(fileInputStream);
			users = workBook.getSheetAt(0);
			apartments=workBook.getSheetAt(1);
			usersRow = users.getLastRowNum();
			apartmentsRow = apartments.getLastRowNum();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else { 
		workBook = new XSSFWorkbook();
		CreationHelper createHelper = workBook.getCreationHelper();
		users=workBook.createSheet("משתמשים");//creating new sheet
		apartments=workBook.createSheet("נכסים");//creating new sheet
		 // Create a Font for styling header cells
	    Font headerFont = workBook.createFont();
	    headerFont.setBold(true);
	    headerFont.setFontHeightInPoints((short) 14);
	    headerFont.setColor(IndexedColors.RED.getIndex());
	
	    // Create a CellStyle with the font
	    CellStyle headerCellStyle = workBook.createCellStyle();
	    headerCellStyle.setFont(headerFont);
	    
	    // Create a Row for each sheet
	    Row headerRowCL = users.createRow(0);
	    Row headerRowGH = apartments.createRow(0);
	
	    // Create cells in both Sheets
	    for(int i = 0; i < usersColumns.length; i++) {
	        Cell cell = headerRowCL.createCell(i);
	        cell.setCellValue(usersColumns[i]);
	        cell.setCellStyle(headerCellStyle);
	    }
	    for(int i = 0; i < apartmentsColumns.length; i++) {
	        Cell cell = headerRowGH.createCell(i);
	        cell.setCellValue(apartmentsColumns[i]);
	        cell.setCellStyle(headerCellStyle);
	    }
	    
	 // Create Cell Style for formatting Date
//	    dateCellStyle = workBook.createCellStyle();
//	    dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
//	    
//		for(int i = 0; i < gamesSheetColumns.length; i++) {
//			apartments.autoSizeColumn(i);}
//			
	
	}   
}
	
	


	public void addNewTenant(Tenant tenant) 
	{
    	String excelFilePath = "DataBase.xlsx";
    	FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(excelFilePath));
	    	Workbook workBook = WorkbookFactory.create(inputStream);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//    	Sheet sheet = workBook.getSheetAt(0);
    	int rowCount = users.getLastRowNum();
    	Row row = users.createRow(++rowCount);

    	row.createCell(0).setCellValue(tenant.userName);
    	row.createCell(1).setCellValue(tenant.password);
    	row.createCell(2).setCellValue(tenant.firstName);
    	row.createCell(3).setCellValue(tenant.lastName);
    	row.createCell(4).setCellValue(tenant.email);
    	row.createCell(5).setCellValue(tenant.phoneNumber);
    	row.createCell(6).setCellValue(tenant.userID);
    	row.createCell(7).setCellValue(tenant.adminToF);


    	//FileInputStream input = new FileInputStream("./Test.xls");
    	//cell.getRichStringCellValue().toString(); - printing value to screen

    	FileOutputStream output;
		try {
			output = new FileOutputStream("DataBase.xlsx");
	    	workBook.write(output);
	    	output.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	//	System.out.println( " secssuce");
	}
	
	public void closeFile()
{
	// Write the output to a file
	try {
		fileOutputStream= new FileOutputStream("DataBase.xlsx");
		workBook.write(fileOutputStream);
		fileOutputStream.close();
		workBook.close();
    }
	catch(Exception e) {e.printStackTrace();  
	}
}
	
	public void getAllUsers() { // for 
		
		Row row;
		int lastRow = users.getLastRowNum();
		Cell userName, password, firstName, lastName, email, phoneNumber, userID, adminToF;
		String [][] data = new String[lastRow][8]; // for table
		String [] record = new String[8]; // lines
		int j = 0;
		
		for(int i=1; i<=lastRow; i++) 
		{
			row = users.getRow(i);
			userName = row.getCell(0);
			password = row.getCell(1);
			firstName = row.getCell(2);
			lastName = row.getCell(3);
			email = row.getCell(4);
			phoneNumber = row.getCell(5);
			userID = row.getCell(6);
			adminToF = row.getCell(7);

			record[0] = dataFormatter.formatCellValue(userName);
			record[1] = dataFormatter.formatCellValue(password);
			record[2] = dataFormatter.formatCellValue(firstName);
			record[3] = dataFormatter.formatCellValue(lastName);
			record[4] = dataFormatter.formatCellValue(email);
			record[5] = dataFormatter.formatCellValue(phoneNumber);
			record[6] = dataFormatter.formatCellValue(userID);
			record[7] = dataFormatter.formatCellValue(adminToF);

			data[j++] = record.clone();
		}
		
		JTable jTable = new JTable(data, usersColumns);
		setChanged();
		notifyObservers(new UsersTable(jTable));
	}
	
	
	public void checkExsistUser(String userName) { /// if the userName exists return *true, if not exists return *false  --- for register
		
		Row row;
		Cell userNameDB;
		boolean exist = false;
		int lastRow = users.getLastRowNum();
		
		for(int i=1;i<=lastRow;i++) {
			row=users.getRow(i);
			userNameDB = row.getCell(0);
			if(userName.equals(userNameDB.toString()))
			{
				exist = true;
				break;
			}
		}
		setChanged();
		notifyObservers(new ExistsUser(exist));
	}

	public void checkValidPass(String userName, String pass) { /// if the userName's pass is valid return *true, if not return *false = wrong combination  --- for login
		
		Row row;
		Cell userNameDB, passDB, adminDB;
		int lastRow = users.getLastRowNum();
		
		for(int i=1;i<=lastRow;i++) {
			row=users.getRow(i);
			userNameDB = row.getCell(0);
			//System.out.println(userName + " " + userNameDB.toString());
			//if(userName == userNameDB.toString())
			if(userName.equals(userNameDB.toString()))
				{
				passDB = row.getCell(1);
				adminDB = row.getCell(7);
				//System.out.println(userName + " " + userNameDB.toString());
				//if(pass == passDB.toString())
				if(pass.equals(passDB.toString())) 
				{
					connectedUser = new String(userName); //Save the connected users name
					if(adminDB.toString()=="FALSE") 
					{
						setChanged();
						notifyObservers(new CheckValidPassClass(true,false));
					}
					else 
					{
						setChanged();
						notifyObservers(new CheckValidPassClass(true,true));
					}
				} 
				else 
					{
					break;
//					setChanged();
//					notifyObservers(new CheckValidPassClass(false,false));
					}
				}
		}
		setChanged();
		notifyObservers(new CheckValidPassClass(false,false));
	}
	
	public boolean checkIfAdmin(String userName) {  // if the user is admin return *true, if not return *false  --- for showAllApartmentView
		
		Row row;
		Cell userNameDB, adminDB;
		
		for(int i=1;i<=users.getLastRowNum();i++) {
			row=users.getRow(i);
			userNameDB = row.getCell(0);
			if(userName.equals(userNameDB.toString())) {
				adminDB = row.getCell(7);
				if(adminDB.toString().equals("TRUE")) return true; 
				else return false;
			}
		}
		return false;
	}
	
	
	public void getAllApartments() {
		
		// {"שם משתמש","עיר","רחוב","סהכ שותפים","שותפים חסרים","חדרים","מחיר","תיאור","סוג הנכס","קומה","גינה","מספר דירה","מספר קומות","מעלית","חניה","מיזוג","מרפסת","ממד","מחסן","גישה לנכים","מרוהטת","חיות מחמד"};
		
		Row row;
		int lastRow = apartments.getLastRowNum();
		Cell userName, city, street, totalRommate, missRommate, roomNum, price, description, propertyKind, floorNumbers, floor, 
		garden, apartmentNumber, elevator, parking, airCon, balcon, dimension, storage, accessDis, furnish, pet;
		String [][] data = new String[lastRow][17]; // for table
		String [] record = new String[17]; // lines
		int j = 0;
		
		for(int i=1; i<=lastRow; i++) 
		{
			row = apartments.getRow(i);
			//userName = row.getCell(0);
			city = row.getCell(1);
			street = row.getCell(2);
			totalRommate = row.getCell(3);
			missRommate = row.getCell(4);
			roomNum = row.getCell(5);
			price = row.getCell(6);
			propertyKind = row.getCell(7);
			elevator = row.getCell(8);
			elevator = row.getCell(9);
			elevator = row.getCell(10);
			elevator = row.getCell(11);
			elevator = row.getCell(12);
			parking = row.getCell(13);
			airCon = row.getCell(14);
			balcon = row.getCell(15);
			dimension = row.getCell(16);
			storage = row.getCell(17);
			accessDis = row.getCell(18);
			furnish = row.getCell(19);
			pet = row.getCell(20);


		//	record[0] = dataFormatter.formatCellValue(userName);
			record[1] = dataFormatter.formatCellValue(city);
			record[2] = dataFormatter.formatCellValue(street);
			record[3] = dataFormatter.formatCellValue(totalRommate);
			record[4] = dataFormatter.formatCellValue(missRommate);
			record[5] = dataFormatter.formatCellValue(roomNum);
			record[6] = dataFormatter.formatCellValue(price);
			record[7] = dataFormatter.formatCellValue(propertyKind);
			record[8] = dataFormatter.formatCellValue(elevator);
			record[9] = dataFormatter.formatCellValue(parking);
			record[10] = dataFormatter.formatCellValue(airCon);
			record[11] = dataFormatter.formatCellValue(balcon);
			record[12] = dataFormatter.formatCellValue(dimension);
			record[13] = dataFormatter.formatCellValue(storage);
			record[14] = dataFormatter.formatCellValue(accessDis);
			record[15] = dataFormatter.formatCellValue(furnish);
			record[16] = dataFormatter.formatCellValue(pet);


			data[j++] = record.clone();
		}
	//	String[] apartmentsColumns = {"שם משתמש","עיר","רחוב","סהכ שותפים","שותפים חסרים","חדרים","מחיר","תיאור","סוג הנכס","קומה","גינה","מספר דירה","מספר קומות","מעלית","חניה","מיזוג","מרפסת","ממד","מחסן","גישה לנכים","מרוהטת","חיות מחמד"};
		JTable jTable = new JTable(data, apartmentsColumns);
		setChanged();
		notifyObservers(new ApartmentsTable(jTable));
		
	}

	public void showUserApartments(String userName) {

		// {"שם משתמש","עיר","רחוב","סהכ שותפים","שותפים חסרים","חדרים","מחיר","תיאור","סוג הנכס","קומה","גינה","מספר דירה","מספר קומות","מעלית","חניה","מיזוג","מרפסת","ממד","מחסן","גישה לנכים","מרוהטת","חיות מחמד"};
	

		Row row;
		int lastRow = apartments.getLastRowNum();
		Cell userNameDB;
		String [][] data = new String[lastRow][21]; // for table
		String [] record = new String[21]; // lines
		int j = 0;
		
		for(int i=1; i<=lastRow; i++)
		{
			row = apartments.getRow(i);
			userNameDB = row.getCell(0);
			if(userName.equals(userNameDB.toString())) 
			{		
				record[0] = dataFormatter.formatCellValue(row.getCell(1));
				record[1] = dataFormatter.formatCellValue(row.getCell(2));
				record[2] = dataFormatter.formatCellValue(row.getCell(3));
				record[3] = dataFormatter.formatCellValue(row.getCell(4));
				record[4] = dataFormatter.formatCellValue(row.getCell(5));
				record[5] = dataFormatter.formatCellValue(row.getCell(6));
				record[6] = dataFormatter.formatCellValue(row.getCell(7));
				record[7] = dataFormatter.formatCellValue(row.getCell(8));
				record[8] = dataFormatter.formatCellValue(row.getCell(9));
				record[9] = dataFormatter.formatCellValue(row.getCell(10));
				record[10] = dataFormatter.formatCellValue(row.getCell(11));
				record[11] = dataFormatter.formatCellValue(row.getCell(12));
				record[12] = dataFormatter.formatCellValue(row.getCell(13));
				record[13] = dataFormatter.formatCellValue(row.getCell(14));
				record[14] = dataFormatter.formatCellValue(row.getCell(15));
				record[15] = dataFormatter.formatCellValue(row.getCell(16));
				record[16] = dataFormatter.formatCellValue(row.getCell(17));
				record[17] = dataFormatter.formatCellValue(row.getCell(18));
				record[18] = dataFormatter.formatCellValue(row.getCell(19));
				record[19] = dataFormatter.formatCellValue(row.getCell(20));
				record[20] = dataFormatter.formatCellValue(row.getCell(21));

					
					data[j++] = record.clone();
			}
		}
		String[] UserapartmentsColumns = {"עיר","רחוב","סהכ שותפים","שותפים חסרים","חדרים","מחיר","תיאור","סוג הנכס","קומה","גינה","מספר דירה","מספר קומות","מעלית","חניה","מיזוג","מרפסת","ממד","מחסן","גישה לנכים","מרוהטת","חיות מחמד"};

		JTable jTable = new JTable(data, UserapartmentsColumns);
//		jTable.setBounds(10, 159, 1030, 309);
		setChanged();
		notifyObservers(new UserApartments(jTable));
	}

	public void addNewApartment() {  // not finished 

		String excelFilePath = "DataBase.xlsx";
    	FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(excelFilePath));
	    	Workbook workBook = WorkbookFactory.create(inputStream);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//    	Sheet sheet = workBook.getSheetAt(0);
    	int rowCount = apartments.getLastRowNum();
    	Row row = apartments.createRow(++rowCount);

//    	row.createCell(0).setCellValue(tenant.userName);
//    	row.createCell(1).setCellValue(tenant.password);
//    	row.createCell(2).setCellValue(tenant.firstName);
//    	row.createCell(3).setCellValue(tenant.lastName);
//    	row.createCell(4).setCellValue(tenant.email);
//    	row.createCell(5).setCellValue(tenant.phoneNumber);
//    	row.createCell(6).setCellValue(tenant.userID);
//    	row.createCell(7).setCellValue(tenant.adminToF);


    	//FileInputStream input = new FileInputStream("./Test.xls");
    	//cell.getRichStringCellValue().toString(); - printing value to screen

    	FileOutputStream output;
		try {
			output = new FileOutputStream("DataBase.xlsx");
	    	workBook.write(output);
	    	output.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println( " secssuce");
	}

	
	public void searchApartment() {
		
	}
	
	
	public void betweenPriceApartment(int start, int end) {
		
		
	}
	
	
	
	
	
	
}












