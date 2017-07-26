package com.lcc.lccshot.core.map2sql.enums;

public enum RelationType {
	AND("and","逻辑关系并且"),
	OR("or","逻辑关系或者");
	
	private String name;
	private String value;
	
	RelationType(String name,String value){
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
