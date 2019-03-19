package com.bootdo.common.config;

import com.soft863.sendmail.config.MailInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: SendMailConfig
 * @Author
 * @Date 2019/3/19 0019 17:11
 */
@Configuration
public class SendMailConfig {

    private String email;

    private String password;

    private String name;

    private boolean authVAlidate;

    private boolean starttlsEnable;

    private boolean starttlsRequired;

    @Bean
    public MailInfo sendMail() {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setEmail(email);
        mailInfo.setPassword(password);
        mailInfo.setName(name);
        mailInfo.setAuthValidate(authVAlidate);
        mailInfo.setStarttlsEnable(starttlsEnable);
        mailInfo.setStarttlsRequired(starttlsRequired);
        return mailInfo;
    }
}
