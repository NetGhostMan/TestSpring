package com.netease.Tool;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netease.SpringJDBC.JdbcTemplateDao;

public class xmlTool {
	public static ApplicationContext open() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		return applicationContext;
	}

	public static JdbcTemplateDao getJdbc(ApplicationContext applicationContext) {
		return applicationContext.getBean("jdbcTemplateDao", JdbcTemplateDao.class);
	}

	public static void close(ApplicationContext applicationContext) {
		((ConfigurableApplicationContext) applicationContext).close();
	}
}
