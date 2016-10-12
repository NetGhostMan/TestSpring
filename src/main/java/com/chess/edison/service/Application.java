package com.chess.edison.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("Application")
public class Application {

	@Autowired
	ServiceOne serviceOne;
	@Autowired
	ServiceTwo serviceTwo;
	
	public void doService() {
		serviceOne.into();
		serviceTwo.into();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-service.xml");
		Application application = applicationContext.getBean("Application", Application.class);
		application.doService();
		((ConfigurableApplicationContext)applicationContext).close();
	}

}
