package com.bootdo.testDemo;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import com.soft863.framework.PushMessage;
import com.soft863.framework.PushMessageConfig.AllMessage;
import com.soft863.framework.PushMessageConfig.AndroidMessage;
import com.soft863.framework.PushMessageConfig.IosMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: PushMessageTest
 * @Author
 * @Date 2019/3/19 0019
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageTest {

    @Autowired
    private PushMessage pushMessage;

    /**
     * 向Android所有用户推送消息 测试
     *
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    @Test
    public void pushMessageToAndroidAll() throws APIConnectionException, APIRequestException {
        Map<String, String> extras = new HashMap<String, String>();
        extras.put("extraKey", "ectraValue");
        AndroidMessage androidMessage = new AndroidMessage("测试pushMessageToAndroidAll", "测试标题", "测试内容", extras);
        // 测试
        pushMessage.pushMessageToAndroidAll(androidMessage);
    }

    /**
     * 根据tag,向Android用户推送消息 测试
     *
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    @Test
    public void pushMessageToAndroidByTags() throws APIConnectionException, APIRequestException {
        List<String> tags = new ArrayList<String>();
        tags.add("Android_tag1");
        tags.add("Android_tag2");
        tags.add("Android_tag3");
        Map<String, String> extras = new HashMap<String, String>();
        extras.put("extraKey", "ectraValue");
        AndroidMessage androidMessage = new AndroidMessage(tags, "测试qpushMessageAndroidByTags", "测试主题", "测试内容", extras);
        // 测试
        pushMessage.pushMessageToAndroidByTags(androidMessage);
    }

    /**
     * 根据alias,向Android用户推送消息 测试
     *
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    @Test
    public void pushMessageAndroidByAlias() throws APIConnectionException, APIRequestException {
        List<String> alias = new ArrayList<String>();
        alias.add("ansroid_alias1");
        alias.add("ansroid_alias2");
        alias.add("ansroid_alias3");
        Map<String, String> extras = new HashMap<String, String>();
        extras.put("extraKey", "ectraValue");
        AndroidMessage androidMessage = new AndroidMessage(alias, "测试pushMessageAndroidByAlias", "测试主题", "测试内容", extras);
        // 测试
        pushMessage.pushMessageToAndroidByAlias(androidMessage);
    }

    /**
     * 根据tags,向Ios用户推送消息 测试
     *
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    @Test
    public void pushMessageIosByTags() throws APIConnectionException, APIRequestException {
        List<String> tags = new ArrayList<String>();
        tags.add("Ios_tag1");
        tags.add("Ios_tag2");
        tags.add("Ios_tag3");
        IosMessage iosMessage = new IosMessage(tags, "测试pushMessageToIOsAll", "消息内容", "extraKey", "extraValue");
        // 测试
        pushMessage.pushMessageToIosByTags(iosMessage);
    }

    /**
     * 向所有ios用户推送消息 测试
     *
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    @Test
    public void pushMessageToIosAll() throws APIConnectionException, APIRequestException {
        IosMessage iosMessage = new IosMessage("测试pushMessageToIOsByTags", "消息内容", "extraKey", "extraValue");
        // 测试
        pushMessage.pushMessageToIosAll(iosMessage);
    }

    /**
     * 向Android和ios的所有用户推送消息 测试
     *
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    @Test
    public void pushMessage() throws APIConnectionException, APIRequestException {
        AllMessage allMessage = new AllMessage("测试pushMessageAndroidAndIosAll", "消息内容", "extraLey", "extraValue");
        // 测试
        pushMessage.pushMessageAndroidAndIosAll(allMessage);
    }

}
