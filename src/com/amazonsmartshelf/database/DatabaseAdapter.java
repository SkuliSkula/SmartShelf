package com.amazonsmartshelf.database;

import java.sql.SQLException;
import java.util.Set;

import com.amazonsmartshelf.models.Order;
import com.amazonsmartshelf.models.Product;
import com.amazonsmartshelf.models.Robot;
import com.amazonsmartshelf.models.Shake;
import com.amazonsmartshelf.models.Shelf;

public class DatabaseAdapter implements IDatabaseAdapter {
	private MyDatabase db;
	private String databaseName = "amasmartdb";
	private static final String USER = "skuli";
	private static final String PASSWORD = "admin";
	
	public DatabaseAdapter() throws ClassNotFoundException {
		db = new MyDatabase(databaseName, USER, PASSWORD);
	}
	
	public boolean addOrder(Order order) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean addShelf(Shelf shelf) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean addRobot(Robot robot) throws SQLException {
		
		//db.query(sql, statementElements)
		
		return false;
	}
	public boolean addProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean addShake(Shake shake) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	public Set<Product> getAllProducts() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public Set<Order> getAllOrders() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
