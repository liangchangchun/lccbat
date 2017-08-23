package com.lcc.consume.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration  
@PropertySource("classpath:dubbo/dubbo.properties")
@ImportResource({"classpath:dubbo/dubbo-consumer.xml"})  
public class DubboConfig {

}
