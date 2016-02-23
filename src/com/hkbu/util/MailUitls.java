package com.hkbu.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 * 邮件发送工具类
 * 
 */
public class MailUitls {
	/**
	 * 发送邮件的方法
	 * @param to	:收件人
	 */
	public static void sendMail(String to,String accNO,String validCode){
		/**
		 * 1.获得一个Session对象.
		 * 2.创建一个代表邮件的对象Message.
		 * 3.发送邮件Transport
		 */
		// 1.获得连接对象
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");//连接的服务器
		props.setProperty("mail.smtp.auth", "true");//是否需要认证
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("systemptu@163.com", "lhbyobjphpnzxxlx");
			}
			
		});
		// 2.创建邮件对象:
		Message message = new MimeMessage(session);
		// 设置发件人:
		try {
			message.setFrom(new InternetAddress("systemptu@163.com"));
			// 设置收件人:
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			// 抄送 CC   密送BCC
			// 设置标题
			message.setSubject("网银转账验证");
			// 设置邮件正文:
			message.setContent("<h1><font color='red'>尊敬的用户，您的银行账户"+ accNO +"正在进行转账操作，验证消息为"+validCode +"</font></h1>", "text/html;charset=UTF-8");
			// 3.发送邮件:
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args)
	{
		
	}
	
}
