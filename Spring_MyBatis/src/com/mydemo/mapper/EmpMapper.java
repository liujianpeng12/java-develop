package com.mydemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mydemo.pojo.Emp;

public interface EmpMapper {

	@Select("select * from t_emp")
	List<Emp> selectList();
	
	@Select("select * from t_emp where id=#{id}")
	Emp getEmp(int id);
	
	@Insert("insert into t_emp(name,age,gender,salary) values(#{name},#{age},#{gender},#{salary})")
	void addEmp(Emp emp);
	
	@Update("update t_emp set name=#{name} where id=#{id}")
	void updateEmp(Emp emp);
	
	@Delete("delete from t_emp where id=#{id}")
	void deleteEmp(int id);
}
