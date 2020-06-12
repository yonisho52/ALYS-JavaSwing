package model;

public class Tenant extends User {
		
	public Tenant(String userName,String password, String firstName, String lastName, String email, String phoneNumber, 
			boolean adminToF) {
		
		this.userName=userName;
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.adminToF=adminToF;
	}
}
