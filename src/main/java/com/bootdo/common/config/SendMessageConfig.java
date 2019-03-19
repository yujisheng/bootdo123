package com.bootdo.common.config;

import org.springframework.beans.factory.annotation.Value;


public class SendMessageConfig {

    @Value("${blsf.sendMessage.accessKey}")
    private String accessKey;

    @Value("${blsf.sendMessage.accessKeySecret}")
    private String accessKeySecret;

    @Value("${blsf.sendMessage.templateCode}")
    private String templateCode;

    @Value("${blsf.sendMessage.connectTimeout}")
    private int connectTimeout;

    @Value("${blsf.sendMessage.readTimeout}")
    private int readTimeout;


    /*@Bean
    public SendMessage sendSmsConfig() {
        SendMessage SendMessage = new SendMessage();
        SendMessage.setAccessKeyId(accessKey);
        SendMessage.setAccessKeySecret(accessKeySecret);
        SendMessage.setTemplateCode(templateCode);
        SendMessage.setConnectTimeout(connectTimeout);
        SendMessage.setReadTimeout(readTimeout);
        return SendMessage;
    }*/
}
