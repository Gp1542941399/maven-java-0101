package com.bosssoft.hr.xmltojava;

public class Task {
	private String catalog;
	private String date;
	private String date2;
	////��ʽ��Ϊ��xxxx��xx��xx��  ʱ:��:��  
	public Task() {
		super();
		// TODO �Զ����ɵĹ��캯�����
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
