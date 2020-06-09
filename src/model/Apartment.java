package model;

public abstract class Apartment implements Property {
	
	protected int propertyID;
	protected int userID;
	protected String propertyType;
	protected int roomMate;
	protected int roomMateMiss;
	protected double price;
	protected String city;
	protected String address;
	protected int rooms;
	protected boolean status;
	protected String description;
	
	@Override
	public int getPropertyID() {
		// TODO Auto-generated method stub
		return 0;
	}
//how
	@Override
	public int getPropertyType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRoomMate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRoomMateMiss() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRooms() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setRoomMate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setRoomMateMiss() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setPropertyType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPrice(double price) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCity(String city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRooms(int numOfRooms) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatus(boolean status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}
}
