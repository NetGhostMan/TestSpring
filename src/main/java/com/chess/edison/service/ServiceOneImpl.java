package com.chess.edison.service;

import org.springframework.stereotype.Component;

@Component("ServiceOne")
public class ServiceOneImpl implements ServiceOne {

	@Override
	public void select(int a) {
		// TODO Auto-generated method stub
		System.out.println("服务1的查 参数是：" + a);
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("服务1的增");
	}

	@Override
	public void updata() {
		// TODO Auto-generated method stub
		System.out.println("服务1的改");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("服务1的删");
	}

}
