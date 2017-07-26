package com.lcc.lccshot.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lcc.lccshot.domain.User;


public interface UserRepository  extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User>{

	 User findByAccount(String account);
	 
	 User findById(Integer id);
	 
	 @Query("select u from User u where  u.status != 3  and (phone like ?1 or account like ?1 or name like ?1) and deptid = ?4 and (createTime between CONCAT(?2,' 00:00:00') and CONCAT(?3,' 23:59:59'))")
	 List<User> selectUsers(String name,String beginTime,String endTime,Integer deptid);
	 
	 @Modifying
	 @Query("update User u set u.password=?1 where u.id = ?2 ")
	 int updatePassById(String newMd5,Integer id);
	 
	 @Modifying
	 @Query("update User u set u.status = :status where u.id = :id ")
	 int updateStatusById(@Param("id") Integer id,@Param("status") Integer status);
	 
	 @Modifying
	 @Query("update User u set u.roleid = :roleIds where u.id = :id ")
	 int updateRolesById(@Param("id") Integer userId,@Param("roleIds") String roleIds);
}
