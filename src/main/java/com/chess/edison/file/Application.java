package com.chess.edison.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	@Autowired
	FileWriterService fileWriterService;

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-file.xml");
		FileWriterService fileWriterService = applicationContext.getBean("FileWriterService",
				FileWriterService.class);

		fileWriterService.write("而是地方");

		((ConfigurableApplicationContext) applicationContext).close();
	}
}
