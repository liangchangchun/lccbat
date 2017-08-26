package com.lcc.concert.web.service;

import java.util.List;

import com.lcc.concert.web.bean.Node;
import com.lcc.concert.web.bean.ZNode;

public interface AppService {

	public Node findStatus();

	public List<ZNode> findProviders();

	public List<ZNode> findConsumers();
}
