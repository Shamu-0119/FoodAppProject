package com.FoodAppModel;

public class CartItem {

	private int itemId;
	private int restaurantId;
	private String itemName;
	private float price;
	private int quantity;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public CartItem() {
		
	}
	
	public CartItem(int itemId, int restaurantId, String itemName, float price, int quantity) {
		super();
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return itemId + "     " + restaurantId + "     " + itemName + "     "+ price + "     " + quantity;
	}
	
}
