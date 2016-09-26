package com.netease.tx;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImp implements AccountDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public void resetMoney() {
		// TODO Auto-generated method stub
		String sql = "update account set balance = 1000";
		jdbcTemplate.update(sql);

	}

	@Override
	public List<Account> accountList() {
		// TODO Auto-generated method stub
		String sql = "select * from account";
		return this.jdbcTemplate.query(sql, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Account account = new Account();
				account.setUser(rs.getString("user"));
				account.setBalance(rs.getDouble("balance"));
				return account;
			}

		});
	}

	@Override
	public void transferMoney(String source, String target, double count) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update account set balance=balance-? where user=?", count, source);
		throwException();
		this.jdbcTemplate.update("update account set balance=balance+? where user=?", count, target);
	}

	private void throwException() {
		throw new RuntimeException("ERROR");
	}
}
