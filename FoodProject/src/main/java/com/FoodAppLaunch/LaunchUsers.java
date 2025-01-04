package com.FoodAppLaunch;

import java.util.Scanner;

import com.FoodAppDaoImpl.UsersDaoImpl;
import com.FoodAppModel.UsersModel;

public class LaunchUsers {

	private static UsersDaoImpl imp=new UsersDaoImpl();

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int userId;
		String name;
		String password;
		String address;
		String email;
		
		
		System.out.println("Welcome to the users table. Select the below options you want to perform:");
		System.out.println("1.  Insert the data into the users\n"
				+"2.  Fetch all the data from users\n"
				+"3.  Fetch particular data from users\n"
				+"4.  Update particular data in users\n"
				+"5.  Delete particular row from users");
		
		int n=scanner.nextInt();
		scanner.nextLine();
		
		switch(n) {
		
		case 1:
			System.out.println("Enter the id:");
			userId=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the name:");
			name=scanner.nextLine();
			System.out.println("Enter the password:");
			password=scanner.nextLine();
			System.out.println("Enter the email:");
			email=scanner.nextLine();
			System.out.println("Enter the address:");
			address=scanner.nextLine();
			
			UsersModel user=new UsersModel(userId,name,password,email,address);
			
			if(imp.insertData(user)!=0) {
				System.out.println("Data inserted into users successfully");
			}
			else {
				System.out.println("Data insertion into users failed");
			}
			break;
			
		case 2:
			for(UsersModel p:imp.fetchAll()) {
				System.out.println(p);
			}
			break;
			
		case 3:
			System.out.println("Enter the id whose data you want:");
			userId=scanner.nextInt();
			imp.fetchOne(userId);
			break;
			
		case 4:
			System.out.println("Enter the id of user whose data you want to update:");
			userId=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the new password:");
			password=scanner.nextLine();
			if(imp.update(userId,password)!=0) {
				System.out.println("Data updated successfully");
			}
			else {
				System.out.println("Data updation failed");
			}
			break;
			
		case 5:
			System.out.println("Enter the id whose data you want to delete");
			userId=scanner.nextInt();
			if(imp.delete(userId)!=0) {
				System.out.println("Data updated successfully");
			}
			else {
				System.out.println("Data updation failed");
			}
			break;
		}
		scanner.close();
		System.out.println("Operation finished");

	}

}
