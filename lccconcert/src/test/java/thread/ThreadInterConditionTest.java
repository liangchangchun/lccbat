package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 子线程 10次与主线程 100次来回循环执行50次
 * @author Administrator
 *
 */
public class ThreadInterConditionTest {

	public static void main (String[] args) {
		final Bussine bu = new Bussine();
		
			Thread t1 = new Thread(new Runnable() {
				public void run() {
					for (int i=0 ; i<5 ; i++ ) {
						bu.sub();
					}
				}
			});
			t1.start();
		for (int i=0 ; i<5 ; i++ ) {
			bu.main();
		}
	}
	
	
	
}

class Bussine {
	public static boolean shouldSub = true;
	
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition(); //Condition是在具体的lock之上的
	
	public void sub(){
		try{
		lock.lock();
		while (!shouldSub) {
			try {
				condition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
			condition.signal();
		} finally{
			lock.unlock();
		}
	}
	
	public void main(){
		try{
			lock.lock();
		while (shouldSub) {
			try {
				condition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			condition.signal();
		} finally{
			lock.unlock();
		}
	}


}
