package com.es.hmc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Guns Web程序启动类
 *
 * @author fengshuonan
 * @date 2017-05-21 9:43
 */
@Configuration
public class WebConfigration extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
}
