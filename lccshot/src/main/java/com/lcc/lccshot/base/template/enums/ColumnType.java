package com.lcc.lccshot.base.template.enums;

public enum ColumnType {
	Varchar(1, "String"),
	Integer(2, "Integer"),
	Date(3, "Date"),
	Long(4, "long"),
	Short(5, "short");

    int code;
    String type;
    

    ColumnType(int code, String type) {
        this.code = code;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static String valueOf(Integer status) {
        if (status == null) {
            return "";
        } else {
            for (ColumnType s : ColumnType.values()) {
                if (s.getCode() == status) {
                    return s.getType();
                }
            }
            return "";
        }
    }
}
