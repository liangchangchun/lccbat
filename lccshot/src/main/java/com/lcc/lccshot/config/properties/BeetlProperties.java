package com.lcc.lccshot.config.properties;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Strings;

/**
 * beetl配置(如果需要配置别的配置可参照这个形式自己添加)
 *
 * @author fengshuonan
 * @date 2017-05-24 20:37
 */
@Configuration
@ConfigurationProperties(prefix = BeetlProperties.BEETLCONF_PREFIX)
public class BeetlProperties {

    public static final String BEETLCONF_PREFIX = "beetl";

    private String delimiterStatementStart;

    private String delimiterStatementEnd;

    private String resourceTagroot;

    private String resourceTagsuffix;

    @Value("${spring.mvc.view.prefix}")
    private String prefix;

    public Properties getProperties(){
        Properties properties = new Properties();
        if(!Strings.isNullOrEmpty(delimiterStatementStart)){
            if(delimiterStatementStart.startsWith("\\")){
                delimiterStatementStart = delimiterStatementStart.substring(1);
            }
            properties.setProperty("DELIMITER_STATEMENT_START",delimiterStatementStart);
        }
        if(!Strings.isNullOrEmpty(delimiterStatementEnd)){
            properties.setProperty("DELIMITER_STATEMENT_END",delimiterStatementEnd);
        }else{
            properties.setProperty("DELIMITER_STATEMENT_END","null");
        }
        if(!Strings.isNullOrEmpty(resourceTagroot)){
            properties.setProperty("RESOURCE.tagRoot",resourceTagroot);
        }
        if(!Strings.isNullOrEmpty(resourceTagsuffix)){
            properties.setProperty("RESOURCE.tagSuffix",resourceTagsuffix);
        }
        return properties;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getDelimiterStatementStart() {
        return delimiterStatementStart;
    }

    public void setDelimiterStatementStart(String delimiterStatementStart) {
        this.delimiterStatementStart = delimiterStatementStart;
    }

    public String getDelimiterStatementEnd() {
        return delimiterStatementEnd;
    }

    public void setDelimiterStatementEnd(String delimiterStatementEnd) {
        this.delimiterStatementEnd = delimiterStatementEnd;
    }

    public String getResourceTagroot() {
        return resourceTagroot;
    }

    public void setResourceTagroot(String resourceTagroot) {
        this.resourceTagroot = resourceTagroot;
    }

    public String getResourceTagsuffix() {
        return resourceTagsuffix;
    }

    public void setResourceTagsuffix(String resourceTagsuffix) {
        this.resourceTagsuffix = resourceTagsuffix;
    }
}
