package com.lcc.lccshot.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lcc.lccshot.base.BaseController;
import com.lcc.lccshot.base.warpper.FastProjectWarpper;
import com.lcc.lccshot.core.annotion.Permission;
import com.lcc.lccshot.core.constant.Const;
import com.lcc.lccshot.domain.FastProject;
import com.lcc.lccshot.exception.BizExceptionEnum;
import com.lcc.lccshot.exception.BussinessException;
import com.lcc.lccshot.repository.FastProjectRepository;
import com.lcc.lccshot.service.IFastProjectService;
import com.lcc.lccshot.utils.BeanKit;
import com.lcc.lccshot.utils.ToolUtil;

/**
 * 项目管理控制器
 *
 * @author fengshuonan
 * @Date 2017-08-14 17:43:20
 */
@Controller
@RequestMapping("/ProjectManager")
public class ProjectManagerController extends BaseController {

    private String PREFIX = "/system/ProjectManager/";
    
    @Resource
    FastProjectRepository fastProjectDao;
    
    @Resource
    IFastProjectService fastProjectService;

    /**
     * 跳转到项目管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "ProjectManager.html";
    }

    /**
     * 跳转到添加项目管理
     */
    @RequestMapping("/ProjectManager_add")
    public String ProjectManagerAdd() {
        return PREFIX + "ProjectManager_add.html";
    }

    /**
     * 跳转到修改项目管理
     */
    @RequestMapping("/ProjectManager_update/{ProjectManagerId}")
    public String ProjectManagerUpdate(@PathVariable Integer ProjectManagerId, Model model) {
    	   if (ToolUtil.isEmpty(ProjectManagerId)) {
               throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
           }
    	FastProject project  = fastProjectDao.findByProjectId(ProjectManagerId);
    	Map<String, Object> map = BeanKit.beanToMap(project);
    	model.addAttribute("ProjectManager", map);
        return PREFIX + "ProjectManager_edit.html";
    }

    /**
     * 获取项目管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    	List<FastProject> list = this.fastProjectService.list(condition);
    	return super.warpObject(new FastProjectWarpper(list,FastProject.class));
    }

    /**
     * 新增项目管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid FastProject project, BindingResult result) {
    	 if (result.hasErrors()) {
             throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
         }
    	 project.setCreatetime(new Date());
    	 fastProjectDao.save(project);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除项目管理
     */
    @Permission(Const.ADMIN_NAME)
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer ProjectManagerId) {
    	 if (ToolUtil.isEmpty(ProjectManagerId)) {
             throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
         }
    	 fastProjectDao.delete(ProjectManagerId);
        return SUCCESS_TIP;
    }


    /**
     * 修改项目管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@Valid FastProject project, BindingResult result) {
    	if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
    	FastProject old = fastProjectDao.findByProjectId(project.getProjectId());
    	project.setCreatetime(old.getCreatetime());
    	fastProjectDao.save(project);
        return super.SUCCESS_TIP;
    }

    /**
     * 项目管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
