package com.lcc.lccshot.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lcc.lccshot.core.map2sql.BaseServiceTemplate;
import com.lcc.lccshot.core.map2sql.Conditions;
import com.lcc.lccshot.core.map2sql.Where;
import com.lcc.lccshot.domain.FastProject;
import com.lcc.lccshot.repository.FastProjectRepository;
import com.lcc.lccshot.service.IFastProjectService;

@Service
public class FastProjectServiceImpl extends BaseServiceTemplate<FastProjectRepository,FastProject> implements IFastProjectService{

	@Override
	public List<FastProject> list(String condition) {
		Where where = Where.create()
				.add(Conditions.create().or().like("projectName", condition))
				.add(Conditions.create().or().like("businessName", condition))
				.add(Conditions.create().or().like("description", condition));
			this.initWhere(where);
			Sort sort = new Sort(Direction.DESC, "createtime");
			return this.findAll(sort);
	}
}
