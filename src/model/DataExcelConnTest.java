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

class DataExcelConnTest  extends junit.framework.TestCase{

	DataExcelConn junit;
	Tenant tenant = new Tenant("user", "pass", "first", "last", "email@email.com", "0000000", false, false);
	Ground ground = new Ground(0);
	
//	@org.junit.jupiter.api.Test
//	void test() {
//		fail("Not yet implemented");
//	}

	
	public DataExcelConnTest() {
		initGround();
		setUp();
		
	}

	public void initGround() {
		ground.setPropertyID(1212);
		ground.setUserId("user");
		ground.setSearchCount();
		ground.setCity("city");
		ground.setAddress("street");
		ground.setNumOfRoomMate(2);
		ground.setRoomMateMiss(1);
		ground.setRooms(3);
		ground.setPrice(2000);
		ground.setDescription("great");
		//ground.setPropertyType();
		ground.setElevator(true);
		ground.setParking(true);
		ground.setAirCon(false);
		ground.setPatio(false);
		ground.setMamad(true);
		ground.setStorage(true);
		ground.setAccesible(false);
		ground.setFurniture(false);
		ground.setPet(true);
	}


	@Before
	public void setUp()
	{
		dataExcel();
		closeFile();
		junit = DataExcelConn.getDataExcelConn();
	}
	
	
	@After
	public void tearDown() throws Exception{}
	
	@Test
	public void checkIfUserAdded()
	{

		junit.addNewTenant(tenant);
		
		dataExcel();
		
		Row row;
		Cell userNameDB,passDB, firstDB,lastDB, emailDB, phoneDB,adminDB,analystDB;
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
		assertTrue(passDB.toString().equals("pass"));
		assertTrue(firstDB.toString().equals("first"));
		assertTrue(lastDB.toString().equals("last"));
		assertTrue(emailDB.toString().equals("email@email.com"));
		assertTrue(phoneDB.toString().equals("0000000"));
		assertTrue(adminDB.toString().equals("FALSE"));
		assertTrue(analystDB.toString().equals("FALSE"));

		closeFile();
	}
	
	@Test
	public void checkIfApartmentAdded()
	{
		
		junit.addNewApartmentGround(ground);
		
		dataExcel();
		
		Row row;
		Cell userNameDB,propertyIdDB, searchCountDB,cityDB, adressDB, numOfRoomatesDB,roomMateMissDB,roomsDB, priceDB, descriptionDB, propertTypeDB, floorDB, gardenDB, 
		apartmentNumDB, floorNumDB, elevatorDB, parkingDB, airConDB, patioDB, mamadDB, storageDB, accesibleDB, furnitureDB, petDB;
		int lastRow = apartments.getLastRowNum();
		int n=0;
		row = apartments.getRow(lastRow);
		userNameDB = row.getCell(n++);
		propertyIdDB = row.getCell(n++);
		searchCountDB = row.getCell(n++);
		cityDB = row.getCell(n++);
		adressDB = row.getCell(n++);
		numOfRoomatesDB = row.getCell(n++);
		roomMateMissDB = row.getCell(n++);
		roomsDB = row.getCell(n++);
		priceDB = row.getCell(n++);
		descriptionDB = row.getCell(n++);
		propertTypeDB = row.getCell(n++);
		floorDB = row.getCell(n++);
		gardenDB = row.getCell(n++);
		apartmentNumDB = row.getCell(n++);
		floorNumDB = row.getCell(n++);
		elevatorDB = row.getCell(n++);
		parkingDB = row.getCell(n++);
		airConDB = row.getCell(n++);
		patioDB = row.getCell(n++);
		mamadDB = row.getCell(n++);
		storageDB = row.getCell(n++);
		accesibleDB = row.getCell(n++);
		furnitureDB = row.getCell(n++);
		petDB = row.getCell(n++);

		assertTrue(userNameDB.toString().equals("user"));
		assertTrue(propertyIdDB.toString().equals("1212.0"));
		assertTrue(searchCountDB.toString().equals("0.0"));
		assertTrue(cityDB.toString().equals("city"));
		assertTrue(adressDB.toString().equals("street"));
		assertTrue(numOfRoomatesDB.toString().equals("2.0"));
		assertTrue(roomMateMissDB.toString().equals("1.0"));
		assertTrue(roomsDB.toString().equals("3.0"));
		assertTrue(priceDB.toString().equals("2000.0"));
		assertTrue(descriptionDB.toString().equals("great"));
		assertTrue(propertTypeDB.toString().equals("קרקע"));
		assertTrue(floorDB.toString().equals("-"));
		assertTrue(gardenDB.toString().equals("-"));
		assertTrue(apartmentNumDB.toString().equals("-"));
		assertTrue(floorNumDB.toString().equals("0.0"));
		assertTrue(elevatorDB.toString().equals("TRUE"));
		assertTrue(parkingDB.toString().equals("TRUE"));
		assertTrue(airConDB.toString().equals("FALSE"));
		assertTrue(patioDB.toString().equals("FALSE"));
		assertTrue(mamadDB.toString().equals("TRUE"));
		assertTrue(storageDB.toString().equals("TRUE"));
		assertTrue(accesibleDB.toString().equals("FALSE"));
		assertTrue(furnitureDB.toString().equals("FALSE"));
		assertTrue(petDB.toString().equals("TRUE"));

		closeFile();
	}

	@Test
	public void checkIfUserDeleted()
	{
		
		junit.deleteUser(users.getLastRowNum());
		
		dataExcel();
		
		Row row;
		Cell userNameDB,passDB, firstDB,lastDB, emailDB, phoneDB,adminDB,analystDB;
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

		assertFalse(userNameDB.toString().equals("user"));
		assertFalse(passDB.toString().equals("pass"));
		assertFalse(firstDB.toString().equals("first"));
		assertFalse(lastDB.toString().equals("last"));
		assertFalse(emailDB.toString().equals("email@email.com"));
		assertFalse(phoneDB.toString().equals("0000000"));
		assertFalse(adminDB.toString().equals("FALSE"));
		assertFalse(analystDB.toString().equals("FALSE"));

		closeFile();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	// Excel open and close
	
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
			users=workBook.createSheet("×ž×©×ª×ž×©×™×�");//creating new sheet
			apartments=workBook.createSheet("× ×›×¡×™×�");//creating new sheet
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
	
}
