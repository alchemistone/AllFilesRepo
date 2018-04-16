package ua.aval.task.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;

import ua.aval.task.entities.Group;

public class GroupsDao extends Dao {

	public static List<Group> getGroups() {
		List<Group> groupsList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM group_function ORDER BY id ASC";
			rs = stmt.executeQuery(sql);
			if (rs != null) {
				groupsList = new ArrayList<Group>();
				while (rs.next()) {
					groupsList.add(new Group(rs.getInt("id"), rs.getString("name"),
							rs.getString("descr")));
				}
			} else {
				System.out.println("Groups list is empty");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Unable to get groups information!");
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
		return groupsList;
	}

}