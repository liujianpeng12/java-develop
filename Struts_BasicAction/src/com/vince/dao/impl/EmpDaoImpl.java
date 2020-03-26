package com.vince.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.vince.dao.EmpDao;
import com.vince.db.util.DbUtils;
import com.vince.entity.Emp;

public class EmpDaoImpl implements EmpDao {
	
	QueryRunner runner=new QueryRunner();

	@Override
	public List<Emp> list() {
		String sql="select id,name,age,income from emptable";
		Connection conn=null;
		List<Emp> list=null;
		try {
			conn=DbUtils.getConnection();
			list=runner.query(conn, sql, new BeanListHandler<Emp>(Emp.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtils.close(null, null, conn);
		}
		return list;
	}

	@Override
	public Emp get(int id) {
		String sql="select id,name,age,income from emptable where id=? ";
		Connection conn=null;
		Emp emp=null;
		try {
			conn=DbUtils.getConnection();
			emp=runner.query(conn, sql, new BeanHandler<Emp>(Emp.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtils.close(null, null, conn);
		}
		return emp;
	}

	@Override
	public boolean add(Emp emp) {
		String sql="insert into emptable(name,age,income) values(?,?,?)";
		Connection conn=null;
		try {
			conn=DbUtils.getConnection();
			int ef=runner.update(conn, sql, emp.getName(),emp.getAge(),emp.getIncome());
			return ef>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtils.close(null, null, conn);
		}
		return false;
	}

	@Override
	public boolean update(Emp emp) {
		String sql="update emptable set name=?,age=?,income=? where id=?";
		Connection conn=null;
		try {
			conn=DbUtils.getConnection();
			int ef=runner.update(conn, sql, emp.getName(),emp.getAge(),emp.getIncome(),emp.getId());
			return ef>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtils.close(null, null, conn);
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		String sql="delete from emptable where id=?";
		Connection conn=null;
		try {
			conn=DbUtils.getConnection();
			int ef=runner.update(conn, sql, id);
			return ef>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtils.close(null, null, conn);
		}
		return false;
	}

}
