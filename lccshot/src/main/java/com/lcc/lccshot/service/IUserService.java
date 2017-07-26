package com.lcc.lccshot.service;

import java.util.List;

import com.lcc.lccshot.domain.User;

public interface IUserService {
	/**
	 * 查询用户
	 * @param name
	 * @param beginTime
	 * @param endTime
	 * @param deptid
	 * @return
	 */
	 List<User> selectUsers(String name,String beginTime,String endTime,Integer deptid);
}
