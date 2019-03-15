package com.bootdo.common.config;

import com.soft863.pushmessge.PushMessageMain;
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

    @Bean
    public PushMessageMain pushMessageconfig() {
        PushMessageMain.setAppKey(appKey);
        PushMessageMain.setMasterSecret(masterSecret);
        PushMessageMain.setProduction(production);
        return new PushMessageMain();
    }
}
