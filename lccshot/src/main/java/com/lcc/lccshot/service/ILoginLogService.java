package com.lcc.lccshot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.lcc.lccshot.domain.LoginLog;

public interface ILoginLogService {
	List<LoginLog>  getLoginLogs(String beginTime,String endTime,String logName,Pageable pageable);
	
	void delete();
}
