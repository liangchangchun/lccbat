package com.lcc.lccshot.core.map2sql.enums;

public enum FuncType {
	CONCAT("CONCAT","mysql","不等于");
	
	private String funcName;
	private String dbtype;
	private String comment;
	
	FuncType(String funcName,String dbtype, String comment){
		this.funcName = funcName;
		this.dbtype = dbtype;
		this.comment = comment;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String getDbtype() {
		return dbtype;
	}

	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}

