package com.music.mails;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailConfigurationUtil {

	
	public static void sendMessage(Session session, String toAddress,
			String subject, String body) {
		
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			
			msg.setFrom(new InternetAddress(MailConstants.ADMIN_USER_ADDRESS));
//			msg.setReplyTo(InternetAddress.parse(MailConstants.ADMIN_USER_ADDRESS, false));
			
			msg.setSubject(subject, MailConstants.MAIL_SUBJECT_ENCODING);
			msg.setText(body, MailConstants.MAIL_BODY_ENCODING);
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress, false));
			
			System.out.println("Message is being sent!!!");
			
			Transport.send(msg);
			
		} catch(MessagingException e) {
			System.out.println(e.getMessage());
		}
	}
}
