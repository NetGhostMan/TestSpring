package com.chess.edison.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ApplicationService")
public class ApplicationService {

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

}
