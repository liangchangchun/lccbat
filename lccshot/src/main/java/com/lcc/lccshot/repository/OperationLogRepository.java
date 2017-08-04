package com.lcc.lccshot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lcc.lccshot.domain.OperationLog;

public interface OperationLogRepository extends JpaRepository<OperationLog, Integer>,JpaSpecificationExecutor<OperationLog> {

	OperationLog findById(Integer id);
	
	//@Query(" select o from OperationLog o where  (createTime between CONCAT(:beginTime,' 00:00:00') and CONCAT(:endTime,' 23:59:59')) and logname like %:logName% and logtype like %:logType%")
	//List<OperationLog> getOperationLogs(@Param("beginTime") String beginTime,@Param("endTime") String endTime, @Param("logName") String logName, @Param("logType") String logType,Pageable pageable);
}
