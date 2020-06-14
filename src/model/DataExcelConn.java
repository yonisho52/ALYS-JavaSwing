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
	private static String[] usersColumns = {"שם משתמש","סיסמא","שם פרטי","שם משפחה","מייל","טלפון","Admin", "Analyst"};
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
		public boolean analystType;
		
		public CheckValidPassClass(boolean valid, boolean admin, boolean analyst)
		{
			this.validPass = valid;
			this.userType = admin;
			this.analystType = analyst;
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
	
	public class TopApartment
	{
		public JTable topTable;
		public TopApartment(JTable table)
		{
			this.topTable = table;
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
	
	public class ShowSearchTable
	{
		public JTable searchTable;
		public ShowSearchTable(JTable table)
		{
			this.searchTable = table;
		}
	}
	
	public class CityShowRep
	{
		public String [] cityList;
		public CityShowRep(String [] cities)
		{
			this.cityList = cities;
		}
	}

	public class PropertType
	{
		public Boolean [] propertType;
		public PropertType(Boolean [] type)
		{
			this.propertType = type;
		}
	}
	
	public class MissRommates
	{
		public String [] missRommatesList;
		public MissRommates(String [] missedRommates)
		{
			this.missRommatesList = missedRommates;
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
    	row.createCell(7).setCellValue(tenant.analyst);


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
		Cell userName, password, firstName, lastName, email, phoneNumber, adminToF, analyst;
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
			analyst = row.getCell(7);

			record[0] = dataFormatter.formatCellValue(userName);
			record[1] = dataFormatter.formatCellValue(password);
			record[2] = dataFormatter.formatCellValue(firstName);
			record[3] = dataFormatter.formatCellValue(lastName);
			record[4] = dataFormatter.formatCellValue(email);
			record[5] = dataFormatter.formatCellValue(phoneNumber);
			record[6] = dataFormatter.formatCellValue(adminToF);
			record[7] = dataFormatter.formatCellValue(analyst);

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
		Cell userNameDB, passDB, adminDB, analystDB;
		int lastRow = users.getLastRowNum();
		boolean validFlag = false, adminFlag = false, analystFlag = false;
		for(int i=1;i<=lastRow;i++) {
			row=users.getRow(i);
			userNameDB = row.getCell(0);
			//System.out.println(userName + " " + userNameDB.toString());
			//if(userName == userNameDB.toString())
			if(userName.equals(userNameDB.toString()))
			{
				passDB = row.getCell(1);
				adminDB = row.getCell(6);
				analystDB = row.getCell(7);
				//System.out.println(userName + " " + userNameDB.toString());
				//if(pass == passDB.toString())
				if(pass.equals(passDB.toString())) 
				{
					validFlag = true;
					connectedUser = new String(userName); //Save the connected users name
					if(adminDB.toString()=="FALSE") 
					{
						adminFlag = false;
						if(analystDB.toString()=="FALSE")
						{
							analystFlag=false;
						}
						else
						{
							analystFlag=true;
						}
					}
					else 
					{
						validFlag = true;
						adminFlag = true;
						analystFlag = true;

					}
				} 
			}
		}
		setChanged();
		notifyObservers(new CheckValidPassClass(validFlag,adminFlag,analystFlag));
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
		int k=0,n;
		for(int i=1; i<=lastRow; i++) 
		{
			row = apartments.getRow(i);
			String [] userDetails = userDetailsForApartemnt(row.getCell(0).toString());

			record[0] = userDetails[0];
			record[1] = userDetails[1];	
			for(n=3,k=2;n<=23;n++,k++)
			{
				record[k] = dataFormatter.formatCellValue(row.getCell(n));
			}
		
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

	public void addNewApartmentGround(Ground ground) 
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
    	
    	row.createCell(n++).setCellValue("-");
    	row.createCell(n++).setCellValue("-");
    	row.createCell(n++).setCellValue("-");
    	
    	row.createCell(n++).setCellValue(ground.getFloorNumbers());
    	
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

	public void addNewApartmentBuilding(Building building)
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
    	row.createCell(n++).setCellValue(building.getUserId());
    	row.createCell(n++).setCellValue(building.getPropertyID());
    	row.createCell(n++).setCellValue(building.getSearchCount());
    	row.createCell(n++).setCellValue(building.getCity());
    	row.createCell(n++).setCellValue(building.getAddress());
    	row.createCell(n++).setCellValue(building.getNumOfRoomMate());
    	row.createCell(n++).setCellValue(building.getRoomMateMiss());
    	row.createCell(n++).setCellValue(building.getRooms());
    	row.createCell(n++).setCellValue(building.getPrice());
    	row.createCell(n++).setCellValue(building.getDescription());
    	row.createCell(n++).setCellValue(building.getPropertyType());
    	
    	row.createCell(n++).setCellValue(building.getFloor());
    	row.createCell(n++).setCellValue(building.getGarden());
    	row.createCell(n++).setCellValue(building.getApartmentNumber());
    	
    	row.createCell(n++).setCellValue("-");
    	
    	row.createCell(n++).setCellValue(building.getElevator());
    	row.createCell(n++).setCellValue(building.getParking());
    	row.createCell(n++).setCellValue(building.getAirCon());
    	row.createCell(n++).setCellValue(building.getPatio());
    	row.createCell(n++).setCellValue(building.getMamad());
    	row.createCell(n++).setCellValue(building.getStorage());
    	row.createCell(n++).setCellValue(building.getAccesible());
    	row.createCell(n++).setCellValue(building.getFurniture());
    	row.createCell(n++).setCellValue(building.getPet());
    	
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
		lastRow++;
		return lastRow;
	}
	
	
	// type , city , missedRommate, start price , limit price

	public void searchApartment(String [] search) 
	{
		Row row;
		Cell typeDB, cityDB, missRommateDB, priceDB, searchDB;
		int lastRow = apartments.getLastRowNum();
		
		// for table
		
		String [][] data = new String[lastRow][23]; 
		String [] record = new String[23]; // lines
		
		String type = search[0];//10
		String city = search[1];// 3
		int missedRommate = Integer.parseInt(search[2]); // 6
		int startPrice = Integer.parseInt(search[3]); // 8
		int limitPrice = Integer.parseInt(search[4]);
		
		Double ps,ms;
		
		double searchValue;
		
		String [] userDetails;
		
		int j = 0,n,k;
		
		int miss,price;
		
		for(int i=1;i<=lastRow;i++)
		{
			row=apartments.getRow(i);
			typeDB = row.getCell(10);
			cityDB = row.getCell(3);
			missRommateDB = row.getCell(6);
			priceDB = row.getCell(8);
			searchDB = row.getCell(2);

			ps = Double.valueOf(priceDB.toString());
			price = ps.intValue();
			

			ms = Double.valueOf(missRommateDB.toString());
			miss = ms.intValue();
			
			searchValue = Double.parseDouble(searchDB.toString());
			
			if(type.equals(typeDB.toString())) 
			{
				if(city.equals(cityDB.toString()))
				{
					if(missedRommate<=miss)
					{
						if(startPrice<=price)
						{
							if(limitPrice>=price)
							{
								userDetails = userDetailsForApartemnt(row.getCell(0).toString());

								record[0] = userDetails[0];
								record[1] = userDetails[1];	
									
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
								record[21] = dataFormatter.formatCellValue(row.getCell(22));
								record[22] = dataFormatter.formatCellValue(row.getCell(23));
								
								data[j++] = record.clone();
								
								searchValue++;
								
								row.createCell(2).setCellValue(searchValue);
								
								}
							}
						}
					}
				}
			}
		
		String[] allApartmentsColumns = {"שם השוכר","טלפון","עיר","רחוב","סהכ שותפים","שותפים חסרים","חדרים","מחיר","תיאור","סוג הנכס","קומה","גינה","מספר דירה","מספר קומות","מעלית","חניה","מיזוג","מרפסת","ממד","מחסן","גישה לנכים","מרוהטת","חיות מחמד"};
		JTable jTable = new JTable(data, allApartmentsColumns);
		setChanged();
		notifyObservers(new ShowSearchTable(jTable));
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
	


	public String [] shortCutArray(String [] arr)
	{
		int i=0,j=0;
		int count=0;
		for(i=0;i<arr.length;i++)
		{
			if(arr[i]=="x") {continue;}
			if(arr[i]==null) {arr[i]="x"; continue;}
			for(j=arr.length-1;j>i;j--)
			{
				if(arr[i] == arr[j] || arr[j] == null)
				{
					arr[j]="x";
					continue;
				}
			}
		}
		for(i=0;i<arr.length;i++)
		{
			if(arr[i]!="x")
				count++;
		}
		
		
		String [] newArr = new String [count];
		i=0;
		for(j=0;j<arr.length;j++)
		{
				if(arr[j]!="x" && arr[j]!=null)
				{
					newArr[i++] = arr[j];
				}
		}
		
		return newArr;
	}
	
	

	public void citysShow(int indexType)  /// 0 - false - ground, 1 - true - building
	{
		  /// j
		String [] allCityDB = new String[apartments.getLastRowNum()];  /// k
		Row row;
		Cell cityDB, typeDB;
		int j=0,k=0,i,count=0;
		String type = "קרקע";
		if(indexType==1) {type = "בניין";}
		
		for(i=1;i<=apartments.getLastRowNum();i++)
		{
			row=apartments.getRow(i);
			cityDB = row.getCell(3);
			typeDB = row.getCell(10);
			if(typeDB.toString().equals(type.toString()))
			{
			allCityDB[k++] = cityDB.toString();
			}
		}
		

		
		String [] city = shortCutArray(allCityDB);
		
		setChanged();
		notifyObservers(new CityShowRep(city));
	}
	
	public void propertShow()  // 0- garden, 1-building
	{
		Row row;
		Cell propertyTypeDB;
		Boolean [] type = new Boolean[2];
		
		
		type[0] = false;
		type[1] = false;
		
		for(int i=1;i<=apartments.getLastRowNum();i++)
		{
			row=apartments.getRow(i);
			propertyTypeDB = row.getCell(10);
			if(propertyTypeDB.toString().equals("קרקע"))
			{
				type[0] = true;
			}
			else if(propertyTypeDB.toString().equals("בניין"))
			{
				type[1] = true;
			}
			if(type[1]&&type[0])
			{
				break;
			}
		}

		
		setChanged();
		notifyObservers(new PropertType(type));
		
	}
	
	public String getPropertyType(int index) // 0- garden, 1-building
	{
		String type = "קרקע";
		if(index==0)
			type = "קרקע";
		if(index==1)
			type = "בניין";
		return type;
	}
	
	public void missedRommateShow(int typeSelected, String citySelected)
	{
		
		String [] allRommateMissedDB = new String[apartments.getLastRowNum()];  /// k
		Row row;
		Cell missedRommateDB, typeDB, cityDB;
		String type = getPropertyType(typeSelected);
		
		int j=0,k=0,i,count=0;
		
		
		
		for(i=1;i<=apartments.getLastRowNum();i++)
		{
			row=apartments.getRow(i);
			cityDB = row.getCell(3);
			typeDB = row.getCell(10);
			missedRommateDB = row.getCell(6);

			if(typeDB.toString().equals(type.toString()) && cityDB.toString().equals(citySelected.toString()))
			{
				allRommateMissedDB[k++] = missedRommateDB.toString();
			}
		}
		
		String [] missedRommets = shortCutArray(allRommateMissedDB);
		

		setChanged();
		notifyObservers(new MissRommates(missedRommets));
	}

	public void topApartment()
	{
		
		Row row;
		int lastRow = apartments.getLastRowNum();
		Cell searchDB;
		String [][] data = new String[lastRow][8]; // for table
		String [] record = new String[8]; // lines
		double [] search = new double[lastRow];
		int j=0, k=0, n=0,i;
		
		
		for(i=1;i<=lastRow;i++)
		{
			row = apartments.getRow(i);
			searchDB = row.getCell(2);
			search[j++]=Double.parseDouble(searchDB.toString());
		}
		
		Arrays.parallelSort(search);
		
		for(j=search.length-1;j>=0;j--)
		{
			for(i=1; i<=lastRow; i++)
			{
				row = apartments.getRow(i);
				searchDB = row.getCell(2);
				if(search[j]==Double.parseDouble(searchDB.toString()))
				{
					record[k++] = dataFormatter.formatCellValue(row.getCell(0));
					record[k++] = dataFormatter.formatCellValue(row.getCell(2));
					record[k++] = dataFormatter.formatCellValue(row.getCell(3));
					record[k++] = dataFormatter.formatCellValue(row.getCell(4));
					record[k++] = dataFormatter.formatCellValue(row.getCell(6));
					record[k++] = dataFormatter.formatCellValue(row.getCell(7));
					record[k++] = dataFormatter.formatCellValue(row.getCell(8));
					record[k++] = dataFormatter.formatCellValue(row.getCell(10));
					data[n++] = record.clone();
					k=0;
					break;
				}
			}
		}
		
		String[] UserapartmentsColumns = {"משתמש","כמות חיפושים","עיר","רחוב","שותפים חסרים","חדרים","מחיר","סוג הנכס"};
		JTable jTable = new JTable(data, UserapartmentsColumns);
		//jTable.setBounds(10, 159, 1030, 309);
		setChanged();
		notifyObservers(new TopApartment(jTable));
		

		}
		
	
	
	public void deleteUser(int index)
	{
		Row row;
		Cell userNameDB;
		row = users.getRow(index);
		userNameDB = row.getCell(0);
		deleteUsersApartment(userNameDB.toString());
        //int getLastCell=row.getLastCellNum()-1;
        int lastIndex = users.getLastRowNum();
		//users.removeRow(deleteRow);
        int rowIndexToDelete = row.getRowNum();
        users.shiftRows(rowIndexToDelete+1, lastIndex, -1);

        
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
		

		
		setChanged();
		notifyObservers(new ConfirmDelete());
		
	}

	public void deleteUsersApartment(String userName)
	{
		Row row;
		Cell userNameDB;
		int rowIndexToDelete,lastIndex;
		
		for(int i=1;i<=apartments.getLastRowNum();i++)
		{
			row=apartments.getRow(i);
			userNameDB = row.getCell(0);
			lastIndex = apartments.getLastRowNum();
			rowIndexToDelete = row.getRowNum();
			if(userName.equals(userNameDB.toString())) 
			{
		        apartments.shiftRows(rowIndexToDelete+1, lastIndex, -1);
			}
		}
		
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
	
	
	
public class ConfirmDelete{}



















}
