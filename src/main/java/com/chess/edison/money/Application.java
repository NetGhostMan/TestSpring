package com.chess.edison.money;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("ApplicatioMoney")
public class Application {

	@Autowired
	TransferDAO springJDBCImpl;
	@Autowired
	TransferDAO mybatisSpringImpl;

	public void doTransfer() {
		Long userId = 1L;
		Long argetUserId = 2L;
		Double count = 2000.00;
		springJDBCImpl.transferMoney(userId, argetUserId, count);
		//mybatisSpringImpl.transferMoney(userId, argetUserId, count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-money.xml");
		Application application = applicationContext.getBean("ApplicatioMoney", Application.class);
		application.doTransfer();
		((ConfigurableApplicationContext) applicationContext).close();
	}

}
