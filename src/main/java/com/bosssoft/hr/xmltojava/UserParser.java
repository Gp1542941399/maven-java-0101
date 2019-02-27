package com.bosssoft.hr.xmltojava;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class UserParser {
	//List<User> user = new ArrayList<User>();
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		//getUser(users);
		//UserParser s = new UserParser();
		//s.getUser(users);
		for(int i = 0;i<users.size();i++) {
			System.out.println(users.get(i).toString());
		}
		
	}

	public void getUser(List<User> users) {
		try {
			//1. ����sax��ȡ����
			SAXReader reader = new SAXReader(); //jdbc -- classloader
			//2. ָ��������xmlԴ
			Document document;
			document = reader.read(new File("D:\\eclipes workspace\\maven-java-0101\\src\\main\\resources\\User.xml"));
			//3. �õ�Ԫ�ء�
			//�õ���Ԫ��
			Element rootElement= document.getRootElement();
			List<Element> elements = rootElement.elements();
			for(Element element : elements) {
				User user = new User();
				user.setName(element.element("name").getText());
				user.setMailid(element.element("mailid").getText());
				users.add(user);
			}
		} catch (DocumentException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
