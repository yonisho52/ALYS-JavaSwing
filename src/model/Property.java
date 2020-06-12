package model;

public interface Property {
	

	
	//getters
	public int getPropertyID();
	public String getUserId();
	public int getSearchCount();
	public String getCity();
	public String getAddress();
	public int getNumOfRoomMate();
	public int getRoomMateMiss();
	public int getRooms();
	public double getPrice();
	public String getDescription();
	public String getPropertyType();  /////*****
	public boolean getElevator();
	public boolean getParking();
	public boolean getAirCon();
	public boolean getPatio();
	public boolean getMamad();
	public boolean getStorage();
	public boolean getAccesible();
	public boolean getFurniture();
	public boolean getPet();
	

	
	//setters
	public int setPropertyID();
	public String setUserId(String userName);
	public int setSearchCount();
	public String setCity(String city);
	public String setAddress(String address);
	public int setNumOfRoomMate(int NnumOfRoomMate);
	public int setRoomMateMiss(int roomMateMiss);
	public int setRooms(int numOfRooms);
	public double setPrice(double price);
	public String setDescription(String description);
	public String setPropertyType();  ///****
	public boolean setElevator(boolean elevator);
	public boolean setParking(boolean parking);
	public boolean setAirCon(boolean airCon);
	public boolean setPatio(boolean patio);
	public boolean setMamad(boolean mamad);
	public boolean setStorage(boolean storage);
	public boolean setAccesible(boolean accesible);
	public boolean setFurniture(boolean furniture);
	public boolean setPet(boolean pet);
	
	
	

}
//String [] buildingApartment = {city,Address,numOfRommates,missingRoomates, rooms, price, description,propertyType, floorsBuilding,gardenGround, apartmentNumberGround, floorCountGround,
//elevator, parking, airCon, patio, mamad, storage, accesible, furniture, pet};
//
//
//
//
//