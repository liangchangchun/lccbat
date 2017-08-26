package com.lcc.concert.web.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lcc.concert.web.bean.Node;
import com.lcc.concert.web.service.AppService;

@Controller
@RequestMapping(value = "/guardian")
public class GuardianController {

	@Resource
	private AppService appService;

	@RequestMapping
	public String doDefault(Map<String, Object> model) {
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String doIndex(Map<String, Object> model) {
		return "index";
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	@ResponseBody
	public Node doStatus() {
		return appService.findStatus();
	}

	@RequestMapping(value = "/providers", method = RequestMethod.GET)
	public String doConsumer(Map<String, Object> model) {
		model.put("providers", appService.findProviders());
		return "provider";
	}

	@RequestMapping(value = "/consumers", method = RequestMethod.GET)
	public String doProvider(Map<String, Object> model) {
		model.put("consumers", appService.findConsumers());
		return "consumer";
	}
}
