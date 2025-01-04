package com.FoodAppModel;

public class UsersModel {
	private int userId;
	private String name;
	private String password;
	private String address;
	private String email;
	private String createdDate;
	private String lastLoginDate;
	
	public int getId() {
		return userId;
	}
	public void setId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	
	public UsersModel() {
		
	}
	
	public UsersModel(int userId,String name,String password,String email,String address) {
		this.userId=userId;
		this.name=name;
		this.password=password;
		this.address=address;
		this.email=email;
	}
	
	public UsersModel(int userId, String name, String password, String address, String email, String createdDate,
			String lastLoginDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.createdDate = createdDate;
		this.lastLoginDate = lastLoginDate;
	}
	
	@Override
	public String toString() {
		return  userId  +"     "+ name +"    " + password + "   " + email
				+"   " + address +"   "+createdDate+"    "+lastLoginDate ;
	}
	
	public UsersModel(String name,String password,String email,String address) {
		this.name=name;
		this.password=password;
		this.address=address;
		this.email=email;
	}
	
}
