package thread;

public class TranditionalThread {


	
	public static void main(String[] args){
		final Outputer out = new Outputer();
		
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.output("liangchangchun");
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.output("haohenhaofeichanghao");
			}
		}).start();
	}
	
}

class Outputer{
	
	public  void output(String carNumber){
		//synchronized (this) {
			int len = carNumber.length();
			for (int i=0;i<len;i++) {
				System.out.print(carNumber.charAt(i));
			}
			System.out.println("");
		//}		
	}
}