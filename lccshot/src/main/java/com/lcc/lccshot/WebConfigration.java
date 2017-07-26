package com.lcc.lccshot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.lcc.lccshot.config.properties.BaseProperties;

/**
 * Guns Web程序启动类
 *
 * @author fengshuonan
 * @date 2017-05-21 9:43
 */
@Configuration
public class WebConfigration extends WebMvcConfigurerAdapter {
	@Autowired
    BaseProperties baseProperties;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	        if(baseProperties.getSwaggerOpen()){
	            registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	        }
	}
}
