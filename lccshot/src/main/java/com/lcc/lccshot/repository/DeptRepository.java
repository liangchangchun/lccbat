package com.lcc.lccshot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lcc.lccshot.domain.Dept;
import com.lcc.lccshot.domain.view.ZTreeView;

public interface DeptRepository extends JpaRepository<Dept, Integer> {

	Dept findById(Integer id);

	
	@Query("select o from Dept o where o.simplename like %?1% or o.fullname like %?1% order by o.num ASC")
	List<Dept> listDept(String name);
	
}
