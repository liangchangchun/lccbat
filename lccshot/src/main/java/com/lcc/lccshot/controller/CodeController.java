package com.lcc.lccshot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lcc.lccshot.base.BaseController;
import com.lcc.lccshot.base.template.config.ContextConfig;
import com.lcc.lccshot.base.template.engine.GunsTemplateEngine;
import com.lcc.lccshot.base.template.engine.SimpleTemplateEngine;
import com.lcc.lccshot.core.annotion.Permission;
import com.lcc.lccshot.core.constant.Const;
import com.lcc.lccshot.exception.BizExceptionEnum;
import com.lcc.lccshot.exception.BussinessException;
import com.lcc.lccshot.utils.ToolUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 代码生成控制器
 *
 * @author fengshuonan
 * @Date 2017-05-23 18:52:34
 */
@Controller
@RequestMapping("/code")
public class CodeController extends BaseController {

    private String PREFIX = "/system/code/";

    /**
     * 跳转到代码生成首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "code.html";
    }

    /**
     * 代码生成
     */
    @ApiOperation("生成代码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bizChName", value = "业务名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "bizEnName", value = "业务英文名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "path", value = "项目生成类路径", required = true, dataType = "String")
    })
    @RequestMapping(value = "/generate",method = RequestMethod.POST)
    @ResponseBody
    @Permission(Const.ADMIN_NAME)
    public Object add(String bizChName, String bizEnName, String path) {
        if (ToolUtil.isOneEmpty(bizChName, bizEnName)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        ContextConfig contextConfig = new ContextConfig();
        contextConfig.setBizChName(bizChName);
        contextConfig.setBizEnName(bizEnName);
        if (ToolUtil.isNotEmpty(path)) {
            contextConfig.setProjectPath(path);
        }

        GunsTemplateEngine gunsTemplateEngine = new SimpleTemplateEngine();
        gunsTemplateEngine.setContextConfig(contextConfig);
        gunsTemplateEngine.start();

        return super.SUCCESS_TIP;
    }
}
