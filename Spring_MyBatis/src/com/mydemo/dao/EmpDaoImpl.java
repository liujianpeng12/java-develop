package com.mydemo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.mydemo.pojo.Emp;

public class EmpDaoImpl extends SqlSessionDaoSupport implements EmpDao {

	@Override
	public List<Emp> selectList() {
		SqlSession session = super.getSqlSession();
		List<Emp> emps = session.selectList("test.selectList");
		return emps;
	}

	@Override
	public Emp getEmp(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmp(Emp emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmp(int id) {
		// TODO Auto-generated method stub
		
	}

}
