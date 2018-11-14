package com.example.filecabinets.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="wechat") //获取配置文件中前缀是weixin的配置
public class WeChatProperties {
    private String APPID;

    private String APPSECRET;

    public String getAPPID() {
        return APPID;
    }
    public String getAPPSECRET() {
        return APPSECRET;
    }

    public void setAPPID(String APPID) {
        this.APPID = APPID;
    }

    public void setAPPSECRET(String APPSECRET) {
        this.APPSECRET = APPSECRET;
    }
}
