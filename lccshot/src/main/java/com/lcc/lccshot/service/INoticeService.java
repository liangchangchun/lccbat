package com.lcc.lccshot.service;

import java.util.List;

import com.lcc.lccshot.domain.Notice;

public interface INoticeService {
	List<Notice> list(String condition);
}
