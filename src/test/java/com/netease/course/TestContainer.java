package com.netease.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		Header header = applicationContext.getBean("header", StraightHeader.class);
		String string = header.getInfo();
		System.out.println(string);
		header.dowork();
		ScrewDriver screwDriver = applicationContext.getBean("screwDriver", ScrewDriver.class);
		// screwDriver.serColor("gr");
		screwDriver.use();
		((ConfigurableApplicationContext) applicationContext).close();
		// ScrewDriver screwDriver1 = applicationContext.getBean("screwDriver",
		// ScrewDriver.class);
		// screwDriver1.use();

	}

}
