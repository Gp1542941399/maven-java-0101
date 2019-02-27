package com.bosssoft.hr.sendemail;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.bosssoft.hr.xmltojava.Administrator;
import com.bosssoft.hr.xmltojava.AdministratorParser;
import com.bosssoft.hr.xmltojava.Task;
import com.bosssoft.hr.xmltojava.User;

public class MailSender {
	/**
     * 以文本格式发送邮件
     * @param mailInfo    待发送邮件信息
     * @throws Exception
     */
    public static void sendTextMail(MailSenderInfo mailInfo) throws Exception{
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        
        if(mailInfo.isValidate()){
             // 如果需要身份认证，则创建一个密码验证器
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        // 根据session创建一个邮件消息
        Message mailMessage = new MimeMessage(sendMailSession);
        // 创建邮件发送者地址
        Address from = new InternetAddress(mailInfo.getFromAddress());
        // 设置邮件消息的发送者
        mailMessage.setFrom(from);
        // 创建邮件的接收者地址，并设置到邮件消息中
        Address to = new InternetAddress(mailInfo.getToAddress());
        mailMessage.setRecipient(Message.RecipientType.TO, to);
        // 设置邮件消息的主题
        mailMessage.setSubject(mailInfo.getSubject());
        // 设置邮件消息发送的时间
        mailMessage.setSentDate(new Date());
        // 设置邮件消息的主要内容
        String mailContent = mailInfo.getContent();
        mailMessage.setText(mailContent);
        // 发送邮件
        Transport.send(mailMessage);
    }
    
    /**
     * 以HTML格式发送邮件
     * @param mailInfo   待发送邮件信息
     * @throws Exception
     */
    public static void sendHtmlMail(MailSenderInfo mailInfo) throws Exception{
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        
        if(mailInfo.isValidate()){
             // 如果需要身份认证，则创建一个密码验证器
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        // 根据session创建一个邮件消息
        Message mailMessage = new MimeMessage(sendMailSession);
        // 创建邮件发送者地址
        Address from = new InternetAddress(mailInfo.getFromAddress());
        // 设置邮件消息的发送者
        mailMessage.setFrom(from);
        // 创建邮件的接收者地址，并设置到邮件消息中
        Address to = new InternetAddress(mailInfo.getToAddress());
        // Message.RecipientType.TO属性表示接收者的类型为TO
        mailMessage.setRecipient(Message.RecipientType.TO, to);
        // 设置邮件消息的主题
        mailMessage.setSubject(mailInfo.getSubject());
        // 设置邮件消息发送的时间
        mailMessage.setSentDate(new Date());
        Multipart mainPart = new MimeMultipart();
        // 创建一个包含HTML内容的MimeBodyPart
        BodyPart html = new MimeBodyPart();
        html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
        mainPart.addBodyPart(html);
        // 将MiniMultipart对象设置为邮件内容
        mailMessage.setContent(mainPart);
        // 发送邮件
        Transport.send(mailMessage);
    }
    public static void sendRemindEmail(List<User> users, Task task, int i) {
    	Administrator administrator = new Administrator();
    	AdministratorParser administratorparser = new AdministratorParser();
    	administratorparser.getAdministrator(administrator);
    	MailSenderInfo mailInfo = new MailSenderInfo();
    	mailInfo.setMailServerHost("smtp.163.com");
    	mailInfo.setMailServerPort("25");
    	mailInfo.setValidate(true);
    	mailInfo.setUserName(administrator.getEmail());
    	mailInfo.setPassword(administrator.getPassword());    // 您的邮箱密码,若你的邮箱开启了客户端授权密码，则此处是您的客户端授权密码
    	mailInfo.setFromAddress(administrator.getEmail());
    	mailInfo.setToAddress(users.get(i).getMailid());
    	mailInfo.setSubject("作业提交提醒邮件");
    	mailInfo.setContent(users.get(i).getName()+"请于"+task.getDate2()+"前上交作业");
       
    	try {
    	    MailSender.sendTextMail(mailInfo);
    	    //Email.sendHtmlMail(mailInfo);
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }
    public void sendWarnEmail(List<User> users, Task task, int i) {
    	Administrator administrator = new Administrator();
    	AdministratorParser administratorparser = new AdministratorParser();
    	administratorparser.getAdministrator(administrator);
    	MailSenderInfo mailInfo = new MailSenderInfo();
    	mailInfo.setMailServerHost("smtp.163.com");
    	mailInfo.setMailServerPort("25");
    	mailInfo.setValidate(true);
    	mailInfo.setUserName(administrator.getEmail());
    	mailInfo.setPassword(administrator.getPassword());    // 您的邮箱密码,若你的邮箱开启了客户端授权密码，则此处是您的客户端授权密码
    	mailInfo.setFromAddress(administrator.getEmail());
    	mailInfo.setToAddress(users.get(i).getMailid());
    	mailInfo.setSubject("作业到时间提醒邮件");
    	mailInfo.setContent(users.get(i).getName()+task.getDate2()+"应交作业你未提交，请后续补交！");
       
    	try {
    	    MailSender.sendTextMail(mailInfo);
    	    //Email.sendHtmlMail(mailInfo);
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }
    public void sendAssignEmail(List<User> users, Task task, int i) {
    	Administrator administrator = new Administrator();
    	AdministratorParser administratorparser = new AdministratorParser();
    	administratorparser.getAdministrator(administrator);
    	MailSenderInfo mailInfo = new MailSenderInfo();
    	mailInfo.setMailServerHost("smtp.163.com");
    	mailInfo.setMailServerPort("25");
    	mailInfo.setValidate(true);
    	mailInfo.setUserName(administrator.getEmail());
    	mailInfo.setPassword(administrator.getPassword());    // 您的邮箱密码,若你的邮箱开启了客户端授权密码，则此处是您的客户端授权密码
    	mailInfo.setFromAddress(administrator.getEmail());
    	mailInfo.setToAddress(users.get(i).getMailid());
    	mailInfo.setSubject("布置作业提醒");
    	mailInfo.setContent(users.get(i).getName()+"请于"+task.getDate2()+"前将作业提交到"+task.getCatalog()+"目录");
       
    	try {
    	    MailSender.sendTextMail(mailInfo);
    	    //Email.sendHtmlMail(mailInfo);
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }
}
