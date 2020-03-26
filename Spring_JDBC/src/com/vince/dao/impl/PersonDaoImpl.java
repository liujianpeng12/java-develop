package com.vince.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.mysql.jdbc.jdbc2.optional.PreparedStatementWrapper;
import com.vince.dao.PersonDao;
import com.vince.entity.Person;

/**
 * 使用spring提供的JdbcTemplate
 * @author Administrator
 *
 */
public class PersonDaoImpl implements PersonDao {
	
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void add(Person p) {
		String sql="insert into Person(name,age) values(?,?)";
		jdbcTemplate.update(sql, new Object[]{p.getName(),p.getAge()});
	}

	/**
	 * 插入数据并返回主键值
	 */
	@Override
	public int insert(final Person p) {
		final String sql="insert into Person(name,age) values(?,?)";
		KeyHolder keyHolder=new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps=conn.prepareStatement(sql, PreparedStatementWrapper.RETURN_GENERATED_KEYS);
				ps.setString(1, p.getName());
				ps.setInt(2, p.getAge());
				return ps;
			}
		}, keyHolder);
		
		return keyHolder.getKey().intValue();
	}

	@Override
	public void update(Person p) {
		String sql="update Person set name=?,age=? where id=?";
		jdbcTemplate.update(sql,  new Object[]{p.getName(),p.getAge(),p.getId()});
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from Person where id=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}

	@Override
	public Person get(int id) {
		String sql="select id,name,age from Person where id=?";
		return (Person)jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper(){
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				Person p=new Person(rs.getInt(1),rs.getString(2),rs.getInt(3));
				return p;
			}
		});
	}

	@Override
	public List<Person> list() {
		String sql="select id,name,age from Person";
		return (List<Person>)jdbcTemplate.query(sql, new RowMapper(){
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				Person p=new Person(rs.getInt(1),rs.getString(2),rs.getInt(3));
				return p;
			}
		});
	}

}
