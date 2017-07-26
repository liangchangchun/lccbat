package com.lcc.lccshot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.lcc.lccshot.config.properties.DruidProperties;

@Configuration
public class DBConfig {

	@Autowired
    DruidProperties druidProperties;
	
    /**
     * druid数据库连接池
     */
    @Bean(name="dataSource",initMethod = "init")
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource  
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.coinfig(dataSource);
        return dataSource;
    }
}
