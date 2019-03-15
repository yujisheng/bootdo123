package com.bootdo.testDemo;

import cn.jpush.api.JPushClient;
import com.soft863.message.SendMessageMain;
import com.soft863.pushmessge.PushMessageMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test() {
        redisTemplate.opsForValue().set("a", "b");
        System.out.println(redisTemplate.opsForValue().get("a"));
    }

    @Test
    public void sendSmsTest() {
        SendMessageMain sendMessageMain = new SendMessageMain();
        List<String> objects = new ArrayList<>();
        objects.add("");
        objects.add("");
        objects.add("");
        try {
            // 向一个人发送信息测试
            sendMessageMain.sendSms("12332", "尊敬的用户你好！");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            sendMessageMain.sendSms(objects, "尊敬的用户您好！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void pushMessageTest() {
        Map<String, String> parm = new HashMap<String, String>();
        //这里的id是,移动端集成极光并登陆后,极光用户的rid
        parm.put("id", "18071adc034cde4d344");
        //设置提示信息,内容是文章标题
        parm.put("msg", "7528/2382382");
        try {
            PushMessageMain.jpushAll(parm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
