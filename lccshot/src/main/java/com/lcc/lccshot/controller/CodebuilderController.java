package com.lcc.lccshot.controller;

import com.lcc.lccshot.base.BaseController;
import com.lcc.lccshot.base.template.codeengine.SimpleCoderEngine;
import com.lcc.lccshot.base.template.config.CodeConfig;
import com.lcc.lccshot.core.annotion.Permission;
import com.lcc.lccshot.core.constant.Const;
import com.lcc.lccshot.exception.BizExceptionEnum;
import com.lcc.lccshot.exception.BussinessException;
import com.lcc.lccshot.utils.ToolUtil;

import io.swagger.annotations.ApiOperation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 代码全自动控制器
 *
 * @author liangchangchun
 * @Date 2017-08-15 16:01:39
 */
@Controller
@RequestMapping("/codebuilder")
public class CodebuilderController extends BaseController {

    private String PREFIX = "/system/codebuilder/";

    /**
     * 跳转到代码全自动首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "codebuilder.html";
    }

    /**
     * 代码生成
     */
    @ApiOperation("全自动代码生成")
    @RequestMapping( value ="create", method = RequestMethod.POST )
    @ResponseBody
    @Permission(Const.ADMIN_NAME)
    public Object create(String bizChName, String bizEnName, String path,String domainName,String domainValues){
    	 if (ToolUtil.isOneEmpty(bizChName, bizEnName,domainName,domainValues)) {
             throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
         }
    	 CodeConfig config = new CodeConfig();
    	 	config.setBizChName(bizChName);
    	 	config.setBizEnName(bizEnName);
            if (ToolUtil.isNotEmpty(path)) {
            	config.setProjectPath(path);
            }
            config.setDomainName(domainName);
            config.setDomainValues(domainValues);
            SimpleCoderEngine coderEngine = new SimpleCoderEngine(config);
            coderEngine.start();
    	return super.SUCCESS_TIP;
    }
}
