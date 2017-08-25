package com.lcc.lccshot.base.template.codeengine;

import java.util.List;

public abstract class ABaseConfig {
    private String packageName;//包名称
    private List<String> imports;//所引入的包
    
    public ABaseConfig(){
	 
    }
    
   public abstract void init();
    
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public List<String> getImports() {
		return imports;
	}
	public void setImports(List<String> imports) {
		this.imports = imports;
	}
    
    
}
