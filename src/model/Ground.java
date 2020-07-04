package model;

public class Ground extends Apartment
{
	private int floorNumbers;

	public Ground(int floorNumbers) 
	{
		super();
		this.floorNumbers = floorNumbers;
		this.propertyType = "קרקע";
	}
	
	public int getFloorNumbers() {
		return floorNumbers;
	}

	public void setFloorNumbers(int floorNumbers) {
		this.floorNumbers = floorNumbers;
	}
}