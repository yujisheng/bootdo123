package com.bootdo.testDemo;

import com.soft863.sendmail.SendMail;
import com.soft863.sendmail.config.MailInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: SendMailTest
 * @Author
 * @Date 2019/3/19 0019 17:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMailTest {

    /*@Autowired
    MailConfig mailConfig;*/

    //邮箱文本,图片,附件不能同时为空


    //默认系统发送
    @Test
    public void defaultEmail() {
        SendMail listMail = new SendMail();
        MailInfo mailInfo = new MailInfo();
        // 收件人邮箱（替换为自己知道的有效邮箱）
        mailInfo.setToAddress(new String[]{"1670915265@qq.com"});

        //邮件文本内容
        mailInfo.setContent("aaa");

        //是否开启SSL
        mailInfo.setStarttlsEnable(true);
        try {
            if (mailInfo.getEmail() == null || mailInfo.getEmail() == "") {
                //页面无账号,使用默认账号
                MailInfo mail = mailConfig.getMail();
                mailInfo.setEmail(mail.getEmail());
                mailInfo.setPassword(mail.getPassword());
                mailInfo.setName(mail.getName());
                listMail.send(mailInfo);
            } else {
                //页面有账号
                listMail.send(mailInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //单个收件人,单个抄送人
    @Test
    public void singleEmail() {
        SendMail listMail = new SendMail();
        MailInfo mailInfo = new MailInfo();
        // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
        mailInfo.setEmail("1670915265@qq.com");
        mailInfo.setPassword("lsozyanivrwtichc");//lsozyanivrwtichc
        // 收件人邮箱（替换为自己知道的有效邮箱）
        mailInfo.setToAddress(new String[]{"1670915265@qq.com"});
        // 发件人名称
        mailInfo.setName("神");
        // 抄送人邮箱
        mailInfo.setCcAddress(new String[]{"1670915265@qq.com"});
        //邮件主题/标题
        mailInfo.setSubject("主题");
        //邮件文本内容
        mailInfo.setContent(null);
        //附件的本地存储位置
        mailInfo.setAttachFile(new String[]{"C:\\Users\\Administrator\\Desktop\\gyyZZ.png"});
        //图片的本地存储位置
        mailInfo.setImagePath(new String[]{"C:\\Users\\Administrator\\Desktop\\gyyZZ.png"});
        //是否开启SSL
        mailInfo.setStarttlsEnable(true);
        try {
            if (mailInfo.getEmail() == null || mailInfo.getEmail() == "") {
                //页面无账号,使用默认账号
                MailInfo mail = mailConfig.getMail();
                mailInfo.setEmail(mail.getEmail());
                mailInfo.setPassword(mail.getPassword());
                mailInfo.setName(mail.getName());
                listMail.send(mailInfo);
            } else {
                //页面有账号
                listMail.send(mailInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //多个收件人,多个抄送人
    @Test
    public void listEmail() {
        MailDemo listMail = new MailDemo();
        MailInfo mailInfo = new MailInfo();
        // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
        mailInfo.setEmail("1670915265@qq.com");
        mailInfo.setPassword("lsozyanivrwtichc");//lsozyanivrwtichc
        // 收件人邮箱（替换为自己知道的有效邮箱）
        mailInfo.setToAddress(new String[]{"1670915265@qq.com", "fg66803@163.com"});
        // 发件人名称
        mailInfo.setName("神");
        // 抄送人邮箱
        mailInfo.setCcAddress(new String[]{"1670915265@qq.com", "fg66803@163.com"});
        //邮件主题/标题
        mailInfo.setSubject("主题");
        //邮件文本内容
        mailInfo.setContent(null);
        //附件的本地存储位置
        mailInfo.setAttachFile(new String[]{"C:\\Users\\Administrator\\Desktop\\gyyZZ.png"});
        //图片的本地存储位置
        mailInfo.setImagePath(new String[]{"C:\\Users\\Administrator\\Desktop\\gyyZZ.png"});
        //是否开启SSL
        mailInfo.setStarttlsEnable(true);

        try {
            if (mailInfo.getEmail() == null || mailInfo.getEmail() == "") {
                //页面无账号,使用默认账号
                MailInfo mail = mailConfig.getMail();
                mailInfo.setEmail(mail.getEmail());
                mailInfo.setPassword(mail.getPassword());
                mailInfo.setName(mail.getName());
                listMail.send(mailInfo);
            } else {
                //页面有账号
                listMail.send(mailInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //只发送文本
    @Test
    public void onlyContent() {
        MailDemo listMail = new MailDemo();
        MailInfo mailInfo = new MailInfo();
        // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
        mailInfo.setEmail("1670915265@qq.com");
        mailInfo.setPassword("lsozyanivrwtichc");//lsozyanivrwtichc
        // 收件人邮箱（替换为自己知道的有效邮箱）
        mailInfo.setToAddress(new String[]{"1670915265@qq.com", "fg66803@163.com"});
        // 发件人名称
        mailInfo.setName("神");
        // 抄送人邮箱
        mailInfo.setCcAddress(new String[]{"1670915265@qq.com", "fg66803@163.com"});
        //邮件主题/标题
        mailInfo.setSubject("主题");
        //邮件文本内容
        mailInfo.setContent("测试");
        //是否开启SSL
        mailInfo.setStarttlsEnable(true);

        try {
            if (mailInfo.getEmail() == null || mailInfo.getEmail() == "") {
                //页面无账号,使用默认账号
                MailInfo mail = mailConfig.getMail();
                mailInfo.setEmail(mail.getEmail());
                mailInfo.setPassword(mail.getPassword());
                mailInfo.setName(mail.getName());
                listMail.send(mailInfo);
            } else {
                //页面有账号
                listMail.send(mailInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送文本加图片
    @Test
    public void contentImage() {
        MailDemo listMail = new MailDemo();
        MailInfo mailInfo = new MailInfo();
        // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
        mailInfo.setEmail("1670915265@qq.com");
        mailInfo.setPassword("lsozyanivrwtichc");//lsozyanivrwtichc
        // 收件人邮箱（替换为自己知道的有效邮箱）
        mailInfo.setToAddress(new String[]{"1670915265@qq.com", "fg66803@163.com"});
        // 发件人名称
        mailInfo.setName("神");
        // 抄送人邮箱
        mailInfo.setCcAddress(new String[]{"1670915265@qq.com", "fg66803@163.com"});
        //邮件主题/标题
        mailInfo.setSubject("主题");
        //邮件文本内容
        mailInfo.setContent("测试");
        //图片的本地存储位置
        mailInfo.setImagePath(new String[]{"C:\\Users\\Administrator\\Desktop\\gyyZZ.png"});
        //是否开启SSL
        mailInfo.setStarttlsEnable(true);

        try {
            if (mailInfo.getEmail() == null || mailInfo.getEmail() == "") {
                //页面无账号,使用默认账号
                MailInfo mail = mailConfig.getMail();
                mailInfo.setEmail(mail.getEmail());
                mailInfo.setPassword(mail.getPassword());
                mailInfo.setName(mail.getName());
                listMail.send(mailInfo);
            } else {
                //页面有账号
                listMail.send(mailInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送文本加单个图片加单个附件
    @Test
    public void imageAttach() {
        MailDemo listMail = new MailDemo();
        MailInfo mailInfo = new MailInfo();
        // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
        mailInfo.setEmail("1670915265@qq.com");
        mailInfo.setPassword("lsozyanivrwtichc");//lsozyanivrwtichc
        // 收件人邮箱（替换为自己知道的有效邮箱）
        mailInfo.setToAddress(new String[]{"1670915265@qq.com", "fg66803@163.com"});
        // 发件人名称
        mailInfo.setName("神");
        // 抄送人邮箱
        mailInfo.setCcAddress(new String[]{"1670915265@qq.com", "fg66803@163.com"});
        //邮件主题/标题
        mailInfo.setSubject("主题");
        //邮件文本内容
        mailInfo.setContent(null);
        //附件的本地存储位置
        mailInfo.setAttachFile(new String[]{"C:\\Users\\Administrator\\Desktop\\gyyZZ.png"});
        //图片的本地存储位置
        mailInfo.setImagePath(new String[]{"C:\\Users\\Administrator\\Desktop\\gyyZZ.png"});
        //是否开启SSL
        mailInfo.setStarttlsEnable(true);

        try {
            if (mailInfo.getEmail() == null || mailInfo.getEmail() == "") {
                //页面无账号,使用默认账号
                MailInfo mail = mailConfig.getMail();
                mailInfo.setEmail(mail.getEmail());
                mailInfo.setPassword(mail.getPassword());
                mailInfo.setName(mail.getName());
                listMail.send(mailInfo);
            } else {
                //页面有账号
                listMail.send(mailInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送文本加多个图片加多个附件
    @Test
    public void listImageAttach() {
        MailDemo listMail = new MailDemo();
        MailInfo mailInfo = new MailInfo();
        // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
        mailInfo.setEmail("1670915265@qq.com");
        mailInfo.setPassword("lsozyanivrwtichc");//lsozyanivrwtichc
        // 收件人邮箱（替换为自己知道的有效邮箱）
        mailInfo.setToAddress(new String[]{"1670915265@qq.com", "fg66803@163.com"});
        // 发件人名称
        mailInfo.setName("神");
        // 抄送人邮箱
        mailInfo.setCcAddress(new String[]{"1670915265@qq.com", "fg66803@163.com"});
        //邮件主题/标题
        mailInfo.setSubject("主题");
        //邮件文本内容
        mailInfo.setContent(null);
        //附件的本地存储位置
        mailInfo.setAttachFile(new String[]{"C:\\Users\\Administrator\\Desktop\\gyyZZ.png", "C:\\Users\\Administrator\\Desktop\\zz.png"});
        //图片的本地存储位置
        mailInfo.setImagePath(new String[]{"C:\\Users\\Administrator\\Desktop\\gyyZZ.png", "C:\\Users\\Administrator\\Desktop\\zz.png"});
        //是否开启SSL
        mailInfo.setStarttlsEnable(true);

        try {
            if (mailInfo.getEmail() == null || mailInfo.getEmail() == "") {
                //页面无账号,使用默认账号
                MailInfo mail = mailConfig.getMail();
                mailInfo.setEmail(mail.getEmail());
                mailInfo.setPassword(mail.getPassword());
                mailInfo.setName(mail.getName());
                listMail.send(mailInfo);
            } else {
                //页面有账号
                listMail.send(mailInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
