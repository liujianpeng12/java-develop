package com.vince.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DbUtils {
	private static String URL;// ="jdbc:mysql://localhost:3306/mydb";
	private static String USERNAME;// ="root";
	private static String PASSWORD;// ="root";
	private static String DRIVER;

	private DbUtils() {
	}

	static {
		ResourceBundle res = ResourceBundle.getBundle("db-config");
		URL = res.getString("URL");
		USERNAME = res.getString("USERNAME");
		PASSWORD = res.getString("PASSWORD");
		DRIVER = res.getString("DRIVER");
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
			if (null != rs)
				rs.close();
			if (null != stat)
				stat.close();
			if (null != conn)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
