package com.vince.test;

import com.vince.dao.EmpDao;
import com.vince.dao.impl.EmpDaoImpl;
import com.vince.domain.Emp;

public class Test {

	public static void main(String[] args) {
		Emp emp = new Emp(21, "Ãû×Ö", "Å®", 40000, 20);

		EmpDao empDao = new EmpDaoImpl();
		// empDao.insert(emp);
		// empDao.update(emp);
		// empDao.delete(emp);

		// List<Emp> emps=empDao.GetAll();
		// System.out.println(emps);

		Emp e = empDao.Get(19);
		System.out.println(e);

		long count = empDao.GetCount();
		System.out.println(count);
	}
}
