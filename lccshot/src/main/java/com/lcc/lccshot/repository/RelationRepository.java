package com.lcc.lccshot.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lcc.lccshot.domain.Relation;

public interface RelationRepository extends JpaRepository<Relation, Integer> {

	@Transactional
	@Modifying
	@Query("delete from Relation o where o.menuid in ?1")
	int deleteByMenuId(List<Integer> menuIds);
	
	@Transactional
	@Modifying
	@Query("delete from Relation o where o.menuid in ?1")
	int deleteByMenuId(Integer menuId);
	
	@Transactional
	@Modifying
	@Query("delete from Relation o where o.roleid in ?1")
	int deleteByRoleId(Integer roleid);
	
	@Transactional
	@Modifying
	@Query("delete from Relation o where o.roleid in ?1")
	int deleteByRoleId(List<Integer> roleid);
}
