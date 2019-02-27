package com.bosssoft.hr.xmltojava;

public class Administrator {
	private String email;
	private String password;
	public Administrator() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Administrator(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Administrator [email=" + email + ", password=" + password + "]";
	}
	
}
