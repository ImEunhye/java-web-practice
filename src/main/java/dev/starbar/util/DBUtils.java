package dev.starbar.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE_NAME = "testdb";
	private static final String USER = "root";
	private static final String PASSWORD = "0000";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
