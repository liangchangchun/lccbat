package com.lcc.lccshot.base.template.config;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.lcc.lccshot.base.template.codeengine.ABaseConfig;

public class ServiceImplConfig extends ABaseConfig{
	
	@Override
    public void init(){
        ArrayList<String> imports = Lists.newArrayList();
        imports.add("java.util.List");
        imports.add("org.springframework.data.domain.Sort");
        imports.add("org.springframework.data.domain.Sort.Direction");
        imports.add("org.springframework.stereotype.Service");
        imports.add("com.lcc.lccshot.core.map2sql.BaseServiceTemplate");
        imports.add("com.lcc.lccshot.core.map2sql.Conditions");
        imports.add("com.lcc.lccshot.core.map2sql.Where");
        
        this.setImports(imports);
        this.setPackageName("com.lcc.lccshot.service.impl");

    }

   

}
