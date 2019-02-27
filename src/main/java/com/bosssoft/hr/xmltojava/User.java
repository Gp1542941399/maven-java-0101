package com.bosssoft.hr.xmltojava;

public class User {
private String name;
private String mailid;
public User(String name, String mailid) {
	super();
	this.name = name;
	this.mailid = mailid;
}
public User() {
	super();
	// TODO 自动生成的构造函数存根
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMailid() {
	return mailid;
}
public void setMailid(String mailid) {
	this.mailid = mailid;
}
@Override
public String toString() {
	return "User [name=" + name + ", mailid=" + mailid + "]";
}

}
