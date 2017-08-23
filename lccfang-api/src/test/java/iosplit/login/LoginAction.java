package iosplit.login;

public class LoginAction implements Runnable{
	
	private LoginService service;

	public int register(String username,String password){
		return service.register(username, password);
	}

	public LoginService getService() {
		return service;
	}

	public void setService(LoginService service) {
		this.service = service;
	}
	
	public LoginAction(LoginService service){
		this.service = service;
	}

	public void run() {
		
	}
	
	
}
