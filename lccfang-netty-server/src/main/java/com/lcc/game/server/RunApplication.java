package com.lcc.game.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class RunApplication {

	protected final static Logger logger = LoggerFactory.getLogger(RunApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RunApplication.class,args);
		 logger.info("RunApplication is sussess!");
		
	}

}
