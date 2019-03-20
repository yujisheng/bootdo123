package com.bootdo.common.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Auther: Song Kun
 * @Date: 2019/3/15 10:24
 * @Description:
 */

public class MailConfig {

    @Value("${blsf.sendMail.defaultEmail}")
    private String email;

    @Value("${blsf.sendMail.defaultPassword}")
    private String password;

    @Value("${blsf.sendMail.defaultName}")
    private String name;


    /*@Bean
    public MailInfo getMail(){
        MailInfo mail = new MailInfo();
        mail.setEmail(email);
        mail.setPassword(password);
        mail.setName(name);
        return mail;
    }*/


}
