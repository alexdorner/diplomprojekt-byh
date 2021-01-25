package smsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import Model.SmsConfigModel;

public class SmsConfigImpl implements SmsConfig {
	
	@Autowired
	private Environment env;
	
	public SmsConfigModel getSmsConfig() {
		SmsConfigModel smsConfig = new SmsConfigModel(env.getProperty("app.smsSender"), env.getProperty("app.smsAccountSID"), env.getProperty("app.smsAuthToken"));
		return smsConfig;
	}

}
