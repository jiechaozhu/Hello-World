package com.mifan2009.chimport.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MyConfig
 * @Description: java类作用描述
 * @Author: mifan2009
 * @CreateDate: 2019-04-25 11:53
 * @Version: 2019-v1.0
 */
@Configuration
public class MyConfig {

    @Value("${chimport.configname}")
    private String configname;

    @Value("${chimport.xmlupload}")
    private String xmlupload;

    @Value("${chimport.district}")
    private String district;

    @Value("${chimport.presellrealtype}")
    private String presellrealtype;


    public String getConfigname() {
        return configname;
    }

    public void setConfigname(String configname) {
        this.configname = configname;
    }

    public String getXmlupload() {
        return xmlupload;
    }

    public void setXmlupload(String xmlupload) {
        this.xmlupload = xmlupload;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }


    public String getPresellrealtype() {
        return presellrealtype;
    }

    public void setPresellrealtype(String presellrealtype) {
        this.presellrealtype = presellrealtype;
    }
}

    

