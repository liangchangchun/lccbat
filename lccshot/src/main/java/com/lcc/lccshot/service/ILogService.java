package com.lcc.lccshot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lcc.lccshot.domain.OperationLog;

public interface ILogService {
	Page<OperationLog> getOperationLogs(String beginTime,String endTime,String logName,String logType,Pageable pageable);
}
