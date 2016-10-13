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
		System.out.println("-------------------------------------------");
		serviceOne.into();
		System.out.println("-------------------------------------------");
		serviceOne.delete(1);
		System.out.println("-------------------------------------------");
		serviceOne.select();
		System.out.println("-------------------------------------------");
		try {
			serviceOne.update();
		} catch (Exception e) {
		}
		System.out.println("-------------------------------------------");
		serviceTwo.into();
		System.out.println("-------------------------------------------");
		serviceTwo.delete(1);
		System.out.println("-------------------------------------------");
		serviceTwo.select();
		System.out.println("-------------------------------------------");
		try {
			serviceTwo.update();
		} catch (Exception e) {
		}
		System.out.println("-------------------------------------------");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-service.xml");
		Application application = applicationContext.getBean("Application", Application.class);
		application.doService();
		((ConfigurableApplicationContext) applicationContext).close();
	}

}
