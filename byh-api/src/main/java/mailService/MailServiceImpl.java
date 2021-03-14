package mailService;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import Model.MailConfigModel;

public class MailServiceImpl implements MailService {
	private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	
	public void config(MailConfigModel mailConfig) {
		mailSender.setHost(mailConfig.getHost());
		mailSender.setPort(mailConfig.getPort());
		  
		mailSender.setUsername(mailConfig.getUsername());
		mailSender.setPassword(mailConfig.getPassword());
		 
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", mailConfig.getProtocol());
		props.put("mail.smtp.auth", mailConfig.getAuth());
		props.put("mail.smtp.starttls.enable", mailConfig.getStarttls());
		props.put("mail.debug", mailConfig.getDebug());
	}
	
	public boolean send(String from, String to, String subject, String text, int tan) {
    	return send(from, to, subject, text + tan);
    }
	
	public boolean send(String from, String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
	        
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
	 
		try {
			// Send Message
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}