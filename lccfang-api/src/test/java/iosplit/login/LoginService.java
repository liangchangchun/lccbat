package iosplit.login;

public class LoginService {

	private LoginDao dao ;
	
	  private static Object object=new Object();
	
	public int register(String username,String password){
		int res =0;
		synchronized (object) {
			 res = dao.register(username, password);
		}
		return res;
	}

	public LoginDao getDao() {
		return dao;
	}

	public void setDao(LoginDao dao) {
		this.dao = dao;
	}
	
	public LoginService(LoginDao dao ){
		this.dao = dao;
	}
	
}
