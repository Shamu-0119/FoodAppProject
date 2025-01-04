package com.FoodAppDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.FoodAppDao.UsersDAO;
import com.FoodAppModel.UsersModel;
import com.dao.dbutil.GetConnection;

public class UsersDaoImpl implements UsersDAO {
	
	
	
	private static Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	ArrayList<UsersModel> users=new ArrayList<UsersModel>();
	private ResultSet result;
	private static final String INSERT="INSERT INTO USERS(userId,name,password,email,address) VALUES(?,?,?,?,?)";
	private static final String FETCHALL="select * from users";
	private static final String FETCHONE="select * from users where id=?";
	private static final String UPDATE="update users set password=? where id=?";
	private static final String DELETE="delete from users where id=?";
	private static final String FETCHUSER="select * from users where email=?";
	
	static {
		con=GetConnection.connect();
	}

	@Override
	public int insertData(UsersModel u) {
		try {
			pstmt=con.prepareStatement(INSERT);
			
			pstmt.setInt(1, u.getId());
			pstmt.setString(2,u.getName());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getAddress());
			return pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public ArrayList<UsersModel> fetchAll() {
		try {
			stmt=con.createStatement();
			result=stmt.executeQuery(FETCHALL);
			while(result.next()) {
				users.add(new UsersModel(result.getInt("userId"),result.getString("name"),result.getString("password"),result.getString("email"),result.getString("address"),result.getString("createdDate"),result.getString("lastLogindate")));
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public void fetchOne(int id) {
		try {
			pstmt=con.prepareStatement(FETCHONE);
			pstmt.setInt(1, id);
			result=pstmt.executeQuery();
			while(result.next()) {
				System.out.println(result.getInt("userId")+"   "+result.getString("name")+"   "+result.getString("password")+"    "+result.getString("email")+"    "+result.getString("address")+"   "+result.getString("createdDate")+"   "+result.getString("lastLoginDate"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	

	@Override
	public int update(int userId,String password) {
		try {
			pstmt=con.prepareStatement(UPDATE);
			pstmt.setInt(2, userId);
			pstmt.setString(1, password);
			return pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(int userId) {
		try {
			pstmt=con.prepareStatement(DELETE);
			pstmt.setInt(1, userId);
			return pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public UsersModel fetch(String email) {
		try {
			pstmt=con.prepareStatement(FETCHUSER);
			pstmt.setString(1, email);
			result=pstmt.executeQuery();
			
			while(result.next()) {
				return (new UsersModel(result.getInt("userId"),result.getString("name"),result.getString("password"),result.getString("email"),result.getString("address"),result.getString("createdDate"),result.getString("lastLogindate")));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
