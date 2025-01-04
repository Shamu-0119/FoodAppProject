package com.FoodAppDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.FoodAppDao.MenuDAO;
import com.FoodAppModel.MenuModel;
import com.dao.dbutil.GetConnection;

public class MenuDAOImpl implements MenuDAO{

	private static final String INSERT="INSERT INTO MENU(menuId,restaurantId,name,description,price,isAvailable,imagePath) VALUES(?,?,?,?,?,?,?)";
	private static final String FETCHALL="select * from menu";
	private static final String FETCHONE="select * from menu where menuId=?";
	private static final String UPDATE="update menu set isAvailable=? where menuId=?";
	private static final String DELETE="delete from menu where menuId=?";
	private static final String FETCHBYRESTAURANTID="select * from menu where restaurantId=?";
	
	private static Connection con;
	
	static {
		con=GetConnection.connect();
	}

	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet result;
	private ArrayList<MenuModel> menu=new ArrayList<MenuModel>();

	@Override
	public int insertData(MenuModel o) {
		try {
			pstmt=con.prepareStatement(INSERT);
			
			pstmt.setInt(1, o.getMenuId());
			pstmt.setInt(2, o.getRestaurantId());
			pstmt.setString(3, o.getName());
			pstmt.setString(4, o.getDescription());
			pstmt.setInt(5, o.getPrice());
			pstmt.setBoolean(6, o.isAvailable());
			pstmt.setString(7, o.getImagePath());
			return pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<MenuModel> fetchAll() {
		try {
			stmt=con.createStatement();
			result=stmt.executeQuery(FETCHALL);
			while(result.next()) {
				menu.add(new MenuModel(result.getInt("menuId"),result.getInt("restaurantId"),result.getString("name"),result.getString("description"),result.getInt("price"),result.getBoolean("isAvailable"),result.getString("imagePath")));
			}
			return menu;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MenuModel fetchOne(int menuId) {
		try {
			pstmt=con.prepareStatement(FETCHONE);
			pstmt.setInt(1, menuId);
			result=pstmt.executeQuery();
			if(result.next()) {
				return (new MenuModel(result.getInt("menuId"),result.getInt("restaurantId"),result.getString("name"),result.getString("description"),result.getInt("price"),result.getBoolean("isAvailable"),result.getString("imagePath")));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public int update(int menuId, boolean isAvailable) {
		try {
			pstmt=con.prepareStatement(UPDATE);
			pstmt.setInt(2, menuId);
			pstmt.setBoolean(1, isAvailable);
			return pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int menuId) {
		try {
			pstmt=con.prepareStatement(DELETE);
			pstmt.setInt(1, menuId);
			return pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<MenuModel> fetchMenuByRestId(int restaurantId) {
		try {
			pstmt=con.prepareStatement(FETCHBYRESTAURANTID);
			pstmt.setInt(1, restaurantId);
			result=pstmt.executeQuery();
			while(result.next()) {
				menu.add(new MenuModel(result.getInt("menuId"),result.getInt("restaurantId"),result.getString("name"),result.getString("description"),result.getInt("price"),result.getBoolean("isAvailable"),result.getString("imagePath")));
			}
			return menu;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}

}
