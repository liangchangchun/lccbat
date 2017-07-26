package com.lcc.lccshot.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lcc.lccshot.domain.LoginLog;

public interface LoginLogRepository extends JpaRepository<LoginLog, Integer>{
	public String loginLogSql = "select o from LoginLog o where 1 = 1 ";
	
	@Query(loginLogSql)
	List<LoginLog>  getLoginLogs();	
	
	@Query(loginLogSql+" and o.logname like %?1%")
	List<LoginLog>  getLoginLogsName(String logName,Pageable pageable);	
	
	@Query(loginLogSql+" and o.createtime > CONCAT(?1,' 00:00:00')")
	List<LoginLog>  getLoginLogsTime(String beginTime,Pageable pageable);
	
	@Query(loginLogSql+" and (o.createtime between CONCAT(?1,' 00:00:00') and CONCAT(?2,' 23:59:59'))")
	List<LoginLog>  getLoginLogsTime(String beginTime,String endTime,Pageable pageable);
	
	@Query(loginLogSql+" and (o.createtime between CONCAT(?1,' 00:00:00') and CONCAT(?2,' 23:59:59')) and o.logname like %?3%")
	List<LoginLog>  getLoginLogs(String beginTime,String endTime,String logName,Pageable pageable);
}
