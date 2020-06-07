package model;

public interface Property {
	
	//non checkbox!
	
	//getters
	public int getPropertyID();
	public int getPropertyType();
	public int getRoomMate();
	public int getRoomMateMiss();
	public double getPrice();
	public String getCity();
	public String getAddress();
	public int getRooms();
	public boolean getStatus();
	public String getDescription();
	
	//setters
	public int setRoomMate();
	public int setRoomMateMiss();
	public int setPropertyType();
	public void setPrice(double price);
	public void setCity(String city);
	public void setAddress(String address);
	public void setRooms(int numOfRooms);
	public void setStatus(boolean status);
	public void setDescription(String description);

}
