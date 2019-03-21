package com.soft863.framework.push.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.soft863.framework.push.domain.PushDO;
import com.soft863.framework.push.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public R save(PushDO push) {
        System.out.println("================" + push + "==================");
        if (pushService.save(push) > 0) {
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
    public R update(PushDO push) {
        pushService.update(push);
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

}
