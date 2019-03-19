package com.bootdo.common.config;

import com.soft863.sendmail.config.MailInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: SendMailConfig
 * @Author
 * @Date 2019/3/19 0019 17:11
 */
@Configuration
public class SendMailConfig {

    @Value("blsf.sendMail.email")
    private String email;

    @Value("blsf.sendMail.password")
    private String password;

    @Value("blsf.sendMail.name")
    private String name;

    /**
     * 设置是否需要认证，如果为true,那么用户名和密码就必须的
     */
    @Value("blsf.sendMail.properties.mail.smtp.auth")
    private boolean authVAlidate;


    @Value("blsf.sendMail.properties.mail.smtp.starttls.enable")
    private boolean starttlsEnable;

    @Value("blsf.sendMail.properties.mail.smtp.starttls.required")
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
