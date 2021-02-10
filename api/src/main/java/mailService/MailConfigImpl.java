package mailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import Model.MailConfigModel;

public class MailConfigImpl implements MailConfig {
	
	@Autowired
	private Environment env;
	
	public MailConfigModel getMailConfig() {
		
		MailConfigModel mailConfig = new MailConfigModel(env.getProperty("app.mail"), env.getProperty("app.mailServer"), Integer.parseInt(env.getProperty("app.mailPort")), env.getProperty("app.mailUser"), env.getProperty("app.mailPw"), "smtp", "true", "true", "true");
		return mailConfig;
	}

}
