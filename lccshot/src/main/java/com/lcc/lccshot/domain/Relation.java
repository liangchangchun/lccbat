package com.lcc.lccshot.domain;

import java.io.Serializable;

import javax.persistence.Entity;
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
public class Relation implements Serializable{

	private static final long serialVersionUID = -4119636560525282143L;
	@Id
	@GeneratedValue
	private Integer id;
	private Integer menuid;
	private Integer roleid;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}


}
