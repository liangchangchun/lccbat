package com.lcc.lccshot.base.template.config;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.lcc.lccshot.base.template.codeengine.ABaseConfig;

public class DomainConfig extends ABaseConfig{

	    private List<CoderDomain> cdomains;//字段名称
	    @Override
	    public void init(){
	        ArrayList<String> imports = Lists.newArrayList();
	        imports.add("java.io.Serializable");
	        imports.add("java.util.Date");
	        imports.add("javax.persistence.Column");
	        imports.add("javax.persistence.Entity");
	        imports.add("javax.persistence.GeneratedValue");
	        imports.add("javax.persistence.Id");

	       this.setImports(imports);
	       this.setPackageName("com.lcc.lccshot.domain");

	    }

		public List<CoderDomain> getCdomains() {
			return cdomains;
		}

		public void setCdomains(List<CoderDomain> cdomains) {
			this.cdomains = cdomains;
		}


	    
}
