package com.FoodProject.Controller;

import java.util.*;

import com.FoodAppModel.CartItem;

public class Cart {
	
	private Map<Integer,CartItem> items;
	
	public Cart() {
		items=new HashMap<>();	
	}
	
	public void addItem(CartItem ci) {
		if(items.containsKey(ci.getItemId())) 
		{
			CartItem exist=items.get(ci.getItemId());
			exist.setQuantity(exist.getQuantity()+ci.getQuantity());
		}
		else 
		{
			items.put(ci.getItemId(),ci);
		}
	}
	
	public void updateItem(int itemId,int quantity) {
		if(items.containsKey(itemId)) 
		{
			CartItem id=items.get(itemId);
			if(quantity>0) {
				id.setQuantity(quantity);
			}
			else {
				items.remove(itemId);
			}
		}
	}
	
	public void deleteItem(int itemId) {
		items.remove(itemId);
	}
	
	public Map<Integer,CartItem> getAllItems(){
		return items;
	}
	
	public void clear() {
		items.clear();
	}
	
}
