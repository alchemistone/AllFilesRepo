package ua.aval.task.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import ua.aval.task.entities.Parameter;

public class ParamsDao extends Dao {

	public static List<Parameter> getParameters() {
		List<Parameter> parametersList = new ArrayList<Parameter>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql1 = "SELECT id, name FROM functions ORDER BY id ASC";
			rs1 = stmt.executeQuery(sql1);
			HashMap<Integer, String> funcsMap = new HashMap<Integer, String>();
			while (rs1.next()) {
				funcsMap.put(rs1.getInt(1), rs1.getString(2));
			}
			rs1.close();
			String sql2 = "SELECT id, name, id_fun, descr FROM fun_param ORDER BY id ASC";
			rs2 = stmt.executeQuery(sql2);
			if (rs2 != null) {
				while (rs2.next()) {
					String funcName = "";
					funcName = funcsMap.get(rs2.getInt(3)); 
					parametersList.add(new Parameter(rs2.getInt(1), rs2.getString(2), funcName, rs2.getString(4)));
				}
			} else {
				System.out.println("Parameters list is empty");
			}
			rs2.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Unable to get parameters information!");
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
		return parametersList;
	}

}