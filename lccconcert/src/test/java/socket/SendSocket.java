package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SendSocket {

	public static void main(String[] args){
		try {
			Socket socket =new Socket("127.0.0.1",8000);
			
			BufferedReader br = new BufferedReader(new FileReader("gg.txt"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String line=null;
			while((line= br.readLine())!=null){//阻塞
				if ("886".equals(line)) {
						break;
					}
			 	bw.write(line);
			 	bw.newLine();
			 	bw.flush();
			}
			
			//释放资源
			br.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
