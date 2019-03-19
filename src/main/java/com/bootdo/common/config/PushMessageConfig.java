package com.bootdo.common.config;

import com.soft863.pushmessge.PushMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PushMessageConfig {

    @Value("${blsf.pushMessage.appKey}")
    private String appKey;
    @Value("${blsf.pushMessage.masterSecret}")
    private String masterSecret;
    @Value("${blsf.pushMessage.production}")
    private boolean production;

    @Bean(name = "pushMessage")
    public PushMessage pushMessage() {

        PushMessage pushMessage = new PushMessage();
        pushMessage.setAppKey(appKey);
        pushMessage.setMasterSecret(masterSecret);
        pushMessage.setProduction(production);
        return pushMessage;
    }
}
