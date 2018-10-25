package com.amazonsmartshelf.models;

public class Product {
	private int id;
	private boolean damaged;
	private Shelf shelf;
	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product(int id) {
		this.id = id;
		this.damaged = false;
	}

	public boolean isDamaged() {
		return damaged;
	}

	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o == this)
			return true;
		if(!(o instanceof Product))
			return false;
		
		Product product = (Product) o;
		
		return product.id == id && product.damaged == damaged;
	}
}
