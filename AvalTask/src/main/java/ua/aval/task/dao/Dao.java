package ua.aval.task.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

	protected static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC driver not found!");
			e.printStackTrace();
			return null;
		}

		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:CMD/Qwerty1234@localhost:1521:taskavaldb");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console.");
			e.printStackTrace();
			conn = null;
		}

		if (conn != null) {
			System.out.println("Connection Success!");
		} else {
			System.out.println("Connection Failed!");
			return null;
		}

		return conn;
	}

}