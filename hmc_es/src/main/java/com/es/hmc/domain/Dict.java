package com.es.hmc.domain;

import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng
 * @since 2017-06-13
 */
public class Dict implements Serializable{

	private static final long serialVersionUID = -4773250600192270375L;
	
	private Integer id;
	private Integer num;
	private Integer pid;
	private String name;
	private String tips;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}


}
