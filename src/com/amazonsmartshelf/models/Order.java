package com.amazonsmartshelf.models;

import java.sql.Timestamp;

public class Order {
	private int id;
	private Timestamp timestamp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
