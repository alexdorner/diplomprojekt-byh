package at.byh.sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {

	private String ACCOUNT_SID = "AC9b008a269ce60627da388af0a742bd99";
    private String AUTH_TOKEN = "639b6d8646ac947b667aeeb5f8db9fb2";

    public void senden(String text, String to) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber(to), // to
                        new PhoneNumber("+12513194777"), // from
                        text)
                .create();

        System.out.println(message.getSid());
    }
}
