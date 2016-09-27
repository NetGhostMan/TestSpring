package com.chess.edison.service;

import org.springframework.stereotype.Component;

@Component("ServiceFour")
public class ServiceFourImpl implements ServiceFour {

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("服务4的查");

	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("服务4的增");
	}

	@Override
	public void updata() {
		// TODO Auto-generated method stub
		System.out.println("服务4的改");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("服务4的删");
	}

}
