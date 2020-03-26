package com.vince;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplete {
	
	public static int update(String sql,Object...args) {
		Connection conn=null;
		PreparedStatement stat=null;
		try {
			conn=DbUtils.getConnection();
			stat=conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				stat.setObject(i+1, args[i]);
			}
			return stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DbUtils.close(null, stat, conn);
		}
		return -1;
	}
	
	public static Object query(String sql,ResultSetHandler handler,Object...args){
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		try {
			conn=DbUtils.getConnection();
			stat=conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				stat.setObject(i+1, args[i]);
			}
			rs= stat.executeQuery();
			return handler.doHandler(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DbUtils.close(null, stat, conn);
		}
		return null;
	}
}
