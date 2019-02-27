package com.bosssoft.hr.mkdir;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.bosssoft.hr.sendemail.MailSender;
import com.bosssoft.hr.xmltojava.Task;
import com.bosssoft.hr.xmltojava.TaskParser;
import com.bosssoft.hr.xmltojava.User;
import com.bosssoft.hr.xmltojava.UserParser;

public class DirectoryBuilder {
	public static void main(String[] args) {
		//mymkdir();
	}

	public void mymkdir() {
		//����Ŀ¼
		//GetTask gettask = new GetTask();
		TaskParser taskparser = new TaskParser();
		Task task = new Task();
		taskparser.getTasks(task);
		File file = new File(task.getCatalog());
		System.out.println(file.mkdir());
		//���ʼ�����
		List<User> users = new ArrayList<User>();
		//GetUser getuser = new GetUser();
		UserParser userparser = new UserParser();
		userparser.getUser(users);
		//GetTask gettask = new GetTask();
		//Task task = new Task();
		//GetTask.getTasks(task);
		String taskdir = task.getCatalog();
		//System.out.println(users.size());
		for(int i = 0;i<users.size();i++) {
			String userdir = users.get(i).getName();
			//String finaldir = taskdir+"//"+userdir;
			//File file = new File(finaldir);
			//System.out.println(file.exists());
			//PrintWriter f = new PrintWriter(new FileWriter("b.txt",true),true); 
//			if(file.exists()) {
//				//���ύ����ӡ���ݣ�
//				f.println(userdir+"���ύ��");
//			}else {
//				//δ�ύ����ӡ����
//				f.println(userdir+"δ�ύ��");
//				//�����ʼ�����
//				SendEmail.sendRemindEmail(users, task, i);
//			}
			MailSender mailsender = new MailSender();
			mailsender.sendAssignEmail(users, task, i);
			
		}
	}
}
