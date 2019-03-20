package com.bootdo.common.config;

import org.springframework.beans.factory.annotation.Value;


public class PushMessageConfig {

    @Value("${blsf.pushMessage.appKey}")
    private String appKey;
    @Value("${blsf.pushMessage.masterSecret}")
    private String masterSecret;
    @Value("${blsf.pushMessage.production}")
    private boolean production;

    /*@Bean(name = "pushMessage")
    public PushMessage pushMessage() {

        PushMessage pushMessage = new PushMessage();
        pushMessage.setAppKey(appKey);
        pushMessage.setMasterSecret(masterSecret);
        pushMessage.setProduction(production);
        return pushMessage;
    }*/
}
