package com.lcc.lccshot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lcc.lccshot.domain.Girl;
import com.lcc.lccshot.repository.GirlRepository;

@RestController
public class GirlController {

	@Autowired
	private GirlRepository girlRepository;
	
	@RequestMapping(value="/hello",method =RequestMethod.GET)
	public String say(){
		
		return "1212";
	}
	
	@PostMapping(value="/addGirl")
	public Girl addGirl(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
		Girl girl = new Girl();
		girl.setAge(age);
		girl.setCupSize(cupSize);
		return girlRepository.save(girl);
	}
}
