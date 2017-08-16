package com.lcc.lccshot.base.template.config;

import com.lcc.lccshot.utils.ToolUtil;

public class CodeConfig {

    private String projectPath = "D:\\lcc\\base";//模板默认输出的项目目录
    private String bizChName;   				 //业务名称
    private String bizEnName;   				 //业务英文名称
    private String bizEnBigName;				 //业务英文名称(大写)
    private String domainName;  				 //业务实体
    private String domainValues;				 //业务实体属性

    

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
		return ToolUtil.firstLetterToUpper(domainName);
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getDomainValues() {
		return domainValues;
	}

	public void setDomainValues(String domainValues) {
		this.domainValues = domainValues;
	}


    
    
}
