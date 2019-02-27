package com.bosssoft.hr.xmltojava;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class AdministratorParser {
	public void getAdministrator(Administrator administrator) {
		try {	
			//创建sax读对象
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File("D:\\eclipes workspace\\maven-java-0101\\src\\main\\resources\\Administrator.xml"));
			Element rootElement = document.getRootElement();
			//System.out.println(rootElement.element("catalog").getText());
			//System.out.println(rootElement.element("date").getText());
			administrator.setEmail(rootElement.element("email").getText());
			administrator.setPassword(rootElement.element("password").getText());
		} catch (DocumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
