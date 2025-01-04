package com.FoodAppLaunch;

import java.util.Scanner;

import com.FoodAppDaoImpl.OrderItemsDaoImpl;
import com.FoodAppModel.OrderItemsModel;

public class LaunchOrderItems {
	
	static OrderItemsDaoImpl oidi=new OrderItemsDaoImpl();
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int orderItemId;
		int orderId;
		int menuId;
		int quantity;
		int itemTotal;
		
		System.out.println("Welcome to the OrderItems table. Select the below options you want to perform:");
		System.out.println("1.  Insert the data into the OrderItems table\n"
				+"2.  Fetch all the data from OrderItems\n"
				+"3.  Fetch particular data from OrderItems\n"
				+"4.  Update particular data in OrderItems\n"
				+"5.  Delete particular row from OrderItems");
		
		int n=scanner.nextInt();
		
switch(n) {
		
		case 1:
			
			System.out.println("Enter the orderId:");
			orderId=scanner.nextInt();
			System.out.println("Enter the menuId:");
			menuId=scanner.nextInt();
			System.out.println("Enter the Quantity:");
			quantity=scanner.nextInt();
			System.out.println("Enter the itemTotal:");
			itemTotal=scanner.nextInt();
			
			OrderItemsModel orderItem=new OrderItemsModel(orderId,menuId,quantity,itemTotal);
			
			if(oidi.insert(orderItem)!=0) {
				System.out.println("Data inserted into OrderItems successfully");
			}
			else {
				System.out.println("Data insertion into OrderItems failed");
			}
			break;
			
		case 2:
			for(OrderItemsModel p:oidi.fetchAll()) {
				System.out.println(p);
			}
			break;
			
		case 3:
			System.out.println("Enter the id whose data you want:");
			orderItemId=scanner.nextInt();
			oidi.fetchOne(orderItemId);
			break;
			
		case 4:
			System.out.println("Enter the id of OrderItem whose data you want to update:");
			orderItemId=scanner.nextInt();
			System.out.println("Enter the new Quantity:");
			quantity=scanner.nextInt();
			if(oidi.update(orderItemId,quantity)!=0) {
				System.out.println("Data updated successfully");
			}
			else {
				System.out.println("Data updation failed");
			}
			break;
			
		case 5:
			System.out.println("Enter the id whose data you want to delete");
			orderItemId=scanner.nextInt();
			if(oidi.delete(orderItemId)!=0) {
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
