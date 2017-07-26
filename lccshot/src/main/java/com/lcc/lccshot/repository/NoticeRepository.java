package com.lcc.lccshot.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lcc.lccshot.domain.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
	
	Notice findById(Integer id);
	
	@Query("select o from Notice o where o.title like %?1% or o.content like %?1% order by createtime DESC")
	List<Notice> list(String condition);
}
