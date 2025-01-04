package com.FoodProject.Controller;

import java.io.IOException;

import com.FoodAppDaoImpl.MenuDAOImpl;
import com.FoodAppModel.CartItem;
import com.FoodAppModel.MenuModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Cart cart=(Cart)session.getAttribute("Cart");
		
		if(cart==null) {
			cart=new Cart();
			session.setAttribute("Cart", cart);
		}
		
		String action=req.getParameter("action");
		int itemId=Integer.parseInt(req.getParameter("menuId"));
		
		
		if(action.equals("add")) {
			MenuDAOImpl object=new MenuDAOImpl();
			MenuModel menu=object.fetchOne(itemId);
			if(menu!=null) {
				int quantity=1;
				CartItem cartItem=new CartItem(menu.getMenuId(),menu.getRestaurantId(),menu.getName(),menu.getPrice(),quantity);
				cart.addItem(cartItem);
			}
			resp.sendRedirect("Cart.jsp");
		}
		else if(action.equals("remove")) {
			int menuId=Integer.parseInt(req.getParameter("menuId"));
			cart.deleteItem(menuId);
			resp.sendRedirect("Cart.jsp");
		}
		else if(action.equals("update")) {
			int itemId1=Integer.parseInt(req.getParameter("menuId"));
			int quantity=Integer.parseInt(req.getParameter("quantity"));
			cart.updateItem(itemId1, quantity);
			resp.sendRedirect("Cart.jsp");
		}
		
	}
	

}
