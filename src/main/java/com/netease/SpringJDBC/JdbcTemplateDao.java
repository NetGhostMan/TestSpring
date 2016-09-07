package com.netease.SpringJDBC;

import javax.sql.DataSource;

public interface JdbcTemplateDao {
	public void setDataSource(DataSource dataSource);
	public void createTable();
	public void insertData();
}
