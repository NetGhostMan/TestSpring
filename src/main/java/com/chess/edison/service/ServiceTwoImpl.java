package com.chess.edison.service;

import org.springframework.stereotype.Component;

@Component("ServiceTwo")
public class ServiceTwoImpl implements ServiceTwo {

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("服务2的查");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("服务2的增");
	}

	@Override
	public void updata() {
		// TODO Auto-generated method stub
		System.out.println("服务2的改");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("服务2的删");
	}

}
