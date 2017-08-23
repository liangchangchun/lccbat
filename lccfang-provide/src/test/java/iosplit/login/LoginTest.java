package iosplit.login;


public class LoginTest {

	public static void main(String[] args){
		// LoginAction action = new LoginAction();
		
		//service.setDao(dao);
		//action.setService(service);
		final LoginDao dao = new LoginDao();
		final LoginService service = new LoginService(dao);
		final LoginService service1 = new LoginService(dao);
		
		for(int i=0;i<100;i++){
			Thread t1 = new Thread(new LoginAction(service){

			public void run() {
				
				this.getService().register("15072364425", "123456");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			});
			t1.start();
		}
		
		for(int i=0;i<100;i++){
			Thread t2 = new Thread(new LoginAction(service1){

			public void run() {
				
				this.getService().register("15072364425", "123456");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			});
			t2.start();
		}
		
	}
}
