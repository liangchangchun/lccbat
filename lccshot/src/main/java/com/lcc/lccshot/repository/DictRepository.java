package com.lcc.lccshot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lcc.lccshot.domain.Dict;

public interface DictRepository extends JpaRepository<Dict, Integer> {
	
	Dict findById(Integer id);
	
	List<Dict> findAllById(Integer id);
	
	List<Dict> findByPid(Integer id);
	
	List<Dict> findByNameAndPid(String dictName,Integer pId);
	
	List<Dict> findByNameLike(String dictName);
	
	@Transactional
	@Modifying
	@Query("delete from Dict where pid = ?1")
	Long deleteByPId(Integer dictId);
}
