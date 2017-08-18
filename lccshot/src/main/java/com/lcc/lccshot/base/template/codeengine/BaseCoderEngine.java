package com.lcc.lccshot.base.template.codeengine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import com.lcc.lccshot.base.template.config.CodeConfig;
import com.lcc.lccshot.utils.ToolUtil;

public abstract class BaseCoderEngine {
	
	protected CodeConfig config = new CodeConfig();
	protected CoderFace face;

	protected GroupTemplate groupTemplate;
	
	public BaseCoderEngine(CodeConfig codeConfig){
		init();
		this.config = codeConfig;
	}

	public void init(){
		initBeetlEngine();
	}
	
	 public void initBeetlEngine() {
	        Properties properties = new Properties();
	        properties.put("RESOURCE.root", "");
	        properties.put("DELIMITER_STATEMENT_START", "<%");
	        properties.put("DELIMITER_STATEMENT_END", "%>");
	        properties.put("HTML_TAG_FLAG", "##");
	        Configuration cfg = null;
	        try {
	            cfg = new Configuration(properties);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
	        groupTemplate = new GroupTemplate(resourceLoader, cfg);
	        groupTemplate.registerFunctionPackage("tool", new ToolUtil());
	    }

	    public void createFile(String template,String filePath){
	        Template pageTemplate = groupTemplate.getTemplate(template);
	        configTemplate(pageTemplate);
	        File file = new File(filePath);
	        File parentFile = file.getParentFile();
	        if(!parentFile.exists()){
	            parentFile.mkdirs();
	        }
	        try {
	            pageTemplate.renderTo(new FileOutputStream(file));
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	   
		 public abstract void configTemplate(Template template);
		 
		public void start() {
		    	face.createPageEditHtml();
		    	face.createPageAddHtml();
		    	face.createPageHtml();
		    	face.createPageInfoJs();
		    	face.createPageJs();
		    	face.createController();
		    	face.createIService();
		    	face.createServiceImpl();
		    	face.createDao();
		    	face.createDomain();
		}
}
