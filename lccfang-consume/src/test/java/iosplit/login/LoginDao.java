package iosplit.login;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class LoginDao {

	public int register(String username,String password){
		
		String info ="xxxxxxxxxxxxxxxxxxxxxxxxxxxx注册成功:用户名"+username+":密码"+password;
		final File newFile = new File("f://infos.txt");
		try
	      {
				Thread.sleep(1000);
			List<String> list=Files.readLines(newFile, Charsets.UTF_8);
			for(String s:list){
				if(s.indexOf(info)==-1){
					//Files.write(info.getBytes(), newFile);
					Files.append(info, newFile, Charsets.UTF_8);
				}
			}
	      } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      catch (IOException fileIoEx)
	      {
	    	  System.out.println(  "ERROR trying to write to file '" + info + "' - "
	                     + fileIoEx.toString());
	      }
		return 1;
	}
}
