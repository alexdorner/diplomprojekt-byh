package Model;

public class SmsConfigModel {
	private String from;
	private String accountSID;
	private String authToken;
	
	public SmsConfigModel() {}
	
	public SmsConfigModel(String from, String accountSID, String authToken) {
		this.from = from;
		this.accountSID = accountSID;
		this.authToken = authToken;
	}
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getAccountSID() {
		return accountSID;
	}

	public void setAccountSID(String accountSID) {
		this.accountSID = accountSID;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
}
