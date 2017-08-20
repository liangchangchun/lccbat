package com.lcc.lccshot.service;

import java.util.List;

import com.lcc.lccshot.domain.Templater;

/**
 * 模板管理业务接口
 *
 * @author liangchangchun
 * @Date 2017-08-20 22:40:52
 */
public interface ITemplaterService {
	List<Templater> list(String condition);
}