package com.vince.util.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtils {

	private DbUtils() {
	}


	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		DataSource source=new ComboPooledDataSource ("dbinfo");
		conn=source.getConnection();
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
