package com.mifan2009.chimport.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName: ConfigUtils
 * @Description: java类作用描述
 * @Author: mifan2009
 * @CreateDate: 2019-04-25 17:08
 * @Version: 2019-v1.0
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ConfigUtils
{

    @Value("${chimport.configname}")
    private String configname;

    @Value("${chimport.service.testFile}")
    private String testFile;


    public String getConfigname() {
        return configname;
    }

    public void setConfigname(String configname) {
        this.configname = configname;
    }

    public String getTestFile() {
        return testFile;
    }

    public void setTestFile(String testFile) {
        this.testFile = testFile;
    }
}


