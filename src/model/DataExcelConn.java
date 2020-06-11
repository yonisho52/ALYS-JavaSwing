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
	private static String[] apartmentsColumns = {"שם משתמש","עיר","רחוב","סהכ שותפים","שותפים חסרים","חדרים","מחיר","סוג הנכס","מעלית","חניה","מיזוג","מרפסת","ממד","מחסן","גישה לנכים","מרוהטת","חיות מחמד"};
	FileOutputStream fileOutputStream;
	int usersRow, apartmentsRow;
	public Workbook workBook;
	File file = new File("DataBase.xlsx");
	FileInputStream fileInputStream;
	Cell cellCompar;
	DataFormatter dataFormatter = new DataFormatter();
	protected String connectedUser = null; //Save log which user connected
	
	public class CheckValidPassClass
	{
		/// inner class for checking if the user name and pass are correct;
		public boolean validPass;
		public boolean userType;
		public CheckValidPassClass() {}
		public CheckValidPassClass(boolean valid, boolean admin)
		{
			this.validPass = valid;
			this.userType = admin;
		}
	}
	
public DataExcelConn() {	
	
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
	
	public void addNewApartment() {}
	public void searchApartment() {}
	public void showUserApartments() {}

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

		System.out.println( " secssuce");
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
		String [][] data = new String[users.getLastRowNum()][8]; // for table
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
		notifyObservers(jTable);
	}
	
	
	public boolean checkExsistUser(String userName) { /// if the userName exists return *true, if not exists return *false  --- for register
		
		Row row;
		Cell userNameDB;
		
		for(int i=1;i<=users.getLastRowNum();i++) {
			row=users.getRow(i);
			userNameDB = row.getCell(0);
			if(userName.equals(userNameDB.toString())) return true;
		}
		return false;
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
					setChanged();
					notifyObservers(new CheckValidPassClass(false,false));
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
	
	
	public void showAllApartments() {
		
//		Row row;
//		int lastRow = apartments.getLastRowNum();
//		Cell userName, city, street, totalRommate, missRommate, roomNum, price, propertyKind, elevator, parking, airCon, balcon, dimension, storage, accessDis, furnish, pet;
//		String [][] data = new String[lastRow][17]; // for table
//		String [] record = new String[17]; // lines
//		int j = 0;
//		
//		for(int i=1; i<=lastRow; i++) 
//		{
//			row = apartments.getRow(i);
//			userName = apartments.getCell(0);
//			city = apartments.getCell(1);
//			street = apartments.getCell(2);
//			totalRommate = apartments.getCell(3);
//			missRommate = apartments.getCell(4);
//			roomNum = apartments.getCell(5);
//			price = apartments.getCell(6);
//			propertyKind = apartments.getCell(7);
//			elevator = apartments.getCell(8);
//			parking = apartments.getCell(9);
//			airCon = apartments.getCell(10);
//			balcon = apartments.getCell(11);
//			dimension = apartments.getCell(12);
//			storage = apartments.getCell(13);
//			accessDis = apartments.getCell(14);
//			furnish = apartments.getCell(15);
//			pet = apartments.getCell(16);
//
//		   till here 
//
//			record[0] = dataFormatter.formatCellValue(userName);
//			record[1] = dataFormatter.formatCellValue(password);
//			record[2] = dataFormatter.formatCellValue(firstName);
//			record[3] = dataFormatter.formatCellValue(lastName);
//			record[4] = dataFormatter.formatCellValue(email);
//			record[5] = dataFormatter.formatCellValue(phoneNumber);
//			record[6] = dataFormatter.formatCellValue(userID);
//			record[7] = dataFormatter.formatCellValue(adminToF);
//
//			data[j++] = record.clone();
//		}
//		
//		JTable jTable = new JTable(data, usersColumns);
//		setChanged();
//		notifyObservers(jTable);
		
	}

	public String getConnectedUser()
	{
		return connectedUser;
	}

	
}












