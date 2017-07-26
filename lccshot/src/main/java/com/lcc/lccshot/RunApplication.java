package com.lcc.lccshot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class RunApplication extends WebMvcConfigurerAdapter{
    protected final static Logger logger = LoggerFactory.getLogger(RunApplication.class);
    
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RunApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(RunApplication.class,args);
		 logger.info("RunApplication is sussess!");
	}

	
}
