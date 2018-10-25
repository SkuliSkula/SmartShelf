package com.amazonsmartshelf.views;

import com.amazonsmartshelf.models.Order;

public class OrderView {

	public void printOrder(Order order) {
		System.out.println("*** Order ***");
		System.out.println("OrderId: " + order.getId());
		System.out.println("Products: ");
		System.out.println("*** End ***");
		System.out.println();
	}
}
