package com.vince.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vince.JdbcTemplete;
import com.vince.ResultSetHandler;
import com.vince.dao.EmpDao;
import com.vince.domain.Emp;

public class EmpDaoImpl implements EmpDao {

	@Override
	public boolean insert(Emp emp) {
		String sql = "insert into emp(name,gender,age,salary) values(?,?,?,?)";
		int eff = JdbcTemplete.update(sql, emp.getName(), emp.getGender(),
				emp.getAge(), emp.getSalary());
		return eff > 0;
	}

	@Override
	public boolean update(Emp emp) {
		String sql = "update emp set name=?,gender=?,age=?,salary=? where id=?";
		int eff = JdbcTemplete.update(sql, emp.getName(), emp.getGender(),
				emp.getAge(), emp.getSalary(), emp.getId());
		return eff > 0;
	}

	@Override
	public boolean delete(Emp emp) {
		String sql = "delete from emp where id=?";
		int eff = JdbcTemplete.update(sql, emp.getId());
		return eff > 0;
	}

	@Override
	public List<Emp> GetAll() {
		String sql = "select id,name,gender,age,salary from emp";
		List<Emp> emps = (List<Emp>) JdbcTemplete.query(sql,
				new ResultSetHandler() {

					@Override
					public Object doHandler(ResultSet rs) {
						List<Emp> emps = null;
						if (null != rs) {
							emps = new ArrayList<Emp>();
							Emp emp = null;
							try {
								while (rs.next()) {
									emp = new Emp();
									emp.setId(rs.getInt("id"));
									emp.setName(rs.getString("name"));
									emp.setGender(rs.getString("gender"));
									emp.setAge(rs.getInt("age"));
									emp.setSalary(rs.getFloat("salary"));
									emps.add(emp);
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						return emps;
					}
				});
		return emps;
	}

	@Override
	public Emp Get(int id) {
		String sql = "select id,name,gender,age,salary from emp where id=?";
		Emp emp = (Emp) JdbcTemplete.query(sql, new ResultSetHandler() {

			@Override
			public Object doHandler(ResultSet rs) {
				Emp emp = null;
				if (null != rs) {
					try {
						if (rs.next()) {
							emp = new Emp();
							emp.setId(rs.getInt("id"));
							emp.setGender(rs.getString("gender"));
							emp.setAge(rs.getInt("age"));
							emp.setSalary(rs.getFloat("salary"));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				return emp;
			}
		}, id);
		return emp;
	}

}
