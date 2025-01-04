package com.FoodProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.FoodAppDaoImpl.UsersDaoImpl;
import com.FoodAppModel.UsersModel;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Registration extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private static UsersDaoImpl imp=new UsersDaoImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String numberInput=req.getParameter("numberInput");
		
		PrintWriter pw = resp.getWriter();
		int userId=0;
		if (numberInput != null && !numberInput.isEmpty()) {
		    userId = Integer.parseInt(numberInput);
		    // Process the number
		} 
		else {
		    pw.println("Number input is missing or empty");
		}
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		
		UsersModel user=new UsersModel(userId,name,password,email,address);
		
		if(imp.insertData(user)!=0) {
			pw.println("New Users Created Successfully");
		}
		else {
			pw.println("New User Insertion Failed");
		}
	}
	
	public static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char ch : input.toCharArray()) {
            encrypted.append((char) (ch + 2));
        }
        return encrypted.toString();
    }

    public static String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char ch : input.toCharArray()) {
            decrypted.append((char) (ch - 2));
        }
        return decrypted.toString();
    }


}
