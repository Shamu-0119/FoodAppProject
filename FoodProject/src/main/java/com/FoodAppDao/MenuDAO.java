package com.FoodAppDao;

import java.util.ArrayList;

import com.FoodAppModel.MenuModel;



public interface MenuDAO {
	int insertData(MenuModel m);
	ArrayList<MenuModel> fetchAll();
	MenuModel fetchOne(int menuId);
	int update(int menuId,boolean isAvailable);
	int delete(int menuId);
	ArrayList<MenuModel> fetchMenuByRestId(int restaurantId);
}
