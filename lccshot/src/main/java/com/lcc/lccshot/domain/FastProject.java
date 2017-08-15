package com.lcc.lccshot.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FastProject implements Serializable {

	private static final long serialVersionUID = 902266248924723666L;
	
	@Id
	@GeneratedValue
	private Integer projectId;
	/**
	 * 项目名称
	 */
	@Column(nullable = false, length = 32)
	private String projectName;
	/**
	 * 业务名称
	 */
	@Column(nullable = false, length = 32)
	private String businessName;
	/**
	 * 项目描述
	 */
	@Column(length = 200)
	private String description;
	/**
	 * 项目模板
	 */
	private Integer projectTemplateId;
	/**
	 * 项目类型
	 */
	private Integer projectType;
	 /**
     * 创建时间
     */
	private Date createtime;
	
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getProjectTemplateId() {
		return projectTemplateId;
	}
	public void setProjectTemplateId(Integer projectTemplateId) {
		this.projectTemplateId = projectTemplateId;
	}
	public Integer getProjectType() {
		return projectType;
	}
	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	
	
}
