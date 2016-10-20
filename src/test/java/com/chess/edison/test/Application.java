package com.chess.edison.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chess.edison.file.ApplicationFile;
import com.chess.edison.service.ApplicationService;

public class Application {

	@Test
	public void testFile() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-file.xml");
		ApplicationFile applicationFile = applicationContext.getBean("ApplicationFile",
				ApplicationFile.class);
		applicationFile.doWriterFile();
		((ConfigurableApplicationContext) applicationContext).close();
	}
	@Test
	public void testService() {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-service.xml");
		ApplicationService applicationService = applicationContext.getBean("ApplicationService", ApplicationService.class);
		applicationService.doService();
		((ConfigurableApplicationContext) applicationContext).close();
	}

}
