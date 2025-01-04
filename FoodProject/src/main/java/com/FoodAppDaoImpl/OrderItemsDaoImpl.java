package com.FoodAppDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.FoodAppDao.OrderItemsDAO;
import com.FoodAppModel.OrderItemsModel;
import com.dao.dbutil.GetConnection;

public class OrderItemsDaoImpl implements OrderItemsDAO {
	
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet result;
	private ArrayList<OrderItemsModel> orderItems=new ArrayList<OrderItemsModel>(); 
	private static Connection con;
	private static final String INSERT="INSERT INTO ORDERITEMS(orderId,menuId,quantity,itemTotal) VALUES(?,?,?,?)";
	private static final String FETCHALL="select * from orderItems";
	private static final String FETCHONE="select * from orderItems where orderItemId=?";
	private static final String UPDATE="update orderItems set quantity=? where orderItemId=?";
	private static final String DELETE="delete from orderItems where orderItemId=?";

	static {
		con=GetConnection.connect();
	}

	@Override
	public int insert(OrderItemsModel oi) {
		try {
			pstmt=con.prepareStatement(INSERT);
			pstmt.setInt(1, oi.getOrderId());
			pstmt.setInt(2, oi.getMenuId());
			pstmt.setInt(3, oi.getQuantity());
			pstmt.setInt(4, oi.getItemTotal());
			return pstmt.executeUpdate();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<OrderItemsModel> fetchAll() {
		try {
			stmt=con.createStatement();
			result=stmt.executeQuery(FETCHALL);
			while(result.next()) {
				orderItems.add(new OrderItemsModel(result.getInt("orderItemId"),result.getInt("orderId"),
				result.getInt("menuId"),result.getInt("quantity"),result.getInt("itemTotal")));
			}
			return orderItems;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void fetchOne(int orderItemId) {
		try {
			pstmt=con.prepareStatement(FETCHONE);
			pstmt.setInt(1, orderItemId);
			result=pstmt.executeQuery();
			while(result.next()) {
				System.out.println(result.getInt("orderItemId")+"   "+result.getInt("orderId")+"   "+result.getInt("menuId")
				+"   "+result.getInt("quantity")+"    "+result.getInt("itemTotal"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int update(int orderItemId, int quantity) {
		try {
			pstmt=con.prepareStatement(UPDATE);
			pstmt.setInt(2, orderItemId);
			pstmt.setFloat(1, quantity);
			return pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int orderItemId) {
		try {
			pstmt=con.prepareStatement(DELETE);
			pstmt.setInt(1, orderItemId);
			return pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
