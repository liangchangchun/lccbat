package com.lcc.lccshot.base.template.config;

import com.lcc.lccshot.utils.ToolUtil;

public class CodeConfig {

    private String projectPath = "D:\\lcc\\base";//模板默认输出的项目目录
    private String basePackage = "com.lcc.lccshot";
    
    private String pagePathTemplate = "\\src\\main\\webapp\\WEB-INF\\view\\system\\{}\\{}.html";
    private String pageAddPathTemplate = "\\src\\main\\webapp\\WEB-INF\\view\\system\\{}\\{}_add.html";
    private String pageEditPathTemplate = "\\src\\main\\webapp\\WEB-INF\\view\\system\\{}\\{}_edit.html";
    private String pageJsPathTemplate = "\\src\\main\\webapp\\static\\modular\\system\\{}\\{}.js";
    private String pageInfoJsPathTemplate = "\\src\\main\\webapp\\static\\modular\\system\\{}\\{}_info.js";
    
    private String controllerPathTemplate = "\\src\\main\\java\\com\\lcc\\lccshot\\controller\\{}Controller.java";
    private String iServicePathTemplate = "\\src\\main\\java\\com\\lcc\\lccshot\\service\\I{}Service.java";
    private String serviceImplPathTemplate = "\\src\\main\\java\\com\\lcc\\lccshot\\service\\impl\\{}ServiceImpl.java";
	private String repositoryPathTemplate = "\\src\\main\\java\\com\\lcc\\lccshot\\repository\\{}Repository.java";
	private String domainPathTemplate = "\\src\\main\\java\\com\\lcc\\lccshot\\domain\\{}.java";
	private String warpperPathTemplate = "\\src\\main\\java\\com\\lcc\\lccshot\\base\\warpper\\{}Warpper.java";
	
	
    private String bizChName;   				 //业务名称
    private String bizEnName;   				 //业务英文名称
    private String bizEnBigName;				 //业务英文名称(大写)
    private String domainName;  				 //业务实体
    private String domainBigName;  				 //业务实体
    private String domainValues;				 //业务实体属性

    public String getPagePathTemplate() {
        return pagePathTemplate;
    }

    public void setPagePathTemplate(String pagePathTemplate) {
        this.pagePathTemplate = pagePathTemplate;
    }

    public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getPageJsPathTemplate() {
        return pageJsPathTemplate;
    }

    public void setPageJsPathTemplate(String pageJsPathTemplate) {
        this.pageJsPathTemplate = pageJsPathTemplate;
    }

    public String getPageAddPathTemplate() {
        return pageAddPathTemplate;
    }

    public void setPageAddPathTemplate(String pageAddPathTemplate) {
        this.pageAddPathTemplate = pageAddPathTemplate;
    }

    public String getPageEditPathTemplate() {
        return pageEditPathTemplate;
    }

    public void setPageEditPathTemplate(String pageEditPathTemplate) {
        this.pageEditPathTemplate = pageEditPathTemplate;
    }

    public String getPageInfoJsPathTemplate() {
        return pageInfoJsPathTemplate;
    }

    public void setPageInfoJsPathTemplate(String pageInfoJsPathTemplate) {
        this.pageInfoJsPathTemplate = pageInfoJsPathTemplate;
    }

    public String getBizEnBigName() {
        return bizEnBigName;
    }

    public void setBizEnBigName(String bizEnBigName) {
        this.bizEnBigName = bizEnBigName;
    }

    public String getBizChName() {
        return bizChName;
    }

    public void setBizChName(String bizChName) {
        this.bizChName = bizChName;
    }

    public String getBizEnName() {
        return bizEnName;
    }

    public void setBizEnName(String bizEnName) {
        this.bizEnName = bizEnName;
        this.bizEnBigName = ToolUtil.firstLetterToUpper(this.bizEnName);
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
		this.domainBigName = ToolUtil.firstLetterToUpper(this.domainName);
	}

	public String getDomainValues() {
		return domainValues;
	}
	
	public String getDomainBigName() {
		return domainBigName;
	}

	public void setDomainBigName(String domainBigName) {
		this.domainBigName = domainBigName;
	}

	public void setDomainValues(String domainValues) {
		this.domainValues = domainValues;
	}

	public String getControllerPathTemplate() {
		return controllerPathTemplate;
	}

	public void setControllerPathTemplate(String controllerPathTemplate) {
		this.controllerPathTemplate = controllerPathTemplate;
	}

	public String getiServicePathTemplate() {
		return iServicePathTemplate;
	}

	public void setiServicePathTemplate(String iServicePathTemplate) {
		this.iServicePathTemplate = iServicePathTemplate;
	}

	public String getServiceImplPathTemplate() {
		return serviceImplPathTemplate;
	}

	public void setServiceImplPathTemplate(String serviceImplPathTemplate) {
		this.serviceImplPathTemplate = serviceImplPathTemplate;
	}

	public String getRepositoryPathTemplate() {
		return repositoryPathTemplate;
	}

	public void setRepositoryPathTemplate(String repositoryPathTemplate) {
		this.repositoryPathTemplate = repositoryPathTemplate;
	}

	public String getDomainPathTemplate() {
		return domainPathTemplate;
	}

	public void setDomainPathTemplate(String domainPathTemplate) {
		this.domainPathTemplate = domainPathTemplate;
	}

	public String getWarpperPathTemplate() {
		return warpperPathTemplate;
	}

	public void setWarpperPathTemplate(String warpperPathTemplate) {
		this.warpperPathTemplate = warpperPathTemplate;
	}

    
    
}
