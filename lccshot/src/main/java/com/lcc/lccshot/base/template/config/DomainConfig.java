package com.lcc.lccshot.base.template.config;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class DomainConfig {
	  private String packageName;//包名称
	    private List<String> imports;//所引入的包
	    private List<CoderDomain> cdomains;//字段名称
	    
	    public DomainConfig(){
	        init();
	    }

	    private void init(){
	        ArrayList<String> imports = Lists.newArrayList();
	        imports.add("java.io.Serializable");
	        imports.add("java.util.Date");
	        imports.add("javax.persistence.Column");
	        imports.add("javax.persistence.Entity");
	        imports.add("javax.persistence.GeneratedValue");
	        imports.add("javax.persistence.Id");

	        this.imports = imports;
	        this.packageName = "com.lcc.lccshot.domain";

	    }

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

		public List<CoderDomain> getCdomains() {
			return cdomains;
		}

		public void setCdomains(List<CoderDomain> cdomains) {
			this.cdomains = cdomains;
		}


	    
}
