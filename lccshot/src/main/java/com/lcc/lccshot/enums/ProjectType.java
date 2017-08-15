package com.lcc.lccshot.enums;

public enum ProjectType {
	JAVA(0, "java项目"),
    GO(1, "go项目");//不是菜单的是按钮

    int code;
    String message;

    ProjectType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String valueOf(Integer status) {
        if (status == null) {
            return "";
        } else {
            for (ProjectType s : ProjectType.values()) {
                if (s.getCode() == status) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
