package smsService;

import Model.SmsConfigModel;

public interface SmsService {
	public void config(SmsConfigModel smsConfig);
	public boolean send(String from, String to, String text, int tan);
}
