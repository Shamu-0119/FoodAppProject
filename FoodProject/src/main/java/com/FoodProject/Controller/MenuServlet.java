package com.FoodProject.Controller;

import java.io.IOException;
import java.util.ArrayList;

import com.FoodAppDaoImpl.MenuDAOImpl;
import com.FoodAppModel.MenuModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MenuServlet
 */
//@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurantId=Integer.parseInt(req.getParameter("restaurantId"));
		
		HttpSession session = req.getSession();
		session.setAttribute("ramu", restaurantId);
		MenuDAOImpl mdi=new MenuDAOImpl();
		ArrayList<MenuModel> mList=mdi.fetchMenuByRestId(restaurantId);
		session.setAttribute("MenuList", mList);
		req.getRequestDispatcher("Menu.jsp").forward(req, resp);
	}
}
