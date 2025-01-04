package com.FoodAppLaunch;

import java.util.Scanner;

import com.FoodAppDaoImpl.MenuDAOImpl;
import com.FoodAppModel.MenuModel;

public class LaunchMenu {

	private static MenuDAOImpl mdi=new MenuDAOImpl();
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		 int menuId;
		 int restaurantId;
		 String name;
		 String description;
		 int price;
		 boolean isAvailable;
		 String imagePath;
		
		
		System.out.println("Welcome to the Menu table. Select the below options you want to perform:");
		System.out.println("1.  Insert the data into the menu\n"
				+"2.  Fetch all the data from menu\n"
				+"3.  Fetch particular data from menu\n"
				+"4.  Update particular data in menu\n"
				+"5.  Delete particular row from menu");
		
		int n=scanner.nextInt();
		scanner.nextLine();
		
		switch(n) {
		
		case 1:
			System.out.println("Enter the menuId:");
			menuId=scanner.nextInt();
			System.out.println("Enter the restaurantId:");
			restaurantId=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the name");
			name=scanner.nextLine();
			System.out.println("Enter the description:");
			description=scanner.nextLine();
			System.out.println("Enter the price");
			price=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the Availability");
			isAvailable=scanner.nextBoolean();
			scanner.nextLine();
			System.out.println("Enter the imagePath:");
			imagePath=scanner.nextLine();
			
			MenuModel menu=new MenuModel(menuId,restaurantId,name,description,price,isAvailable,imagePath);
			
			if(mdi.insertData(menu)!=0) {
				System.out.println("Data inserted into menu successfully");
			}
			else {
				System.out.println("Data insertion into menu failed");
			}
			break;
			
		case 2:
			for(MenuModel p:mdi.fetchAll()) {
				System.out.println(p);
			}
			break;
			
		case 3:
			System.out.println("Enter the menuId whose data you want:");
			menuId=scanner.nextInt();
			mdi.fetchOne(menuId);
			break;
			
		case 4:
			System.out.println("Enter the id of menu whose data you want to update:");
			menuId=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the availablity:");
			isAvailable=scanner.nextBoolean();
			if(mdi.update(menuId,isAvailable)!=0) {
				System.out.println("Data updated successfully");
			}
			else {
				System.out.println("Data updation failed");
			}
			break;
			
		case 5:
			System.out.println("Enter the id whose data you want to delete");
			menuId=scanner.nextInt();
			if(mdi.delete(menuId)!=0) {
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
