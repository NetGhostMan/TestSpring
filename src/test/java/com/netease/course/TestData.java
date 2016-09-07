package com.netease.course;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.netease.SpringJDBC.JdbcTemplateDao;
import com.netease.SpringJDBC.Users;
import com.netease.Tool.xmlTool;

public class TestData {
	@Test
	public void TestTemplateDao() {
		ApplicationContext applicationContext = xmlTool.open();
		JdbcTemplateDao jdbcTemplateDao = xmlTool.getJdbc(applicationContext);
		jdbcTemplateDao.createTable();
		xmlTool.close(applicationContext);
	}

	@Test
	public void Testupdate() {
		ApplicationContext applicationContext = xmlTool.open();
		JdbcTemplateDao jdbcTemplateDao = xmlTool.getJdbc(applicationContext);
		jdbcTemplateDao.insertData();
		xmlTool.close(applicationContext);
	}

	@Test
	public void Testselect() {
		ApplicationContext applicationContext = xmlTool.open();
		JdbcTemplateDao jdbcTemplateDao = xmlTool.getJdbc(applicationContext);
		int a = jdbcTemplateDao.count();
		xmlTool.close(applicationContext);
		System.out.println(a);
	}

	@Test
	public void TestList() {
		ApplicationContext applicationContext = xmlTool.open();
		JdbcTemplateDao jdbcTemplateDao = xmlTool.getJdbc(applicationContext);
		List<Users> userList = jdbcTemplateDao.getUserList();
		for (Users users : userList) {
			System.out.println(users.toString());
		}
		xmlTool.close(applicationContext);
	}

	@Test
	public void TestName() {
		ApplicationContext applicationContext = xmlTool.open();
		JdbcTemplateDao jdbcTemplateDao = xmlTool.getJdbc(applicationContext);
		Users users = new Users();
		users.setFirstName("Meimei");
		users.setId(1);
		users.setLastName("Han");
		int a = jdbcTemplateDao.countOfUsersByFirstName(users);
		xmlTool.close(applicationContext);
		System.out.println(a);

	}
}
