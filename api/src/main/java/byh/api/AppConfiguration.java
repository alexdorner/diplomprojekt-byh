package byh.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mailService.MailConfig;
import mailService.MailConfigImpl;
import mailService.MailService;
import mailService.MailServiceImpl;
import smsService.SmsConfig;
import smsService.SmsConfigImpl;
import smsService.SmsService;
import smsService.SmsServiceImpl;
import tanService.TanService;
import tanService.TanServiceImpl;

@Configuration
public class AppConfiguration {
	
	@Bean
	public SmsService smsServiceBean() {
		return new SmsServiceImpl();
	}
	
	@Bean
	public SmsConfig smsConfigBean() {
		return new SmsConfigImpl();
	}
	
	@Bean
	public MailService mailServiceBean() {
		return new MailServiceImpl();
	}
	
	@Bean
	public MailConfig mailConfigBean() {
		return new MailConfigImpl();
	}
	
	@Bean
	public TanService tanServiceBean() {
		return new TanServiceImpl();
	}

}
