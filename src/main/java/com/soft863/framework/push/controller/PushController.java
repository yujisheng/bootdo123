package com.soft863.framework.push.controller;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.soft863.framework.PushMessage;
import com.soft863.framework.push.domain.PushDO;
import com.soft863.framework.push.domain.PushVO;
import com.soft863.framework.push.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 15:21:21
 */

@Controller
@RequestMapping("/plugin/push")
public class PushController {
    @Autowired
    private PushService pushService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
//    @RequiresPermissions("system:push:push")
    String Push() {
        return "/plugin/push/push";
    }

    @ResponseBody
    @GetMapping("/list")
//    @RequiresPermissions("system:push:push")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<PushDO> pushList = pushService.list(query);
        int total = pushService.count(query);
        PageUtils pageUtils = new PageUtils(pushList, total);
        /*List<PushDO> pushDOS = new ArrayList<>();
        PushDO pushDO = null;
        for(int i=0;i<20;i++){
            pushDO = new PushDO();
            pushDO.setAlter("alter"+i);
            pushDOS.add(pushDO);
        }
        PageUtils pageUtils = new PageUtils(pushDOS, 20);*/
        return pageUtils;
    }

    @GetMapping("/add")
//    @RequiresPermissions("system:push:add")
    String add() {
        return "plugin/push/add1";
    }

    @GetMapping("/edit/{pushId}")
