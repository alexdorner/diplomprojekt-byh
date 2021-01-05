package smsService;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import Model.SmsConfigModel;

public class SmsServiceImpl implements SmsService {

	public void config(SmsConfigModel smsConfig) {
    	Twilio.init(smsConfig.getAccountSID(), smsConfig.getAuthToken());
    }

    public boolean send(String from, String to, String text, int tan) {
    	try {
	        Message message = Message
	        		.creator(new PhoneNumber(to),
	        				new PhoneNumber(from),
	        				text)
	        		.create();
	
	        System.out.println(message.getSid());
    	} catch (Exception e) {
    		e.printStackTrace();
			return false;
		}
    	
    	return true;
    }
}
