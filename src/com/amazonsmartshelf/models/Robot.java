package com.amazonsmartshelf.models;

public class Robot {
	private int id;
	private float speed;
	
	public Robot(int id) {
		this.id = id;
		this.speed = 0.0f;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getId() {
		return id;
	}
}
