package com.vince.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DbUtils {

	private static String URL;
	private static String DRIVER;
	private static String USERNAME;
	private static String PASSWORD;

	static {
		ResourceBundle res = ResourceBundle.getBundle("db-config");
		URL = res.getString("URL");
		DRIVER = res.getString("DRIVER");
		USERNAME = res.getString("USERNAME");
		PASSWORD = res.getString("PASSWORD");
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(ResultSet rs, Statement stat, Connection conn) {
		try {
			if (null != rs) {
				rs.close();
			}
			if(null!=stat){
				stat.close();
			}
			if(null!=conn){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
