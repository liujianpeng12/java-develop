package com.vince.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.vince.dao.*;
import com.vince.model.Teacher;

public class TeacherDaoImpl implements TeacherDao {

	private static QueryRunner runner = new QueryRunner();

	@Override
	public boolean insert(Teacher t) {
		String sql = "insert into teacher(name,age,description) values(?,?,?)";
		Connection conn = null;
		int eff = -1;
		try {
			conn = com.vince.util.db.DbUtils.getConnection();
			eff = runner.update(conn, sql, t.getName(), t.getAge(),
					t.getDescription());
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
	public boolean update(Teacher t) {
		String sql = "update teacher set name=?,age=?,description=? where tid=?";
		Connection conn = null;
		int eff = -1;
		try {
			conn = com.vince.util.db.DbUtils.getConnection();
			eff = runner.update(conn, sql, t.getName(), t.getAge(),
					t.getDescription(), t.getTid());
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
	public boolean delete(int id) {
		String sql = "delete from teacher where tid=?";
		int eff = -1;
		try {
			eff = runner.update(com.vince.util.db.DbUtils.getConnection(), sql,
					id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eff > 0;
	}

	@Override
	public List<Teacher> findAll() {
		String sql = "select tid,name,age,description from teacher";
		List<Teacher> emps = null;
		try {
			emps = runner.query(com.vince.util.db.DbUtils.getConnection(), sql,
					new BeanListHandler<Teacher>(Teacher.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emps;
	}

	@Override
	public Teacher findById(int id) {
		String sql="select tid,name,age,description from teacher where tid=?";
		Teacher t=null;
		try {
			t=runner.query(com.vince.util.db.DbUtils.getConnection(), sql, new BeanHandler<Teacher>(Teacher.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

}
