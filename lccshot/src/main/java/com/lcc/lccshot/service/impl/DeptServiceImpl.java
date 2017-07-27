package com.lcc.lccshot.service.impl;

import java.util.List;

import com.lcc.lccshot.core.map2sql.BaseServiceTemplate;
import com.lcc.lccshot.core.map2sql.Conditions;
import com.lcc.lccshot.core.map2sql.Where;
import com.lcc.lccshot.domain.Dept;
import com.lcc.lccshot.repository.DeptRepository;
import com.lcc.lccshot.service.IDeptService;

public class DeptServiceImpl extends BaseServiceTemplate<DeptRepository,Dept> implements IDeptService{

	@Override
	public List<Dept> listDept(String name) {
		Where where = Where.create()
				.add(Conditions.create().and().like("simplename", name))
				.add(Conditions.create().and().like("fullname", name));
			this.initWhere(where);
			return this.findAll();
	}

}
