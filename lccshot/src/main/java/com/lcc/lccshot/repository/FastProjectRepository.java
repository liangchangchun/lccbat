package com.lcc.lccshot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lcc.lccshot.domain.FastProject;

/**
 * 数据dao层curd 
 * @author lcc
 *
 */
public interface FastProjectRepository extends JpaRepository<FastProject, Integer>,JpaSpecificationExecutor<FastProject> {

	FastProject findByProjectId(Integer id);
}
