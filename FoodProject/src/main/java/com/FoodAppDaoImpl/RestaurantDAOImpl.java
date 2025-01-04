package com.FoodAppDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.FoodAppDao.RestaurantDAO;
import com.FoodAppModel.RestaurantModel;
import com.dao.dbutil.GetConnection;

public class RestaurantDAOImpl implements RestaurantDAO {
	
	
	private static Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet result;
	private ArrayList<RestaurantModel> restaurants=new ArrayList<RestaurantModel>(); 
	private static final String INSERT="INSERT INTO RESTAURANT(restaurantId,name,cuisineType,deliveryTime,address,ratings,isActive,imagePath) VALUES(?,?,?,?,?,?,?,?)";
	private static final String FETCHALL="select * from restaurant";
	private static final String FETCHONE="select * from restaurant where restaurantId=?";
	private static final String UPDATE="update restaurant set ratings=? where restaurantId=?";
	private static final String DELETE="delete from restaurant where restaurantId=?";

	static {
		con=GetConnection.connect();
	}

	

	@Override
	public int insert(RestaurantModel r) {
		try {
			pstmt=con.prepareStatement(INSERT);
			pstmt.setInt(1, r.getRestaurantId());
			pstmt.setString(2, r.getName());
			pstmt.setString(3, r.getCuisineType());
			pstmt.setInt(4, r.getDeliveryTime());
			pstmt.setString(5, r.getAddress());
			pstmt.setFloat(6, r.getRatings());
			pstmt.setBoolean(7, r.getIsActive());
			pstmt.setString(8, r.getImagePath());
			return pstmt.executeUpdate();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}



	@Override
	public ArrayList<RestaurantModel> fetchAll() {
		try {
			stmt=con.createStatement();
			result=stmt.executeQuery(FETCHALL);
			while(result.next()) {
				restaurants.add(new RestaurantModel(result.getInt("restaurantId"),result.getString("name"),
				result.getString("cuisineType"),result.getInt("deliveryTime"),result.getString("address"),
				result.getFloat("ratings"),result.getBoolean("isActive"),result.getString("imagePath")));
			}
			return restaurants;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public void fetchOne(int restaurantId) {
		try {
			pstmt=con.prepareStatement(FETCHONE);
			pstmt.setInt(1, restaurantId);
			result=pstmt.executeQuery();
			while(result.next()) {
				System.out.println(result.getInt("restaurantId")+"   "+result.getString("name")+"   "+result.getString("cuisineType")
				+"   "+result.getInt("deliveryTime")+"    "+result.getString("address")+"   "+result.getFloat("ratings")+"   "+result.getBoolean("isActive")+"   "+result.getString("imagePath"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	@Override
	public int update(int restaurantId, float ratings) {
		try {
			pstmt=con.prepareStatement(UPDATE);
			pstmt.setInt(2, restaurantId);
			pstmt.setFloat(1, ratings);
			return pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}



	@Override
	public int delete(int restaurantId) {
		try {
			pstmt=con.prepareStatement(DELETE);
			pstmt.setInt(1, restaurantId);
			return pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	

}
