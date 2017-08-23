package com.lcc.consume.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lcc.dubbo.domain.Person;
import com.lcc.dubbo.service.BusizssService;


@RestController
public class BusinessController {

	@Resource
    private BusizssService busizssService;
	
	  @RequestMapping(value = "/api/busizss", method = RequestMethod.GET)
	  public String findOneCity() {
	       Person p =  busizssService.findProjectName("1234");
	         return p.getAge();
	 }
}
