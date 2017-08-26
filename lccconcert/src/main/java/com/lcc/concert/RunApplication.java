package com.lcc.concert;

import javax.annotation.Resource;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@ComponentScan(basePackages = "com.lcc.concert.web")
public class RunApplication extends WebMvcConfigurerAdapter implements EmbeddedServletContainerCustomizer{

	protected final static Logger logger = LoggerFactory.getLogger(RunApplication.class);
	
	@Resource
	private Environment environment;

	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(Integer.valueOf(environment.getProperty("sever.port")));
		
	}
	
	@Bean(name = "zkClient")
	public CuratorFramework getCurator() {
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, Integer.MAX_VALUE);
		CuratorFramework zkClient = CuratorFrameworkFactory.newClient(environment.getProperty("zkurl"), 1000,
				100 * 1000, retryPolicy);
		zkClient.start();
		return zkClient;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RunApplication.class,args);
		 logger.info("RunApplication is sussess!");
	}

}