//    @RequiresPermissions("system:push:edit")
    String edit(@PathVariable("pushId") Integer pushId, Model model) {
        PushDO push = pushService.get(pushId);
        model.addAttribute("push", push);
        return "plugin/push/edit";
    }
 /*   @GetMapping("/edit")
    String edit() {
        return "plugin/push/edit";
    }*/

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
//    @RequiresPermissions("system:push:add")
    public R save(PushVO pushVO) {
        PushDO pushDO1 = new PushDO();
        pushDO1.setAlter(pushVO.getMessage());
        pushDO1.setStatus(0L);
        pushDO1.setAudience(pushVO.getTargetType());
        pushDO1.setMessage(pushVO.getMessageConetent());
        pushDO1.setTitle(pushVO.getTitle());
        pushDO1.setPlatfrom(pushVO.getType());
        System.out.println("================" + pushVO + "==================");
        if (pushService.save(pushDO1) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
//    @RequiresPermissions("system:push:edit")
    public R update(PushVO pushVO) {
        PushDO pushDO1 = new PushDO();
        pushDO1.setAlter(pushVO.getMessage());
        pushDO1.setStatus(1L);
        pushDO1.setAudience(pushVO.getTargetType());
        pushDO1.setMessage(pushVO.getMessageConetent());
        pushDO1.setTitle(pushVO.getTitle());
        pushDO1.setPlatfrom(pushVO.getType());
        pushService.update(pushDO1);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
//    @RequiresPermissions("system:push:remove")
    public R remove(Integer pushId) {
        if (pushService.remove(pushId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
//    @RequiresPermissions("system:push:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] pushIds) {
        pushService.batchRemove(pushIds);
        return R.ok();
    }

    @Autowired
    private PushMessage pushMessage;

   /* @RequestMapping("/pushMessage")
    @ResponseBody
    public R pushMessage(PushVO pushVO,Integer pushId) throws APIConnectionException, APIRequestException {
        System.out.println("=========="+pushVO+"=========="+pushId+"=============");
        PushDO pushDO = pushService.get(pushId);
        //if (PushUtil.PLATFROM_ANDROID.equals(pushVO.getType()) && PushUtil.TARGET_ALL.equals(pushVO.getTargetType())){
            if(pushDO != null){
                pushDO.setStatus(1L);
                pushService.update(pushDO);
            }else{
                PushDO pushDO1 = new PushDO();
                pushDO1.setAlter(pushVO.getMessage());
                pushDO1.setStatus(1L);
                pushDO1.setAudience(pushVO.getTargetType());
                pushDO1.setMessage(pushVO.getMessageConetent());
                pushDO1.setTitle(pushVO.getTitle());
                pushDO1.setPlatfrom(pushVO.getType());
                pushService.save(pushDO1);
            }
            return push(pushVO.getMessage(), pushVO.getTitle(), pushVO.getMessageConetent(), pushVO.getExtraValue());
    }*/


    @RequestMapping("/pushMessage")
    @ResponseBody
    public R pushMessageToAndroidAll(PushVO pushVO) throws APIConnectionException, APIRequestException {
        System.out.println("==============" + pushVO);
        return push(pushVO.getMessage(), pushVO.getTitle(), pushVO.getMessageConetent(), pushVO.getExtraValue(),
                pushVO.getTargetType(), pushVO.getTargetArray(), pushVO.getExtraKey());
    }
/*
    @RequestMapping("/pushMessageToAndroidByTag")
    @ResponseBody
    public R pushMessageToAndroidByTag() throws APIConnectionException, APIRequestException {
        List<String> tags = new ArrayList<String>();
        tags.add("Android_tag1");
        tags.add("Android_tag2");
        tags.add("Android_tag3");
        Map<String, String> extras = new HashMap<String, String>();
        extras.put("extraKey", "ectraValue");
        AndroidMessage androidMessage = new AndroidMessage(tags, "测试qpushMessageAndroidByTags", "测试主题", "测试内容", extras);
        // 测试
        int i = pushMessage.pushMessageToAndroidByTags(androidMessage);
        if (i > 0) {
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping("/pushMessageToAndroidByAlias")
    @ResponseBody
    public R pushMessageToAndroidByalias() throws APIConnectionException, APIRequestException {
        List<String> alias = new ArrayList<String>();
        alias.add("ansroid_alias1");
        alias.add("ansroid_alias2");
        alias.add("ansroid_alias3");
        Map<String, String> extras = new HashMap<String, String>();
        extras.put("extraKey", "ectraValue");
        AndroidMessage androidMessage = new AndroidMessage(alias, "测试pushMessageAndroidByAlias", "测试主题", "测试内容", extras);
        // 测试
        int i = pushMessage.pushMessageToAndroidByAlias(androidMessage);
        if (i > 0) {
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping("/pushMessageIosByTags")
    @ResponseBody
    public R pushMessageIosByTags() throws APIConnectionException, APIRequestException {
        List<String> tags = new ArrayList<String>();
        tags.add("Ios_tag1");
        tags.add("Ios_tag2");
        tags.add("Ios_tag3");
        IosMessage iosMessage = new IosMessage(tags, "测试pushMessageToIOsAll", "消息内容", "extraKey", "extraValue");
        // 测试
        int i = pushMessage.pushMessageToIosByTags(iosMessage);
        if (i > 0) {
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping("/pushMessageToIosAll")
    @ResponseBody
    public R pushMessageToIosAll(PushDO pushDO) throws APIConnectionException, APIRequestException {
        pushService.save(pushDO);
        IosMessage iosMessage = new IosMessage(pushDO.getAlter(), pushDO.getMessage(), "extraKey", "extraValue");
        // 测试
        int i = pushMessage.pushMessageToIosAll(iosMessage);
        if (i > 0) {
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping("/pushMessage")
    @ResponseBody
    public R pushMessage() throws APIConnectionException, APIRequestException {
        AllMessage allMessage = new AllMessage("测试pushMessageAndroidAndIosAll", "消息内容", "extraLey", "extraValue");
        // 测试
        int i = pushMessage.pushMessageAndroidAndIosAll(allMessage);
        if (i > 0) {
            return R.ok();
        }
        return R.error();
    }*/

    public R push(String alter, String title, String msgContent, String extraValue, String targetType,
                  String targetArray, String extraKey) {
        String host = "http://192.168.1.66:10081";
        R result = null;
        ResponseEntity<R> ret = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("x-requested-with", "XMLHttpRequest");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ret = restTemplate.exchange(host + "/api/login?username=admin&password=123456",
                HttpMethod.POST,
                entity, R.class);
        if (ret != null) {
            System.out.println(ret.getBody());
            result = ret.getBody();
            if (Integer.parseInt(result.get("code").toString()) == 0) {
                String authorization = result.get("Authorization").toString();
                System.out.println(authorization);

                LinkedMultiValueMap body = new LinkedMultiValueMap();
                //alter=测试33851&msgContent=消息内容&title=消息标题&extraValue=extraValue
                body.add("deviceType", "Android");
                body.add("alter", alter);
                body.add("msgContent", msgContent);
                body.add("title", title);
                body.add("targetType", targetType);
                body.add("targetArray", targetArray);
                body.add("extraValue", extraKey);
                body.add("extraValue", extraValue);


                headers = new HttpHeaders();
                headers.add("x-requested-with", "XMLHttpRequest");
                headers.add("Authorization", authorization);
                entity = new HttpEntity(body, headers);
                ret = restTemplate.exchange(host + "/api/plugin/push",
                        HttpMethod.POST,
                        entity, R.class);
                return ret.getBody();
            }

        }
        return R.error();

    }


}
