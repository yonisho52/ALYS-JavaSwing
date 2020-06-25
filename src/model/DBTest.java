package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Observable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import view.RegisterView.AddUser;

class DBTest  extends junit.framework.TestCase{

	DataExcelConn junit;
	
	
//	@org.junit.jupiter.api.Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	

	
	public DBTest() {
		dataExcel();
		setUp();
	}




	public void setUp()
	{
		//DataExcelConn();
		junit = new DataExcelConn();

		
		
		//junit = new Tenant("user", "pass", "first", "last", "email@email.com", "0000000", false, false);
//		
//		String newTenant[] = {"user", "pass", "first", "last", "email@email.com", "0000000"};
//				setChanged();
//				notifyObservers(new AddUser(newTenant));
	}
	
	
	@After
	public void tearDown() throws Exception{}
	
	@Test
	public void testAdd()
	{
//		DataExcelConn();
//		junit = new Tenant("user", "pass", "first", "last", "email@email.com", "0000000", false, false);
//		
//		String newTenant[] = {"user", "pass", "first", "last", "email@email.com", "0000000"};
//				setChanged();
//				notifyObservers(new AddUser(newTenant));
		

		
		Tenant tenant = new Tenant("user", "pass", "first", "last", "email@email.com", "0000000", false, false);
		junit.addNewTenant(tenant);
	
		junit.closeFile();
		closeFile();
		
		

		
		Row row;
		Cell userNameDB,passDB, firstDB,lastDB, emailDB, phoneDB,adminDB,analystDB;
		boolean valid = false;
		int lastRow = users.getLastRowNum();
		
		
		row = users.getRow(lastRow);
		userNameDB = row.getCell(0);
		passDB = row.getCell(1);
		firstDB = row.getCell(2);
		lastDB = row.getCell(3);
		emailDB = row.getCell(4);
		phoneDB = row.getCell(5);
		adminDB = row.getCell(6);
		analystDB = row.getCell(7);

		
		
		
		assertTrue(userNameDB.toString().equals("user"));
//		&& junit.password == "pass" && junit.firstName == "first" && junit.lastName == "last" &&
//				junit.email == "email@email.com" && junit.phoneNumber == "0000000" && junit.adminToF == false && junit.analyst == false);
//		
		
	}
	
	
	
	
	
	Sheet users,apartments;
	private static String[] usersColumns = {"שם משתמש","סיסמא","שם פרטי","שם משפחה","מייל","טלפון","Admin", "Analyst"};
	private static String[] apartmentsColumns = {"שם משתמש","id","כמות חיפושים","עיר","רחוב","סהכ שותפים","שותפים חסרים","חדרים","מחיר","תיאור","סוג הנכס","קומה","גינה","מספר דירה","מספר קומות","מעלית","חניה","מיזוג","מרפסת","ממד","מחסן","גישה לנכים","מרוהטת","חיות מחמד"};
	
	FileOutputStream fileOutputStream;
	FileInputStream fileInputStream;
	
	int usersRow, apartmentsRow;
	public Workbook workBook;
	File file = new File("DataBase.xlsx");

	Cell cellCompar;
	DataFormatter dataFormatter = new DataFormatter();
	

	
	public void dataExcel() 
	{	
		if(file.exists()) 
		{
			try 
			{
				fileInputStream = new FileInputStream(file);
				workBook = WorkbookFactory.create(fileInputStream);
				users = workBook.getSheetAt(0);
				apartments=workBook.getSheetAt(1);
				usersRow = users.getLastRowNum();
				apartmentsRow = apartments.getLastRowNum();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		else 
		{ 
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
		    for(int i = 0; i < usersColumns.length; i++) 
		    {
		        Cell cell = headerRowCL.createCell(i);
		        cell.setCellValue(usersColumns[i]);
		        cell.setCellStyle(headerCellStyle);
		    }
		    
		    for(int i = 0; i < apartmentsColumns.length; i++) 
		    {
		        Cell cell = headerRowGH.createCell(i);
		        cell.setCellValue(apartmentsColumns[i]);
		        cell.setCellStyle(headerCellStyle);
		    }
		}
	}
	
	public void closeFile()
	{
		// Write the output to a file
		try 
		{
			fileOutputStream= new FileOutputStream("DataBase.xlsx");
			workBook.write(fileOutputStream);
			fileOutputStream.close();
			workBook.close();
	    }
		
		catch(Exception e) 
		{
			e.printStackTrace();  
		}
	}
	
	
	
	
	public class AddUser
	{
		public String [] userName;
		public AddUser(String [] user)
		{
			this.userName = user;
		}
	}
	
}
