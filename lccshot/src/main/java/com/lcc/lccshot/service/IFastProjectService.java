package com.lcc.lccshot.service;

import java.util.List;

import com.lcc.lccshot.domain.FastProject;

public interface IFastProjectService {
	List<FastProject> list(String condition);
}
