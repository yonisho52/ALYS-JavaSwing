package model;

public class Building extends Apartment{

	private int floor;
	private boolean garden;
	private int apartmentNumber;

	
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public boolean isGarden() {
		return garden;
	}
	public void setGarden(boolean garden) {
		this.garden = garden;
	}
	public int getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
}
