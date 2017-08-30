package thread;

/**
 * 子线程 10次与主线程 100次来回循环执行50次
 * @author Administrator
 *
 */
public class ThreadInterViewTest {

	public static void main (String[] args) {
		final Bussiness bu = new Bussiness();
		for (int i=0 ; i<5 ; i++ ) {
			Thread t1 = new Thread(new Runnable() {
				public void run() {
				bu.sub();
				}
			});
			t1.start();
		
			bu.main();
		}
	}
	
	
	
}

class Bussiness {
	public static boolean shouldSub = true;
	
	public synchronized void sub(){
		if (!shouldSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			this.notify();
		}
		for (int i=0;i<5;i++) {
			System.out.println("sub线程 "+Thread.currentThread().getName() + "执行第" + i + "次");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		shouldSub = false;
	}
	
	public synchronized void main(){
		if (shouldSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			this.notify();
		}
		
		for (int j=0;j<10;j++) {
			System.out.println("main线程 "+Thread.currentThread().getName() + "执行第" + j + "次");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
			}
		shouldSub = true;
	}


}
