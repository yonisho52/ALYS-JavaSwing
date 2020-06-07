package model;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
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
	private static String[] usersColumns = {"שם משתמש","סיסמא","שם פרטי","שם משפחה","מייל","טלפון","ID"};
	private static String[] apartmentsColumns = {"שם משתמש","סיסמא","שם פרטי","שם משפחה","מייל","טלפון","ID"};

	int usersRow, apartmentsRow;
	public Workbook workBook;
	File file = new File("DataBase.xlsx");
	
public DataExcelConn() {
		
	/*
	//if(file.exists()) {
	/////
	//} else { 
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
	    usersRow = 1;
	    apartmentsRow = 1;
	*/
	//}
}
	

	
	
	
	
	public void addNewUser(User detatils) {}
	public void checkExsistUser() {}
	public void searchApartment() {}
	public void showAllApartments() {}
	public void showUserApartments() {}






	public void addNewTenant(Tenant user) 
	{
		System.out.println(user.userName);
	}
}
