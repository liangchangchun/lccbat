package com.lcc.service;

import org.springframework.stereotype.Service;

import com.lcc.dubbo.domain.Person;
import com.lcc.dubbo.service.BusizssService;

@Service
public class BusizssServiceImpl implements BusizssService{

	@Override
	public Person findProjectName(String name) {
		Person person = new Person();
		person.setName(name);
		person.setAge("20");
		return person;
	}

}
