package com.lcc.lccshot.controller;

import com.baomidou.mybatisplus.mapper.SqlRunner;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.lcc.lccshot.core.annotion.Permission;
import com.lcc.lccshot.core.annotion.log.BussinessLog;
import com.lcc.lccshot.core.constant.Const;
import com.lcc.lccshot.core.constant.factory.LogicConstantFactory;
import com.lcc.lccshot.core.constant.factory.PageFactory;
import com.lcc.lccshot.base.BaseController;
import com.lcc.lccshot.base.warpper.LogWarpper;
import com.lcc.lccshot.repository.LoginLogRepository;
import com.lcc.lccshot.service.ILoginLogService;
import com.lcc.lccshot.domain.LoginLog;
import com.lcc.lccshot.domain.OperationLog;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 日志管理的控制器
 *
 * @author fengshuonan
 * @Date 2017年4月5日 19:45:36
 */
@Controller
@RequestMapping("/loginLog")
public class LoginLogController extends BaseController {

    private static String PREFIX = "/system/log/";

    @Resource
    private ILoginLogService logDao;

    /**
     * 跳转到日志管理的首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "login_log.html";
    }

    /**
     * 查询登录日志列表
     */
    @RequestMapping("/list")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object list(@RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime, @RequestParam(required = false) String logName) {
    	Pageable pageable = new PageFactory().simplePage();
    	List<LoginLog> result=logDao.getLoginLogs(beginTime, endTime, logName,pageable);
    	//Page<OperationLog> page = new PageFactory<OperationLog>().defaultPage();
       // List<Map<String, Object>> result = logDao.getLoginLogs(page, beginTime, endTime, logName, page.getOrderByField(), page.isAsc());
       // page.setRecords((List<OperationLog>) new LogWarpper(result).warp());
    	/**
    	 * 查询处理后映射
    	 */
    	Collection<LoginLog> resultRt = Collections2.transform(result, new Function<LoginLog,LoginLog>(){
             @Override
             public LoginLog apply(LoginLog loginLog) {
            	 loginLog.setUserName(LogicConstantFactory.me().getUserNameById(loginLog.getUserid()));
                 return loginLog;
             }
         });
       return super.packForBT(resultRt);
    }

    /**
     * 清空日志
     */
    @BussinessLog("清空登录日志")
    @RequestMapping("/delLoginLog")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object delLog() {
        //SqlRunner.db().delete("delete from login_log");
    	logDao.delete();
        return super.SUCCESS_TIP;
    }
}
