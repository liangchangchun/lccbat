package com.lcc.lccshot.base.template.config;

import java.util.ArrayList;

import com.google.common.collect.Lists;
import com.lcc.lccshot.base.template.codeengine.ABaseConfig;

public class WarpperConfig extends ABaseConfig{

	@Override
	public void init() {
		  ArrayList<String> imports = Lists.newArrayList();
	        imports.add("java.util.Map");
	        imports.add("com.lcc.lccshot.base.BaseControllerWarpper");

	        this.setImports(imports);
	        this.setPackageName("com.lcc.lccshot.base.warpper");
	}
    
}
