package com.netease.SpringJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTemplateDaoImp implements JdbcTemplateDao {
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// @Autowired
	// public void setDataSource(DataSource dataSource) {
	// this.jdbcTemplate = new JdbcTemplate(dataSource);
	// }
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public void createTable() {
		String sql = "create table users (id integer,first_name varchar(100), last_name varchar(100))";
		jdbcTemplate.execute(sql);
	}

	public void insertData() {
		int id = 1;
		String sql = "insert into users values (" + id + ",?,?)";
		this.jdbcTemplate.update(sql, "Meimei", "Han");
		id = 2;
		sql = "insert into users values (" + id + ",?,?)";
		this.jdbcTemplate.update(sql, "Lei", "Li");
	}

	public int count() {
		return this.jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
	}

	public List<Users> getUserList() {
		return this.jdbcTemplate.query("select * from users", new RowMapper<Users>() {

			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Users users = new Users();
				users.setId(rs.getInt("id"));
				users.setFirstName(rs.getString("first_name"));
				users.setLastName(rs.getString("last_name"));
				return users;
			}
		});
	}

	public int countOfUsersByFirstName(Users exampleUsers) {
		String sql = "select count(*) from users where first_name = :firstName";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(exampleUsers);
		return this.namedParameterJdbcTemplate.queryForObject(sql, parameterSource, Integer.class);

	}
}
