package com.bootdo.testDemo;

import com.soft863.framework.Mail;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: SendMessageTest
 * @Author
 * @Date 2019/3/19 0019
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMessageTest {

   /* @Autowired
    private SendMessage sendMessage;


    @Test
    public void sendSmsTest() {
        List<String> objects = new ArrayList<>();
        objects.add("");
        objects.add("");
        objects.add("");
        try {
            // 向一个人发送信息测试
            sendMessage.sendSms("12332", "尊敬的用户你好！");
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            sendMessage.sendSms(objects, "尊敬的用户您好！");
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }*/

   @Autowired
   private Mail mail;

   /*@Test
   public void mmm(){
       Mail mail = new Mail();
       System.out.println(mail.sayHello());
   }*/

}
