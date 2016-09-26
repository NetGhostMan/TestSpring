package com.netease.course;

import org.springframework.context.ApplicationContext;

public class TestContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = xmlTool.open();
		Header header = applicationContext.getBean("header", StraightHeader.class);
		String string = header.getInfo();
		System.out.println(string);
		header.dowork();
		ScrewDriver screwDriver = applicationContext.getBean("screwDriver", ScrewDriver.class);
		// screwDriver.serColor("gr");
		screwDriver.use();
		xmlTool.close(applicationContext);
		// ScrewDriver screwDriver1 = applicationContext.getBean("screwDriver",
		// ScrewDriver.class);
		// screwDriver1.use();

	}

}
