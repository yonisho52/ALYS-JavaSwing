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

public class DataExcelConn extends Observable
{
	Sheet users,apartments;
	private static String[] usersColumns = {"שם משתמש","סיסמא","שם פרטי","שם משפחה","מייל","טלפון","admin"};
	private static String[] apartmentsColumns = {"שם משתמש","id","כמות חיפושים","עיר","רחוב","סהכ שותפים","שותפים חסרים","חדרים","מחיר","תיאור","סוג הנכס","קומה","גינה","מספר דירה","מספר קומות","מעלית","חניה","מיזוג","מרפסת","ממד","מחסן","גישה לנכים","מרוהטת","חיות מחמד"};
	FileOutputStream fileOutputStream;
	int usersRow, apartmentsRow;
	public Workbook workBook;
	File file = new File("DataBase.xlsx");
	FileInputStream fileInputStream;
	Cell cellCompar;
	DataFormatter dataFormatter = new DataFormatter();
	static DataExcelConn dataExcelConn = new DataExcelConn(); //for singleton DP
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
	
	public class ShowAllApartments
	{
		public JTable allApartmentTable;
		public ShowAllApartments(JTable table)
		{
			this.allApartmentTable = table;
		}
	}
	
	private DataExcelConn() 
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
		try 
		{
			inputStream = new FileInputStream(new File(excelFilePath));
	    	Workbook workBook = WorkbookFactory.create(inputStream);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

    	//Sheet sheet = workBook.getSheetAt(0);
    	int rowCount = users.getLastRowNum();
    	Row row = users.createRow(++rowCount);

    	row.createCell(0).setCellValue(tenant.userName);
    	row.createCell(1).setCellValue(tenant.password);
    	row.createCell(2).setCellValue(tenant.firstName);
    	row.createCell(3).setCellValue(tenant.lastName);
    	row.createCell(4).setCellValue(tenant.email);
    	row.createCell(5).setCellValue(tenant.phoneNumber);
    	row.createCell(6).setCellValue(tenant.adminToF);


    	FileOutputStream output;
		try 
		{
			output = new FileOutputStream("DataBase.xlsx");
	    	workBook.write(output);
	    	output.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
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
	
	public void getAllUsers() 
	{
		Row row;
		int lastRow = users.getLastRowNum();
		Cell userName, password, firstName, lastName, email, phoneNumber, adminToF;
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
			adminToF = row.getCell(6);

			record[0] = dataFormatter.formatCellValue(userName);
			record[1] = dataFormatter.formatCellValue(password);
			record[2] = dataFormatter.formatCellValue(firstName);
			record[3] = dataFormatter.formatCellValue(lastName);
			record[4] = dataFormatter.formatCellValue(email);
			record[5] = dataFormatter.formatCellValue(phoneNumber);
			record[6] = dataFormatter.formatCellValue(adminToF);

			data[j++] = record.clone();
		}
		
		JTable jTable = new JTable(data, usersColumns);
		setChanged();
		notifyObservers(new UsersTable(jTable));
	}
	
	
	public void checkExsistUser(String userName) /// if the userName exists return *true, if not exists return *false  --- for register
	{ 
		Row row;
		Cell userNameDB;
		boolean exist = false;
		int lastRow = users.getLastRowNum();
		
		for(int i=1;i<=lastRow;i++) 
		{
			row=users.getRow(i);
			userNameDB = row.getCell(0);
			if (userName.equals(userNameDB.toString()))
			{
				exist = true;
				break;
			}
		}
		
		setChanged();
		notifyObservers(new ExistsUser(exist));
	}

	public void checkValidPass(String userName, String pass) /// if the userName's pass is valid return *true, if not return *false = wrong combination  --- for login
	{
		Row row;
		Cell userNameDB, passDB, adminDB;
		int lastRow = users.getLastRowNum();
		boolean validFlag = false, adminFlag = false;
		for(int i=1;i<=lastRow;i++) {
			row=users.getRow(i);
			userNameDB = row.getCell(0);
			//System.out.println(userName + " " + userNameDB.toString());
			//if(userName == userNameDB.toString())
			if(userName.equals(userNameDB.toString()))
			{
				passDB = row.getCell(1);
				adminDB = row.getCell(6);
				//System.out.println(userName + " " + userNameDB.toString());
				//if(pass == passDB.toString())
				if(pass.equals(passDB.toString())) 
				{
					connectedUser = new String(userName); //Save the connected users name
					if(adminDB.toString()=="FALSE") 
					{
						validFlag = true;
						adminFlag = false;
						//setChanged();
						//notifyObservers(new CheckValidPassClass(true,false));
					}
					else 
					{
						validFlag = true;
						adminFlag = true;
						//setChanged();
						//notifyObservers(new CheckValidPassClass(true,true));
					}
				} 
				//else 
					//{
					//validFlag = false;
					//adminFlag = false;
					//setChanged();
					//notifyObservers(new CheckValidPassClass(false,false));
					//}
				}
		}
		setChanged();
		notifyObservers(new CheckValidPassClass(validFlag,adminFlag));
	}
	
	public boolean checkIfAdmin(String userName) // if the user is admin return *true, if not return *false  --- for showAllApartmentView
	{  
		Row row;
		Cell userNameDB, adminDB;
		
		for(int i=1;i<=users.getLastRowNum();i++) 
		{
			row=users.getRow(i);
			userNameDB = row.getCell(0);
			if(userName.equals(userNameDB.toString())) {
				adminDB = row.getCell(6);
				if(adminDB.toString().equals("TRUE")) return true; 
				else return false;
			}
		}
		
		return false;
	}
	
	public void getAllApartments() 
	{
		// {"שם משתמש","עיר","רחוב","סהכ שותפים","שותפים חסרים","חדרים","מחיר","תיאור","סוג הנכס","קומה","גינה","מספר דירה","מספר קומות","מעלית","חניה","מיזוג","מרפסת","ממד","מחסן","גישה לנכים","מרוהטת","חיות מחמד"};
		
		Row row;
		int lastRow = apartments.getLastRowNum();

		String [][] data = new String[lastRow][23]; // for table
		String [] record = new String[23]; // lines
		int j = 0;
		
		for(int i=1; i<=lastRow; i++) 
		{
			row = apartments.getRow(i);
			String [] userDetails = userDetailsForApartemnt(row.getCell(0).toString());

			record[0] = userDetails[0];
			record[1] = userDetails[1];	
			record[2] = dataFormatter.formatCellValue(row.getCell(1));
			record[3] = dataFormatter.formatCellValue(row.getCell(2));
			record[4] = dataFormatter.formatCellValue(row.getCell(3));
			record[5] = dataFormatter.formatCellValue(row.getCell(4));
			record[6] = dataFormatter.formatCellValue(row.getCell(5));
			record[7] = dataFormatter.formatCellValue(row.getCell(6));
			record[8] = dataFormatter.formatCellValue(row.getCell(7));
			record[9] = dataFormatter.formatCellValue(row.getCell(8));
			record[10] = dataFormatter.formatCellValue(row.getCell(9));
			record[11] = dataFormatter.formatCellValue(row.getCell(10));
			record[12] = dataFormatter.formatCellValue(row.getCell(11));
			record[13] = dataFormatter.formatCellValue(row.getCell(12));
			record[14] = dataFormatter.formatCellValue(row.getCell(13));
			record[15] = dataFormatter.formatCellValue(row.getCell(14));
			record[16] = dataFormatter.formatCellValue(row.getCell(15));
			record[17] = dataFormatter.formatCellValue(row.getCell(16));
			record[18] = dataFormatter.formatCellValue(row.getCell(17));
			record[19] = dataFormatter.formatCellValue(row.getCell(18));
			record[20] = dataFormatter.formatCellValue(row.getCell(19));
			record[21] = dataFormatter.formatCellValue(row.getCell(20));
			record[22] = dataFormatter.formatCellValue(row.getCell(21));
		
			data[j++] = record.clone();
		}

		String[] allApartmentsColumns = {"שם השוכר","טלפון","עיר","רחוב","סהכ שותפים","שותפים חסרים","חדרים","מחיר","תיאור","סוג הנכס","קומה","גינה","מספר דירה","מספר קומות","מעלית","חניה","מיזוג","מרפסת","ממד","מחסן","גישה לנכים","מרוהטת","חיות מחמד"};
		JTable jTable = new JTable(data, allApartmentsColumns);
		setChanged();
		notifyObservers(new ShowAllApartments(jTable));
	}

	public void showUserApartments(String userName) 
	{
		Row row;
		int lastRow = apartments.getLastRowNum();
		Cell userNameDB;
		String [][] data = new String[lastRow][22]; // for table
		String [] record = new String[22]; // lines
		int j = 0,n,k;
		
		for(int i=1; i<=lastRow; i++)
		{
			row = apartments.getRow(i);
			userNameDB = row.getCell(0);
			if(userName.toString().equals(userNameDB.toString())) 
			{		
				for(n=3,k=0;n<=23;n++,k++)	
				{
					record[k] = dataFormatter.formatCellValue(row.getCell(n));
				}
					data[j++] = record.clone();
			}
		}
		
		//{"שם משתמש","id","כמות חיפושים","עיר","רחוב","סהכ שותפים","שותפים חסרים","חדרים","מחיר","תיאור","סוג הנכס","קומה","גינה","מספר דירה","מספר קומות","מעלית","חניה","מיזוג","מרפסת","ממד","מחסן","גישה לנכים","מרוהטת","חיות מחמד"};
		String[] UserapartmentsColumns = {"id","עיר","רחוב","סהכ שותפים","שותפים חסרים","חדרים","מחיר","תיאור","סוג הנכס","קומה","גינה","מספר דירה","מספר קומות","מעלית","חניה","מיזוג","מרפסת","ממד","מחסן","גישה לנכים","מרוהטת","חיות מחמד"};
		JTable jTable = new JTable(data, UserapartmentsColumns);
		//jTable.setBounds(10, 159, 1030, 309);
		setChanged();
		notifyObservers(new UserApartments(jTable));
	}

	public void addNewApartmentGround(Ground ground) // not finished 
	{  
		String excelFilePath = "DataBase.xlsx";
    	FileInputStream inputStream;
		try 
		{
			inputStream = new FileInputStream(new File(excelFilePath));
	    	Workbook workBook = WorkbookFactory.create(inputStream);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

    	//Sheet sheet = workBook.getSheetAt(0);
    	int rowCount = apartments.getLastRowNum();
    	Row row = apartments.createRow(++rowCount);
    	int n=0;
    	row.createCell(n++).setCellValue(ground.getUserId());
    	row.createCell(n++).setCellValue(ground.getPropertyID());
    	row.createCell(n++).setCellValue(ground.getSearchCount());
    	row.createCell(n++).setCellValue(ground.getCity());
    	row.createCell(n++).setCellValue(ground.getAddress());
    	row.createCell(n++).setCellValue(ground.getNumOfRoomMate());
    	row.createCell(n++).setCellValue(ground.getRoomMateMiss());
    	row.createCell(n++).setCellValue(ground.getRooms());
    	row.createCell(n++).setCellValue(ground.getPrice());
    	row.createCell(n++).setCellValue(ground.getDescription());
    	row.createCell(n++).setCellValue(ground.getPropertyType());
    	row.createCell(n++).setCellValue(ground.getElevator());
    	row.createCell(n++).setCellValue(ground.getParking());
    	row.createCell(n++).setCellValue(ground.getAirCon());
    	row.createCell(n++).setCellValue(ground.getPatio());
    	row.createCell(n++).setCellValue(ground.getMamad());
    	row.createCell(n++).setCellValue(ground.getStorage());
    	row.createCell(n++).setCellValue(ground.getAccesible());
    	row.createCell(n++).setCellValue(ground.getFurniture());
    	row.createCell(n++).setCellValue(ground.getPet());
    	
    	FileOutputStream output;
		try 
		{
			output = new FileOutputStream("DataBase.xlsx");
	    	workBook.write(output);
	    	output.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		System.out.println( " secssuce");
	}

	public int getTheLastApartmentId()
	{
		Row row;
		Cell lastIdDB;
		int lastRow = apartments.getLastRowNum();
		int lastId;
		row = apartments.getRow(lastRow);
		lastIdDB = row.getCell(1); // id cell
		lastId = Integer.parseInt(lastIdDB.toString());
		lastId++;
		return lastId;
	}
	
	public void searchApartment() 
	{
		
	}
	
	public String [] userDetailsForApartemnt(String userName)  /// 0 - name and last name, 2 - phone number
	{
		Row row;
		Cell userNameDB;
		String [] userDetails = new String[2];
		for(int i=1;i<=users.getLastRowNum();i++)
		{
			row=users.getRow(i);
			userNameDB = row.getCell(0);
			if(userName.equals(userNameDB.toString())) 
			{
				userDetails[0] = row.getCell(2).toString() + " " + row.getCell(3).toString();
				userDetails[1] = row.getCell(5).toString();
				break;
			}
		}
		return userDetails;
	}
	
	public void betweenPriceApartment(int start, int end) 
	{
		
	}
}