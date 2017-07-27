package com.lcc.lccshot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lcc.lccshot.domain.Dept;

public interface DeptRepository extends JpaRepository<Dept, Integer>,JpaSpecificationExecutor<Dept> {

	Dept findById(Integer id);

	
	//@Query("select o from Dept o where o.simplename like %?1% or o.fullname like %?1% order by o.num ASC")
	//List<Dept> listDept(String name);
	
}
