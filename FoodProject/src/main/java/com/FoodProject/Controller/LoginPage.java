package com.FoodProject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.FoodAppDaoImpl.UsersDaoImpl;
import com.FoodAppModel.UsersModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	
	
	
	private static UsersDaoImpl imp=new UsersDaoImpl();
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession();
		 PrintWriter pw=resp.getWriter();
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		 
		
		UsersModel p=imp.fetch(email);
		
		if(p!=null) {
			if(p.getPassword().equals(password)) {
				session.setAttribute("userId", p.getId());
				session.setAttribute("name", p.getName());
				session.setAttribute("password", p.getPassword());
				session.setAttribute("email", p.getEmail());
				session.setAttribute("address", p.getAddress());
				Cookie ck=new Cookie("email",email);
				resp.addCookie(ck);
				req.getRequestDispatcher("GetAllRestaurants").forward(req, resp);
			}
			else {
				resp.sendRedirect("Login.jsp");
			}
		}
		else {
			pw.println("Incorrect Details");
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
