package com.lcc.lccshot.controller;

import com.lcc.lccshot.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 权限管理控制器
 *
 * @author fengshuonan
 * @Date 2017-08-14 18:16:27
 */
@Controller
@RequestMapping("/relation")
public class RelationController extends BaseController {

    private String PREFIX = "/system/relation/";

    /**
     * 跳转到权限管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "relation.html";
    }

    /**
     * 跳转到添加权限管理
     */
    @RequestMapping("/relation_add")
    public String relationAdd() {
        return PREFIX + "relation_add.html";
    }

    /**
     * 跳转到修改权限管理
     */
    @RequestMapping("/relation_update/{relationId}")
    public String relationUpdate(@PathVariable Integer relationId, Model model) {
        return PREFIX + "relation_edit.html";
    }

    /**
     * 获取权限管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增权限管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除权限管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改权限管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 权限管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
