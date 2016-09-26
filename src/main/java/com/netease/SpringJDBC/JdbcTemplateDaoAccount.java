package com.netease.SpringJDBC;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTemplateDaoAccount implements JdbcTemplateDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		String sql = "create table account (user varchar(100), balance integer)";
		jdbcTemplate.execute(sql);
	}

	@Override
	public void insertData() {
		// TODO Auto-generated method stub
		String sql = "insert into account values (?,?)";
		this.jdbcTemplate.update(sql, "han", "1000");
		this.jdbcTemplate.update(sql, "li", "1000");
		
	}

}
