package smsService;

import Model.SmsConfigModel;

public class SmsConfigImpl implements SmsConfig {
	
	public SmsConfigModel getSmsConfig() {
		SmsConfigModel smsConfig = new SmsConfigModel("+12513194777", "AC9b008a269ce60627da388af0a742bd99", "639b6d8646ac947b667aeeb5f8db9fb2");
		return smsConfig;
	}

}
