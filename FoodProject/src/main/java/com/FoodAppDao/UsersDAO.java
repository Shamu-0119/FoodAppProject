package com.FoodAppDao;

import java.util.ArrayList;

import com.FoodAppModel.UsersModel;

public interface UsersDAO {
	int insertData(UsersModel u);
	ArrayList<UsersModel> fetchAll();
	void fetchOne(int userId);
	int update(int userId,String password);
	int delete(int userId);
	UsersModel fetch(String email);
}
