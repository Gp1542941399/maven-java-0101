package com.bosssoft.hr.xmltojava;

public class Task {
	private String catalog;
	private String date;
	private String date2;
	////格式化为：xxxx年xx月xx日  时:分:秒  
	public Task() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Task(String catalog, String date, String date2) {
		super();
		this.catalog = catalog;
		this.date = date;
		this.date2 = date2;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	@Override
	public String toString() {
		return "Task [catalog=" + catalog + ", date=" + date + ", date2=" + date2 + "]";
	}
	
}
