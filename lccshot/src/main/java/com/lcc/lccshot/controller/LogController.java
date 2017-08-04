package com.lcc.lccshot.controller;

import com.baomidou.mybatisplus.mapper.SqlRunner;
import com.lcc.lccshot.core.annotion.Permission;
import com.lcc.lccshot.core.annotion.log.BussinessLog;
import com.lcc.lccshot.core.constant.Const;
import com.lcc.lccshot.core.constant.factory.PageFactory;
import com.lcc.lccshot.core.constant.state.BizLogType;
import com.lcc.lccshot.base.BaseController;
import com.lcc.lccshot.base.warpper.LogWarpper;
import com.lcc.lccshot.utils.BeanKit;
import com.lcc.lccshot.domain.OperationLog;
import com.lcc.lccshot.repository.OperationLogRepository;
import com.lcc.lccshot.service.ILogService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 日志管理的控制器
 *
 * @author fengshuonan
 * @Date 2017年4月5日 19:45:36
 */
@Controller
@RequestMapping("/log")
public class LogController extends BaseController {

    private static String PREFIX = "/system/log/";

    @Resource
    private OperationLogRepository operationLogDao;
    
    @Resource
    private ILogService operationLogService;

    /**
     * 跳转到日志管理的首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "log.html";
    }

    /**
     * 查询操作日志列表
     */
    @RequestMapping("/list")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object list(@RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime, @RequestParam(required = false) String logName, @RequestParam(required = false) Integer logType) {
    	Pageable pageable = new PageFactory().simplePage();
    	Page<OperationLog> result = operationLogService.getOperationLogs(beginTime, endTime,logName,BizLogType.valueOf(logType),pageable);
    	
    	//Page<OperationLog> page = new PageFactory<OperationLog>().defaultPage();
        //Sort sort = new Sort(Direction.DESC, page.getOrderByField());
       // Pageable pageable = new PageRequest(page.getCurrent(), page.getSize(), sort);
       // List<Map<String, Object>> result = logDao.getOperationLogs(page, beginTime, endTime, logName, BizLogType.valueOf(logType), page.getOrderByField(), page.isAsc());
       // List<OperationLog> result = operationLogDao.getOperationLogs(beginTime, endTime,logName,BizLogType.valueOf(logType),pageable);
       // page.setRecords((List<OperationLog>) new LogWarpper(result).warp());
      //  return super.packForBT(page);
        return result;
    }

    /**
     * 查询操作日志详情
     */
    @RequestMapping("/detail/{id}")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object detail(@PathVariable Integer id) {
        OperationLog operationLog = operationLogDao.findById(id);
        Map<String, Object> stringObjectMap = BeanKit.beanToMap(operationLog);
        return super.warpObject(new LogWarpper(stringObjectMap));
    }

    /**
     * 清空日志
     */
    @BussinessLog(value = "清空业务日志")
    @RequestMapping("/delLog")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object delLog() {
        SqlRunner.db().delete("delete from operation_log");
        return super.SUCCESS_TIP;
    }
}
