package com.lcc.lccshot.base.template.config;

import com.lcc.lccshot.utils.ToolUtil;

public class CoderDomain {
	private String column;
	private String bigColumn;
	private String type;//字段类型
	private String columnName;
	private String length;
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
		this.bigColumn = ToolUtil.firstLetterToUpper(this.column);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getBigColumn() {
		return bigColumn;
	}
	public void setBigColumn(String bigColumn) {
		this.bigColumn = bigColumn;
	}
	
	
	
}
