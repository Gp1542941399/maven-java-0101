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
		//创建目录
		//GetTask gettask = new GetTask();
		TaskParser taskparser = new TaskParser();
		Task task = new Task();
		taskparser.getTasks(task);
		File file = new File(task.getCatalog());
		System.out.println(file.mkdir());
		//发邮件提醒
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
//				//已提交，打印数据！
//				f.println(userdir+"已提交！");
//			}else {
//				//未提交，打印数据
//				f.println(userdir+"未提交！");
//				//发送邮件提醒
//				SendEmail.sendRemindEmail(users, task, i);
//			}
			MailSender mailsender = new MailSender();
			mailsender.sendAssignEmail(users, task, i);
			
		}
	}
}
