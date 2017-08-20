package com.lcc.lccshot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lcc.lccshot.domain.Templater;

/**
 * 数据dao层curd 
 * @author lcc
 *
 */
public interface TemplaterRepository extends JpaRepository<Templater, Integer>,JpaSpecificationExecutor<Templater> {
	
	Templater findByTemplaterId(Integer id);
}