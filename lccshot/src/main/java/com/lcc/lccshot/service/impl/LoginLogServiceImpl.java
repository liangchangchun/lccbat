package com.lcc.lccshot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.assertj.core.util.Strings;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lcc.lccshot.domain.LoginLog;
import com.lcc.lccshot.repository.LoginLogRepository;
import com.lcc.lccshot.service.ILoginLogService;

@Service
public class LoginLogServiceImpl implements ILoginLogService{

    @Resource
    private LoginLogRepository logDao;
    
	@Override
	public List<LoginLog> getLoginLogs(String beginTime, String endTime, String logName, Pageable pageable) {
		if(!Strings.isNullOrEmpty(logName) && Strings.isNullOrEmpty(beginTime) && Strings.isNullOrEmpty(endTime)){
		  return logDao.getLoginLogsName(logName, pageable);
		}else if(Strings.isNullOrEmpty(logName) && !Strings.isNullOrEmpty(beginTime) && Strings.isNullOrEmpty(endTime)){
			 return logDao.getLoginLogsTime(beginTime, pageable);
		}else if(Strings.isNullOrEmpty(logName) && !Strings.isNullOrEmpty(beginTime) && !Strings.isNullOrEmpty(endTime)){
			 return logDao.getLoginLogsTime(beginTime,endTime, pageable);
		}else if(!Strings.isNullOrEmpty(logName) && !Strings.isNullOrEmpty(beginTime) && !Strings.isNullOrEmpty(endTime)){
			return logDao.getLoginLogs(beginTime,endTime,logName, pageable);
		}else {
			return logDao.getLoginLogs();
		}
	}

	@Override
	public void delete() {
		 logDao.deleteAll();
	}

}
