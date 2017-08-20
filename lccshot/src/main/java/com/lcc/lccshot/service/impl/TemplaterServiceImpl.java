package com.lcc.lccshot.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.lcc.lccshot.core.map2sql.BaseServiceTemplate;
import com.lcc.lccshot.core.map2sql.Conditions;
import com.lcc.lccshot.core.map2sql.Where;

import com.lcc.lccshot.domain.Templater;
import com.lcc.lccshot.repository.TemplaterRepository;
import com.lcc.lccshot.service.ITemplaterService;

/**
 * 模板管理service实现类
 *
 * @author liangchangchun
 * @Date 2017-08-20 22:40:52
 */
@Service
public class TemplaterServiceImpl extends BaseServiceTemplate<TemplaterRepository,Templater> implements ITemplaterService{

	@Override
	public List<Templater> list(String condition) {
		Where where = Where.create();
			this.initWhere(where);
			Sort sort = new Sort(Direction.DESC, "createTime");
			return this.findAll(sort);
	}
}
