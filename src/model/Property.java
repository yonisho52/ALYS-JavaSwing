package model;

public interface Property 
{
	//getters
	public int getPropertyID();
	public String getUserId();
	public int getSearchCount();
	public String getCity();
	public String getAddress();
	public int getNumOfRoomMate();
	public int getRoomMateMiss();
	public int getRooms();
	public int getPrice();
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
	public void setPropertyID(int apartmentId);
	public void setUserId(String userName);
	public void setSearchCount();
	public void setCity(String city);
	public void setAddress(String address);
	public void setNumOfRoomMate(int NnumOfRoomMate);
	public void setRoomMateMiss(int roomMateMiss);
	public void setRooms(int numOfRooms);
	public void setPrice(int price);
	public void setDescription(String description);
	public void setPropertyType();  ///****
	public void setElevator(boolean elevator);
	public void setParking(boolean parking);
	public void setAirCon(boolean airCon);
	public void setPatio(boolean patio);
	public void setMamad(boolean mamad);
	public void setStorage(boolean storage);
	public void setAccesible(boolean accesible);
	public void setFurniture(boolean furniture);
	public void setPet(boolean pet);
}
//String [] buildingApartment = {city,Address,numOfRommates,missingRoomates, rooms, price, description,propertyType, floorsBuilding,gardenGround, apartmentNumberGround, floorCountGround,
//elevator, parking, airCon, patio, mamad, storage, accesible, furniture, pet};
//
//
//
//
//