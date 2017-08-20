package com.lcc.lccshot.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Templater 实体类
 *
 * @author liangchangchun
 * @Date 2017-08-20 22:40:52
 */

@Entity
public class Templater implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer templaterId;
	
	/**
     * 创建时间
     */
	private Date createTime;
	/**
     * 修改时间
     */
	private Date updateTime;
	
	
	/**
     * 模板名称
     */
	private String templaterName;
	
	public String getTemplaterName() {
		return this.templaterName;
	}

	public void setTemplaterName(String templaterName) {
		this.templaterName = templaterName;
	}
	/**
     * 模板类型
     */
	private String templaterType;
	
	public String getTemplaterType() {
		return this.templaterType;
	}

	public void setTemplaterType(String templaterType) {
		this.templaterType = templaterType;
	}
	
	public Integer getTemplaterId() {
		return templaterId;
	}
	public void setTemplaterId(Integer templaterId) {
		this.templaterId = templaterId;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
