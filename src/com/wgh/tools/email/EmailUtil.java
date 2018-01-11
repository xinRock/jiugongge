package com.wgh.tools.email;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 *  
 * @author mWX488777
 *huanglaiye@163.com
 *hello159357
 *只试用于163邮箱作为服务邮箱其他的邮箱不适用
 */
public class EmailUtil  {
	
    private EmailUtil() {
    }
    //作为发送者服务器的邮箱账号
	private static String sendEmailAccount= DevelperSetData.sendemailaccount;
	//邮箱的授权码
	private static String shouquanma= DevelperSetData.shouquanma;
	//要发送的邮箱模板
	private static String content= DevelperSetData.content;
	/**
	 * 发送邮箱消息的主题内容
	 * @param emailname
	 * @param code
	 */
	public static void sendEmail(String emailname,String code) {  
		  // 配置  
		  Properties prop=new Properties();  
		  // 设置邮件服务器主机名，这里是163  
		  prop.put("mail.host","smtp.163.com" );  
		  // 发送邮件协议名称  
		  prop.put("mail.transport.protocol", "smtp");  
		  // 是否认证  
		  prop.put("mail.smtp.auth", true);  
		  
		  try {  
		    // SSL加密  
		    MailSSLSocketFactory sf = null;  
		    sf = new MailSSLSocketFactory();  
		    // 设置信任所有的主机  
		    sf.setTrustAllHosts(true);  
		    prop.put("mail.smtp.ssl.enable", "true");  
		    prop.put("mail.smtp.ssl.socketFactory", sf);  
		  
		    // 创建会话对象  
		    Session session = Session.getDefaultInstance(prop, new Authenticator() {  
		      // 认证信息，需要提供"用户账号","授权码"  
		      public PasswordAuthentication getPasswordAuthentication() {  
		        return new PasswordAuthentication(sendEmailAccount, shouquanma);  
		      }  
		    });  
		    // 是否打印出debug信息  
		    //session.setDebug(true);  
		  
		    // 创建邮件  
		    Message message = new MimeMessage(session);  
		    // 邮件发送者  
		    message.setFrom(new InternetAddress(sendEmailAccount));  
		    // 邮件接受者  
		    message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailname));  
		    // 邮件主题  
		    message.setSubject("激活邮件");  
		    
		    message.setContent(content, "text/html;charset=UTF-8");  
		    // Transport.send(message);  
		    // 邮件发送  
		    Transport transport = session.getTransport();  
		    transport.connect();  
		    transport.sendMessage(message, message.getAllRecipients());  
		    transport.close();  
		  } catch (Exception e) {  
		    e.printStackTrace();  
		  }  
		}  
}
