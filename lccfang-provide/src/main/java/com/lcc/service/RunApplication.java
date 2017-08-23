package com.lcc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
public class RunApplication {

	final static Logger logger = LoggerFactory.getLogger(RunApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RunApplication.class,args);
		 logger.info("RunApplication is sussess!");
	}

}
