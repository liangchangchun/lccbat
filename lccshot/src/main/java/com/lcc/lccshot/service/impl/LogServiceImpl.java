package com.lcc.lccshot.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lcc.lccshot.core.map2sql.BaseServiceTemplate;
import com.lcc.lccshot.core.map2sql.Conditions;
import com.lcc.lccshot.core.map2sql.Where;
import com.lcc.lccshot.domain.OperationLog;
import com.lcc.lccshot.repository.OperationLogRepository;
import com.lcc.lccshot.service.ILogService;

@Service
public class LogServiceImpl extends BaseServiceTemplate<OperationLogRepository,OperationLog> implements ILogService{

   

	@Override
	public Page<OperationLog> getOperationLogs(String beginTime,String endTime,String logName,String logType,Pageable pageable) {
		Where where = Where.create()
				.add(Conditions.create().and().between("createtime", beginTime,endTime))
				.add(Conditions.create().or().like("logname", logName))
				.add(Conditions.create().or().like("logtype", logType));
			this.initWhere(where);
			return this.findAll(pageable);
	}

}
