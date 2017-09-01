package thread.hm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueCommunication {
	
	public static void main(String[] args){
		final RunController controller = new RunController();
	    Thread t = new Thread(new Runnable() {
			
			public void run() {
				for (int i=0;i<10;i++) {
					controller.state1(i);
				}
			}
		});
	    t.start();
	    
	    for (int i=0;i<10;i++) {
	    	controller.state2(i);
		}
	}

	static class RunController{
		
		BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<Integer>(1);
		BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<Integer>(1);
		{
			try {
				System.out.println("初始化");
				queue2.put(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void state1(int i){
			try {
				queue1.put(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int j=0;j < 10;j++){
				System.out.println("线程1 sequece of " + j + ",loop of " + i);
			}
			
			try {
				queue2.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void state2(int i){
			try {
				queue2.put(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int j=0;j < 20;j++){
				System.out.println("线程2 sequece of " + j + ",loop of " + i);
			}
			
			try {
				queue1.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
