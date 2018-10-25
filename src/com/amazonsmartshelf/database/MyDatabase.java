package com.amazonsmartshelf.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyDatabase {
	private String url;
	private String user;
	private String pw;
	private Connection connection;
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/";
	public static final String USER = "root";
	public static final String PASSWORD = "";

	public MyDatabase(String driver, String url, String user, String pw)
			throws ClassNotFoundException {
		this.url = url;
		this.user = user;
		this.pw = pw;
		connection = null;
		Class.forName(driver);
	}

	public MyDatabase(String databaseName, String user, String pw)
			throws ClassNotFoundException {
		this(DRIVER, URL + databaseName, user, pw);
	}

	public MyDatabase(String databaseName) throws ClassNotFoundException {
		this(DRIVER, URL + databaseName, USER, PASSWORD);
	}

	// Open Database
	// ********************************************************************************************************
	private void openDatabase() throws SQLException {
		connection = DriverManager.getConnection(url, user, pw);
	}

	// Close Database
	// ******************************************************************************************************
	private void closeDatabase() throws SQLException {
		connection.close();
	}

	// Sql query
	// **************************************************************************************************************
	public ArrayList<Object[]> query(String sql, Object... statementElements)
			throws SQLException {
		openDatabase();

		PreparedStatement statement = null;
		ArrayList<Object[]> list = null;
		ResultSet resultSet = null;

		if (sql != null && statement == null) {
			statement = connection.prepareStatement(sql);

			if (statementElements != null) {
				for (int i = 0; i < statementElements.length; i++)
					statement.setObject(i + 1, statementElements[i]);

			}
		}
		resultSet = statement.executeQuery();
		list = new ArrayList<Object[]>();
		while (resultSet.next()) {
			Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
			for (int i = 0; i < row.length; i++) {
				row[i] = resultSet.getObject(i + 1);
			}
			list.add(row);
		}

		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		closeDatabase();
		return list;
	}

	// Update database
	// ************************************************************************************************************
	public int update(String sql, Object... statementElements)
			throws SQLException {
		openDatabase();
		PreparedStatement statement = null;
		statement = connection.prepareStatement(sql);

		for (int i = 0; i < statementElements.length; i++) {

			statement.setObject(i + 1, statementElements[i]);

		}

		int updates = statement.executeUpdate();
		System.out.println("Number of update= " + updates);

		closeDatabase();

		return updates;
	}

	// Update database all rows and columns
	// ***************************************************************************************************************
	public int[] updateAll(ArrayList<String> sqlList) throws SQLException {
		openDatabase();
		PreparedStatement statement = null;
		for (int i = 0; i < sqlList.size(); i++) {
			statement = connection.prepareStatement(sqlList.get(i));
		}

		int[] updates = new int[sqlList.size()];

		for (int j = 0; j < updates.length; j++) {
			updates[j] = statement.executeUpdate();
		}
		closeDatabase();
		return updates;
	}

	// Update database from file
	// ***************************************************************************************************************************
	public int[] updateAll(String fileName) throws SQLException,
			FileNotFoundException {
		ArrayList<String> sqlList = readFile(fileName, ";");
		return updateAll(sqlList);
	}

	// Read file
	// **********************************************************************************************************************************
	private ArrayList<String> readFile(String fileName, String deliminator)
			throws FileNotFoundException {
		Scanner input = new Scanner(new FileInputStream(fileName));
		ArrayList<String> list = new ArrayList<String>();
		String sql = "";
		while (input.hasNext()) {
			sql += input.nextLine();
			if (deliminator == null || sql.trim().endsWith(deliminator)) {
				list.add(sql);
				sql = "";
			}

			else if (sql.length() > 0) {
				sql += "\n";
			}
		}
		input.close();
		return list;
	}

	// Get column names from database

	public ArrayList<String> getColumnNames(String sql,
			Object... statementElements) throws SQLException {
		openDatabase();
		PreparedStatement statement = null;
		ArrayList<String> names = null;
		ResultSet resultSet = null;

		java.sql.ResultSetMetaData rsmd = null;
		if (sql != null && statement == null) {
			statement = connection.prepareStatement(sql);

			if (statementElements != null) {
				for (int i = 0; i < statementElements.length; i++)
					statement.setObject(i + 1, statementElements[i]);
			}
		}

		resultSet = statement.executeQuery();
		rsmd = resultSet.getMetaData();

		names = new ArrayList<String>();

		// The column count starts from 1
		int counter = rsmd.getColumnCount();
		System.out.println(counter);
		for (int i = 1; i < counter + 1; i++)
			names.add(rsmd.getColumnLabel(i));

		closeDatabase();

		return names;

	}

}
