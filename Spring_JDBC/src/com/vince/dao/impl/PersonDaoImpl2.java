package com.vince.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.vince.dao.PersonDao;
import com.vince.entity.Person;

/**
 * 使用spring提供的NamedParameterJdbcTemplate
 * 封装了JdbcTemplate,增加了在SQL语句中对参数名的支持
 * @author Administrator
 *
 */
public class PersonDaoImpl2 implements PersonDao {

	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void add(Person p) {
		String sql="insert into Person(name,age) values(:name,:age)";
		MapSqlParameterSource paramSource=new MapSqlParameterSource();
		paramSource.addValue("name", p.getName());
		paramSource.addValue("age", p.getAge());
		jdbcTemplate.update(sql, paramSource);
		
	}

	@Override
	public int insert(Person p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
