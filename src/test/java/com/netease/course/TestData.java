package com.netease.course;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.netease.SpringJDBC.JdbcTemplateDao;
import com.netease.SpringJDBC.JdbcTemplateDaoImp;
import com.netease.SpringJDBC.Users;
import com.netease.mybatis.MybatisUserDao;
import com.netease.tx.Account;
import com.netease.tx.AccountDao;

public class TestData {
	@Test
	public void testCreateTable() {
		ApplicationContext applicationContext = xmlTool.open();
		String bean = "jdbcTemplateDaoAccount";
//		bean = "jdbcTemplateDaoImp";
		JdbcTemplateDao jdbcTemplateDao = applicationContext.getBean(bean, JdbcTemplateDao.class);
		jdbcTemplateDao.createTable();
		xmlTool.close(applicationContext);
	}

	@Test
	public void TestupdateTable() {
		ApplicationContext applicationContext = xmlTool.open();
		String bean = "jdbcTemplateDaoAccount";
		JdbcTemplateDao jdbcTemplateDao = applicationContext.getBean(bean,JdbcTemplateDao.class);
		jdbcTemplateDao.insertData();
		xmlTool.close(applicationContext);
	}

	@Test
	public void Testselect() {
		ApplicationContext applicationContext = xmlTool.open();
		JdbcTemplateDaoImp jdbcTemplateDao = xmlTool.getJdbc(applicationContext);
		int a = jdbcTemplateDao.count();
		xmlTool.close(applicationContext);
		System.out.println(a);
	}

	@Test
	public void TestList() {
		ApplicationContext applicationContext = xmlTool.open();
		JdbcTemplateDaoImp jdbcTemplateDao = xmlTool.getJdbc(applicationContext);
		List<Users> userList = jdbcTemplateDao.getUserList();
		for (Users users : userList) {
			System.out.println(users.toString());
		}
		xmlTool.close(applicationContext);
	}

	@Test
	public void TestName() {
		ApplicationContext applicationContext = xmlTool.open();
		JdbcTemplateDaoImp jdbcTemplateDao = xmlTool.getJdbc(applicationContext);
		Users users = new Users();
		users.setFirstName("Meimei");
		users.setId(1);
		users.setLastName("Han");
		int a = jdbcTemplateDao.countOfUsersByFirstName(users);
		xmlTool.close(applicationContext);
		System.out.println(a);
	}

	@Test
	public void TestTx() { 
		ApplicationContext applicationContext = xmlTool.open();
		AccountDao accountDao = applicationContext.getBean("accountDaoImp", AccountDao.class);
		accountDao.resetMoney();
		try {
			accountDao.transferMoney("li", "han",521);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		List<Account> accounts = accountDao.accountList();
		for (Account account : accounts) {
			System.out.println(account.getUser() + ": " + account.getBalance());
		}
		xmlTool.close(applicationContext);
	}
	
	@Test
	public void TestMybatis(){
		ApplicationContext applicationContext = xmlTool.open();
		MybatisUserDao mybatisUserDao = applicationContext.getBean("mybatisUserDao",MybatisUserDao.class);
		
		List<Users> users = mybatisUserDao.getUsers();
		
		for(Users user : users){
			System.out.println(user.getFirstName()+" " + user.getLastName());
		}
		String string = mybatisUserDao.getUser("Lei").toString();
		System.out.println("------------------");
		System.out.println(string);
		xmlTool.close(applicationContext);
	}
}




















