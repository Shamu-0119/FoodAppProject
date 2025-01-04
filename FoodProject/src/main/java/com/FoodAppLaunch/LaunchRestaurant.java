package com.FoodAppLaunch;

import java.util.Scanner;

import com.FoodAppDaoImpl.RestaurantDAOImpl;
import com.FoodAppModel.RestaurantModel;

public class LaunchRestaurant {
	
	static RestaurantDAOImpl rdi=new RestaurantDAOImpl();

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int restaurantId;
		String name;
		String cuisineType;
		int deliveryTime;
		String address;
		float ratings;
		boolean isActive;
		String imagePath;
		
		
		System.out.println("Welcome to the Restaurant table. Select the below options you want to perform:");
		System.out.println("1.  Insert the data into the restaurant table\n"
				+"2.  Fetch all the data from restaurant\n"
				+"3.  Fetch particular data from restaurant\n"
				+"4.  Update particular data in restaurant\n"
				+"5.  Delete particular row from restaurant");
		
		int n=scanner.nextInt();
		
switch(n) {
		
		case 1:
			System.out.println("Enter the restaurant id");
			restaurantId=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the name:");
			name=scanner.nextLine();
			System.out.println("Enter the cuisine Type:");
			cuisineType=scanner.nextLine();
			System.out.println("Enter the Delivery Time:");
			deliveryTime=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the address:");
			address=scanner.nextLine();
			System.out.println("Enter the ratings:");
			ratings=scanner.nextFloat();
			System.out.println("Enter the isActive:");
			isActive=scanner.nextBoolean();
			scanner.nextLine();
			System.out.println("Enter the imagePath:");
			imagePath=scanner.nextLine();
			
			RestaurantModel rest=new RestaurantModel(restaurantId,name,cuisineType,deliveryTime,address,ratings,isActive,imagePath);
			
			if(rdi.insert(rest)!=0) {
				System.out.println("Data inserted into restaurant successfully");
			}
			else {
				System.out.println("Data insertion into restaurant failed");
			}
			break;
			
		case 2:
			for(RestaurantModel p:rdi.fetchAll()) {
				System.out.println(p);
			}
			break;
			
		case 3:
			System.out.println("Enter the id whose data you want:");
			restaurantId=scanner.nextInt();
			rdi.fetchOne(restaurantId);
			break;
			
		case 4:
			System.out.println("Enter the id of restaurant whose data you want to update:");
			restaurantId=scanner.nextInt();
			System.out.println("Enter the new ratings:");
			ratings=scanner.nextFloat();
			if(rdi.update(restaurantId,ratings)!=0) {
				System.out.println("Data updated successfully");
			}
			else {
				System.out.println("Data updation failed");
			}
			break;
			
		case 5:
			System.out.println("Enter the id whose data you want to delete");
			restaurantId=scanner.nextInt();
			if(rdi.delete(restaurantId)!=0) {
				System.out.println("Data deleted successfully");
			}
			else {
				System.out.println("Data deleted failed");
			}
			break;
		}

		scanner.close();
		System.out.println("Operation completed");

	}

}
