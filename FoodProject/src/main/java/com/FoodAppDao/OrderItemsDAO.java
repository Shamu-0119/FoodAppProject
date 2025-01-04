package com.FoodAppDao;

import java.util.ArrayList;

import com.FoodAppModel.OrderItemsModel;


public interface OrderItemsDAO {
	
	int insert(OrderItemsModel oi);
	
	ArrayList<OrderItemsModel> fetchAll();
	
	void fetchOne(int orderItemId);
	
	int update(int orderItemId,int quantity);
	
	int delete(int orderItemId);
}
