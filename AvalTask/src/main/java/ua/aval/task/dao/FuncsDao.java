package ua.aval.task.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;

import ua.aval.task.entities.Function;

public class FuncsDao extends Dao {

	public static List<Function> getFunctions() {
		List<Function> functionsList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT functions.id, functions.name, group_function.name, functions.descr FROM functions INNER JOIN group_function ON functions.id_group = group_function.id ORDER BY functions.id ASC";
			rs = stmt.executeQuery(sql);
			if (rs != null) {
				functionsList = new ArrayList<Function>();
				while (rs.next()) {
					functionsList.add(new Function(rs.getInt(1), rs.getString(2), rs.getString(3),
							rs.getString(4)));
				}
			} else {
				System.out.println("Functions list is empty");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Unable to get functions information!");
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return functionsList;
	}

}