package com.FoodAppLaunch;

import java.util.Scanner;

import com.FoodAppDaoImpl.OrderHistoryDaoImpl;
import com.FoodAppModel.OrderHistoryModel;

public class LaunchOrderHistory {

	
	static OrderHistoryDaoImpl ohdi=new OrderHistoryDaoImpl();
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int orderHistoryId;
		int orderId;
		int userId;
		int totalAmount;
		String status;
		
		System.out.println("Welcome to the OrderHistory table. Select the below options you want to perform:");
		System.out.println("1.  Insert the data into the OrderHistory table\n"
				+"2.  Fetch all the data from OrderHistory\n"
				+"3.  Fetch particular data from OrderHistory\n"
				+"4.  Update particular data in OrderHistory\n"
				+"5.  Delete particular row from OrderHistory");
		
		int n=scanner.nextInt();
		
switch(n) {
		
		case 1:
			System.out.println("Enter the orderHistory id");
			orderHistoryId=scanner.nextInt();
			System.out.println("Enter the orderId:");
			orderId=scanner.nextInt();
			System.out.println("Enter the userId:");
			userId=scanner.nextInt();
			System.out.println("Enter the totalAmount:");
			totalAmount=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the status of ordered item:");
			status=scanner.nextLine();
			
			OrderHistoryModel orderItem=new OrderHistoryModel(orderHistoryId,orderId,userId,totalAmount,status);
			
			if(ohdi.insert(orderItem)!=0) {
				System.out.println("Data inserted into OrderHistory successfully");
			}
			else {
				System.out.println("Data insertion into OrderHistory failed");
			}
			break;
			
		case 2:
			for(OrderHistoryModel p:ohdi.fetchAll()) {
				System.out.println(p);
			}
			break;
			
		case 3:
			System.out.println("Enter the id whose data you want:");
			orderHistoryId=scanner.nextInt();
			ohdi.fetchOne(orderHistoryId);
			break;
			
		case 4:
			System.out.println("Enter the id of OrderHistory whose data you want to update:");
			orderHistoryId=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the new status:");
			status=scanner.nextLine();
			if(ohdi.update(orderHistoryId,status)!=0) {
				System.out.println("Data updated successfully");
			}
			else {
				System.out.println("Data updation failed");
			}
			break;
			
		case 5:
			System.out.println("Enter the id whose data you want to delete");
			orderHistoryId=scanner.nextInt();
			if(ohdi.delete(orderHistoryId)!=0) {
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
