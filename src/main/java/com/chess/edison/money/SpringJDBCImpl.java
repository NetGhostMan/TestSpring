package com.chess.edison.money;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SpringJDBCImpl implements TransferDAO {

	private JdbcTemplate jdbcTemplte;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplte = new JdbcTemplate(dataSource);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void transferMoney(Long srcUserId, Long targetUserId, Double count) {
		// TODO Auto-generated method stub
		String sql = "update `UserBalance` set `balance` = `balance` - ? where userId = ?";
		this.jdbcTemplte.update(sql,count,srcUserId);
		try {
			ex();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		String sql1 = "update `UserBalance` set `balance` = `balance` + ? where userId = ?";
		this.jdbcTemplte.update(sql1,count,targetUserId);
	}
	private void ex() throws Exception {
		String sql = "select * from `UserBalance`";
		List<User> users = this.jdbcTemplte.query(sql, new RowMapper<User>(){
			public User mapRow(ResultSet rs,int rowNum)throws SQLException{
				User user = new User();
				user.setUserId(rs.getLong("userId"));
				user.setBalance(rs.getDouble("balance"));
				return user;
			}
		});
		String string = "|";
		for(User user : users){
			string = string + user.toString() + "|";
		}
		throw new Exception("中间异常，现在每个人的值是："+string);
	}
}
 