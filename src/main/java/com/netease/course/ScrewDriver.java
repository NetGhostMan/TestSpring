package com.netease.course;

public class ScrewDriver {

	private Header header;
	private String color = "red";

	public ScrewDriver(Header header) {
		this.header = header;
	}

	public void use() {
		System.out.println("hello world!" + color + " "+ header.getInfo());
		header.dowork();
	}

	public void serColor(String color) {
		this.color = color;
	}

	public void init() {
		System.out.println("init");
	}

	public void cleanup() {
		System.out.println("destroy");
	}
}
