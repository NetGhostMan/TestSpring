package com.netease.SpringJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-jdbc.xml");
		JdbcTemplateDao dao = applicationContext.getBean("JdbcTemplateDaoAccount", JdbcTemplateDao.class);
		dao.insertData();
		((ConfigurableApplicationContext)applicationContext).close();

	}

}
