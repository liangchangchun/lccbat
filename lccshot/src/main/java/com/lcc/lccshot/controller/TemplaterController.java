package com.lcc.lccshot.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.lcc.lccshot.base.BaseController;
import com.lcc.lccshot.core.annotion.Permission;
import com.lcc.lccshot.core.constant.Const;
import com.lcc.lccshot.exception.BizExceptionEnum;
import com.lcc.lccshot.exception.BussinessException;
import com.lcc.lccshot.utils.BeanKit;
import com.lcc.lccshot.utils.ToolUtil;

import com.lcc.lccshot.domain.Templater;
import com.lcc.lccshot.repository.TemplaterRepository;
import com.lcc.lccshot.service.ITemplaterService;

/**
 * 模板管理控制器
 *
 * @author liangchangchun
 * @Date 2017-08-20 22:40:52
 */
@Controller
@RequestMapping("/templater")
public class TemplaterController extends BaseController {

    private String PREFIX = "/system/templater/";
    
    @Resource
    TemplaterRepository templaterRepository;
    
    @Resource
    ITemplaterService templaterService;

    /**
     * 跳转到模板管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "templater.html";
    }

    /**
     * 跳转到添加模板管理
     */
    @RequestMapping("/templater_add")
    public String templaterAdd() {
        return PREFIX + "templater_add.html";
    }

    /**
     * 跳转到修改模板管理
     */
    @RequestMapping("/templater_update/{templaterId}")
    public String templaterUpdate(@PathVariable Integer templaterId, Model model) {
     	if (ToolUtil.isEmpty(templaterId)) {
               throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
           }
    	Templater templater  = templaterRepository.findByTemplaterId(templaterId);
    	Map<String, Object> map = BeanKit.beanToMap(templater);
    	model.addAttribute("templater", map);
        return PREFIX + "templater_edit.html";
    }

    /**
     * 获取模板管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    	List<Templater> list = this.templaterService.list(condition);
        return list;
    }

    /**
     * 新增模板管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid Templater  templater, BindingResult result) {
     	if (result.hasErrors()) {
             throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
         }
    	 templater.setCreateTime(new Date());
    	 templater.setUpdateTime(new Date());
    	 templaterRepository.save(templater);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除模板管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer templaterId) {
    	if (ToolUtil.isEmpty(templaterId)) {
             throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
         }
    	 templaterRepository.delete(templaterId);
        return SUCCESS_TIP;
    }


    /**
     * 修改模板管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Valid Templater  templater, BindingResult result) {
    	if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
    	Templater old = templaterRepository.findByTemplaterId(templater.getTemplaterId());
    	templater.setCreateTime(old.getCreateTime());
    	templater.setUpdateTime(new Date());
    	templaterRepository.save(templater);
        return super.SUCCESS_TIP;
    }

    /**
     * 模板管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
