package com.Ashokit.utilities;

import org.hibernate.pretty.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class Emailutils {

	@Autowired
	private JavaMailSender mailsender;
	
	public boolean sendMail(String subject, String body, String to)
	{
		boolean isSent=false;
		
		
		try {
		MimeMessage msg=mailsender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(msg);
		
						helper.setTo(to);
						helper.setSubject(subject);
						helper.setText(body, true);
						
						mailsender.send(msg);
						
						isSent=true;
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return isSent;
	}
	
	
	
	
	
}
