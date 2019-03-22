package com.bootdo.testDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController()
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {
    @Autowired
    RestTemplate restTemplate;

//    @Test
//    public void test() {
//        redisTemplate.opsForValue().set("a", "b");
//        System.out.println(redisTemplate.opsForValue().get("a"));
//    }

    @Test
    public void push() {
        String host = "http://192.168.1.66:10081";
        JSONObject result = null;
        ResponseEntity<String> ret = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("x-requested-with", "XMLHttpRequest");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ret = restTemplate.exchange(host + "/api/login?username=admin&password=123456",
                HttpMethod.POST,
                entity, String.class);
        if (ret != null) {
            System.out.println(ret.getBody());
            result = JSON.parseObject(ret.getBody());
            if (result.getIntValue("code") == 0) {
                String authorization = result.getString("Authorization");
                System.out.println(authorization);
                LinkedMultiValueMap body = new LinkedMultiValueMap();
                //alter=测试33851&msgContent=消息内容&title=消息标题&extraValue=extraValue
                body.add("alter", "测试33852");
                body.add("msgContent", "消息内容33852");
                body.add("title", "消息标题33852");
                body.add("extraValue", "extraValue");
                body.add("deviceType", "Android");
                body.add("targetType", "tag");
                body.add("targetArray", "tag,tag1");

                headers = new HttpHeaders();
                headers.add("x-requested-with", "XMLHttpRequest");
                headers.add("Authorization", authorization);
                entity = new HttpEntity(body, headers);
                ret = restTemplate.exchange(host + "/api/plugin/push",
                        HttpMethod.POST,
                        entity, String.class);
                System.out.println(ret.getBody());
            }

        }


    }
}
