package com.music.mails;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class RegistrationMailSending implements Runnable{

	private String toEmailAddress;
	
	public RegistrationMailSending(String toEmailAddress) {
		this.toEmailAddress = toEmailAddress;
	}

	@Override
	public void run() {
		Properties props = System.getProperties();
		
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", MailConstants.GMAIL_HOST);
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.port", "587");
		
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthenticator() {
				return new PasswordAuthentication(MailConstants.ADMIN_USER_ADDRESS, MailConstants.PASSWORD);
			}
		};
		
		Session session = Session.getInstance(props, auth);
		
		MailConfigurationUtil.sendMessage(session, toEmailAddress, "test subject", "test body");
		
	}
	
	
}
