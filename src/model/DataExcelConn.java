package model;

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
	private static String[] usersColumns = {"שם משתמש","סיסמא","שם פרטי","שם משפחה","מייל","טלפון","ID","admin"};
	private static String[] apartmentsColumns = {"שם משתמש","סיסמא","שם פרטי","שם משפחה","מייל","טלפון","ID"};
	FileOutputStream fileOutputStream;
	int usersRow, apartmentsRow;
	public Workbook workBook;
	File file = new File("DataBase.xlsx");
	
public DataExcelConn() {	
	
//	if(file.exists()) {
		
//		usersRow=users.getLastRowNum();
//		apartmentsRow = apartments.getLastRowNum();
//		users=workBook.getSheetAt(0);
//		apartments=workBook.getSheetAt(0);
	
//	}else { 
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
	
//	}   
}
	
	public void addNewApartment() {}
	public void checkExsistUser() {}
	public void searchApartment() {}
	public void showAllApartments() {}
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
}
