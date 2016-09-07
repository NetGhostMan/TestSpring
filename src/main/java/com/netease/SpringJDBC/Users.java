package com.netease.SpringJDBC;

public class Users {
	private int id;
	private String firstName;
	private String lastName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string = "id = " + id + ", firstName = " + firstName + ", lastName = " +lastName;
		
		
		return string;
	}
}
