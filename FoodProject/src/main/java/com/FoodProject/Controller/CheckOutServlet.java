package com.FoodProject.Controller;

import java.io.IOException;
import com.FoodAppDaoImpl.OrderItemsDaoImpl;
import com.FoodAppDaoImpl.OrdersDAOImpl;
import com.FoodAppModel.CartItem;
import com.FoodAppModel.OrderItemsModel;
import com.FoodAppModel.OrdersModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckOutServlet
 */
public class CheckOutServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Cart cart=(Cart)session.getAttribute("Cart");
		Object userId=session.getAttribute("userId");
		System.out.println(cart);
		System.out.println(userId);
		
		if(cart!=null && userId!=null && !cart.getAllItems().isEmpty()) {
			int id=(int)(userId);
			double totalAmount=0;
			for(CartItem item:cart.getAllItems().values()) {
				totalAmount+=(item.getQuantity()*item.getPrice());
			}
			int restId = (int)session.getAttribute("ramu");
			//int restId=Integer.parseInt(req.getParameter("restaurantId"));
			System.out.println(restId);
			String payment_type=req.getParameter("payment");
			//String payment_type=req.getAttribute("payment").toString();
			OrdersModel order=new OrdersModel(2,id,restId,(int)(totalAmount),"pending",payment_type);
			
			OrdersDAOImpl odi=new OrdersDAOImpl();
			odi.insertData(order);
			System.out.println("askjdhkjas");
			
			OrderItemsDaoImpl oidi=new OrderItemsDaoImpl();
			for(CartItem item:cart.getAllItems().values()) {
				OrderItemsModel orderItem = new OrderItemsModel(1,item.getItemId(),item.getQuantity(),(int)(item.getQuantity()*item.getPrice()));
				oidi.insert(orderItem);
			}
			
			resp.sendRedirect("OrderConformation.jsp");
		}
		else {
			resp.sendRedirect("home.jsp");
		}
	}

}
