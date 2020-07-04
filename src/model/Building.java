package model;

public class Building extends Apartment
{
	private int floor;
	private boolean garden;
	private int apartmentNumber;

	public Building(int floor, boolean garden, int apartmentNumber) 
	{
		super();
		this.floor = floor;
		this.garden = garden;
		this.apartmentNumber = apartmentNumber;
		this.propertyType = "בניין";
	}
	
	public int getFloor() 
	{
		return floor;
	}
	
	public void setFloor(int floor) 
	{
		this.floor = floor;
	}
	
	public boolean getGarden() 
	{
		return garden;
	}
	
	public void setGarden(boolean garden) 
	{
		this.garden = garden;
	}
	
	public int getApartmentNumber() 
	{
		return apartmentNumber;
	}
	
	public void setApartmentNumber(int apartmentNumber) 
	{
		this.apartmentNumber = apartmentNumber;
	}
}