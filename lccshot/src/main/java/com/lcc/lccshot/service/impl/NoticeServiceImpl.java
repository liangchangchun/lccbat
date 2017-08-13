package com.lcc.lccshot.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lcc.lccshot.core.map2sql.BaseServiceTemplate;
import com.lcc.lccshot.core.map2sql.Conditions;
import com.lcc.lccshot.core.map2sql.Where;
import com.lcc.lccshot.domain.Notice;
import com.lcc.lccshot.repository.NoticeRepository;
import com.lcc.lccshot.service.INoticeService;

@Service
public class NoticeServiceImpl extends BaseServiceTemplate<NoticeRepository,Notice> implements INoticeService{

	@Override
	public List<Notice> list(String condition) {
		Where where = Where.create()
				.add(Conditions.create().or().like("title", condition))
				.add(Conditions.create().or().like("content", condition));
			this.initWhere(where);
			Sort sort = new Sort(Direction.DESC, "createtime");
			return this.findAll(sort);
	}

}
