package com.netease.tx;

import java.util.List;

import javax.sql.DataSource;

public interface AccountDao {
	public void setDataSource(DataSource dataSource);

	public void resetMoney();

	public List<Account> accountList();
	
	public void transferMoney(String source,String target,double count);
}
