package com.netease.course;

import java.util.Map;

public class StraightHeader implements Header {

	private String color;
	private int size;
	
	public StraightHeader(String color, int size) {
		super();
		this.color = color;
		this.size = size;
	}
	public StraightHeader(Map<String,String> paras) {
		// TODO Auto-generated constructor stub
		this.color = paras.get("color");
		this.size = Integer.valueOf(paras.get("size"));
	}

	@Override
	public void dowork() {
		// TODO Auto-generated method stub
		System.out.println("Do work with StraightHeader");

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "StraightHeader " + color + " " + size;
	}
	public void setColor(String color){
		this.color = color;
	}
	public void setSize(int size){
		this.size = size;
	}

}
