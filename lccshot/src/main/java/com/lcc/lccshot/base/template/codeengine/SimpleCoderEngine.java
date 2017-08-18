package com.lcc.lccshot.base.template.codeengine;

import java.util.List;

import org.beetl.core.Template;

import com.google.common.collect.Lists;
import com.lcc.lccshot.base.template.config.CodeConfig;
import com.lcc.lccshot.base.template.config.CoderDomain;
import com.lcc.lccshot.base.template.config.ControllerConfig;
import com.lcc.lccshot.base.template.config.DomainConfig;
import com.lcc.lccshot.base.template.config.IServiceConfig;
import com.lcc.lccshot.base.template.config.RepositoryConfig;
import com.lcc.lccshot.base.template.config.ServiceImplConfig;
import com.lcc.lccshot.base.template.enums.ColumnType;
import com.lcc.lccshot.utils.ToolUtil;


public class SimpleCoderEngine extends BaseCoderEngine implements CoderFace {

	public SimpleCoderEngine(CodeConfig codeConfig ) {
		super(codeConfig);
		super.face = this;
	}

	@Override
	public void configTemplate(Template template) {
		 template.binding("context", config);
		 template.binding("controller", new ControllerConfig());
		 template.binding("iService", new IServiceConfig());
		 template.binding("serviceImpl", new ServiceImplConfig());
		 template.binding("repository", new RepositoryConfig());
		 DomainConfig domainConfig = new DomainConfig();
		 String[] values = config.getDomainValues().split(";");
		 List<CoderDomain> domains = Lists.newArrayList();
		 
		 if(!ToolUtil.isEmpty(values)){
			 for(String str:values){
				 String[] prop = str.split(":");
				 CoderDomain domain = new CoderDomain();
				 domain.setColumnName(prop[0]);
				 domain.setColumn(prop[1]);
				 domain.setType(ColumnType.valueOf(Integer.parseInt(prop[2]) + 1));
				 if(ToolUtil.isEmpty(prop[3])){
					 domain.setLength(prop[3]);
				 }else{
					 domain.setLength(prop[3]);
				 }
			 }
		 }
		 
		 domainConfig.setCdomains(domains);
		 template.binding("domain", domainConfig);
	}

	@Override
	public void createPageEditHtml( ) {
		// "codeTemplate/page_edit.html.btl";
		 String path = ToolUtil.format(config.getProjectPath() + config.getPageEditPathTemplate(),
				 config.getBizEnName(),config.getBizEnName());
	        createFile("codeTemplate/page_edit.html.btl", path);
	        System.out.println("生成编辑页面成功!");
	}

	@Override
	public void createPageAddHtml() {
		// "codeTemplate/page_add.html.btl";
		   String path = ToolUtil.format(config.getProjectPath() + config.getPageAddPathTemplate(),
				   config.getBizEnName(),config.getBizEnName());
		   createFile("codeTemplate/page_add.html.btl", path);
	        System.out.println("生成添加页面成功!");
	}

	@Override
	public void createPageHtml() {
		// "codeTemplate/page.html.btl";
		  String path = ToolUtil.format(config.getProjectPath() + config.getPagePathTemplate(),
				  config.getBizEnName(),config.getBizEnName());
		  createFile("codeTemplate/page.html.btl", path);
	      System.out.println("生成页面成功!");
	}

	@Override
	public void createPageInfoJs() {
		// "codeTemplate/page_info.js.btl";
	     String path = ToolUtil.format(config.getProjectPath() + config.getPageInfoJsPathTemplate(),
	    		 config.getBizEnName(),config.getBizEnName());
	     createFile("codeTemplate/page_info.js.btl", path);
	        System.out.println("生成页面详情js成功!");
	}

	@Override
	public void createPageJs() {
		// "codeTemplate/page.js.btl";
		  String path = ToolUtil.format(config.getProjectPath() + config.getPageJsPathTemplate(),
				  config.getBizEnName(),config.getBizEnName());
		  createFile("codeTemplate/page.js.btl", path);
	        System.out.println("生成页面js成功!");
	}

	@Override
	public void createController() {
		// "codeTemplate/Controller.java.btl";
		String path = ToolUtil.format(config.getProjectPath() + config.getControllerPathTemplate(),
                ToolUtil.firstLetterToUpper(config.getBizEnName()));
		createFile("codeTemplate/Controller.java.btl", path);
        System.out.println("生成控制器成功!");
	}


	@Override
	public void createServiceImpl() {
		// TODO Auto-generated method stub
		String path = ToolUtil.format(config.getProjectPath() + config.getServiceImplPathTemplate(),
                ToolUtil.firstLetterToUpper(config.getBizEnName()));
		createFile("codeTemplate/ServiceImpl.java.btl", path);
        System.out.println("生成Service实现类成功!");
	}

	@Override
	public void createIService() {
		// TODO Auto-generated method stub
		String path = ToolUtil.format(config.getProjectPath() + config.getiServicePathTemplate(),
                ToolUtil.firstLetterToUpper(config.getBizEnName()));
		createFile("codeTemplate/IService.java.btl", path);
        System.out.println("生成Service接口成功!");
	}
	
	@Override
	public void createDao() {
		// "codeTemplate/Repository.java.btl";
		String path = ToolUtil.format(config.getProjectPath() + config.getRepositoryPathTemplate(),
                ToolUtil.firstLetterToUpper(config.getBizEnName()));
		createFile("codeTemplate/Repository.java.btl", path);
        System.out.println("生成Dao成功!");
	}
	
	@Override
	public void createDomain() {
		// "codeTemplate/Repository.java.btl";
		String path = ToolUtil.format(config.getProjectPath() + config.getDomainPathTemplate(),
                ToolUtil.firstLetterToUpper(config.getDomainName()));
		createFile("codeTemplate/Domain.java.btl", path);
        System.out.println("生成实体类成功!");
	}
}
