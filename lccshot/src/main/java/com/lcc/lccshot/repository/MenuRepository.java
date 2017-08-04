package com.lcc.lccshot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lcc.lccshot.domain.Menu;
import com.lcc.lccshot.domain.User;
import com.lcc.lccshot.domain.view.MenuView;
import com.lcc.lccshot.domain.view.ZTreeView;


public interface MenuRepository  extends JpaRepository<Menu, Integer>,JpaSpecificationExecutor<Menu>{
	
	
	Menu findById(Integer id);
	
	Menu findByCode(String code);


	@Query(value="select m.url from relation rel inner join menu m on rel.menuid = m.id where rel.roleid = ?1",nativeQuery=true)
	 List<String> getResUrlsByRoleId(Integer roleId);
	
	@Query("select o.menuid from Relation o where o.roleid = ?1")
	List<Integer> getMenuIdsByRoleId(Integer roleId);
	
	
	@Query(value="SELECT m1.id AS id,IFNULL(m1.icon,'') AS icon,(CASE WHEN (m2.id = 0 OR m2.id IS NULL) THEN 0 ELSE m2.id END) AS parentId,m1.NAME as name,m1.url as url,m1.levels as levels,m1.ismenu as ismenu,m1.num as num FROM Menu m1 LEFT JOIN Menu m2 ON m1.pcode = m2.code where m1.id in (SELECT rela.menuid FROM Relation rela WHERE rela.roleid IN ?1) and m1.ismenu = 1 order by levels,num asc",nativeQuery=true)
	List<MenuView> findViewByRoleIds(List<Integer> roleIds);

	//@Query("select o from Menu o where status = 1 and (name like %?1% or code like %?1%) and levels = ?2")
	//List<Menu> selectMenus(String menuName,String level);
	
	@Query(value="select o.id,o.pid as pid,o.simplename as name,(CASE WHEN (o.pid = 0 OR o.pid IS NULL) THEN 'true' ELSE 'false' END ) as open from Dept o",nativeQuery = true)
	List<ZTreeView> tree();
	
	@Query(value="SELECT m1.id AS id,(CASE WHEN (m2.id = 0 OR m2.id IS NULL) THEN 0 ELSE m2.id END) AS pId,m1. NAME AS NAME,( CASE WHEN (m2.id = 0 OR m2.id IS NULL) THEN 'true' ELSE 'false' END ) as isOpen FROM menu m1 LEFT JOIN menu m2 ON m1.pcode = m2. CODE ORDER BY m1.id ASC",nativeQuery = true)
	List<ZTreeView> menuTreeList();
}
