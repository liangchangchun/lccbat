package com.lcc.lccshot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.lcc.lccshot.domain.Role;
import com.lcc.lccshot.domain.view.ZTreeView;

public interface RoleRepository extends JpaRepository<Role, Integer>,JpaSpecificationExecutor<Role> {

	Role findById(Integer id);
	
	List<Role> findByNameLike(String roleName);
	
	@Transactional
	@Modifying 
	@Query("delete from Role o where o.id = ?1")
	int deleteById(Integer roleId);
	
	@Query(value="select o.id id,o.pid pid,o.name as name,(case when (o.pid=0 or o.pid is null) then 'true' else 'false' end) open from role o",nativeQuery=true)
	List<ZTreeView> roleTreeList();
	
	@Query(value="SELECT r.id id,pid pid,NAME AS name,(CASE WHEN (pid = 0 OR pid IS NULL) THEN 'true' ELSE 'false' END) open,(CASE WHEN (r1.ID = 0 OR r1.ID IS NULL) THEN 'false' ELSE 'true' END) checked FROM role r LEFT JOIN (SELECT ID FROM role WHERE ID IN ?1) r1 ON r.ID = r1.ID ORDER BY pId,num ASC)",nativeQuery=true)
	List<ZTreeView>  roleTreeListByRoleId(String[] roleIds);
}
