package mailService;

import Model.MailConfigModel;

public class MailConfigImpl implements MailConfig {
	
	public MailConfigModel getMailConfig() {
		//Email, user und passwort eintragen
		MailConfigModel mailConfig = new MailConfigModel("email", "mail.spengergasse.at", 587, "htl-wien5\\user", "passwort", "smtp", "true", "true", "true");
		return mailConfig;
	}

}
