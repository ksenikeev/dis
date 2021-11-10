package ru.itis.dis.lab10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbWork {

	private static DbWork db;
	private static Connection connection;

	public static DbWork getInstance() {
		DbWork localInstance = db;
		if (localInstance == null) {
			synchronized(DbWork.class) {
				localInstance = db;
				if (localInstance == null) {
					db = localInstance = new DbWork();
					getConnection();
				}
			}
		}
		return db;
	}
	
	public static void clear(){
	}

	public static Connection getConnection() {
		if (db == null) {
			getInstance();
		}

		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://127.0.0.1:5432/cars";
				connection = DriverManager.getConnection(url,"postgres","passwd");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}

		return connection;
	}
}
