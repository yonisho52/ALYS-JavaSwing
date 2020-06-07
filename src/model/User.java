package model;

import java.util.Observable;


public abstract class User extends Observable {

	protected String userName;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String phoneNumber;
	protected int userID;
      
    
    //getters
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getEmail() {return email;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getuserName() {return userName;}
    public String getpassword() {return password;}
    public int getUserID() {return userID;}
    
    //setters
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setEmail(String email) {this.email = email;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setUserID(int userID) {this.userID = userID;}
    public void setuserName(String userName){this.userName=userName;}
    public void setpassword( String password) {this.password=password;}
}
