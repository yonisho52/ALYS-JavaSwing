package model;

public abstract class Apartment implements Property 
{
	protected int propertyID;
	protected String userId;
	protected int searchCount;
	protected String city;
	protected String address;
	protected int numOfRoomMate;
	protected int roomMateMiss;
	protected int rooms;
	protected int price;
	protected String description;
	protected String propertyType;  /////*****
	protected boolean elevator;
	protected boolean parking;
	protected boolean airCon;
	protected boolean patio;
	protected boolean mamad;
	protected boolean storage;
	protected boolean accesible;
	protected boolean furniture;
	protected boolean pet;

	@Override
	public int getPropertyID() {
		// TODO Auto-generated method stub
		return propertyID;
	}
	@Override
	public String getUserId() {
		// TODO Auto-generated method stub
		return userId;
	}
	@Override
	public int getSearchCount() {
		// TODO Auto-generated method stub
		return searchCount;
	}
	@Override
	public String getCity() {
		// TODO Auto-generated method stub
		return city;
	}
	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}
	@Override
	public int getNumOfRoomMate() {
		// TODO Auto-generated method stub
		return numOfRoomMate;
	}
	@Override
	public int getRoomMateMiss() {
		// TODO Auto-generated method stub
		return roomMateMiss;
	}
	@Override
	public int getRooms() {
		// TODO Auto-generated method stub
		return rooms;
	}
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}
	@Override
	public String getPropertyType() {
		// TODO Auto-generated method stub
		return propertyType;
	}
	@Override
	public boolean getElevator() {
		// TODO Auto-generated method stub
		return elevator;
	}
	@Override
	public boolean getParking() {
		// TODO Auto-generated method stub
		return parking;
	}
	@Override
	public boolean getAirCon() {
		// TODO Auto-generated method stub
		return airCon;
	}
	@Override
	public boolean getPatio() {
		// TODO Auto-generated method stub
		return patio;
	}
	@Override
	public boolean getMamad() {
		// TODO Auto-generated method stub
		return mamad;
	}
	@Override
	public boolean getStorage() {
		// TODO Auto-generated method stub
		return storage;
	}
	@Override
	public boolean getAccesible() {
		// TODO Auto-generated method stub
		return accesible;
	}
	@Override
	public boolean getFurniture() {
		// TODO Auto-generated method stub
		return furniture;
	}
	@Override
	public boolean getPet() {
		// TODO Auto-generated method stub
		return pet;
	}

	//setter's
	
	@Override
	public void setPropertyID(int apartmentId) {
		// TODO Auto-generated method stub
		this.propertyID = apartmentId;
	}
	@Override
	public void setUserId(String userName) {
		// TODO Auto-generated method stub
		this.userId = userName;

	}
	@Override
	public void setSearchCount() {
		// TODO Auto-generated method stub
		this.searchCount = 0;

	}
	@Override
	public void setCity(String city) {
		// TODO Auto-generated method stub
		this.city = city;

	}
	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		this.address = address;

	}
	@Override
	public void setNumOfRoomMate(int NnumOfRoomMate) {
		// TODO Auto-generated method stub
		this.numOfRoomMate = NnumOfRoomMate;

	}
	@Override
	public void setRoomMateMiss(int roomMateMiss) {
		// TODO Auto-generated method stub
		this.roomMateMiss = roomMateMiss;
	}
	@Override
	public void setRooms(int numOfRooms) {
		// TODO Auto-generated method stub
		this.rooms = numOfRooms;
	}
	@Override
	public void setPrice(int price) {
		// TODO Auto-generated method stub
		this.price = price;
	}
	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		this.description = description;
	}
	@Override
	public void setPropertyType() {
		// TODO Auto-generated method stub
	}
	@Override
	public void setElevator(boolean elevator) {
		// TODO Auto-generated method stub
		this.elevator = elevator;
	}
	@Override
	public void setParking(boolean parking) {
		// TODO Auto-generated method stub
		this.parking = parking;
	}
	@Override
	public void setAirCon(boolean airCon) {
		// TODO Auto-generated method stub
		this.airCon = airCon;
	}
	@Override
	public void setPatio(boolean patio) {
		// TODO Auto-generated method stub
		this.patio = patio;
	}
	@Override
	public void setMamad(boolean mamad) {
		// TODO Auto-generated method stub
		this.mamad = mamad;
	}
	@Override
	public void setStorage(boolean storage) {
		// TODO Auto-generated method stub
		this.storage = storage;
	}
	@Override
	public void setAccesible(boolean accesible) {
		// TODO Auto-generated method stub
		this.accesible = accesible;
	}
	@Override
	public void setFurniture(boolean furniture) {
		// TODO Auto-generated method stub
		this.furniture = furniture;
	}
	@Override
	public void setPet(boolean pet) {
		// TODO Auto-generated method stub
		this.pet = pet;
	}
}