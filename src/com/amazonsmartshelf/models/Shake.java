package com.amazonsmartshelf.models;

import java.sql.Timestamp;

public class Shake {
	private int id;
	private Severity severity;
	private Timestamp timestamp;
	private Shelf shelf;
	public Shelf getShelf() {
		return shelf;
	}
	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Severity getSeverity() {
		return severity;
	}
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
