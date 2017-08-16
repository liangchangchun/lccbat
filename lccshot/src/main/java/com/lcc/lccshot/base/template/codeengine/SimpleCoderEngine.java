package com.lcc.lccshot.base.template.codeengine;

import org.beetl.core.Template;

import com.lcc.lccshot.base.template.config.CodeConfig;
import com.lcc.lccshot.base.template.config.ControllerConfig;
import com.lcc.lccshot.base.template.config.DomainConfig;
import com.lcc.lccshot.base.template.config.IServiceConfig;
import com.lcc.lccshot.base.template.config.RepositoryConfig;
import com.lcc.lccshot.base.template.config.ServiceImplConfig;
import com.lcc.lccshot.utils.ToolUtil;


public class SimpleCoderEngine extends BaseCoderEngine implements CoderFace {

	public SimpleCoderEngine(CodeConfig codeConfig, CoderFace coderface) {
		super(codeConfig, coderface);
	}

	@Override
	public void configTemplate(Template template) {
		 template.binding("CodeConfig", config);
		 template.binding("Controller", new ControllerConfig());
		 template.binding("IService", new IServiceConfig());
		 template.binding("ServiceImpl", new ServiceImplConfig());
		 template.binding("Repository", new RepositoryConfig());
		 template.binding("Domain", new DomainConfig());
	}

	@Override
	public void createPageEditHtml( ) {
		// "codeTemplate/page_edit.html.btl";
		 String path = ToolUtil.format(config.getProjectPath() + config.getPageEditPathTemplate(),
				 config.getBizEnName(),config.getBizEnName());
	        createFile("gunsTemplate/page_edit.html.btl", path);
	        System.out.println("生成编辑页面成功!");
	}

	@Override
	public void createPageAddHtml() {
		// "codeTemplate/page_add.html.btl";
		   String path = ToolUtil.format(config.getProjectPath() + config.getPageAddPathTemplate(),
				   config.getBizEnName(),config.getBizEnName());
		   createFile("gunsTemplate/page_add.html.btl", path);
	        System.out.println("生成添加页面成功!");
	}

	@Override
	public void createPageHtml() {
		// "codeTemplate/page.html.btl";
		  String path = ToolUtil.format(config.getProjectPath() + config.getPagePathTemplate(),
				  config.getBizEnName(),config.getBizEnName());
		  createFile("gunsTemplate/page.html.btl", path);
	      System.out.println("生成页面成功!");
	}

	@Override
	public void createPageInfoJs() {
		// "codeTemplate/page_info.js.btl";
	     String path = ToolUtil.format(config.getProjectPath() + config.getPageInfoJsPathTemplate(),
	    		 config.getBizEnName(),config.getBizEnName());
	     createFile("gunsTemplate/page_info.js.btl", path);
	        System.out.println("生成页面详情js成功!");
	}

	@Override
	public void createPageJs() {
		// "codeTemplate/page.js.btl";
		  String path = ToolUtil.format(config.getProjectPath() + config.getPageJsPathTemplate(),
				  config.getBizEnName(),config.getBizEnName());
		  createFile("gunsTemplate/page.js.btl", path);
	        System.out.println("生成页面js成功!");
	}

	@Override
	public void createController() {
		// "codeTemplate/Controller.java.btl";
		String controllerPath = ToolUtil.format(config.getProjectPath() + config.getControllerPathTemplate(),
                ToolUtil.firstLetterToUpper(config.getBizEnName()));
		createFile("gunsTemplate/Controller.java.btl", controllerPath);
        System.out.println("生成控制器成功!");
	}


	@Override
	public void createDao() {
		// "codeTemplate/Repository.java.btl";
		String controllerPath = ToolUtil.format(config.getProjectPath() + config.getRepositoryPathTemplate(),
                ToolUtil.firstLetterToUpper(config.getBizEnName()));
		createFile("gunsTemplate/Controller.java.btl", controllerPath);
        System.out.println("生成控制器成功!");
	}

	@Override
	public void createServiceImpl() {
		// TODO Auto-generated method stub
		String controllerPath = ToolUtil.format(config.getProjectPath() + config.getServiceImplPathTemplate(),
                ToolUtil.firstLetterToUpper(config.getBizEnName()));
		createFile("gunsTemplate/Controller.java.btl", controllerPath);
        System.out.println("生成控制器成功!");
	}

	@Override
	public void createIService() {
		// TODO Auto-generated method stub
		String controllerPath = ToolUtil.format(config.getProjectPath() + config.getiServicePathTemplate(),
                ToolUtil.firstLetterToUpper(config.getBizEnName()));
		createFile("gunsTemplate/Controller.java.btl", controllerPath);
        System.out.println("生成控制器成功!");
	}

}
