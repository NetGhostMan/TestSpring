package com.chess.edison.money;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	@Autowired
	TransferDAO springJDBCImpl;

	
	public void doTransfer(){
		Long userId = 001L;
		Long argetUserId = 002L;
		Double count = 3.14;
		springJDBCImpl.transferMoney(userId,argetUserId,count);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicatin-money.xml");
		Application application = applicationContext.getBean("Application",Application.class);
		application.doTransfer();
		((ConfigurableApplicationContext)applicationContext).close();
	}

}
