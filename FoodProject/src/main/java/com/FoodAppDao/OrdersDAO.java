package com.FoodAppDao;

import java.util.ArrayList;

import com.FoodAppModel.OrdersModel;

public interface OrdersDAO {
	int insertData(OrdersModel o);
	ArrayList<OrdersModel> fetchAll();
	void fetchOne(int id);
	int update(int id,String password);
	int delete(int id);

}
