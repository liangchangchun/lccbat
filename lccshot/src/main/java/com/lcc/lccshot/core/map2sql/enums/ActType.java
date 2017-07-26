package com.lcc.lccshot.core.map2sql.enums;

import com.lcc.lccshot.exception.BizExceptionEnum;
import com.lcc.lccshot.exception.BussinessException;

public enum ActType {
	
	BETWEEN("between","between", "区间判断"),
	LIKE("like","like", "模糊查询like"),
	NOT_LIKE("not like","not like","模糊查询like取反"),
	EQ("equals","=", "等于"),
	NOT_EQ("not equals","!=","不等于");
	
	private String name;
	private String value;
	private String comment;
	
	 ActType(){
		
	}
	
	ActType(String name,String value, String comment){
		this.name = name;
		this.value = value;
		this.comment = comment;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public static ConditionType getByName(String name){
		for(ConditionType conditionType : ConditionType.values()){
			if(conditionType.getValue().equals(name)){
				return conditionType;
			}
		}
		throw new BussinessException(BizExceptionEnum.TYPE_NOT_DEFINE);
	}
	
}
