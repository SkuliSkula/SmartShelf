package com.amazonsmartshelf.models;

import java.sql.Timestamp;

public class OrderItem {
	private int id;
	private int orderId;
	private int productId;
	private int quantity;
	private Robot robot;
	private Timestamp robotSent;
	private Timestamp itemDelivered;
	
	public Timestamp getRobotSent() {
		return robotSent;
	}

	public void setRobotSent(Timestamp robotSent) {
		this.robotSent = robotSent;
	}

	public Timestamp getItemDelivered() {
		return itemDelivered;
	}

	public void setItemDelivered(Timestamp itemDelivered) {
		this.itemDelivered = itemDelivered;
	}

	public OrderItem(int id) {
		this.id = id;
		this.robot = null;
		this.orderId = -1;
		this.productId = -1;
		this.quantity = 0;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}
	
}
