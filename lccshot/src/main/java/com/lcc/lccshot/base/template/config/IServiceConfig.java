package com.lcc.lccshot.base.template.config;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.lcc.lccshot.base.template.codeengine.ABaseConfig;

public class IServiceConfig extends ABaseConfig{
	

	@Override
    public void init(){
        ArrayList<String> imports = Lists.newArrayList();
        imports.add("java.util.List");

        this.setImports(imports);
        this.setPackageName("com.lcc.lccshot.service");
    }

  
}
