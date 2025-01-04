package com.FoodAppDao;

import java.util.ArrayList;

import com.FoodAppModel.RestaurantModel;

public interface RestaurantDAO {
	
	int insert(RestaurantModel r);
	
	ArrayList<RestaurantModel> fetchAll();
	
	void fetchOne(int restaurantId);
	
	int update(int restaurantId,float ratings);
	
	int delete(int restaurantId);

}
