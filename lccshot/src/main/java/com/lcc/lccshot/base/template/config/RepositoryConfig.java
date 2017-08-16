package com.lcc.lccshot.base.template.config;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class RepositoryConfig {

    private String packageName;//包名称
    private List<String> imports;//所引入的包

    public RepositoryConfig(){
        init();
    }

    private void init(){
        ArrayList<String> imports = Lists.newArrayList();
        imports.add("com.lcc.lccshot.base.BaseController");
        imports.add("org.springframework.stereotype.Controller");
        imports.add("org.springframework.web.bind.annotation.RequestMapping");
        imports.add("org.springframework.web.bind.annotation.ResponseBody");
        imports.add("org.springframework.ui.Model");
        imports.add("org.springframework.web.bind.annotation.PathVariable");
        this.imports = imports;
        this.packageName = "com.lcc.lccshot.controller";
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
