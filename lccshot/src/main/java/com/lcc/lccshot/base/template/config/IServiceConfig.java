package com.lcc.lccshot.base.template.config;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class IServiceConfig {
	
    private String packageName;//包名称
    private List<String> imports;//所引入的包

    public IServiceConfig(){
        init();
    }

    private void init(){
        ArrayList<String> imports = Lists.newArrayList();
        imports.add("java.util.List");

        this.imports = imports;
        this.packageName = "com.lcc.lccshot.service";
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
