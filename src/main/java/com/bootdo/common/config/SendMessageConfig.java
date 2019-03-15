package com.bootdo.common.config;

import com.soft863.message.SendMessageMain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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


    @Bean
    public SendMessageMain sendSmsConfig() {
        SendMessageMain sendMessageMain = new SendMessageMain();
        sendMessageMain.setAccessKeyId(accessKey);
        sendMessageMain.setAccessKeySecret(accessKeySecret);
        sendMessageMain.setTemplateCode(templateCode);
        sendMessageMain.setConnectTimeout(connectTimeout);
        sendMessageMain.setReadTimeout(readTimeout);
        return sendMessageMain;
    }
}
