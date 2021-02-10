package Model;

public class MailConfigModel {
	private String from;
	private String host;
	private int port;
	private String username;
	private String password;
	private String protocol;
	private String auth;
	private String starttls;
	private String debug;
	
	public MailConfigModel() {}
	
	public MailConfigModel(String from, String host, int port, String username, String password, String protocol,	String auth, String starttls, String debug) {
		this.from = from;
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
		this.protocol = protocol;
		this.auth = auth;
		this.starttls = starttls;
		this.debug = debug;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getStarttls() {
		return starttls;
	}
	public void setStarttls(String starttls) {
		this.starttls = starttls;
	}
	public String getDebug() {
		return debug;
	}
	public void setDebug(String debug) {
		this.debug = debug;
	}
}
