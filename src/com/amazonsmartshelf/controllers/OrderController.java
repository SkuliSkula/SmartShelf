package com.amazonsmartshelf.controllers;

import com.amazonsmartshelf.models.Order;

import com.amazonsmartshelf.views.OrderView;

public class OrderController {
	private Order order;
	private OrderView view;
	
	public OrderController(Order order, OrderView view) {
		this.order = order;
		this.view = view;
	}
	/* Model methods */
	
	public void setOrderID(int id) {
		this.order.setId(id);
	}
	
	public int getOrderId() {
		return this.order.getId();
	}
	
	/* View methods */ 
	
	public void updateView() {
		view.printOrder(order);
	}
	
}
