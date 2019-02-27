package com.bosssoft.hr.date;

import java.io.IOException;
import java.util.Date;

import com.bosssoft.hr.mkdir.DirectoryBuilder;
import com.bosssoft.hr.scan.Scanner;
import com.bosssoft.hr.xmltojava.Task;
import com.bosssoft.hr.xmltojava.TaskParser;

public class Timer {
	public static void main(String[] args) throws IOException {
		DirectoryBuilder directory = new DirectoryBuilder();
		directory.mymkdir();
//		Object obj1 = new Object(); 
//		Scaner1 s1 = new Scaner1();
//		Scaner2 s2 = new Scaner2();
//		s1.obj = obj1;
//		s2.obj = obj1;
//		Thread th1 = new Thread(s1);
//		Thread th2 = new Thread(s2);
		while(true) {
			Date date = new Date();
			String s = date.toLocaleString();
			Task task = new Task();
			TaskParser taskParser = new TaskParser();
			taskParser.getTasks(task);
			Scanner scanner = new Scanner();
			if(s.equals(task.getDate())) {
				scanner.scan();
				System.out.println(s);
			}
			if(s.equals(task.getDate2())){
				scanner.scan2();
				System.out.println(s);
				break;
			}
			
		}
	}
	
}
//class Scaner1 extends Thread{
//	public Object obj = new Object();
//	public void run() {
//		Scanner scanner = new Scanner();
//		try {
//			synchronized (obj) {
//				scanner.scan();
//			}
//			
//		} catch (IOException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		//System.out.println(s);
//		
//	}
//	
//}
//class Scaner2 extends Thread{
//
//	public Object obj = new Object();
//	public void run() {
//		Scanner scanner = new Scanner();
//		try {
//			scanner.scan2();
//		} catch (IOException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		//System.out.println(s);
//		
//	}
//	
//}
