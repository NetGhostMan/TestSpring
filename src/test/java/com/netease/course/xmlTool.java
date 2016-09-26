package com.netease.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netease.SpringJDBC.JdbcTemplateDaoImp;

public class xmlTool {
	public static ApplicationContext open() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		return applicationContext;
	}

	public static JdbcTemplateDaoImp getJdbc(ApplicationContext applicationContext) {
		return applicationContext.getBean("jdbcTemplateDao", JdbcTemplateDaoImp.class);
	}

	public static void close(ApplicationContext applicationContext) {
		((ConfigurableApplicationContext) applicationContext).close();
	}
}
