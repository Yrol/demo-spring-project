package com.yrol.demo.domain;

public class User {

	private String fullName;
	private int age;
	private Boolean employed;
	private String gender;

	public User() {

	}

	public User(String fullName, int age, Boolean employed, String gender) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.employed = employed;
		this.gender = gender;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Boolean getEmployed() {
		return employed;
	}

	public void setEmployed(Boolean employed) {
		this.employed = employed;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
