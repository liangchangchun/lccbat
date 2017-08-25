package com.lcc.lccshot.base.template.config;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.lcc.lccshot.base.template.codeengine.ABaseConfig;

public class RepositoryConfig extends ABaseConfig{


	@Override
    public void init(){
        ArrayList<String> imports = Lists.newArrayList();
        imports.add("org.springframework.data.jpa.repository.JpaRepository");
        imports.add("org.springframework.data.jpa.repository.JpaSpecificationExecutor");

        this.setImports(imports);
        this.setPackageName("com.lcc.lccshot.repository");
    }

   


  
}
