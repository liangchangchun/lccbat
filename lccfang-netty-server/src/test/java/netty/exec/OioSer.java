package netty.exec;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OioSer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ExecutorService executorCacheThreadPool = Executors.newCachedThreadPool();
		
		ServerSocket server = new ServerSocket(8888);
		System.out.println("服务器启动!");
		while (true) {
			final Socket socket = server.accept();
			System.out.println("来一个新客户端!");
			executorCacheThreadPool.execute(new Runnable() {
				public void run() {
					//业务处理
					handler(socket);
				}
			});
		}
	}
	
	public static void handler(Socket socket){
		try{
			byte[] bytes = new byte[1024];
			InputStream input = socket.getInputStream();
			while (true) {
				int read = input.read(bytes);
				if (read != -1) {
					System.out.println(new String(bytes,0,read));
				} else {
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			System.out.println("关闭socket");
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
