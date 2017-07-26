package com.lcc.lccshot.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FastProject implements Serializable {

	private static final long serialVersionUID = 902266248924723666L;
	
	@Id
	@GeneratedValue
	private Integer projectId;
}
