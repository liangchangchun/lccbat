package com.es.hmc.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
    
	public static final String dic_path_dic = "/data/app/els-file-static/learnbuycar.dic";
	public static final String dic_path_dic_tp = "/data/app/els-file-static/learnbuycar.dic.tp";
    public static final String dic_path = "/data/app/els-file-static/learnbuycarbase.dic";
	
    @RequestMapping(value = "/es/participle", method = RequestMethod.GET)
    public Object searchCity(String sContent)  {
    	//String path =   ClassUtils.getDefaultClassLoader().getResource("").getPath();
    	//System.out.println(path);
    	if (sContent!=null && !sContent.equals("")) {
    		logger.info("dic_path_dic:"+dic_path_dic);
    		logger.info("dic_path_dic_tp:"+dic_path_dic_tp);
    		logger.info("dic_path:"+dic_path);
    		try {
				addWord(sContent);
			} catch (IOException e) {
				logger.error("文件不存在异常"+e.getMessage());
			}
    	}
        return sContent;
    }
    
    private void addWord(String sContent) throws IOException{
    	//String filepath = System.getProperty("user.dir");
    	//System.out.println(filepath);
    	File f = new File(dic_path);
    	File  f1= new File(dic_path_dic_tp);
    	if (!f1.exists()) {
    		f1.createNewFile();
    	}
    	File  f2= new File(dic_path_dic);
    	if (!f2.exists()) {
    		f2.createNewFile();
    	}
    	BufferedReader br = null;
    	BufferedWriter bw = null;
    	boolean has = true;
		try {
    	br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
    	bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f2)));
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
			copyFile(dic_path_dic,dic_path);
			//copyFile(dic_path_dic_tp,dic_path);
			logger.info("写入新词:【"+sContent+"】成功!词库路径:"+dic_path_dic);
		} else {
			logger.info("【"+sContent+"】词库已存在该词.词库路径:"+dic_path_dic);
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
