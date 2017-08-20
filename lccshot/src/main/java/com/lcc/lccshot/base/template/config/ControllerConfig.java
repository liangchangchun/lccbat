package com.lcc.lccshot.base.template.config;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 控制器模板生成的配置
 *
 * @author fengshuonan
 * @date 2017-05-07 22:12
 */
public class ControllerConfig {

    private String controllerPathTemplate = "\\src\\main\\java\\com\\lcc\\lccshot\\controller\\{}Controller.java";
    private String packageName;//包名称
    private List<String> imports;//所引入的包

    public ControllerConfig(){
        init();
    }

    private void init(){
        ArrayList<String> imports = Lists.newArrayList();
        imports.add("java.util.Date");
        imports.add("java.util.List");
        imports.add("java.util.Map");
        
        imports.add("javax.annotation.Resource");
        imports.add("javax.validation.Valid");
        
        imports.add("org.springframework.stereotype.Controller");
        imports.add("org.springframework.web.bind.annotation.RequestMapping");
        imports.add("org.springframework.web.bind.annotation.ResponseBody");
        imports.add("org.springframework.ui.Model");
        imports.add("org.springframework.validation.BindingResult");
        imports.add("org.springframework.web.bind.annotation.PathVariable");
        imports.add("org.springframework.web.bind.annotation.RequestParam");

        imports.add("com.lcc.lccshot.base.BaseController");
        imports.add("com.lcc.lccshot.core.annotion.Permission");
        imports.add("com.lcc.lccshot.core.constant.Const");
        imports.add("com.lcc.lccshot.exception.BizExceptionEnum");
        imports.add("com.lcc.lccshot.exception.BussinessException");
        imports.add("com.lcc.lccshot.utils.BeanKit");
        imports.add("com.lcc.lccshot.utils.ToolUtil");
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

    public String getControllerPathTemplate() {
        return controllerPathTemplate;
    }

    public void setControllerPathTemplate(String controllerPathTemplate) {
        this.controllerPathTemplate = controllerPathTemplate;
    }
}
