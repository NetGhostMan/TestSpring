package com.netease;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.netease.tx.Account;
import com.netease.tx.AccountDao;

public class AccountDaoTx implements AccountDao {

	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetMoney() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Account> accountList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void transferMoney(String source, String target, double count) {
		// TODO Auto-generated method stub

	}

}
