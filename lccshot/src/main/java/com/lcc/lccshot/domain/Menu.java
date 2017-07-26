package com.lcc.lccshot.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng
 * @since 2017-06-13
 */
@Entity
public class Menu implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3982769490933898192L;
	@Id
	@GeneratedValue
	private Integer id;
    /**
     * 菜单编号
     */
	private String code;
    /**
     * 菜单父编号
     */
	private String pcode;
    /**
     * 菜单名称
     */
	@Column(name="name",columnDefinition="varchar(255)")
	private String name;
    /**
     * 菜单图标
     */
	@Column(name="icon",columnDefinition="varchar(255)")
	private String icon;
    /**
     * url地址
     */
	@Column(name="url",columnDefinition="varchar(255)")
	private String url;
    /**
     * 菜单排序号
     */
	private Integer num;
    /**
     * 菜单层级
     */
	private Integer levels;
	private Integer ismenu;
    /**
     * 备注
     */
	private String tips;
    /**
     * 菜单状态 :  1:启用   0:不启用
     */
	private Integer status;
    /**
     * 是否打开:    1:打开   0:不打开
     */
	private Integer isopen;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getLevels() {
		return levels;
	}

	public void setLevels(Integer levels) {
		this.levels = levels;
	}

	public Integer getIsmenu() {
		return ismenu;
	}

	public void setIsmenu(Integer ismenu) {
		this.ismenu = ismenu;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsopen() {
		return isopen;
	}

	public void setIsopen(Integer isopen) {
		this.isopen = isopen;
	}

}
