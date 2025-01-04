package com.FoodAppModel;

public class OrderHistoryModel {
	private int orderHistoryId;
	private int orderId;
	private int userid;
	private int totalAmount;
	private String status;
	private String orderDate;
	
	public int getOrderHistoryId() {
		return orderHistoryId;
	}
	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public OrderHistoryModel() {
		
	}
	
	public OrderHistoryModel(int orderHistoryId, int orderId, int userid, int totalAmount, String status) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.orderId = orderId;
		this.userid = userid;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	
	
	public OrderHistoryModel(int orderHistoryId, int orderId, int userid, int totalAmount, String status,
			String orderDate) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.orderId = orderId;
		this.userid = userid;
		this.totalAmount = totalAmount;
		this.status = status;
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() {
		return   orderHistoryId + "    " + orderId + "    " + userid
				+ "    " + totalAmount + "    " + status + "    " + orderDate;
	}
	
	
}
