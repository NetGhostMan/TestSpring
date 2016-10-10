package com.chess.edison.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	@Autowired
	FileWriterService fileWriterService;

	public static void main(String[] args) {
		Application application = new Application();
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-file.xml");
		application.fileWriterService = applicationContext.getBean("FileWriterService",
				FileWriterService.class);

		application.fileWriterService.write("而是地方");

		((ConfigurableApplicationContext) applicationContext).close();
	}
}
