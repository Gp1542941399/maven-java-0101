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
     * ���ı���ʽ�����ʼ�
     * @param mailInfo    �������ʼ���Ϣ
     * @throws Exception
     */
    public static void sendTextMail(MailSenderInfo mailInfo) throws Exception{
        // �ж��Ƿ���Ҫ�����֤
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        
        if(mailInfo.isValidate()){
             // �����Ҫ�����֤���򴴽�һ��������֤��
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // �����ʼ��Ự���Ժ�������֤������һ�������ʼ���session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        // ����session����һ���ʼ���Ϣ
        Message mailMessage = new MimeMessage(sendMailSession);
        // �����ʼ������ߵ�ַ
        Address from = new InternetAddress(mailInfo.getFromAddress());
        // �����ʼ���Ϣ�ķ�����
        mailMessage.setFrom(from);
        // �����ʼ��Ľ����ߵ�ַ�������õ��ʼ���Ϣ��
        Address to = new InternetAddress(mailInfo.getToAddress());
        mailMessage.setRecipient(Message.RecipientType.TO, to);
        // �����ʼ���Ϣ������
        mailMessage.setSubject(mailInfo.getSubject());
        // �����ʼ���Ϣ���͵�ʱ��
        mailMessage.setSentDate(new Date());
        // �����ʼ���Ϣ����Ҫ����
        String mailContent = mailInfo.getContent();
        mailMessage.setText(mailContent);
        // �����ʼ�
        Transport.send(mailMessage);
    }
    
    /**
     * ��HTML��ʽ�����ʼ�
     * @param mailInfo   �������ʼ���Ϣ
     * @throws Exception
     */
    public static void sendHtmlMail(MailSenderInfo mailInfo) throws Exception{
        // �ж��Ƿ���Ҫ�����֤
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        
        if(mailInfo.isValidate()){
             // �����Ҫ�����֤���򴴽�һ��������֤��
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // �����ʼ��Ự���Ժ�������֤������һ�������ʼ���session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        // ����session����һ���ʼ���Ϣ
        Message mailMessage = new MimeMessage(sendMailSession);
        // �����ʼ������ߵ�ַ
        Address from = new InternetAddress(mailInfo.getFromAddress());
        // �����ʼ���Ϣ�ķ�����
        mailMessage.setFrom(from);
        // �����ʼ��Ľ����ߵ�ַ�������õ��ʼ���Ϣ��
        Address to = new InternetAddress(mailInfo.getToAddress());
        // Message.RecipientType.TO���Ա�ʾ�����ߵ�����ΪTO
        mailMessage.setRecipient(Message.RecipientType.TO, to);
        // �����ʼ���Ϣ������
        mailMessage.setSubject(mailInfo.getSubject());
        // �����ʼ���Ϣ���͵�ʱ��
        mailMessage.setSentDate(new Date());
        Multipart mainPart = new MimeMultipart();
        // ����һ������HTML���ݵ�MimeBodyPart
        BodyPart html = new MimeBodyPart();
        html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
        mainPart.addBodyPart(html);
        // ��MiniMultipart��������Ϊ�ʼ�����
        mailMessage.setContent(mainPart);
        // �����ʼ�
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
    	mailInfo.setPassword(administrator.getPassword());    // ������������,��������俪���˿ͻ�����Ȩ���룬��˴������Ŀͻ�����Ȩ����
    	mailInfo.setFromAddress(administrator.getEmail());
    	mailInfo.setToAddress(users.get(i).getMailid());
    	mailInfo.setSubject("��ҵ�ύ�����ʼ�");
    	mailInfo.setContent(users.get(i).getName()+"����"+task.getDate2()+"ǰ�Ͻ���ҵ");
       
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
    	mailInfo.setPassword(administrator.getPassword());    // ������������,��������俪���˿ͻ�����Ȩ���룬��˴������Ŀͻ�����Ȩ����
    	mailInfo.setFromAddress(administrator.getEmail());
    	mailInfo.setToAddress(users.get(i).getMailid());
    	mailInfo.setSubject("��ҵ��ʱ�������ʼ�");
    	mailInfo.setContent(users.get(i).getName()+task.getDate2()+"Ӧ����ҵ��δ�ύ�������������");
       
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
    	mailInfo.setPassword(administrator.getPassword());    // ������������,��������俪���˿ͻ�����Ȩ���룬��˴������Ŀͻ�����Ȩ����
    	mailInfo.setFromAddress(administrator.getEmail());
    	mailInfo.setToAddress(users.get(i).getMailid());
    	mailInfo.setSubject("������ҵ����");
    	mailInfo.setContent(users.get(i).getName()+"����"+task.getDate2()+"ǰ����ҵ�ύ��"+task.getCatalog()+"Ŀ¼");
       
    	try {
    	    MailSender.sendTextMail(mailInfo);
    	    //Email.sendHtmlMail(mailInfo);
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }
}
