package com.es.hmc.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ParticipleController {
    private static final Logger logger= LoggerFactory.getLogger("LOGGER.PARTICIPLE");
    
	//public static final String dic_path = System.getProperty("user.dir") + "/learnbuycar.dic";
    public static final String dic_path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/learnbuycar.dic";
	
    @RequestMapping(value = "/es/participle", method = RequestMethod.GET)
    public Object searchCity(String sContent) {
    	//String path =   ClassUtils.getDefaultClassLoader().getResource("").getPath();
    	//System.out.println(path);
    	if (sContent!=null && !sContent.equals("")) {
    		addWord(sContent);
    	}
        return sContent;
    }
    
    private void addWord(String sContent){
    	//String filepath = System.getProperty("user.dir");
    	//System.out.println(filepath);
    	BufferedReader br = null;
    	BufferedWriter bw = null;
    	boolean has = true;
		try {
    	br = new BufferedReader(new InputStreamReader(new FileInputStream(dic_path)));
    	bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dic_path+".tp")));
    	String line="";
    	
		while((line= br.readLine())!=null){
			bw.write(line.trim());
		 	bw.newLine();
		 	bw.flush();
		 		if (line.equals(sContent)) {
		 			has = false;
		 		}
		}
		if (has) {
			bw.write(sContent.trim());
		 	bw.newLine();
		 	bw.flush();
		}
			} catch (Exception e) {
			e.printStackTrace();
			}finally {//关闭流
				try {
					if(bw!=null) 
						bw.close();
				} catch (IOException e) {
					logger.error("BufferedReader br 输入流关闭异常");
				}
			try {
				if(br!=null) 
				br.close();
			} catch (IOException e) {
				logger.error("BufferedWriter bw 输出流关闭异常");
			}
		}
		
		if (has) {
			copyFile(dic_path+".tp",dic_path);
			logger.info("写入新词:【"+sContent+"】成功!词库路径:"+dic_path);
		} else {
			logger.info("【"+sContent+"】词库已存在该词.词库路径:"+dic_path);
		}
		
    }
    
    private void copyFile(String oldpath,String newpath){
    	BufferedReader br = null;
    	BufferedWriter bw = null;
		try {
    	br = new BufferedReader(new InputStreamReader(new FileInputStream(oldpath)));
    	bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newpath)));
    	String line="";
		while((line= br.readLine())!=null){
			bw.write(line);
		 	bw.newLine();
		 	bw.flush();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//关闭流
			try {
				if(bw!=null) 
				bw.close();
			} catch (IOException e) {
				logger.error("BufferedReader br 输入流关闭异常");
			}
			try {
				if(br!=null) 
				br.close();
			} catch (IOException e) {
				logger.error("BufferedWriter bw 输出流关闭异常");
			}
		}
    }
}
