package com.FoodAppDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.FoodAppDao.OrdersDAO;
import com.FoodAppModel.OrdersModel;
import com.dao.dbutil.GetConnection;

public class OrdersDAOImpl implements OrdersDAO{
	
	private static final String INSERT="INSERT INTO ORDERS(orderId,userId,restaurantId,totalAmount,status,paymentMode) VALUES(?,?,?,?,?,?)";
	private static final String FETCHALL="select * from orders";
	private static final String FETCHONE="select * from orders where orderId=?";
	private static final String UPDATE="update orders set status=? where orderId=?";
	private static final String DELETE="delete from orders where orderId=?";
	
	private static Connection con;
	
	static {
		con=GetConnection.connect();
	}

	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet result;
	private ArrayList<OrdersModel> orders=new ArrayList<OrdersModel>();

	@Override
	public int insertData(OrdersModel o) {
		try {
			pstmt=con.prepareStatement(INSERT);
			
			pstmt.setInt(1, o.getOrderId());
			pstmt.setInt(2,o.getUserId());
			pstmt.setInt(3, o.getRestaurantId());
			pstmt.setInt(4, o.getTotalAmount());
			pstmt.setString(5, o.getStatus());
			pstmt.setString(6, o.getPaymentMode());
			return pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<OrdersModel> fetchAll() {
		try {
			stmt=con.createStatement();
			result=stmt.executeQuery(FETCHALL);
			while(result.next()) {
				orders.add(new OrdersModel(result.getInt("orderId"),result.getInt("userId"),result.getInt("restaurantId"),result.getString("orderDate"),result.getInt("totalAmount"),result.getString("status"),result.getString("paymentMode")));
			}
			return orders;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void fetchOne(int orderId) {
		try {
			pstmt=con.prepareStatement(FETCHONE);
			pstmt.setInt(1, orderId);
			result=pstmt.executeQuery();
			while(result.next()) {
				System.out.println(result.getInt("orderId")+"   " +result.getInt("userId")+"   "+result.getInt("restaurantId")+"    "+result.getString("orderDate")+"   "+result.getInt("totalAmount")+"   "+result.getString("status")+"   "+result.getString("paymentMode"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public int update(int orderId, String status) {
		try {
			pstmt=con.prepareStatement(UPDATE);
			pstmt.setInt(2, orderId);
			pstmt.setString(1, status);
			return pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int orderId) {
		try {
			pstmt=con.prepareStatement(DELETE);
			pstmt.setInt(1, orderId);
			return pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
