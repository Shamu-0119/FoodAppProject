package com.FoodAppLaunch;

import java.util.Scanner;

import com.FoodAppDaoImpl.OrdersDAOImpl;
import com.FoodAppModel.OrdersModel;

public class LaunchOrders {
	
	private static OrdersDAOImpl odi=new OrdersDAOImpl();

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		 int orderId;
		 int userId;
		 int restaurantId;
		 int totalAmount;
		 String status;
		 String paymentMode;
		
		
		System.out.println("Welcome to the Orders table. Select the below options you want to perform:");
		System.out.println("1.  Insert the data into the orders\n"
				+"2.  Fetch all the data from orders\n"
				+"3.  Fetch particular data from orders\n"
				+"4.  Update particular data in orders\n"
				+"5.  Delete particular row from orders");
		
		int n=scanner.nextInt();
		scanner.nextLine();
		
		switch(n) {
		
		case 1:
			System.out.println("Enter the orderId:");
			orderId=scanner.nextInt();
			System.out.println("Enter the userId:");
			userId=scanner.nextInt();
			System.out.println("Enter the restaurantId:");
			restaurantId=scanner.nextInt();
			System.out.println("Enter the totalAmount:");
			totalAmount=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the status:");
			status=scanner.nextLine();
			System.out.println("Enter the paymentMode:");
			paymentMode=scanner.nextLine();
			
			OrdersModel order=new OrdersModel(orderId,userId,restaurantId,totalAmount,status,paymentMode);
			
			if(odi.insertData(order)!=0) {
				System.out.println("Data inserted into orders successfully");
			}
			else {
				System.out.println("Data insertion into orders failed");
			}
			break;
			
		case 2:
			for(OrdersModel p:odi.fetchAll()) {
				System.out.println(p);
			}
			break;
			
		case 3:
			System.out.println("Enter the orderId whose data you want:");
			orderId=scanner.nextInt();
			odi.fetchOne(orderId);
			break;
			
		case 4:
			System.out.println("Enter the id of orders whose data you want to update:");
			orderId=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the new status:");
			status=scanner.nextLine();
			if(odi.update(orderId,status)!=0) {
				System.out.println("Data updated successfully");
			}
			else {
				System.out.println("Data updation failed");
			}
			break;
			
		case 5:
			System.out.println("Enter the id whose data you want to delete");
			orderId=scanner.nextInt();
			if(odi.delete(orderId)!=0) {
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
