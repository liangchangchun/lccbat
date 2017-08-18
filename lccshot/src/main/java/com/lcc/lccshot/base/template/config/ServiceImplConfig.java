package com.lcc.lccshot.base.template.config;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class ServiceImplConfig {
	
    private String packageName;//包名称
    private List<String> imports;//所引入的包

    public ServiceImplConfig(){
        init();
    }

    private void init(){
        ArrayList<String> imports = Lists.newArrayList();
        imports.add("java.util.List");
        imports.add("org.springframework.data.domain.Sort");
        imports.add("org.springframework.data.domain.Sort.Direction");
        imports.add("org.springframework.stereotype.Service");
        imports.add("com.lcc.lccshot.core.map2sql.BaseServiceTemplate");
        imports.add("com.lcc.lccshot.core.map2sql.Conditions");
        imports.add("com.lcc.lccshot.core.map2sql.Where");
        this.imports = imports;
        this.packageName = "com.lcc.lccshot.service.impl";

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

}
