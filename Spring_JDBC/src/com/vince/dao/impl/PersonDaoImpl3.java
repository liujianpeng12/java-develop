package com.vince.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.vince.dao.PersonDao;
import com.vince.entity.Person;

/**
 * SimpleJdbcTemplate
 * 在NameParameterJdbcTemplate上的扩展,增加了JDK1.5以后对泛型的支持
 * @author Administrator
 *
 */
public class PersonDaoImpl3 implements PersonDao {

	private SimpleJdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void add(Person p) {
		// TODO Auto-generated method stub
		
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
		String sql="select id,name,age from Person where id=:id";
		
		MapSqlParameterSource paramSource=new MapSqlParameterSource("id", id);
		
		ParameterizedRowMapper<Person> rm=new ParameterizedRowMapper<Person>() {
			
			@Override
			public Person mapRow(ResultSet rs, int arg1) throws SQLException {
				Person p=new Person(rs.getInt(1), rs.getString(2), rs.getInt(3));
				return p;
			}
		};
		
		return jdbcTemplate.queryForObject(sql, rm, paramSource);
	}

	@Override
	public List<Person> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
