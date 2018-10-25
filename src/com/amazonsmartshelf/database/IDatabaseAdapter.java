package com.amazonsmartshelf.database;

import java.sql.SQLException;
import java.util.Set;

import com.amazonsmartshelf.models.Order;
import com.amazonsmartshelf.models.Product;
import com.amazonsmartshelf.models.Robot;
import com.amazonsmartshelf.models.Shake;
import com.amazonsmartshelf.models.Shelf;

public interface IDatabaseAdapter {

	boolean addOrder(Order order) throws SQLException;
	boolean addShelf(Shelf shelf) throws SQLException;
	boolean addRobot(Robot robot) throws SQLException;
	boolean addProduct(Product product) throws SQLException;
	boolean addShake(Shake shake) throws SQLException;
	
	Set<Product> getAllProducts() throws SQLException;
	Set<Order> getAllOrders() throws SQLException;

}
