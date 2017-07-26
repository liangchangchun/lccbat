package com.lcc.lccshot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lcc.lccshot.core.map2sql.BaseServiceTemplate;
import com.lcc.lccshot.core.map2sql.Conditions;
import com.lcc.lccshot.core.map2sql.Where;
import com.lcc.lccshot.domain.User;
import com.lcc.lccshot.repository.UserRepository;
import com.lcc.lccshot.service.IUserService;

@Service
public class UserServiceImpl extends BaseServiceTemplate<UserRepository,User> implements IUserService {
	

	@Override
	public List<User> selectUsers(String name, String beginTime, String endTime, Integer deptid) {
		Where where = Where.create()
							.add(Conditions.create().notEq("status", "3"))
							.add(Conditions.create().or().like("phone", name))
							.add(Conditions.create().or().like("account", name))
							.add(Conditions.create().or().like("name", name))
							.add(Conditions.create().and().eq("deptid", deptid))
							.add(Conditions.create().and().between("createtime", beginTime,endTime));
		this.initWhere(where);
		return this.findAll();
	}


}
