package com.es.hmc.constant.tips;

/**
 * 返回给前台的提示（最终转化为json形式）
 *
 * @author fengshuonan
 * @Date 2017年1月11日 下午11:58:00
 */
public abstract class Tip {

    protected int code;
    protected String message;
    protected String content;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    
    
}
