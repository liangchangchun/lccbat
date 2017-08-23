package com.lcc.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration  
@PropertySource("classpath:dubbo/dubbo.properties")
@ImportResource({"classpath:dubbo/dubbo-provider.xml"})  
public class DubboConfig {

}
