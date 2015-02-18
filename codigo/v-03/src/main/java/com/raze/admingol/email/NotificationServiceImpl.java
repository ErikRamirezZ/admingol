package com.raze.admingol.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class NotificationServiceImpl implements NotificationService {

	private static final Logger log = LoggerFactory
			.getLogger(NotificationServiceImpl.class);

	@Autowired
	private MailSender mailSender;

	@Autowired
	private SimpleMailMessage simpleMailMessage;

	public void sendMessage(String mailTo, String message) {
		try {
			log.info("simpleMailMessage ===> " + simpleMailMessage + "\n\n");
			log.info("mailSender ===> " + mailSender + "\n\n");
			log.debug("NotificationServiceImpl:: sendMessage() called.");
			log.info("mailSender.toString() ===> " + mailSender.toString()
					+ "\n\n");
			SimpleMailMessage msg = new SimpleMailMessage(this.simpleMailMessage);
			msg.setTo(mailTo);
			msg.setText(message);
			mailSender.send(msg);			
		} catch(Exception e){
			log.info("Exception ===> " + e + "\n\n");
			log.info("Exception.toString() ===> " + e.toString() + "\n\n");
			log.info("Exception.getMessage() ===> " + e.getMessage() + "\n\n");
		}
	}
	
}
