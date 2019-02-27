package com.bosssoft.hr.scan;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.bosssoft.hr.sendemail.MailSender;
import com.bosssoft.hr.xmltojava.Task;
import com.bosssoft.hr.xmltojava.TaskParser;
import com.bosssoft.hr.xmltojava.User;
import com.bosssoft.hr.xmltojava.UserParser;

public class Scanner {
	public void scan() throws IOException {
		List<User> users = new ArrayList<User>();
		//UserParser getuser = new GetUser();
		UserParser userparser = new UserParser();
		userparser.getUser(users);
		//GetTask gettask = new GetTask();
		Task task = new Task();
		TaskParser taskparser = new TaskParser();
		taskparser.getTasks(task);
		String taskdir = task.getCatalog();
		//System.out.println(users.size());
		for(int i = 0;i<users.size();i++) {
			String userdir = users.get(i).getName();
			String finaldir = taskdir+"//"+userdir;
			File file = new File(finaldir);
			System.out.println(file.exists());
			//PrintWriter f = new PrintWriter(new FileWriter("b.txt",true),true); 
			if(file.exists()) {
				//���ύ����ӡ���ݣ�
				//f.println(userdir+task.getDate()+"Ӧ����ҵ���ύ��");
			}else {
				//δ�ύ����ӡ����
				//f.println(userdir+task.getDate()+"Ӧ����ҵδ�ύ��");
				//�����ʼ�����
				MailSender.sendRemindEmail(users, task, i);
			}
		}
	}
	public void scan2() throws IOException {
		List<User> users = new ArrayList<User>();
		//GetUser getuser = new GetUser();
		UserParser userparser = new UserParser();
		userparser.getUser(users);
		//GetTask gettask = new GetTask();
		Task task = new Task();
		TaskParser taskparser = new TaskParser();
		taskparser.getTasks(task);
		String taskdir = task.getCatalog();
		//System.out.println(users.size());
		for(int i = 0;i<users.size();i++) {
			String userdir = users.get(i).getName();
			String finaldir = taskdir+"//"+userdir;
			File file = new File(finaldir);
			System.out.println(file.exists());
			PrintWriter f = new PrintWriter(new FileWriter(taskdir+"//b.txt",true),true); 
			if(file.exists()) {
				//���ύ����ӡ���ݣ�
				f.println(userdir+task.getDate2()+"Ӧ����ҵ���ύ��");
			}else {
				//δ�ύ����ӡ����
				f.println(userdir+task.getDate2()+"Ӧ����ҵδ�ύ��");
				//�����ʼ�����
				MailSender mailsender = new MailSender();
				mailsender.sendWarnEmail(users, task, i);
			}
		}
	}
}
