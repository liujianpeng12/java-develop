package com.vince.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.vince.dao.FriendDao;
import com.vince.model.Friend;
import com.vince.model.PageRoll;

public class FriendDaoImpl implements FriendDao {

	private static QueryRunner runner = new QueryRunner();

	@Override
	public boolean insert(Friend f) {
		String sql = "insert into friend(name,age,description) values(?,?,?)";
		int eff = 0;
		Connection conn = null;
		try {
			conn = com.vince.util.db.DbUtils.getConnection();
			eff = runner.update(conn, sql, f.getName(), f.getAge(),
					f.getDescription());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return eff > 0;
	}

	@Override
	public boolean update(Friend f) {
		String sql = "update friend set name=?,age=?,description=? where id=?";
		int eff = 0;
		Connection conn = null;
		try {
			conn = com.vince.util.db.DbUtils.getConnection();
			eff = runner.update(conn, sql, f.getName(), f.getAge(),
					f.getDescription(), f.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return eff>0;
	}

	@Override
	public boolean delete(int id) {
		String sql="delete from friend where id=?";
		int eff=0;
		Connection conn=null;
		try {
			conn=com.vince.util.db.DbUtils.getConnection();
			eff=runner.update(conn,sql,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return eff>0;
	}

	@Override
	public List<Friend> findAll() {
		String sql="select id,name,age,description from friend";
		List<Friend> list=null;
		Connection conn=null;
		try {
			conn=com.vince.util.db.DbUtils.getConnection();
			 list=runner.query(conn, sql, new BeanListHandler<Friend>(Friend.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Friend findById(int id) {
		String sql="select id,name,age,description from friend where id=?";
		Friend f=null;
		Connection conn=null;
		try {
			conn=com.vince.util.db.DbUtils.getConnection();
			 f=runner.query(conn, sql, new BeanHandler<Friend>(Friend.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return f;
	}

	@Override
	public List<Friend> list(PageRoll pageRoll) {
		String sql_total="select count(1) from friend";
		String sql_page="select id,name,age,description from friend limit ?,?";
		List<Friend> list=null;
		Connection conn=null;
		
		try {
			conn=com.vince.util.db.DbUtils.getConnection();
			Object s=runner.query(conn, sql_total, new ScalarHandler(1));
			int totalCount=Integer.parseInt(s.toString());
			pageRoll.setTotalCount(totalCount);
			
			list=runner.query(conn, sql_page, new BeanListHandler<Friend>(Friend.class), 
					(pageRoll.getPageIndex()-1)*pageRoll.getPageSize(),pageRoll.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
