package com.vince.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.vince.dao.EmpDao;
import com.vince.domain.Emp;

public class EmpDaoImpl implements EmpDao {

	private static QueryRunner runner = new QueryRunner();

	@Override
	public boolean insert(Emp emp) {
		String sql = "insert into emp(name,gender,age,salary) values(?,?,?,?)";
		Connection conn = null;
		int eff = -1;
		try {
			conn = com.vince.DbUtils.getConnection();
			eff = runner.update(conn, sql, emp.getName(), emp.getGender(),
					emp.getAge(), emp.getSalary());
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
	public boolean update(Emp emp) {
		String sql = "update emp set name=?,gender=?,age=?,salary=? where id=?";
		int eff = -1;
		try {
			eff = runner.update(com.vince.DbUtils.getConnection(), sql,
					emp.getName(), emp.getGender(), emp.getAge(),
					emp.getSalary(), emp.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eff > 0;
	}

	@Override
	public boolean delete(Emp emp) {
		String sql = "delete from emp where id=?";
		int eff = -1;
		try {
			eff = runner.update(com.vince.DbUtils.getConnection(), sql,
					emp.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eff > 0;
	}

	@Override
	public List<Emp> GetAll() {
		String sql = "select id,name,gender,age,salary from emp";
		List<Emp> emps = null;
		try {
			emps = runner.query(com.vince.DbUtils.getConnection(), sql,
					new BeanListHandler<Emp>(Emp.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emps;
	}

	@Override
	public Emp Get(int id) {
		String sql = "select id,name,gender,age,salary from emp where id=?";
		Emp emp = null;
		try {
			emp = runner.query(com.vince.DbUtils.getConnection(), sql,
					new BeanHandler<Emp>(Emp.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public long GetCount() {
		String sql = "select count(1) from emp";
		try {
			long count = runner.query(com.vince.DbUtils.getConnection(), sql,
					new ScalarHandler<Long>());
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
