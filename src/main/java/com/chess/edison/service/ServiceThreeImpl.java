package com.chess.edison.service;

import org.springframework.stereotype.Component;

@Component("ServiceThree")
public class ServiceThreeImpl implements ServiceThree {

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("服务3的查");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("服务3的增");
	}

	@Override
	public void updata() {
		// TODO Auto-generated method stub
		System.out.println("服务3的改");
	}

	@Override
	public void delete() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("服务3的删");
	}

}
