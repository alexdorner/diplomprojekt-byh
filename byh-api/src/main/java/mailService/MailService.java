package mailService;

import Model.MailConfigModel;

public interface MailService {
	public void config(MailConfigModel mail);
	public boolean send(String from, String to, String subject, String text, int tan);
	public boolean send(String from, String to, String subject, String text);
}
